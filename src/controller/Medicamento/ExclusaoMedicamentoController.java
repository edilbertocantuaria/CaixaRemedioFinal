package controller.Medicamento;

import javax.swing.JOptionPane;

import model.Medicamento;
import view.Medicamento.ExclusaoMedicamento;
import view.Medicamento.PrincipalMedicamento;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Medicamento.ExclusaoMedicamento e a classe
 * controller.Medicamento.MedicamentoController, excluindo um objeto desejado.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */
public class ExclusaoMedicamentoController {

	private ExclusaoMedicamento view;

	/**
	 * Chama o método construtor da classe ExclusaoMedicamento
	 * 
	 * @param view - é a classe view.Medicamento.ExclusaoMedicamento
	 */
	public ExclusaoMedicamentoController(ExclusaoMedicamento view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Medicamento.ExclusaoMedicamento e identifica qual o método deve ser
	 * executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Medicamento.ExclusaoMedicamento
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.excluiMedicamento();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método limpa os campos e retorna para a tela
	 * view.Medicamento.PrincipalMedicamento
	 * 
	 */
	public void voltarTelaAnterior() {
		// limpando os campos dos jtfield's
		view.tfMedicamentoBusca.setText("");

		PrincipalMedicamento obj = new PrincipalMedicamento();
		obj.setVisible(true);
		ExclusaoMedicamento.getFrame().dispose();
	}

	/**
	 * Ao clicar no botão para excluir, este método invoca a classe
	 * MedicamentoController, procurando pelo método excluirMedicamentos, passando
	 * como parâmetro o nome do medicamento e removendo e realocando as posições dos
	 * demais objetos que compõem o ArrayList medicamentos
	 * 
	 */
	public void excluiMedicamento() {

		// deixa o cursor dentro desse jtfield's
		view.tfMedicamentoBusca.requestFocus();

		String nomeMedicacao = view.tfMedicamentoBusca.getText();

		// Invoca o controller para que ele procure o medicamento pelo seu nome no
		// método excluirMedicamentos.
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
