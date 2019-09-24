package unipar.br.pav.turma.telas.dialog;

import org.eclipse.swt.widgets.Display;

public class Main {

	public static void main(String[] args) {
		Curriculo curriculo = new Curriculo(Display.getDefault().getActiveShell());
		curriculo.open();
	}

}
