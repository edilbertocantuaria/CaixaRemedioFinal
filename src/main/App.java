package main;

import controller.Medicamento.MedicamentoController;
import controller.Paciente.PacienteController;
import controller.Posologia.PosologiaController;
import view.TelaPrincipal.TelaPrincipal;

/**
 * É a responsável para executar a tela view.TelaPrincipal e invoca os dados já
 * cadastrados que estão em PacienteController, MedicamentoController e
 * PosologiaController.
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
