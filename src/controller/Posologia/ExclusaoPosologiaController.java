package controller.Posologia;

import javax.swing.JOptionPane;

import model.Posologia;
import view.Posologia.ExclusaoPosologia;
import view.Posologia.PrincipalPosologia;

public class ExclusaoPosologiaController {

	private ExclusaoPosologia view;

	public ExclusaoPosologiaController(ExclusaoPosologia view) {
		this.view = view;

	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.limpaCampo();

		} else {
			this.excluiPosologia();
		}

	}

	public void limpaCampo() {
		// limpando os campos dos jtextfield's
		view.jftCodPosologiaBusca.setText("");

		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		ExclusaoPosologia.getFrame().dispose();
	}

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
