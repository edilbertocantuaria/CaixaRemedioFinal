package controller.Medicamento;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Medicamento;
import view.Medicamento.BuscaMedicamento;
import view.Medicamento.PrincipalMedicamento;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Medicamento.BuscaMedicamento e a classe
 * controller.Medicamento.MedicamentoController, buscando um objeto desejado e
 * retornando seus valores
 * 
 * @author Edilberto
 *
 */
public class BuscaMedicamentoController {

	private BuscaMedicamento view;

	/**
	 * Chama o método construtor da classe BuscaMedicamento
	 * 
	 * @param view - é a classe view.Medicamento.BuscaMedicamento
	 */
	public BuscaMedicamentoController(BuscaMedicamento view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Medicamento.BuscaMedicamento e identifica qual o método deve ser
	 * executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Medicamento.BuscaMedicamento
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.buscaMedicamento();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método limpa os campos e retorna para a tela
	 * view.Medicamento.PrincipalMedicamento
	 * 
	 */
	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.tabelaBuscaMedicamento = (DefaultTableModel) view.jtMedicacaoEncontrada.getModel();
		view.tabelaBuscaMedicamento.setNumRows(0);

		// deixa o cursor dentro desse jtextfield's
		view.tfMedicamentoBusca.requestFocus();
		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		BuscaMedicamento.frame.dispose();

	}

	/**
	 * Ao clicar no botão para buscar, este método executa invoca a classe
	 * MedicamentoController, procurando pelo método buscarMedicamentos, passando
	 * como parâmetro o nome do medicamento, retornando os dados solicidados que
	 * compõem o ArrayList medicamentos medicamentos
	 * 
	 */
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
