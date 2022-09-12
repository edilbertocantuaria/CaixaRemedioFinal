
package view.Posologia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import controller.Posologia.ExclusaoPosologiaController;

/**
 * É a tela para a exclusão das posologias. Ela recebe o nome do posologia,
 * envia para o controller.Posologia.EdicaoPosologiaController e, se cadastrado
 * no ArrayList, permite a remoção. *
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class ExclusaoPosologia implements ActionListener {

	private static JFrame frame = new JFrame("Excluir Posologia");
	private JLabel lbCod;
	public JFormattedTextField jftCodPosologiaBusca;
	public JButton btnApagarPosologia;
	public JButton btnVoltar;

	private ExclusaoPosologiaController controller;

	/**
	 * Define as dimensões físicas da view.Posologia.EdicaoPosologia
	 * 
	 */
	public ExclusaoPosologia() {
		frame.setSize(400, 280);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na
	 * view.Posologia.EdicaoPosologia EdicaoPosologia
	 * 
	 */
	private void placeComponents(JPanel panel) {
		setController(new ExclusaoPosologiaController(this));
		panel.setLayout(null);

		MaskFormatter mascaraCodigo = null;
		try {
			mascaraCodigo = new MaskFormatter("###");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		lbCod = new JLabel("Digite o Código:");
		lbCod.setBounds(20, 10, 136, 25);
		panel.add(lbCod);

		jftCodPosologiaBusca = new JFormattedTextField(mascaraCodigo);
		jftCodPosologiaBusca.setBounds(166, 10, 100, 25);
		panel.add(jftCodPosologiaBusca);

		btnApagarPosologia = new JButton("Excluir Posologia");
		btnApagarPosologia.setBounds(10, 50, 146, 25);
		btnApagarPosologia.addActionListener(this);
		panel.add(btnApagarPosologia);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 175, 23);
		btnVoltar.addActionListener(this);
		panel.add(btnVoltar);

		// Invoca o controller, que neste caso, é EdicaoPosologiaController,
		// apontandoque a ação está descrita nesta parte do código
		this.controller = new ExclusaoPosologiaController(this);
	}

	/**
	 * Está recebendo, o evento dos botões que estão na
	 * view.Posologia.EdicaoPosologia e invoca o controller
	 * controller.Posologia.EdicaoPosologia para saber qual deve ser a ação
	 * executada
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JFormattedTextField getJftCodPosologiaBusca() {
		return jftCodPosologiaBusca;
	}

	public JButton getBtnApagarPosologia() {
		return btnApagarPosologia;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public ExclusaoPosologiaController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		ExclusaoPosologia.frame = frame;
	}

	public void setJftCodPosologiaBusca(JFormattedTextField jftCodPosologiaBusca) {
		this.jftCodPosologiaBusca = jftCodPosologiaBusca;
	}

	public void setBtnApagarPosologia(JButton btnApagarPosologia) {
		this.btnApagarPosologia = btnApagarPosologia;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setController(ExclusaoPosologiaController controller) {
		this.controller = controller;
	}

}
