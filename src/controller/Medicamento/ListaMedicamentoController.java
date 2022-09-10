package controller.Medicamento;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Medicamento;
import view.Medicamento.ListaMedicamento;
import view.Medicamento.PrincipalMedicamento;

public class ListaMedicamentoController {

	private ListaMedicamento view;

	public ListaMedicamentoController(ListaMedicamento view) {
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
		view.tabelaMedicacao = (DefaultTableModel) view.jtMedicacao.getModel();
		view.tabelaMedicacao.setNumRows(0);

		for (int i = 0; i < MedicamentoController.medicamentos.size(); i++) {

			Medicamento medicamento = MedicamentoController.medicamentos.get(i);

			view.tabelaMedicacao.addRow(new String[] { medicamento.getNomeRemedio(), medicamento.getDescricao(),
					medicamento.getObservacaoAdicionalMedicamento() });
		}
		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		ListaMedicamento.getFrame().dispose();

	}

	public void atualizaTabela() {
		// limpando os campos dos jtextfield's
		view.tabelaMedicacao = (DefaultTableModel) view.jtMedicacao.getModel();
		view.tabelaMedicacao.setNumRows(0);

		for (int i = 0; i < MedicamentoController.medicamentos.size(); i++) {

			Medicamento medicamento = MedicamentoController.medicamentos.get(i);

			view.tabelaMedicacao.addRow(new String[] { medicamento.getNomeRemedio(), medicamento.getDescricao(),
					medicamento.getObservacaoAdicionalMedicamento() });
		}
		JOptionPane.showMessageDialog(null, "Lista atualizada!");
	}
}
