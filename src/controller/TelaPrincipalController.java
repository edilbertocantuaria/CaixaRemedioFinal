package controller;

import view.Medicamento.PrincipalMedicamento;
import view.Paciente.PrincipalPaciente;
import view.Posologia.PrincipalPosologia;
import view.Rotina.PrincipalRotina;
import view.TelaPrincipal.TelaPrincipal;

public class TelaPrincipalController {

	private final TelaPrincipal view;

	public TelaPrincipalController(TelaPrincipal view) {
		super();
		this.view = view;
	}

	public void executarBotao(Object botaoApertado) {

		if (botaoApertado == TelaPrincipal.getBtnPaciente()) {

			this.executarBotaoPrincipalPaciente();
		}

		if (botaoApertado == view.getBtnMedicamento()) {

			this.executarBotaoPrincipalMedicamento();
		}

		if (botaoApertado == view.getBtnPosologia()) {

			this.executarBotaoPrincipalPosologia();
		}
		if (botaoApertado == view.getBtnRotina()) {

			this.executarBotaoRotina();
		}

	}

	// Chama a tela principal do Paciente
	private void executarBotaoPrincipalPaciente() {
		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		view.dispose();
	}

	// Chama a tela principal do Medicamento
	private void executarBotaoPrincipalMedicamento() {
		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		view.dispose();
	}

	// Chama a tela principal da Posologia
	private void executarBotaoPrincipalPosologia() {
		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		view.dispose();
	}

	// Chama a tela principal da Rotina
	private void executarBotaoRotina() {
		PrincipalRotina obj = new PrincipalRotina();
		obj.setVisible(true);
		view.dispose();
	}

}
