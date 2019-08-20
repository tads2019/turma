package unipar.br.pav.turma.telas.editor;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;

import unipar.br.pav.turma.telas.editor.editorInput.ExemploEditorInput;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class ExemploEditor extends AbstractEditor {

	public static final String ID = "unipar.br.pav.turma.telas.editor.ExemploEditor"; //$NON-NLS-1$
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtTexto;

	public ExemploEditor() {
	}

	@Override
	protected void addComponents(Composite compositeTop) {
		Composite container = compositeTop;
		container.setLayout(new GridLayout(2, false));
		
		Label lblEtiqueta = new Label(compositeTop, SWT.NONE);
		lblEtiqueta.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblEtiqueta, true, true);
		lblEtiqueta.setText("Etiqueta");
		
		txtTexto = new Text(compositeTop, SWT.BORDER);
		txtTexto.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.adapt(txtTexto, true, true);
	}

	@Override
	protected void salvarRegistro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void excluirRegistro() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
		ExemploEditorInput exemploEditorInput = (ExemploEditorInput) input;
		setSite(site);
		setInput(exemploEditorInput);
	}

}
