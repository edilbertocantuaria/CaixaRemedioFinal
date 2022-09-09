package main;

import controller.MedicamentoController;
import controller.PacienteController;
import controller.PosologiaController;
import view.TelaPrincipal.TelaPrincipal;

/**
 * É a responsável para executar a tela principal.Importa os Controller's e
 * invoca os dados já cadastrados.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */
public class App {

	public static void main(String[] args) {

		PacienteController.dadosPaciente();
		MedicamentoController.dadosMedicamento();
		PosologiaController.dadosPosologia();
		new TelaPrincipal().setVisible(true);
	}
}
