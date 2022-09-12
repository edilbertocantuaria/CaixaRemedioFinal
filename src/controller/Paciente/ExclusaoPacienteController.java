package controller.Paciente;

import javax.swing.JOptionPane;

import model.Pessoa;
import view.Paciente.ExclusaoPaciente;
import view.Paciente.PrincipalPaciente;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Paciente.ExclusaoPaciente e a classe
 * controller.Paciente.PacienteController, excluindo um objeto desejado.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */
public class ExclusaoPacienteController {

	private ExclusaoPaciente view;

	/**
	 * Chama o método construtor da classe ExclusaoPaciente
	 * 
	 * @param view - é a classe view.Paciente.ExclusaoPaciente
	 */
	public ExclusaoPacienteController(ExclusaoPaciente view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Paciente.ExclusaoPaciente e identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Paciente.ExclusaoPaciente
	 */

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.excluiPaciente();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método limpa os campos e retorna para a tela
	 * view.Paciente.PrincipalPaciente
	 * 
	 */
	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.jftCPFBusca.setText("");

		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		ExclusaoPaciente.getFrame().dispose();
	}

	/**
	 * Ao clicar no botão para excluir, este método invoca a classe
	 * PacienteController, procurando pelo método excluirPacientes, passando como
	 * parâmetro o CPF do paciente e removendo e realocando as posições dos demais
	 * objetos que compõem o ArrayList pacientes
	 * 
	 */
	public void excluiPaciente() {
		// deixa o cursor dentro desse jtextfield's
		view.jftCPFBusca.requestFocus();

		String cpf = view.jftCPFBusca.getText();
		// Invoca o controller para que ele procure o paciente pelo seu nome no método
		// excluirPacientes.
		PacienteController pacienteController = new PacienteController(null);
		Pessoa resultado = pacienteController.excluirPacientes(cpf);

		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Paciente não cadastrado ou CPF inválido!");

		} else {

			JOptionPane.showMessageDialog(null, "Paciente excluido!");

			// deixa o cursor dentro desse jtextfield's
			view.jftCPFBusca.requestFocus();

		}
		// System.out.println(PacienteController.pacientes.toString());
	}
}
