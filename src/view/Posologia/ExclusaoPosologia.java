
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

public class ExclusaoPosologia implements ActionListener {

	private static JFrame frame = new JFrame("Excluir Posologia");
	private JLabel lbCod;
	public JFormattedTextField jftCodPosologiaBusca;
	public JButton btnApagarPosologia;
	public JButton btnVoltar;

	private ExclusaoPosologiaController controller;

	public ExclusaoPosologia() {
		frame.setSize(400, 280);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

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

		this.controller = new ExclusaoPosologiaController(this);
	}

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
