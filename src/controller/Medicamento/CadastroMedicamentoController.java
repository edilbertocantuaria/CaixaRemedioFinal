package controller.Medicamento;

import javax.swing.JOptionPane;

import model.Medicamento;
import view.Medicamento.CadastroMedicamento;
import view.Medicamento.PrincipalMedicamento;

/**
 * Responsável por pegar todos os dados que estão na view.CadastroMedicamento e
 * alocolocá-los no ArrayList medicamentos, que está na classe
 * MedicamentoController.
 * 
 * @author Edilberto
 * @version 09 set 22
 *
 */
public class CadastroMedicamentoController {

	private CadastroMedicamento view;

	/**
	 * Chama o método construtor da classe CadastroMedicamento
	 * 
	 * @param view - é a classe view.Medicamento.CadastroMedicamento
	 */
	public CadastroMedicamentoController(CadastroMedicamento view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão classe
	 * view.Medicamento.CadastroMedicamento e identifica qual o método deve ser
	 * executado.
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Medicamento.CadastroMedicamento
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.cadastraMedicamento();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método limpa os campos e retorna para a tela
	 * view.Medicamento.PrincipalMedicamento
	 * 
	 */
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

	/**
	 * Ao clicar no botão para cadastrar, este método executa uma busca para evitar
	 * dois nomes de medicamentos iguais. Sendo bem sucedido, pega os dados que
	 * estão na view e aloca no ArrayList medicamentos
	 * 
	 */
	public void cadastraMedicamento() {

		String nomeMedicacao = view.getTfNomeMedicamento().getText();

		MedicamentoController medicamentoController = new MedicamentoController();
		Medicamento resultado = medicamentoController.buscarMedicamentos(nomeMedicacao);

		if (resultado != null) {
			JOptionPane.showMessageDialog(null, "Medicamento já possui cadastrado!");
		} else {
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

			if (view.getTfNomeMedicamento().getText().isEmpty() || view.getTfCodigo().getText().isEmpty()
					|| view.getTfDescricao().getText().isEmpty() || view.getTfFabricante().getText().isEmpty()
					|| view.getTfBula().getText().isEmpty() || view.getTfPrincipioAtivo().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Não foi possível realizar o cadastro: os dados do medicamento não podem estar vazios!");

			} else {
				// Adiciona os dados inseridos acima no ArrayList medicamentos. Este ArrayList
				// está em controller.MedicamentoController.
				Medicamento medicamento = new Medicamento(nomeRemedio, codigo, descricao, fabricante, bula,
						principioAtivo, observacaoAdicionalMedicamento);
				MedicamentoController.medicamentos.add(medicamento);
				JOptionPane.showMessageDialog(null, "Cadastro efetivado!");

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

			// System.out.println(MedicamentoController.medicamentos.toString());

		}
	}

}
