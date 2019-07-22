package unipar.br.pav.turma;

import org.eclipse.core.runtime.Status;

import unipar.br.pav.turma.Activator;

public final class EclipseLogger {

	private Activator plugin;

    public EclipseLogger(Activator plugin) {
        super();
        this.plugin = plugin;
    }

    /**
     * Loga a mensagem de erro no log do próprio eclipse.
     * @param msg
     * @see #log(String, Exception)
     */
    public void logError(String msg, Exception e) {
        log(msg, Status.ERROR, e);
    }

    /**
     * Loga a mensagem de informação no log do próprio eclipse.
     * @param msg
     * @see #log(String, Exception)
     */
    public void logInfo(String msg) {
        log(msg, Status.INFO, null);
    }

    /**
     * Loga a mensagem e a exceção no log do eclipse utilizando um objeto
     * {@link Status}.
     * @param msg
     *            - a mensagem
     * @param severity
     *            - a gravidade
     * @param e
     *            - a exceção
     */
    public void log(String msg, int severity, Exception e) {
        plugin.getLog().log(new Status(severity, Activator.PLUGIN_ID, Status.OK, msg, e));
    }
	
}
