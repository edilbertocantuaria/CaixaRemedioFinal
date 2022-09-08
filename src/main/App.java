package main;

import controller.MedicamentoController;
import controller.PacienteController;
import controller.PosologiaController;
import view.TelaPrincipal.TelaPrincipal;

public class App {

	public static void main(String[] args) {
		PacienteController.dadosPaciente();
		MedicamentoController.dadosMedicamento();
		PosologiaController.dadosPosologia();
		new TelaPrincipal().setVisible(true);
	}
}
