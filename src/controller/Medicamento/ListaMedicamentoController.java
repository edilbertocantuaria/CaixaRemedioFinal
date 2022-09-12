package controller.Medicamento;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Medicamento;
import view.Medicamento.ListaMedicamento;
import view.Medicamento.PrincipalMedicamento;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Medicamento.ListaMedicamento e a classe
 * controller.Medicamento.MedicamentoController, listando os objetos que compões
 * o ArrayList medicamento.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */
public class ListaMedicamentoController {

	private ListaMedicamento view;

	/**
	 * Chama o método construtor da classe ListaMedicamento
	 * 
	 * @param view - é a classe view.Medicamento.ListaMedicamento
	 */
	public ListaMedicamentoController(ListaMedicamento view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Medicamento.ListaMedicamento e identifica qual o método deve ser
	 * executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Medicamento.ListaMedicamento
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
	 * view.Medicamento.PrincipalMedicamento
	 * 
	 */

	public void voltarTelaAnterior() {
		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		ListaMedicamento.getFrame().dispose();

	}

	/**
	 * Ao clicar no botão para atualizar, este método limpa toda a lista e insere os
	 * dados do ArrayList medicamentos (que está em
	 * controller.Medicamento.MedicamentoController) na tabela, atualizando-a,
	 * assim, após um novo cadastro, exclusão ou edição.
	 * 
	 */
	public void atualizaTabela() {
		// limpando os campos dos jtextfield's
		view.tabelaMedicacao = (DefaultTableModel) view.jtMedicacao.getModel();
		view.tabelaMedicacao.setNumRows(0);

		for (int i = 0; i < MedicamentoController.medicamentos.size(); i++) {

			Medicamento medicamento = MedicamentoController.medicamentos.get(i);

			view.tabelaMedicacao.addRow(new String[] { medicamento.getNomeRemedio(), medicamento.getCodigo(),
					medicamento.getDescricao(), medicamento.getFabricante(), medicamento.getBula(),
					medicamento.getObservacaoAdicionalMedicamento() });
		}
		JOptionPane.showMessageDialog(null, "Lista atualizada!");
	}
}
