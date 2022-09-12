package controller.TelaPrincipal;

import view.Medicamento.PrincipalMedicamento;
import view.Paciente.PrincipalPaciente;
import view.Posologia.ListaPosologia;
import view.Posologia.PrincipalPosologia;
import view.TelaPrincipal.TelaPrincipal;

/**
 * Esta classe é responsável pela comunicação entre a classe view.TelaPrincipal
 * e a classe controller.TelaPrincipal. É onde descreve a ação de cada botão que
 * está na tela inicial.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */
public class TelaPrincipalController {

	private final TelaPrincipal view;

	/**
	 * Chama o método construtor da classe TelaPrincipal
	 * 
	 * @param view - é a classe view.TelaPrincipal
	 */
	public TelaPrincipalController(TelaPrincipal view) {
		super();
		this.view = view;
	}

	/**
	 * Está recebendo, o evento dos botões que estão em view.TelaPrincipal e
	 * identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na view.TelaPrincipal
	 */
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

	/**
	 * Ao clicar no botão Paciente, este método encaminha para a tela
	 * view.Paciente.PrincipalPaciente
	 * 
	 */
	// Chama a tela principal do Paciente
	private void executarBotaoPrincipalPaciente() {
		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		view.dispose();
	}

	/**
	 * Ao clicar no botão Medicamento, este método encaminha para a tela
	 * view.Medicamento.PrincipalMedicamento
	 * 
	 */
	// Chama a tela principal do Medicamento
	private void executarBotaoPrincipalMedicamento() {
		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		view.dispose();
	}

	/**
	 * Ao clicar no botão Posologia, este método encaminha para a tela
	 * view.Posologia.PrincipalPosologia
	 * 
	 */
	// Chama a tela principal da Posologia
	private void executarBotaoPrincipalPosologia() {
		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		view.dispose();
	}

	/**
	 * Ao clicar no botão Rotina de paciente e medicação, este método encaminha para
	 * a tela view.Posologia.ListaPosologia
	 * 
	 */
	// Chama a tela principal da Rotina
	private void executarBotaoRotina() {
		ListaPosologia obj = new ListaPosologia();
		obj.setVisible(true);
		view.dispose();
	}

}
