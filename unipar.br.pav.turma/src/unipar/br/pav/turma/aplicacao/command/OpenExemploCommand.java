package unipar.br.pav.turma.aplicacao.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import unipar.br.pav.turma.aplicacao.helper.EditorHelper;
import unipar.br.pav.turma.telas.editor.ExemploEditor;
import unipar.br.pav.turma.telas.editor.editorInput.ExemploEditorInput;

public class OpenExemploCommand extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EditorHelper.abrirEditor(new ExemploEditorInput(), ExemploEditor.ID);
		return null;
	}

}
