package unipar.br.pav.turma.persistence;

import java.sql.Driver;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.config.TargetDatabase;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.eclipse.persistence.sessions.UnitOfWork;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.Maps;

import unipar.br.pav.turma.Activator;
import unipar.br.pav.turma.EclipseLogger;
import unipar.br.pav.turma.aplicacao.internal.utils.SingleValue;

public class PersistenceManager {
	
	private static PersistenceManager instance;
	private EclipseLogger logger = new EclipseLogger(Activator.getDefault());
	private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<>();
	/**
	 * Criado um single value para n�o manter refer�ncia est�tica direta ao EntityManagerFactory
	 * para que o sistema fa�a o GC (Garbage Collect) dele.
	 */
	private EntityManagerFactory entityManagerFactory;
	private final Map<Thread, EntityManager> entityManagers = Maps.newHashMap();
	
	/**
	 * Utilizando single value para permitir que o GC limpe a mem�ria.
	 */
	private SingleValue<EMForQueries> queryEntityManagerValue = SingleValue.create();
	private EntityManager uiEntityManager;
	private UnitOfWork uow;

	/**
	 * A do-nothing constructor.
	 */
	private PersistenceManager() {}
	
	public static PersistenceManager getInstance() {
		if(instance == null)
			instance = new PersistenceManager();
		return instance;
	}
	
	private synchronized void initializeEntityManagerFactory() {
		// Se j� tem um entity manager factory, retorna
		if(entityManagerFactory != null)
			return;
		
		Map<String, Object> props = getDefaultProperties();
		
		// Cria tabelas novas (mas n�o atualiza)
		logger.logInfo("Gerando tabelas...");
		props.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
		props.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_DATABASE_GENERATION);

		// Para criar s� um entity manager factory
		logger.logInfo("Criando EntityManagerFactory.");
		entityManagerFactory = new PersistenceProvider().createEntityManagerFactory("gtech", props);
	}

	private static Map<String, Object> getDefaultProperties() {
		Map<String, Object> properties = Maps.newHashMap();
		
		properties.put(PersistenceUnitProperties.TARGET_DATABASE, TargetDatabase.PostgreSQL);
		properties.put(PersistenceUnitProperties.JDBC_DRIVER, Driver.class.getCanonicalName());
		properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc://127.0.0.1/turma");
		properties.put(PersistenceUnitProperties.JDBC_USER, "postgres");
		properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "admin");
		properties.put(PersistenceUnitProperties.JDBC_PROPERTY.concat("ApplicationName"), "Unipar - Turma");
		properties.put(PersistenceUnitProperties.CONNECTION_POOL_MIN, "1");
		properties.put(PersistenceUnitProperties.CONNECTION_POOL_MAX, "10");
		properties.put(PersistenceUnitProperties.CACHE_STATEMENTS, "true");
		properties.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
		properties.put(PersistenceUnitProperties.CLASSLOADER, Activator.class.getClassLoader());
		properties.put(PersistenceUnitProperties.PERSISTENCE_CONTEXT_CLOSE_ON_COMMIT, "true");
		properties.put(PersistenceUnitProperties.DDL_GENERATION_INDEX_FOREIGN_KEYS, "true");

		properties.put("eclipselink.logging.level", "FINE");
		properties.put("eclipselink.logging.timestamp", "true");
		properties.put("eclipselink.logging.session", "true");
		properties.put("eclipselink.logging.thread", "true");
		properties.put("eclipselink.logging.exceptions", "true");
		
		return properties;
	}
	
	/**
	 * Retorna um {@link EntityManager}. Caso n�o exista, cria um novo
	 * @param thread
	 */
	public synchronized EntityManager getEntityManager(Thread thread) {
		EntityManager entityManager = entityManagers.get(thread);
		// Se n�o tem um EM
		if (entityManager == null) {
			// Reinicia
			initializeEntityManagerFactory();
			entityManagers.put(thread, entityManager = entityManagerFactory.createEntityManager());
			
			// Guarda o EM do UI Thread
			if(thread.equals(Display.getDefault().getThread()))
				this.uiEntityManager = entityManager;
			
			// Loga que foi criado um novo entity manager.
			logger.logInfo(String.format("EntityManager [%s] criado no Thread [%s]", entityManager, thread.getName()));
			
			// instancia o query entity manager
			getQueryEntityManager();
		}
		return entityManager;
	}
	
	public synchronized EntityManager getEntityManagerFromUIThread() {
		return uiEntityManager;
	}

	public synchronized EMForQueries getQueryEntityManager() {
		// Se n�o tiver um entity manager para query criado, ele cria
		if (queryEntityManagerValue.get() == null) {
//			log.info(String.format("queryEntityManager � null para o Thread [%s]", Thread.currentThread().getName()));
			queryEntityManagerValue.set(new EMForQueries());
			queryEntityManagerValue.get().start();
		}
		return queryEntityManagerValue.get();
	}
	
	/**
	 * As vezes, � necess�rio comparar o valor de um objeto da aplica��o com o
	 * banco, e usando o {@link getEntityManager}, o EclipseLink n�o vai buscar
	 * do banco, e sim da sess�o. Ent�o, usa-se um EntityManager novo para
	 * buscar o objeto. Esse {@link EntityManager} n�o deve ser usado sempre.
	 */
	public EntityManager getIsolatedEntityManager() {
		EntityManager em = entityManagerFactory.createEntityManager();
//		log.debug("Props: ".concat(emfValue.get().getProperties().toString()));
		EntityManagerImpl impl = (EntityManagerImpl) em;
		uow = impl.getUnitOfWork();
		return em;
	}
	
	public EntityManagerFactory evictCache() {
		if (entityManagerFactory != null) {
			entityManagerFactory.getCache().evictAll();
		}
		return entityManagerFactory;
	}
	
	public UnitOfWork getUnityOfWorkFromIsolated(){
		return uow;
	}
	
	public EntityManager reload() {
		// Fecha e recarrega
		closeEntityManagers();
		
		// Fecha e recarrega tambem o query entity manager
		if (queryEntityManagerValue.get() != null) {
			queryEntityManagerValue.set(null);
		}
		// Fechando o entity manager factory.
		if (entityManagerFactory != null) {
			// Limpa o cache
			entityManagerFactory.getCache().evictAll();
			entityManagerFactory.close();
			entityManagerFactory = null;
		}
		// Reinicia o entity manager
		EntityManager entityManager = getEntityManager(Thread.currentThread());
		return entityManager;
	}

	public void closeEntityManagers() {
		// Se estiver aberto, fecha
		Set<Thread> keys = entityManagers.keySet();
		
		for (Thread thread : keys) {
			EntityManager em = entityManagers.get(thread);
			// Fecha e remove
			if(em != null) {
				logger.logInfo(String.format("Fechando EntityManager [%s] do Thread [%s]", em, thread.getName()));
				em.clear();
				em.close();
			}
		}
		// Acaba com todos os entity managers
		entityManagers.clear();
	}
	
	public void generateDDLScript(String path) {
		Map<String, Object> props = getDefaultProperties();
		
		props.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
		props.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_SQL_SCRIPT_GENERATION);
		props.put(PersistenceUnitProperties.CREATE_JDBC_DDL_FILE, "CREATE-DDL.jdbc.sql");
		props.put(PersistenceUnitProperties.APP_LOCATION, path);
		
		EntityManagerFactory factory = new PersistenceProvider().createEntityManagerFactory("unipar", props);
		factory.createEntityManager().createQuery("select u from Usuario u").getResultList();
		factory.close();
	}
	
	/**
	 * Retorna um {@link EntityManager}. Caso n�o exista, cria um novo
	 */
	public synchronized EntityManager getEntityManager() {
		EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
		if (entityManager == null) {
			initializeEntityManagerFactory();
			EntityManager em = entityManagerFactory.createEntityManager();
			ENTITY_MANAGER_CACHE.set(entityManager = em);
		}

		return entityManager;
	}
	
}
