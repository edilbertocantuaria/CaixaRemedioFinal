package controller.Paciente;

import javax.swing.JOptionPane;

import model.Pessoa;
import view.Paciente.ExclusaoPaciente;
import view.Paciente.PrincipalPaciente;

public class ExclusaoPacienteController {

	private ExclusaoPaciente view;

	public ExclusaoPacienteController(ExclusaoPaciente view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.excluiPaciente();
		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.jftCPFBusca.setText("");

		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		ExclusaoPaciente.getFrame().dispose();
	}

	public void excluiPaciente() {
		// deixa o cursor dentro desse jtextfield's
		view.jftCPFBusca.requestFocus();

		String cpf = view.jftCPFBusca.getText();

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
