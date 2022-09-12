package controller.Paciente;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Paciente;
import view.Paciente.ListaPaciente;
import view.Paciente.PrincipalPaciente;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Paciente.ListaPaciente e a classe
 * controller.Paciente.PacienteController, listando os objetos que compões o
 * ArrayList paciente.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */
public class ListaPacienteController {

	private ListaPaciente view;

	/**
	 * Chama o método construtor da classe ListaPaciente
	 * 
	 * @param view - é a classe view.Paciente.ListaPaciente
	 */
	public ListaPacienteController(ListaPaciente view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em view.Paciente.ListaPaciente
	 * e identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na view.Paciente.ListaPaciente
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();
		}
		if (botaoApertado == view.getBtnAtualizar()) {
			this.atualizaTabela();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método retorna para a tela
	 * view.Paciente.PrincipalPaciente
	 * 
	 */
	public void voltarTelaAnterior() {
		PrincipalPaciente obj = new PrincipalPaciente();
		obj.setVisible(true);
		ListaPaciente.getFrame().dispose();
	}

	/**
	 * Ao clicar no botão para atualizar, este método limpa toda a lista e insere os
	 * dados do ArrayList pacientes (que está em
	 * controller.Paciente.PacienteController) na tabela, atualizando-a, assim, após
	 * um novo cadastro, exclusão ou edição.
	 * 
	 */
	public void atualizaTabela() {
		// limpando os campos dos jtextfield's
		view.tabelaPaciente = (DefaultTableModel) view.jtPaciente.getModel();
		view.tabelaPaciente.setNumRows(0);

		for (int i = 0; i < PacienteController.pacientes.size(); i++) {

			Paciente paciente = PacienteController.pacientes.get(i);

			view.tabelaPaciente
					.addRow(new String[] { paciente.getNome(), paciente.getCpf(), paciente.getDataNascimento(),
							paciente.getTelefone(), paciente.getGenero(), paciente.getObservacaoAdicionalPessoa() });

		}
		JOptionPane.showMessageDialog(null, "Lista atualizada!");
	}

	public void gerarListaPaciente() {
	}
}
