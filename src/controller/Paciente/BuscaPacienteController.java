package controller.Paciente;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Pessoa;
import view.Paciente.BuscaPaciente;
import view.Paciente.PrincipalPaciente;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Paciente.BuscaPaciente e a classe
 * controller.Paciente.PacienteController, buscando um objeto desejado e
 * retornando seus valores
 * 
 * @author Edilberto
 *
 */

public class BuscaPacienteController {

	private BuscaPaciente<?> view;

	/**
	 * Chama o método construtor da classe BuscaPaciente
	 * 
	 * @param view - é a classe view.Paciente.BuscaPaciente
	 */

	public BuscaPacienteController(BuscaPaciente<?> view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em view.Paciente.BuscaPaciente
	 * e identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na view.Paciente.BuscaPaciente
	 */

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.buscaPaciente();
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

		view.tabelaBuscaPaciente = (DefaultTableModel) view.jtPacienteEncontrado.getModel();
		view.tabelaBuscaPaciente.setNumRows(0);

		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		BuscaPaciente.getFrame().dispose();

	}

	/**
	 * Ao clicar no botão para buscar, este método executa invoca a classe
	 * PacienteController, procurando pelo método buscarPacientes, passando como
	 * parâmetro o CPF do paciente, retornando os dados solicidados que compõem o
	 * ArrayList pacientes
	 * 
	 */

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
