package unipar.br.pav.turma.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import unipar.br.pav.turma.Activator;
import unipar.br.pav.turma.EclipseLogger;

public class EMForQueries implements Runnable {

	private EntityManager em;
	private EclipseLogger logger = new EclipseLogger(Activator.getDefault());
	private Thread thread;
	
	public EMForQueries() {
		thread = new Thread(null, this, "Thread-EMForQueries");
	}
	
	@Override
	public void run() {
		// Criar o EM
		em = AbstractEntityManager.getIsolatedEntityManager();
		logger.logInfo(String.format("EntityManager (query) [%s] criado no Thread [%s]", em, Thread.currentThread().getName()));
	}
	
	public void start() {
		thread.start();
	}
	
	public synchronized EntityManager get() {
		return em;
	}
	
	public synchronized <T> TypedQuery<T> createQuery(String query, Class<T> clazz) {
		em.clear();
		return em.createQuery(query, clazz);
	}
	
	public synchronized Query createNativeQuery(String query, Class<?> clazz) {
		em.clear();
		logger.logInfo(String.format("Creating native query in thread [%s].", Thread.currentThread().getName()));
		return em.createNativeQuery(query, clazz);
	}

	public synchronized Query createNativeQuery(String query) {
		em.clear();
		return em.createNativeQuery(query);
	}
	
	public Thread getThread() {
		return thread;
	}

}
