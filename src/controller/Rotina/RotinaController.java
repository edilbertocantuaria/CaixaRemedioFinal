package controller.Rotina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.Posologia.PosologiaController;
import model.Posologia;
import view.Posologia.PrincipalPosologia;
import view.Rotina.PrincipalRotina;

public class RotinaController implements ActionListener {

	private PrincipalRotina view;

	public RotinaController(PrincipalRotina view) {
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
		view.tabelaPosologia = (DefaultTableModel) view.jtPosologia.getModel();
		view.tabelaPosologia.setNumRows(0);

		for (int i = 0; i < PosologiaController.posologias.size(); i++) {

			Posologia posologia = PosologiaController.posologias.get(i);

			view.tabelaPosologia.addRow(new String[] { posologia.getCodigoPosologia(), posologia.getNomePaciente(),
					posologia.getNomeMedicamento(), (posologia.getDosagem()), (posologia.getAspectoMedicamento()),
					posologia.getHorario1(), posologia.getHorario2(), posologia.getHorario3(), posologia.getHorario4(),
					posologia.getHorario5(), posologia.getHorario6(), posologia.getDataInicioTratamento(),
					posologia.getDataFimTratamento(), posologia.getObservacaoAdicionalPosologia() });
		}
		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		PrincipalRotina.getFrame().dispose();

	}

	public void atualizaTabela() {
		// limpando os campos dos jtextfield's
		view.tabelaPosologia = (DefaultTableModel) view.jtPosologia.getModel();
		view.tabelaPosologia.setNumRows(0);

		for (int i = 0; i < PosologiaController.posologias.size(); i++) {

			Posologia posologia = PosologiaController.posologias.get(i);

			view.tabelaPosologia.addRow(new String[] { posologia.getCodigoPosologia(), posologia.getNomePaciente(),
					posologia.getNomeMedicamento(), (posologia.getDosagem()), (posologia.getAspectoMedicamento()),
					posologia.getHorario1(), posologia.getHorario2(), posologia.getHorario3(), posologia.getHorario4(),
					posologia.getHorario5(), posologia.getHorario6(), posologia.getDataInicioTratamento(),
					posologia.getDataFimTratamento(), posologia.getObservacaoAdicionalPosologia() });
		}
		JOptionPane.showMessageDialog(null, "Lista atualizada!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
