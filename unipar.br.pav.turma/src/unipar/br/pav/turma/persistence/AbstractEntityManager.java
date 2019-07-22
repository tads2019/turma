package unipar.br.pav.turma.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.eclipse.persistence.sessions.UnitOfWork;

public abstract class AbstractEntityManager {

	private static PersistenceManager delegate = PersistenceManager.getInstance();

	public static UnitOfWork getUnityOfWorkFromIsolated(){
		return delegate.getUnityOfWorkFromIsolated();
	}

	public static EntityManager getEntityManager() {
		return delegate.getEntityManager();
	}

	public static EntityManager getEntityManagerCurrentThread() {
		return delegate.getEntityManager(Thread.currentThread());
	}

	public EntityManager getEntityManager(Thread thread) {
		return delegate.getEntityManager(thread);
	}

	public static EMForQueries getQueryEntityManager() {
		return delegate.getQueryEntityManager();
	}

	public static EntityManager getIsolatedEntityManager() {
		return delegate.getIsolatedEntityManager();
	}

	public static EntityManagerFactory evictCache() {
		return delegate.evictCache();
	}

	public static EntityManager reload() {
		return delegate.reload();
	}

	public static void closeEntityManagers() {
		delegate.closeEntityManagers();
	}

	public static EntityManager getEntityManagerFromUIThread() {
		return delegate.getEntityManagerFromUIThread();
	}
	
}
