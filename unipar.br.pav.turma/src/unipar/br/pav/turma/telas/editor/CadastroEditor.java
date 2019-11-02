package unipar.br.pav.turma.telas.editor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import unipar.br.pav.turma.aplicacao.helper.MessageHelper;
import unipar.br.pav.turma.telas.editor.editorInput.CadastroEditorInput;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class CadastroEditor extends AbstractEditor {

	public static final String ID = "unipar.br.pav.turma.telas.editor.CadastroEditor"; //$NON-NLS-1$
	private Text txtNome;

	public CadastroEditor() {
	}

	@Override
	protected void salvarRegistro() {
		// TODO Auto-generated method stub
		MessageHelper.openInformation("Validar aqui");
	}

	@Override
	protected void excluirRegistro() {
		// Não faremos nada
	}

	@Override
	protected void addComponents(Composite compositeTop) {
		compositeTop.setLayout(new GridLayout(2, false));
		
		Label lblNome = new Label(compositeTop, SWT.NONE);
		lblNome.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNome.setText("Nome");
		
		txtNome = new Text(compositeTop, SWT.BORDER);
		txtNome.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		CadastroEditorInput editorInput = new CadastroEditorInput();
		
		setInput(editorInput);
		setSite(site);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

}
