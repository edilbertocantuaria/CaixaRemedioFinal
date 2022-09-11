package controller.Paciente;

import javax.swing.JOptionPane;

import model.Pessoa;
import view.Paciente.EdicaoPaciente;
import view.Paciente.PrincipalPaciente;

public class EdicaoPacienteController {

	private EdicaoPaciente view;

	public EdicaoPacienteController(EdicaoPaciente view) {
		this.view = view;
	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();
		}

		if (botaoApertado == view.getBtnEditarPaciente_edicao()) {
			this.edicaoPaciente();

		}

		if (botaoApertado == view.getBtnAtualizarCadastroPaciente()) {
			this.atualizarPaciente();

		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.jftCPFBusca.setText("");

		// desabilita o botão de atualizar paciente
		view.btnAtualizarCadastroPaciente.setEnabled(false);

		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		EdicaoPaciente.getFrame().dispose();
	}

	public void edicaoPaciente() {
		view.jftCPFBusca.requestFocus();

		if (view.jftCPFBusca.getText().matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {

			String cpf = view.jftCPFBusca.getText();

			PacienteController pacienteController = new PacienteController(null);
			Pessoa resultado = pacienteController.buscarPacientes(cpf);
			if (resultado != null) {
				view.btnAtualizarCadastroPaciente.setEnabled(true);

				view.tfNomePaciente.setText(resultado.getNome());
				view.tfNomePaciente.setEnabled(true);
				view.tfNomePaciente.setEditable(true);

				view.tfCPF.setText(resultado.getCpf());
				view.tfCPF.setEnabled(true);
				view.tfCPF.setEditable(true);

				view.tfDataNascimento.setText(resultado.getDataNascimento());
				view.tfDataNascimento.setEnabled(true);
				view.tfDataNascimento.setEditable(true);

				view.tfTelefone.setText(resultado.getTelefone());
				view.tfTelefone.setEnabled(true);
				view.tfTelefone.setEditable(true);

				view.tfGenero.setText(resultado.getGenero());
				view.tfGenero.setEnabled(true);
				view.tfGenero.setEditable(true);

				view.tfObsAdcPaciente.setText(resultado.getObservacaoAdicionalPessoa());
				view.tfObsAdcPaciente.setEnabled(true);
				view.tfObsAdcPaciente.setEditable(true);
			} else {
				JOptionPane.showMessageDialog(null, "Paciente não cadastrado ou CPF inválido!");

			}
		} else {
			JOptionPane.showMessageDialog(null, "Paciente não cadastrado ou CPF inválido!");
		}
	}

	public void atualizarPaciente() {
		String cpfBusca = view.jftCPFBusca.getText();

		// Para inserir as informações de um paciente na lista (igual a do cadastro)
		String nomePaciente = view.getTfNomePaciente().getText().trim();
		String cpf = view.getTfCPF().getText().trim();
		String dataNascimento = view.getTfDataNascimento().getText().trim();
		String telefone = view.getTfTelefone().getText().trim();
		String genero = view.getTfGenero().getText().trim();
		String observacaoAdicionalPaciente = view.getTfObsAdcPaciente().getText().trim();

		int i, j, k;
		if (view.getTfCPF().getText().matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
			i = 0;
		} else {
			i = 1;
		}

		if (view.getTfDataNascimento().getText().matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$")) {
			j = 0;
		} else {
			j = 1;
		}

		if (view.getTfTelefone().getText().matches("\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4}")) {
			k = 0;
		} else {
			k = 1;
		}

		if (view.getTfNomePaciente().getText().isEmpty() || i == 1 || j == 1 || k == 1
				|| view.getTfGenero().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível realizar o cadastro: os dados do paciente não podem estar vazios!");
		}

		else {
			PacienteController pacienteController = new PacienteController(null);
			Pessoa paciente = pacienteController.buscarPacientes(cpfBusca);

			// Atualiza os dados do paciente
			paciente.setNome(nomePaciente);
			paciente.setCpf(cpf);
			paciente.setDataNascimento(dataNascimento);
			paciente.setTelefone(telefone);
			paciente.setGenero(genero);
			paciente.setObservacaoAdicionalPessoa(observacaoAdicionalPaciente);

			// System.out.println(PacienteController.pacientes.toString());
			JOptionPane.showMessageDialog(null, "Atualização efetivada!");

			// limpando os campos dos jtextfield's
			view.tfNomePaciente.setText("");
			view.tfCPF.setText("");
			view.tfDataNascimento.setText("");
			view.tfTelefone.setText("");
			view.tfGenero.setText("");
			view.tfObsAdcPaciente.setText("");
			view.jftCPFBusca.setText("");

			// desabilitando a edição/inserção de texto nos jtexview.tfield's
			view.tfNomePaciente.setEnabled(false);
			view.tfNomePaciente.setEditable(false);
			view.tfCPF.setEnabled(false);
			view.tfCPF.setEditable(false);
			view.tfDataNascimento.setEnabled(false);
			view.tfDataNascimento.setEditable(false);
			view.tfTelefone.setEnabled(false);
			view.tfTelefone.setEditable(false);
			view.tfGenero.setEnabled(false);
			view.tfGenero.setEditable(false);
			view.tfObsAdcPaciente.setEnabled(false);
			view.tfObsAdcPaciente.setEditable(false);

		}

	}

}