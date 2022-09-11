package controller.Paciente;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Pessoa;
import view.Paciente.BuscaPaciente;
import view.Paciente.PrincipalPaciente;

public class BuscaPacienteController {

	private BuscaPaciente<?> view;

	public BuscaPacienteController(BuscaPaciente<?> view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.buscaPaciente();
		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.jftCPFBusca.setText("");

		view.tabelaBuscaPaciente = (DefaultTableModel) view.jtPacienteEncontrado.getModel();
		view.tabelaBuscaPaciente.setNumRows(0);

		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		BuscaPaciente.getFrame().dispose();

	}

	public void buscaPaciente() {
		// deixa o cursor dentro desse jtextfield's
		view.jftCPFBusca.requestFocus();

		String cpf = view.jftCPFBusca.getText();

		PacienteController buscaPacienteController = new PacienteController(null);
		Pessoa resultado = buscaPacienteController.buscarPacientes(cpf);

		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Paciente não cadastrado ou CPF inválido!");
		} else {

			view.tabelaBuscaPaciente = (DefaultTableModel) view.jtPacienteEncontrado.getModel();
			view.tabelaBuscaPaciente
					.addRow(new String[] { resultado.getNome(), resultado.getCpf(), resultado.getDataNascimento(),
							resultado.getTelefone(), resultado.getGenero(), resultado.getObservacaoAdicionalPessoa() });

			// System.out.println(PacienteController.pacientes.toString());
			JOptionPane.showMessageDialog(null, "Busca efetivada!");
		}
		// deixa o cursor dentro desse jtextfield's
		view.jftCPFBusca.requestFocus();

		// limpando os campos dos jtextfield's
		view.jftCPFBusca.setText("");

	}

}
