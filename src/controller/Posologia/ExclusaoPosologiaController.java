package controller.Posologia;

import javax.swing.JOptionPane;

import model.Posologia;
import view.Posologia.ExclusaoPosologia;
import view.Posologia.PrincipalPosologia;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Posologia.ExclusaoPosologia e a classe
 * controller.Posologia.PosologiaController, excluindo um objeto desejado.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */
public class ExclusaoPosologiaController {

	private ExclusaoPosologia view;

	/**
	 * Chama o método construtor da classe ExclusaoPosologia
	 * 
	 * @param view - é a classe view.Posologia.ExclusaoPosologia
	 */
	public ExclusaoPosologiaController(ExclusaoPosologia view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Posologia.ExclusaoPosologia e identifica qual o método deve ser
	 * executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Posologia.ExclusaoPosologia
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.excluiPosologia();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método limpa os campos e retorna para a tela
	 * view.Posologia.PrincipalPosologia
	 * 
	 */
	public void voltarTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.jftCodPosologiaBusca.setText("");

		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		ExclusaoPosologia.getFrame().dispose();
	}

	/**
	 * Ao clicar no botão para excluir, este método invoca a classe
	 * PosologiaController, procurando pelo método excluirPosologias, passando como
	 * parâmetro o código da posologia e removendo e realocando as posições dos
	 * demais objetos que compõem o ArrayList posologias
	 * 
	 */
	public void excluiPosologia() {
		// deixa o cursor dentro desse jtextfield's
		view.jftCodPosologiaBusca.requestFocus();

		view.jftCodPosologiaBusca.requestFocus();

		String cod = view.jftCodPosologiaBusca.getText();
		Posologia resultado = PosologiaController.excluirPosologia(cod);

		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Posologia não cadastrada ou código inválido!");
		} else {
			JOptionPane.showMessageDialog(null, "Posologia excluida!");

			// deixa o cursor dentro desse jtextfield's
			view.jftCodPosologiaBusca.requestFocus();

		}
		// System.out.println(PosologiaController.posologias.toString());
	}

}
