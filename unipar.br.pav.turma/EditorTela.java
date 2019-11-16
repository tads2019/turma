package unipar.br.pav.turma.telas.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class EditorTela extends AbstractEditor {
	private DataBindingContext m_bindingContext;

	public static final String ID = "unipar.br.pav.turma.telas.editor.EditorTela"; //$NON-NLS-1$
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Label lblNewLabel;

	public EditorTela() {
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		setM_bindingContext(initDataBindings());
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
	protected void addComponents(Composite compositeTop) {
		compositeTop.setBackground(SWTResourceManager.getColor(47, 79, 79));
		compositeTop.setLayout(null);
		
		Label lblRa = new Label(compositeTop, SWT.NONE);
		lblRa.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblRa.setAlignment(SWT.CENTER);
		lblRa.setBounds(24, 10, 690, 39);
		lblRa.setBackground(SWTResourceManager.getColor(0, 128, 128));
		lblRa.setFont(SWTResourceManager.getFont("Rockwell Extra Bold", 20, SWT.BOLD));
		formToolkit.adapt(lblRa, true, true);
		lblRa.setText("CADASTRO DE ALUNO");
		
		Label lblDigiteSeuRa = new Label(compositeTop, SWT.NONE);
		lblDigiteSeuRa.setTouchEnabled(true);
		lblDigiteSeuRa.setEnabled(false);
		lblDigiteSeuRa.setText("Digite seu R.A *");
		lblDigiteSeuRa.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteSeuRa.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteSeuRa.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteSeuRa.setAlignment(SWT.CENTER);
		lblDigiteSeuRa.setBounds(90, 83, 136, 21);
		formToolkit.adapt(lblDigiteSeuRa, true, true);
		
		Label lblNomeCompleto = new Label(compositeTop, SWT.NONE);
		lblNomeCompleto.setText("Nome completo:");
		lblNomeCompleto.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblNomeCompleto.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblNomeCompleto.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblNomeCompleto.setAlignment(SWT.CENTER);
		lblNomeCompleto.setBounds(24, 123, 141, 24);
		formToolkit.adapt(lblNomeCompleto, true, true);
		
		Label lblDigiteSeuNome = new Label(compositeTop, SWT.NONE);
		lblDigiteSeuNome.setEnabled(false);
		lblDigiteSeuNome.setBounds(171, 123, 231, 24);
		formToolkit.adapt(lblDigiteSeuNome, true, true);
		lblDigiteSeuNome.setText(" Digite seu nome completo*");
		
		Label lblDataDeNascimento = new Label(compositeTop, SWT.NONE);
		lblDataDeNascimento.setText("Data de nascimento:");
		lblDataDeNascimento.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblDataDeNascimento.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblDataDeNascimento.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblDataDeNascimento.setAlignment(SWT.CENTER);
		lblDataDeNascimento.setBounds(424, 123, 181, 24);
		formToolkit.adapt(lblDataDeNascimento, true, true);
		
		Label lblCpf = new Label(compositeTop, SWT.NONE);
		lblCpf.setText("CPF:");
		lblCpf.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblCpf.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblCpf.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblCpf.setAlignment(SWT.CENTER);
		lblCpf.setBounds(24, 166, 54, 21);
		formToolkit.adapt(lblCpf, true, true);
		
		Label lblDigiteSeuCpf = new Label(compositeTop, SWT.NONE);
		lblDigiteSeuCpf.setText("Digite seu CPF *");
		lblDigiteSeuCpf.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteSeuCpf.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteSeuCpf.setEnabled(false);
		lblDigiteSeuCpf.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteSeuCpf.setAlignment(SWT.CENTER);
		lblDigiteSeuCpf.setBounds(90, 169, 136, 21);
		formToolkit.adapt(lblDigiteSeuCpf, true, true);
		
		Label lblRg = new Label(compositeTop, SWT.NONE);
		lblRg.setText("RG:");
		lblRg.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblRg.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblRg.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblRg.setAlignment(SWT.CENTER);
		lblRg.setBounds(24, 207, 54, 21);
		formToolkit.adapt(lblRg, true, true);
		
		Label lblDigiteSeuRg = new Label(compositeTop, SWT.NONE);
		lblDigiteSeuRg.setText("Digite seu RG (opcional)");
		lblDigiteSeuRg.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteSeuRg.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteSeuRg.setEnabled(false);
		lblDigiteSeuRg.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteSeuRg.setAlignment(SWT.CENTER);
		lblDigiteSeuRg.setBounds(90, 210, 189, 21);
		formToolkit.adapt(lblDigiteSeuRg, true, true);
		
		Label lblSexo = new Label(compositeTop, SWT.NONE);
		lblSexo.setText("SEXO:");
		lblSexo.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblSexo.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblSexo.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblSexo.setAlignment(SWT.CENTER);
		lblSexo.setBounds(24, 245, 54, 21);
		formToolkit.adapt(lblSexo, true, true);
		
		DateTime dateTime = new DateTime(compositeTop, SWT.BORDER);
		dateTime.setBackground(SWTResourceManager.getColor(255, 0, 0));
		dateTime.setForeground(SWTResourceManager.getColor(0, 0, 128));
		dateTime.setBounds(611, 123, 102, 24);
		formToolkit.adapt(dateTime);
		formToolkit.paintBordersFor(dateTime);
		
		Button btnM = new Button(compositeTop, SWT.CHECK);
		btnM.setForeground(SWTResourceManager.getColor(139, 0, 0));
		btnM.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnM.setBounds(163, 247, 44, 20);
		formToolkit.adapt(btnM, true, true);
		btnM.setText("F");
		
		Button btnM_1 = new Button(compositeTop, SWT.CHECK);
		btnM_1.setSelection(true);
		btnM_1.setForeground(SWTResourceManager.getColor(105, 105, 105));
		btnM_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnM_1.setText("M");
		btnM_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnM_1.setBounds(95, 247, 54, 20);
		formToolkit.adapt(btnM_1, true, true);
		
		Button btnIndiferente = new Button(compositeTop, SWT.CHECK);
		btnIndiferente.setText("Indiferente");
		btnIndiferente.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		btnIndiferente.setBounds(222, 247, 125, 20);
		formToolkit.adapt(btnIndiferente, true, true);
		
		Label lblE = new Label(compositeTop, SWT.NONE);
		lblE.setText("E-mail:");
		lblE.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblE.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblE.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblE.setAlignment(SWT.CENTER);
		lblE.setBounds(24, 286, 64, 24);
		formToolkit.adapt(lblE, true, true);
		
		Label lblDigiteSeuEmail = new Label(compositeTop, SWT.NONE);
		lblDigiteSeuEmail.setText("Digite seu email (opcional)");
		lblDigiteSeuEmail.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteSeuEmail.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteSeuEmail.setEnabled(false);
		lblDigiteSeuEmail.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteSeuEmail.setAlignment(SWT.CENTER);
		lblDigiteSeuEmail.setBounds(98, 289, 231, 21);
		formToolkit.adapt(lblDigiteSeuEmail, true, true);
		
		Label lblEndereo = new Label(compositeTop, SWT.NONE);
		lblEndereo.setText("Endere\u00E7o:");
		lblEndereo.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblEndereo.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblEndereo.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblEndereo.setAlignment(SWT.CENTER);
		lblEndereo.setBounds(24, 333, 102, 21);
		formToolkit.adapt(lblEndereo, true, true);
		
		Label lblDigiteSeuEndereo = new Label(compositeTop, SWT.NONE);
		lblDigiteSeuEndereo.setText("Digite seu endere\u00E7o*");
		lblDigiteSeuEndereo.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteSeuEndereo.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteSeuEndereo.setEnabled(false);
		lblDigiteSeuEndereo.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteSeuEndereo.setAlignment(SWT.CENTER);
		lblDigiteSeuEndereo.setBounds(132, 333, 231, 21);
		formToolkit.adapt(lblDigiteSeuEndereo, true, true);
		
		Label lblNmero = new Label(compositeTop, SWT.NONE);
		lblNmero.setText("N\u00FAmero:");
		lblNmero.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblNmero.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblNmero.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblNmero.setAlignment(SWT.CENTER);
		lblNmero.setBounds(394, 333, 93, 21);
		formToolkit.adapt(lblNmero, true, true);
		
		Label lblN = new Label(compositeTop, SWT.NONE);
		lblN.setText("N\u00BA *");
		lblN.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblN.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblN.setEnabled(false);
		lblN.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblN.setAlignment(SWT.CENTER);
		lblN.setBounds(496, 333, 54, 21);
		formToolkit.adapt(lblN, true, true);
		
		Label lblBairro = new Label(compositeTop, SWT.NONE);
		lblBairro.setText("Bairro:");
		lblBairro.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblBairro.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblBairro.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblBairro.setAlignment(SWT.CENTER);
		lblBairro.setBounds(24, 371, 93, 24);
		formToolkit.adapt(lblBairro, true, true);
		
		Label lblDigiteONome = new Label(compositeTop, SWT.NONE);
		lblDigiteONome.setText("Digite o nome do seu bairro*");
		lblDigiteONome.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteONome.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteONome.setEnabled(false);
		lblDigiteONome.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteONome.setAlignment(SWT.CENTER);
		lblDigiteONome.setBounds(132, 371, 231, 24);
		formToolkit.adapt(lblDigiteONome, true, true);
		
		Label lblCidade = new Label(compositeTop, SWT.NONE);
		lblCidade.setText("Cidade:");
		lblCidade.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblCidade.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblCidade.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblCidade.setAlignment(SWT.CENTER);
		lblCidade.setBounds(24, 410, 93, 24);
		formToolkit.adapt(lblCidade, true, true);
		
		Label lblDigiteONome_1 = new Label(compositeTop, SWT.NONE);
		lblDigiteONome_1.setText("Digite o nome da cidade*");
		lblDigiteONome_1.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteONome_1.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteONome_1.setEnabled(false);
		lblDigiteONome_1.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteONome_1.setAlignment(SWT.CENTER);
		lblDigiteONome_1.setBounds(132, 410, 231, 24);
		formToolkit.adapt(lblDigiteONome_1, true, true);
		
		Label lblCep = new Label(compositeTop, SWT.NONE);
		lblCep.setText("CEP:");
		lblCep.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblCep.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblCep.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblCep.setAlignment(SWT.CENTER);
		lblCep.setBounds(394, 410, 64, 24);
		formToolkit.adapt(lblCep, true, true);
		
		Label lblDigiteOCep = new Label(compositeTop, SWT.NONE);
		lblDigiteOCep.setText("Digite o CEP (opcional)");
		lblDigiteOCep.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteOCep.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteOCep.setEnabled(false);
		lblDigiteOCep.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteOCep.setAlignment(SWT.CENTER);
		lblDigiteOCep.setBounds(470, 410, 212, 24);
		formToolkit.adapt(lblDigiteOCep, true, true);
		
		Label lblEstado = new Label(compositeTop, SWT.NONE);
		lblEstado.setText("Estado:");
		lblEstado.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblEstado.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblEstado.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblEstado.setAlignment(SWT.CENTER);
		lblEstado.setBounds(24, 450, 93, 24);
		formToolkit.adapt(lblEstado, true, true);
		
		Label lblDigiteONome_2 = new Label(compositeTop, SWT.NONE);
		lblDigiteONome_2.setText("Digite o nome do estado*");
		lblDigiteONome_2.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblDigiteONome_2.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblDigiteONome_2.setEnabled(false);
		lblDigiteONome_2.setBackground(SWTResourceManager.getColor(128, 0, 128));
		lblDigiteONome_2.setAlignment(SWT.CENTER);
		lblDigiteONome_2.setBounds(132, 450, 231, 24);
		formToolkit.adapt(lblDigiteONome_2, true, true);
		
		Label lblRa_1 = new Label(compositeTop, SWT.NONE);
		lblRa_1.setText("R.A");
		lblRa_1.setForeground(SWTResourceManager.getColor(47, 79, 79));
		lblRa_1.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblRa_1.setBackground(SWTResourceManager.getColor(47, 79, 79));
		lblRa_1.setAlignment(SWT.CENTER);
		lblRa_1.setBounds(30, 83, 54, 21);
		formToolkit.adapt(lblRa_1, true, true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		return bindingContext;
	}

	public DataBindingContext getM_bindingContext() {
		return m_bindingContext;
	}

	public void setM_bindingContext(DataBindingContext m_bindingContext) {
		this.m_bindingContext = m_bindingContext;
	}

	public Label getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(Label lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
}
