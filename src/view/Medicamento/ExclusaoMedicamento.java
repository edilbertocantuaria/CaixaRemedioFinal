package view.Medicamento;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Medicamento.ExclusaoMedicamentoController;

/**
 * É a tela para o exclusão dos medicamentos, onde ocorre o dele do CRUD. Ele
 * busca o remédio pelo nome e o remove do ArrayList medicamentos.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */

public class ExclusaoMedicamento implements ActionListener {
	private static JFrame frame = new JFrame("Excluir Medicamento");
	private JLabel instrucao;
	private JLabel lbInstrucaoInfo;
	public TextField tfMedicamentoBusca;
	public JButton btnApagarMedicamento;
	public JButton btnVoltar;

	private ExclusaoMedicamentoController controller;

	/**
	 * Define as dimensões físicas da tela ExclusaoMedicamento
	 * 
	 * @version 09 set 22.
	 */
	public ExclusaoMedicamento() {
		frame.setSize(446, 280);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na tela
	 * ExclusaoMedicamento
	 * 
	 * @version 09 out 22.
	 */
	private void placeComponents(JPanel panel) {
		setController(new ExclusaoMedicamentoController(this));

		panel.setLayout(null);

		instrucao = new JLabel("Digite o nome do medicamento: ");
		instrucao.setBounds(10, 10, 200, 25);
		panel.add(instrucao);

		lbInstrucaoInfo = new JLabel("(tudo maiúsculo)");
		lbInstrucaoInfo.setBounds(10, 23, 200, 25);
		panel.add(lbInstrucaoInfo);

		tfMedicamentoBusca = new TextField();
		tfMedicamentoBusca.setBounds(227, 10, 193, 25);
		panel.add(tfMedicamentoBusca);

		btnApagarMedicamento = new JButton("Excluir Medicamento");
		btnApagarMedicamento.setBounds(10, 50, 175, 25);
		panel.add(btnApagarMedicamento);
		btnApagarMedicamento.addActionListener(this);

		/**
		 * Determina a ação do btnVoltar, que neste caso fecha a tela
		 * ExclusaoMedicamento e abre a tela PrincipalMedicamento
		 * 
		 * @version 09 set. 22.
		 */
		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(this);

		this.controller = new ExclusaoMedicamentoController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());

	}

	private void setController(ExclusaoMedicamentoController exclusaoMedicamentoController) {
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JLabel getInstrucao() {
		return instrucao;
	}

	public TextField getTfMedicamentoBusca() {
		return tfMedicamentoBusca;
	}

	public JButton getBtnApagarMedicamento() {
		return btnApagarMedicamento;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public ExclusaoMedicamentoController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		ExclusaoMedicamento.frame = frame;
	}

	public void setInstrucao(JLabel instrucao) {
		this.instrucao = instrucao;
	}

	public void setTfMedicamentoBusca(TextField tfMedicamentoBusca) {
		this.tfMedicamentoBusca = tfMedicamentoBusca;
	}

	public void setBtnApagarMedicamento(JButton btnApagarMedicamento) {
		this.btnApagarMedicamento = btnApagarMedicamento;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

}
