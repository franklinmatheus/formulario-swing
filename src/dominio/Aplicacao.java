package dominio;

import formulario.Formulario;

public class Aplicacao {

	public static void main(String[] args) {
		Formulario form = new Formulario();
		form.fazerJanela();
		form.setVisible(true);
	}
}
