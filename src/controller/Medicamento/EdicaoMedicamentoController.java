package controller.Medicamento;

import javax.swing.JOptionPane;

import model.Medicamento;
import view.Medicamento.EdicaoMedicamento;
import view.Medicamento.PrincipalMedicamento;

public class EdicaoMedicamentoController {

	private EdicaoMedicamento view;

	public EdicaoMedicamentoController(EdicaoMedicamento view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();
		}

		if (botaoApertado == view.getBtnEditarMedicamento_edicao()) {
			this.edicaoMedicamento();

		}

		if (botaoApertado == view.getBtnAtualizarCadastroMedicamento()) {
			this.atualizaMedicamento();

		}

	}

	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.tfMedicamentoEdicao.setText("");

		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		EdicaoMedicamento.getFrame().dispose();
	}

	public void edicaoMedicamento() {
		view.tfMedicamentoEdicao.requestFocus();

		String nomeMedicacao = view.tfMedicamentoEdicao.getText();

		/**
		 * Invoca o controller para que ele procure o medicamento pelo seu nome no
		 * método buscarMedicamento.
		 * 
		 * @param nomeMedicacao.
		 * @version 09 set 22.
		 */
		MedicamentoController medicamentoController = new MedicamentoController();
		Medicamento resultado = medicamentoController.buscarMedicamentos(nomeMedicacao);
		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Entrada inválida ou medicamento não cadastrado!");
		} else {

			view.btnAtualizarCadastroMedicamento.setEnabled(true);

			view.tfNomeMedicamento.setText(resultado.getNomeRemedio());
			view.tfNomeMedicamento.setEnabled(true);
			view.tfNomeMedicamento.setEditable(true);

			view.tfCodigo.setText(resultado.getCodigo());
			view.tfCodigo.setEnabled(true);
			view.tfCodigo.setEditable(true);

			view.tfDescricao.setText(resultado.getDescricao());
			view.tfDescricao.setEnabled(true);
			view.tfDescricao.setEditable(true);

			view.tfFabricante.setText(resultado.getFabricante());
			view.tfFabricante.setEnabled(true);
			view.tfFabricante.setEditable(true);

			view.tfBula.setText(resultado.getBula());
			view.tfBula.setEnabled(true);
			view.tfBula.setEditable(true);

			view.tfPrincipioAtivo.setText(resultado.getPrincipioAtivo());
			view.tfPrincipioAtivo.setEnabled(true);
			view.tfPrincipioAtivo.setEditable(true);

			view.tfObsAdcMedicamento.setText(resultado.getObservacaoAdicionalMedicamento());
			view.tfObsAdcMedicamento.setEnabled(true);
			view.tfObsAdcMedicamento.setEditable(true);

		}
	}

	public void atualizaMedicamento() {

		view.tfMedicamentoEdicao.requestFocus();

		String nomeMedicacao = view.tfMedicamentoEdicao.getText();

		// Para inserir as informações de um medicamento na lista (igual ao cadastro)

		// Cadastra as informações de um medicamento na lista
		String nomeRemedio = view.getTfNomeMedicamento().getText().trim();
		String codigo = view.getTfCodigo().getText().trim();
		String descricao = view.getTfDescricao().getText().trim();
		String fabricante = view.getTfFabricante().getText().trim();
		String bula = view.getTfBula().getText().trim();
		String principioAtivo = view.getTfPrincipioAtivo().getText().trim();
		String observacaoAdicionalMedicamento = view.getTfObsAdcMedicamento().getText().trim();

		/**
		 * Invoca o controller para que ele atualize o medicamento, substituindo as
		 * informações antigas e inserindo as novas
		 *
		 * @param nomeMedicacao.
		 * 
		 * @version 09 set 22.
		 */

		if (view.getTfNomeMedicamento().getText().isEmpty() || view.getTfCodigo().getText().isEmpty()
				|| view.getTfDescricao().getText().isEmpty() || view.getTfFabricante().getText().isEmpty()
				|| view.getTfBula().getText().isEmpty() || view.getTfPrincipioAtivo().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível atualizar o cadastro: os dados do medicamento não podem estar vazios!");

		} else {

			MedicamentoController medicamentoController = new MedicamentoController();
			Medicamento medicamento = medicamentoController.buscarMedicamentos(nomeMedicacao);
			// Atualiza os dados do medicamento
			medicamento.setNomeRemedio(nomeRemedio);
			medicamento.setCodigo(codigo);
			medicamento.setDescricao(descricao);
			medicamento.setFabricante(fabricante);
			medicamento.setBula(bula);
			medicamento.setPrincipioAtivo(principioAtivo);
			medicamento.setObservacaoAdicionalMedicamento(observacaoAdicionalMedicamento);
			JOptionPane.showMessageDialog(null, "Atualização efetivada!");

			// limpando os campos dos jtfield's
			view.tfMedicamentoEdicao.setText("");
			view.tfNomeMedicamento.setText("");
			view.tfCodigo.setText("");
			view.tfDescricao.setText("");
			view.tfFabricante.setText("");
			view.tfBula.setText("");
			view.tfPrincipioAtivo.setText("");
			view.tfObsAdcMedicamento.setText("");

			// desabilitando a edição/inserção de texto nos jtfield's
			view.tfNomeMedicamento.setEnabled(false);
			view.tfNomeMedicamento.setEditable(false);
			view.tfCodigo.setEnabled(false);
			view.tfCodigo.setEditable(false);
			view.tfDescricao.setEnabled(false);
			view.tfDescricao.setEditable(false);
			view.tfFabricante.setEnabled(false);
			view.tfFabricante.setEditable(false);
			view.tfBula.setEnabled(false);
			view.tfBula.setEditable(false);
			view.tfPrincipioAtivo.setEnabled(false);
			view.tfPrincipioAtivo.setEditable(false);
			view.tfObsAdcMedicamento.setEnabled(false);
			view.tfObsAdcMedicamento.setEditable(false);
		}
		// System.out.println(MedicamentoController.medicamentos.toString());

	}

}
