package controller.Posologia;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Posologia;
import view.Posologia.BuscaPosologia;
import view.Posologia.PrincipalPosologia;

public class BuscaPosologiaController {
	private BuscaPosologia view;

	public BuscaPosologiaController(BuscaPosologia view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.buscaPosologia();
		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.jftCodPosologiaBusca.setText("");

		view.tabelaBuscaPosologia = (DefaultTableModel) view.jtPosologiaEncontrada.getModel();
		view.tabelaBuscaPosologia.setNumRows(0);

		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		BuscaPosologia.getFrame().dispose();
	}

	public void buscaPosologia() {
		// deixa o cursor dentro desse jtextfield's
		view.jftCodPosologiaBusca.requestFocus();

		String cod = view.jftCodPosologiaBusca.getText();
		Posologia resultado = PosologiaController.buscarPosologia(cod);

		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Posologia não cadastrada ou código inválido!");
		} else {

			view.tabelaBuscaPosologia = (DefaultTableModel) view.jtPosologiaEncontrada.getModel();
			view.tabelaBuscaPosologia.addRow(new String[] { resultado.getCodigoPosologia(), resultado.getNomePaciente(),
					resultado.getNomeMedicamento(), resultado.getNumeroVezes(), resultado.getRotinaMedicacao(),
					resultado.getHorario1(), resultado.getHorario2(), resultado.getHorario3(), resultado.getHorario4(),
					resultado.getHorario5(), resultado.getHorario6(), resultado.getDosagem(),
					resultado.getAspectoMedicamento(), resultado.getDataInicioTratamento(),
					resultado.getDataFimTratamento(), resultado.getObservacaoAdicionalPosologia() });

			// System.out.println(PacienteController.pacientes.toString());
			JOptionPane.showMessageDialog(null, "Busca efetivada!");
		}
		// deixa o cursor dentro desse jtextfield's
		view.jftCodPosologiaBusca.requestFocus();

		// limpando os campos dos jtextfield's
		view.jftCodPosologiaBusca.setText("");

	}

}
