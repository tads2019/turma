package unipar.br.pav.turma.aplicacao.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import unipar.br.pav.turma.aplicacao.helper.EditorHelper;
import unipar.br.pav.turma.telas.editor.CadastroEditor;
import unipar.br.pav.turma.telas.editor.editorInput.CadastroEditorInput;

public class OpenCadastroEditor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EditorHelper.abrirEditor(new CadastroEditorInput(), CadastroEditor.ID);
		return null;
	}

}
