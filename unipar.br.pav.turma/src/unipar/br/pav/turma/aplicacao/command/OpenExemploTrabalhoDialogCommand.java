package unipar.br.pav.turma.aplicacao.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import unipar.br.pav.turma.aplicacao.helper.ShellHelper;
import unipar.br.pav.turma.telas.dialog.ExemploTrabalhoDialog;

public class OpenExemploTrabalhoDialogCommand extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ExemploTrabalhoDialog dialog = new ExemploTrabalhoDialog(ShellHelper.getActiveShell());
		dialog.open();
		return null;
	}

}
