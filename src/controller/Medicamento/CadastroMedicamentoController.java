package controller.Medicamento;

import javax.swing.JOptionPane;

import model.Medicamento;
import view.Medicamento.CadastroMedicamento;
import view.Medicamento.PrincipalMedicamento;

public class CadastroMedicamentoController {

	private CadastroMedicamento view;

	public CadastroMedicamentoController(CadastroMedicamento view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.cadastraMedicamento();
		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.tfNomeMedicamento.setText("");
		view.tfCodigo.setText("");
		view.tfDescricao.setText("");
		view.tfFabricante.setText("");
		view.tfBula.setText("");
		view.tfPrincipioAtivo.setText("");
		view.tfObsAdcMedicamento.setText("");

		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		CadastroMedicamento.getFrame().dispose();

	}

	public void cadastraMedicamento() {
		// deixa o cursor dentro desse jtextfield's
		view.tfNomeMedicamento.requestFocus();

		// Cadastra as informações de um medicamento na lista

		String nomeRemedio = view.getTfNomeMedicamento().getText().trim();
		String codigo = view.getTfCodigo().getText().trim();
		String descricao = view.getTfDescricao().getText().trim();
		String fabricante = view.getTfFabricante().getText().trim();
		String bula = view.getTfBula().getText().trim();
		String principioAtivo = view.getTfPrincipioAtivo().getText().trim();
		String observacaoAdicionalMedicamento = view.getTfObsAdcMedicamento().getText().trim();

		/**
		 * Adiciona os dados inseridos acima no ArrayList medicamentos. Este ArrayList
		 * está em controller.MedicamentoController, linhas 23 a 26.
		 * 
		 * @version 09 set 22
		 */

		if (view.getTfNomeMedicamento().getText().isEmpty() || view.getTfCodigo().getText().isEmpty()
				|| view.getTfDescricao().getText().isEmpty() || view.getTfFabricante().getText().isEmpty()
				|| view.getTfBula().getText().isEmpty() || view.getTfPrincipioAtivo().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível realizar o cadastro: os dados do medicamento não podem estar vazios!");

		} else {
			Medicamento medicamento = new Medicamento(nomeRemedio, codigo, descricao, fabricante, bula, principioAtivo,
					observacaoAdicionalMedicamento);
			MedicamentoController.medicamentos.add(medicamento);
			JOptionPane.showMessageDialog(null, "Cadastro efetivado!");
		}

		// System.out.println(MedicamentoController.medicamentos.toString());

		// limpando os campos dos jtextfield's
		view.tfNomeMedicamento.setText("");
		view.tfCodigo.setText("");
		view.tfDescricao.setText("");
		view.tfFabricante.setText("");
		view.tfBula.setText("");
		view.tfPrincipioAtivo.setText("");
		view.tfObsAdcMedicamento.setText("");

		// deixa o cursor dentro desse jtextfield's
		view.tfNomeMedicamento.requestFocus();

	}

}
