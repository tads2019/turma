package unipar.br.pav.turma.telas.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

import unipar.br.pav.turma.aplicacao.helper.MessageHelper;

public class Curriculo extends TitleAreaDialog {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private Text text_13;
	
	private List<String> tags = new ArrayList<String>();
	private TableViewer tvExperiencia;
	private Text txtExperiencia;
	private Table tExperiencia;
	private Text text_12;
	private Text text_14;
	private Text text_15;
	private Text text_16;
	private Text text_17;


	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public Curriculo(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(11, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblNomeCompleto = new Label(container, SWT.NONE);
		lblNomeCompleto.setText("Nome Completo:");
		
		text = new Text(container, SWT.BORDER);
		text.setToolTipText("Ex: Marina Silva");
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 211;
		text.setLayoutData(gd_text);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblCpf = new Label(container, SWT.NONE);
		lblCpf.setText("CPF:");
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setToolTipText("(somente n\u00FAmeros)");
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 142;
		text_1.setLayoutData(gd_text_1);
		
		Label lblRg = new Label(container, SWT.NONE);
		lblRg.setText("RG:");
		
		text_2 = new Text(container, SWT.BORDER);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_2.widthHint = 146;
		text_2.setLayoutData(gd_text_2);
		
		Label lblEmail = new Label(container, SWT.NONE);
		lblEmail.setText("E-Mail:");
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblCelular = new Label(container, SWT.NONE);
		lblCelular.setText("Celular:");
		
		text_4 = new Text(container, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblTelefone = new Label(container, SWT.NONE);
		lblTelefone.setText("Telefone:");
		
		text_5 = new Text(container, SWT.BORDER);
		GridData gd_text_5 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text_5.widthHint = 164;
		text_5.setLayoutData(gd_text_5);
		
		Label lblEstadoCivil = new Label(container, SWT.NONE);
		lblEstadoCivil.setText("Endere\u00E7o:");
		
		text_6 = new Text(container, SWT.BORDER);
		text_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblNmero = new Label(container, SWT.NONE);
		lblNmero.setText("N\u00FAmero:");
		
		text_7 = new Text(container, SWT.BORDER);
		text_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblBairro = new Label(container, SWT.NONE);
		lblBairro.setText("Bairro:");
		
		text_8 = new Text(container, SWT.BORDER);
		text_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblEstado = new Label(container, SWT.NONE);
		lblEstado.setText("Cidade:");
		
		text_9 = new Text(container, SWT.BORDER);
		text_9.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblUf = new Label(container, SWT.NONE);
		lblUf.setText("UF:");
		
		text_10 = new Text(container, SWT.BORDER);
		text_10.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblCep = new Label(container, SWT.NONE);
		lblCep.setText("CEP:");
		
		text_11 = new Text(container, SWT.BORDER);
		text_11.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label_3 = new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label label_2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_label_2 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 11, 1);
		gd_label_2.widthHint = 925;
		label_2.setLayoutData(gd_label_2);
		
		Label lblEstadoCivil_1 = new Label(container, SWT.NONE);
		lblEstadoCivil_1.setText("Estado Civil:");
		
		text_13 = new Text(container, SWT.BORDER | SWT.MULTI);
		text_13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("G\u00EAnero:");
		
		ComboViewer cvSexo = new ComboViewer(container, SWT.READ_ONLY);
		Combo comboSexo = cvSexo.getCombo();
		GridData gd_comboSexo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_comboSexo.widthHint = 63;
		comboSexo.setLayoutData(gd_comboSexo);
		comboSexo.select(0);
		cvSexo.setContentProvider(ArrayContentProvider.getInstance());
		cvSexo.setInput(Sexo.values());
		cvSexo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				Sexo sexo = (Sexo) element;
				return sexo.getDescricao();
			}
		});
		
		Label lblIdade = new Label(container, SWT.NONE);
		lblIdade.setText("Nascimento:");
		
		DateTime dateTime = new DateTime(container, SWT.BORDER);
		
		Label label_6 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_label_6 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 11, 1);
		gd_label_6.widthHint = 924;
		label_6.setLayoutData(gd_label_6);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblFormao = new Label(container, SWT.NONE);
		lblFormao.setText("Formação:");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblObjetivo = new Label(container, SWT.NONE);
		lblObjetivo.setText("Objetivo:");
		
		text_12 = new Text(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		text_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		//Cria uma nova TableViewer
		tvExperiencia = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		//Cria a table e vincula ela a tableViewer
		tExperiencia = tvExperiencia.getTable();
		tExperiencia.setHeaderVisible(true);
		tExperiencia.setLinesVisible(true);
		GridData gd_tExperiencia = new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1);
		gd_tExperiencia.heightHint = 122;
		gd_tExperiencia.widthHint = 277;
		tExperiencia.setLayoutData(gd_tExperiencia);
		//Defini como será o conteúdo da tabela (padrão utilizamos array)
		tvExperiencia.setContentProvider(ArrayContentProvider.getInstance());
		//Insere na tabela a lista que deverá ser exibida 
		tvExperiencia.setInput(tags);
		
		//Cria uma nova coluna para a tabela
		TableViewerColumn tvcExperiencia = new TableViewerColumn(tvExperiencia, SWT.NONE);
		//Definimos a forma que será exibido esses dados
		tvcExperiencia.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				return element == null ? "" : element.toString();
			}
		});
		TableColumn tblclmnExperiencia = tvcExperiencia.getColumn();
		tblclmnExperiencia.setAlignment(SWT.CENTER);
		tblclmnExperiencia.setWidth(317);
		tblclmnExperiencia.setText("Formação   ");
		
		//Cria um menu de contexto para a tabela
		Menu MenuExcluir = new Menu(tExperiencia);
		tExperiencia.setMenu(MenuExcluir);
		
		//Cria um item dentro desse menu de contexto para remover o item
		MenuItem mntmRemoverExperiencia = new MenuItem(MenuExcluir, SWT.NONE);
		mntmRemoverExperiencia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Comando padrão para obter o item selecionado na lista
				IStructuredSelection selecao = (IStructuredSelection) tvExperiencia.getSelection();
				//Pega o primeiro item selecionado
				String tag = (String) selecao.getFirstElement();
				if(tag == null)
					return;
				
				//Remove o item selecionado da lista
				tags.remove(tag);
				//Atualiza a tabela para visualizar as modificações
				tvExperiencia.refresh();
			}
		});
		mntmRemoverExperiencia.setText("Remover");
		tvExperiencia.refresh();
		
		txtExperiencia = new Text(container, SWT.BORDER);
		txtExperiencia.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button btnExperiencia = new Button(container, SWT.NONE);
		btnExperiencia.setText("Adicionar");
		btnExperiencia.setImage(ResourceManager.getPluginImage("unipar.br.pav.turma", "assets/funcoes/plus16.png"));
		btnExperiencia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Obtemos o valor digitado pelo usuário
				String tag = txtExperiencia.getText();
				//Validamos se foi digitado alguma coisa
				if(tag.equals("")) {
					MessageHelper.openError("Não foi informada a TAG");
					return;
				}
				
				//Caso a TAG já foi adicionada, não iremos inserir novamente
				if(tags.contains(tag)) {
					txtExperiencia.setText("");
					return;
				}
				
				//Insere o texto obtido na lista de tags
				tags.add(tag);
				//Atualiza a tabela, para a informação nova apareça
				tvExperiencia.refresh();
				//Limpa o campo de texto para inserir uma nova tag
				txtExperiencia.setText("");
			}
		});
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblExperinciasProfissionais = new Label(container, SWT.NONE);
		lblExperinciasProfissionais.setText("Experiências Profissionais:");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblIdiomas = new Label(container, SWT.NONE);
		lblIdiomas.setText("Idiomas:");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblInformaesAdicionais = new Label(container, SWT.NONE);
		lblInformaesAdicionais.setText("Informações Adicionais:");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("Última Empresa:");
		
		text_14 = new Text(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		text_14.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button btnIngls = new Button(container, SWT.CHECK);
		btnIngls.setText("Inglês");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		text_17 = new Text(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		GridData gd_text_17 = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 3);
		gd_text_17.heightHint = 47;
		text_17.setLayoutData(gd_text_17);
		new Label(container, SWT.NONE);
		
		Label lblPenltimaEmpresa = new Label(container, SWT.NONE);
		lblPenltimaEmpresa.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPenltimaEmpresa.setText("Penúltima Empresa:");
		
		text_15 = new Text(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		text_15.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button btnEspanhol = new Button(container, SWT.CHECK);
		btnEspanhol.setText("Espanhol");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblAntepenltimaEmpresa = new Label(container, SWT.NONE);
		lblAntepenltimaEmpresa.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAntepenltimaEmpresa.setText("Antepenúltima Empresa:");
		
		text_16 = new Text(container, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		text_16.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button btnOutro = new Button(container, SWT.CHECK);
		btnOutro.setText("Outro");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label label_4 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_label_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 11, 1);
		gd_label_4.widthHint = 926;
		label_4.setLayoutData(gd_label_4);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(938, 625);
	}

}
