package controller.Paciente;

import javax.swing.JOptionPane;

import model.Paciente;
import model.Pessoa;
import view.Paciente.CadastroPaciente;
import view.Paciente.PrincipalPaciente;

/**
 * Responsável por pegar todos os dados que estão na view.CadastroPaciente e
 * alocolocá-los no ArrayList pacientes, que está na classe PacienteController.
 * 
 * @author Edilberto
 * @version 11 set 22
 */
public class CadastroPacienteController {

	private CadastroPaciente view;

	/**
	 * Chama o método construtor da classe CadastroPaciente
	 * 
	 * @param view - é a classe view.Paciente.CadastroPaciente.
	 */
	public CadastroPacienteController(CadastroPaciente view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão classe
	 * view.Paciente.CadastroPaciente e identifica qual o método deve ser executado.
	 * 
	 * @param botaoApertado- evento que é descrito na view.Paciente.CadastroPaciente
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.cadastraPaciente();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método limpa os campos e retorna para a tela
	 * view.Paciente.PrincipalPaciente
	 * 
	 */
	public void voltarTelaAnterior() {

		// limpando os campos dos jtextfield's
		view.tfNomePaciente.setText("");
		view.tfCPF.setText("");
		view.tfDataNascimento.setText("");
		view.tfTelefone.setText("");
		view.tfGenero.setText("");
		view.tfObsAdcPaciente.setText("");

		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		CadastroPaciente.getFrame().dispose();
	}

	/**
	 * Ao clicar no botão para cadastrar, este método executa uma busca para evitar
	 * dois CPF's iguais. Sendo bem sucedido, pega os dados que estão na view e
	 * aloca no ArrayList pacientes
	 * 
	 */
	public void cadastraPaciente() {

		String cpfBusca = view.getTfCPF().getText().trim();

		PacienteController buscaPacienteController = new PacienteController(null);
		Pessoa resultado = buscaPacienteController.buscarPacientes(cpfBusca);

		if (resultado != null) {
			JOptionPane.showMessageDialog(null, "Paciente já possui cadastrado!");
		} else {

			// deixa o cursor dentro desse jtextfield's
			view.tfNomePaciente.requestFocus();

			// Cadastra as informações de um paciente no ArrayList pacientes
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
			} else {

				// Adiciona os dados inseridos acima no ArrayList pacientes. Este ArrayList está
				// em controller.MedicamentoController.

				Paciente paciente = new Paciente(nomePaciente, cpf, dataNascimento, telefone, genero,
						observacaoAdicionalPaciente);
				PacienteController.pacientes.add(paciente);
				// System.out.println(PacienteController.pacientes.toString());
				JOptionPane.showMessageDialog(null, "Cadastro efetivado!");

				// limpando os campos dos jtextfield's
				view.tfNomePaciente.setText("");
				view.tfCPF.setText("");
				view.tfDataNascimento.setText("");
				view.tfTelefone.setText("");
				view.tfGenero.setText("");
				view.tfObsAdcPaciente.setText("");

				// deixa o cursor dentro desse jtextfield's
				view.tfNomePaciente.requestFocus();
			}

		}
	}

}
