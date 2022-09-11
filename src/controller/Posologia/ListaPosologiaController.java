package controller.Posologia;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Posologia;
import view.Posologia.ListaPosologia;
import view.Posologia.PrincipalPosologia;

public class ListaPosologiaController {

	private ListaPosologia view;

	public ListaPosologiaController(ListaPosologia view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.limpaCampo();
		}
		if (botaoApertado == view.getBtnAtualizar()) {
			this.atualizaTabela();
		}

	}

	public void limpaCampo() {
		// limpando os campos dos jtextfield's
		view.tabelaPosologia = (DefaultTableModel) view.jtPosologia.getModel();
		view.tabelaPosologia.setNumRows(0);

		for (int i = 0; i < PosologiaController.posologias.size(); i++) {

			Posologia posologia = PosologiaController.posologias.get(i);

			view.tabelaPosologia.addRow(new String[] { posologia.getCodigoPosologia(), posologia.getNomePaciente(),
					posologia.getNomeMedicamento(), (posologia.getDosagem()), posologia.getHorario1(),
					posologia.getHorario2(), posologia.getHorario3(), posologia.getHorario4(), posologia.getHorario5(),
					posologia.getHorario6(), posologia.getDataInicioTratamento(), posologia.getDataFimTratamento(),
					posologia.getObservacaoAdicionalPosologia() });
		}
		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		ListaPosologia.getFrame().dispose();

	}

	public void atualizaTabela() {
		// limpando os campos dos jtextfield's
		view.tabelaPosologia = (DefaultTableModel) view.jtPosologia.getModel();
		view.tabelaPosologia.setNumRows(0);

		for (int i = 0; i < PosologiaController.posologias.size(); i++) {

			Posologia posologia = PosologiaController.posologias.get(i);

			view.tabelaPosologia.addRow(new String[] { posologia.getCodigoPosologia(), posologia.getNomePaciente(),
					posologia.getNomeMedicamento(), (posologia.getDosagem()), posologia.getHorario1(),
					posologia.getHorario2(), posologia.getHorario3(), posologia.getHorario4(), posologia.getHorario5(),
					posologia.getHorario6(), posologia.getDataInicioTratamento(), posologia.getDataFimTratamento(),
					posologia.getObservacaoAdicionalPosologia() });
		}
		JOptionPane.showMessageDialog(null, "Lista atualizada!");
	}
}
