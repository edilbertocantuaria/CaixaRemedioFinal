package controller.Medicamento;

import javax.swing.JOptionPane;

import model.Medicamento;
import view.Medicamento.ExclusaoMedicamento;
import view.Medicamento.PrincipalMedicamento;

public class ExclusaoMedicamentoController {

	private ExclusaoMedicamento view;

	public ExclusaoMedicamentoController(ExclusaoMedicamento view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.excluiMedicamento();
		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtfield's
		view.tfMedicamentoBusca.setText("");

		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		ExclusaoMedicamento.getFrame().dispose();
	}

	public void excluiMedicamento() {

		// deixa o cursor dentro desse jtfield's
		view.tfMedicamentoBusca.requestFocus();

		String nomeMedicacao = view.tfMedicamentoBusca.getText();

		/**
		 * Invoca o controller para que ele busque o medicamento pelo seu nome e
		 * retire-o do ArrayList medicamentos.
		 *
		 * @param nomeMedicacao.
		 * 
		 * @version 09 set 22.
		 */

		MedicamentoController medicamentoController = new MedicamentoController();
		Medicamento resultado = medicamentoController.excluirMedicamentos(nomeMedicacao);

		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Medicamento não cadastrado ou nome inválido!");

		} else {

			JOptionPane.showMessageDialog(null, "Medicamento excluído!");

			// deixa o cursor dentro desse jtfield's
			view.tfMedicamentoBusca.requestFocus();

			// limpando os campos dos jtfield's
			view.tfMedicamentoBusca.setText("");

			// System.out.println(MedicamentoController.medicamentos.toString());
		}
	}
}
