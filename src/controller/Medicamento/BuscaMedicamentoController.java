package controller.Medicamento;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Medicamento;
import view.Medicamento.BuscaMedicamento;
import view.Medicamento.PrincipalMedicamento;

public class BuscaMedicamentoController {

	private BuscaMedicamento view;

	public BuscaMedicamentoController(BuscaMedicamento view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.limpaCampo();

		} else {
			this.buscaMedicamento();
		}

	}

	public void limpaCampo() {
		// limpando os campos dos jtextfield's
		view.tfMedicamentoBusca.setText("");

		// deixa o cursor dentro desse jtextfield's
		view.tfMedicamentoBusca.requestFocus();
		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		BuscaMedicamento.frame.dispose();

	}

	public void buscaMedicamento() {
		// deixa o cursor dentro desse jtextfield's
		view.tfMedicamentoBusca.requestFocus();

		String nomeMedicacao = view.tfMedicamentoBusca.getText();

		MedicamentoController medicamentoController = new MedicamentoController();
		Medicamento resultado = medicamentoController.buscarMedicamentos(nomeMedicacao);

		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Medicamento não cadastrado!");
		} else {
			view.tabelaBuscaMedicamento = (DefaultTableModel) view.jtMedicacaoEncontrada.getModel();
			view.tabelaBuscaMedicamento.addRow(new String[] { resultado.getNomeRemedio(), resultado.getCodigo(),
					resultado.getDescricao(), resultado.getFabricante(), resultado.getBula(),
					resultado.getObservacaoAdicionalMedicamento() });

			JOptionPane.showMessageDialog(null, "Busca efetivada!");

			// limpando os campos dos jtextfield's
			view.tfMedicamentoBusca.setText("");

			// deixa o cursor dentro desse jtextfield's
			view.tfMedicamentoBusca.requestFocus();

		}

	}
}
