package controller.Paciente;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Paciente;
import view.Paciente.ListaPaciente;
import view.Paciente.PrincipalPaciente;

public class ListaPacienteController {

	private ListaPaciente view;

	public ListaPacienteController(ListaPaciente view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();
		}
		if (botaoApertado == view.getBtnAtualizar()) {
			this.atualizaTabela();
		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.tabelaPaciente = (DefaultTableModel) view.jtPaciente.getModel();
		view.tabelaPaciente.setNumRows(0);

		for (int i = 0; i < PacienteController.pacientes.size(); i++) {

			Paciente paciente = PacienteController.pacientes.get(i);

			view.tabelaPaciente.addRow(
					new String[] { paciente.getNome(), paciente.getCpf(), paciente.getObservacaoAdicionalPessoa() });
		}
		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		ListaPaciente.getFrame().dispose();
	}

	public void atualizaTabela() {
		// limpando os campos dos jtextfield's
		view.tabelaPaciente = (DefaultTableModel) view.jtPaciente.getModel();
		view.tabelaPaciente.setNumRows(0);

		for (int i = 0; i < PacienteController.pacientes.size(); i++) {

			Paciente paciente = PacienteController.pacientes.get(i);

			view.tabelaPaciente.addRow(
					new String[] { paciente.getNome(), paciente.getCpf(), paciente.getObservacaoAdicionalPessoa() });

		}
		JOptionPane.showMessageDialog(null, "Lista atualizada!");
	}

	public void gerarListaPaciente() {
	}
}
