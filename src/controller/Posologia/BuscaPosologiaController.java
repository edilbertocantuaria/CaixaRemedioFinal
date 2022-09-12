package controller.Posologia;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Posologia;
import view.Posologia.BuscaPosologia;
import view.Posologia.PrincipalPosologia;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Posologia.BuscaPosologia e a classe
 * controller.Posologia.PosologiaController, buscando um objeto desejado e
 * retornando seus valores
 * 
 * @author Edilberto
 *
 */

public class BuscaPosologiaController {
	private BuscaPosologia view;

	/**
	 * Chama o método construtor da classe BuscaPosologia
	 * 
	 * @param view - é a classe view.Posologia.BuscaPosologia
	 */

	public BuscaPosologiaController(BuscaPosologia view) {
		this.view = view;

	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Posologia.BuscaPosologia e identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na view.Posologia.BuscaPosologia
	 */

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltarTelaAnterior();

		} else {
			this.buscaPosologia();
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

		view.tabelaBuscaPosologia = (DefaultTableModel) view.jtPosologiaEncontrada.getModel();
		view.tabelaBuscaPosologia.setNumRows(0);

		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		BuscaPosologia.getFrame().dispose();
	}

	/**
	 * Ao clicar no botão para buscar, este método executa invoca a classe
	 * PosologiaController, procurando pelo método buscarPosologias, passando como
	 * parâmetro o código da posologia, retornando os dados solicidados que compõem
	 * o ArrayList posologias
	 * 
	 */

	public void buscaPosologia() {
		// deixa o cursor dentro desse jtextfield's
		view.jftCodPosologiaBusca.requestFocus();

		String cod = view.jftCodPosologiaBusca.getText();
		Posologia resultado = PosologiaController.buscarPosologia(cod);

		if (resultado == null) {
			JOptionPane.showMessageDialog(null, "Posologia não cadastrada ou código inválido!");
		} else {

			view.tabelaBuscaPosologia = (DefaultTableModel) view.jtPosologiaEncontrada.getModel();
			view.tabelaBuscaPosologia.addRow(new String[] { resultado.getCodigoPosologia(), resultado.getNomePaciente(),
					resultado.getNomeMedicamento(), resultado.getNumeroVezes(), resultado.getRotinaMedicacao(),
					resultado.getHorario1(), resultado.getHorario2(), resultado.getHorario3(), resultado.getHorario4(),
					resultado.getHorario5(), resultado.getHorario6(), resultado.getDosagem(),
					resultado.getAspectoMedicamento(), resultado.getDataInicioTratamento(),
					resultado.getDataFimTratamento(), resultado.getObservacaoAdicionalPosologia() });

			// System.out.println(PacienteController.pacientes.toString());
			JOptionPane.showMessageDialog(null, "Busca efetivada!");
		}
		// deixa o cursor dentro desse jtextfield's
		view.jftCodPosologiaBusca.requestFocus();

		// limpando os campos dos jtextfield's
		view.jftCodPosologiaBusca.setText("");

	}

}
