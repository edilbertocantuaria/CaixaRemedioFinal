package controller.Posologia;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Posologia;
import view.Posologia.ListaPosologia;
import view.Posologia.PrincipalPosologia;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Posologia.ListaPosologia e a classe
 * controller.Posologia.PosologiaController, listando os objetos que compões o
 * ArrayList posologia.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */
public class ListaPosologiaController {

	/**
	 * Chama o método construtor da classe ListaPosologia
	 * 
	 * @param view - é a classe view.Posologia.ListaPosologia
	 */
	private ListaPosologia view;

	public ListaPosologiaController(ListaPosologia view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Posologia.ListaPosologia e identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na view.Posologia.ListaPosologia
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
	 * view.Posologia.PrincipalPosologia
	 * 
	 */
	public void voltarTelaAnterior() {
		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		ListaPosologia.getFrame().dispose();

	}

	/**
	 * Ao clicar no botão para atualizar, este método limpa toda a lista e insere os
	 * dados do ArrayList posologias (que está em
	 * controller.Posologia.PosologiaController) na tabela, atualizando-a, assim,
	 * após um novo cadastro, exclusão ou edição.
	 * 
	 */
	public void atualizaTabela() {
		// limpando os campos dos jtextfield's
		view.tabelaPosologia = (DefaultTableModel) view.jtPosologia.getModel();
		view.tabelaPosologia.setNumRows(0);

		for (int i = 0; i < PosologiaController.posologias.size(); i++) {

			Posologia posologia = PosologiaController.posologias.get(i);

			view.tabelaPosologia.addRow(new String[] { posologia.getCodigoPosologia(), posologia.getNomePaciente(),
					posologia.getNomeMedicamento(), (posologia.getNumeroVezes()), (posologia.getRotinaMedicacao()),
					posologia.getHorario1(), posologia.getHorario2(), posologia.getHorario3(), posologia.getHorario4(),
					posologia.getHorario5(), posologia.getHorario6(), (posologia.getDosagem()),
					(posologia.getAspectoMedicamento()), posologia.getDataInicioTratamento(),
					posologia.getDataFimTratamento(), posologia.getObservacaoAdicionalPosologia() });
		}
		JOptionPane.showMessageDialog(null, "Lista atualizada!");
	}
}
