package view.Medicamento;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Medicamento.BuscaMedicamentoController;

/**
 * É a tela para a busca dos medicamentos. Ela recebe o nome do medicamento,
 * envia para o controller.Medicamento.BuscaMedicamentoController e, se
 * cadastrado no ArrayList, exibe as informações deste.
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class BuscaMedicamento implements ActionListener {
	public static JFrame frame = new JFrame("Buscar cadastro de medicamento");

	private JPanel panel;
	private JLabel lbInstrucao;
	private JLabel lbInstrucaoInfo;
	private JLabel lbMedicacaoEncontrada;

	public JButton btnBuscar;
	public JButton btnVoltar;
	public TextField tfMedicamentoBusca;

	private JPanel panel_1;
	private JScrollPane scrollPane;
	public JTable jtMedicacaoEncontrada;

	public DefaultTableModel tabelaBuscaMedicamento;

	public BuscaMedicamentoController controller;

	/**
	 * Define as dimensões físicas da view.Medicamento.BuscaMedicamento
	 * 
	 */
	public BuscaMedicamento() {
		frame.setSize(1000, 280);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na
	 * view.Medicamento.BuscaMedicamento BuscaMedicamento
	 * 
	 */
	private void placeComponents(JPanel panel) {
		setController(new BuscaMedicamentoController(this));
		panel.setLayout(null);

		lbInstrucao = new JLabel("Digite o nome do medicamento: ");
		lbInstrucao.setBounds(10, 10, 200, 25);
		panel.add(lbInstrucao);
		lbInstrucaoInfo = new JLabel("(tudo maiúsculo)");
		lbInstrucaoInfo.setBounds(10, 23, 200, 25);
		panel.add(lbInstrucaoInfo);

		tfMedicamentoBusca = new TextField();
		tfMedicamentoBusca.setBounds(260, 10, 200, 25);
		panel.add(tfMedicamentoBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(466, 10, 85, 25);
		panel.add(btnBuscar);

		lbMedicacaoEncontrada = new JLabel("Medicação encontrada");
		lbMedicacaoEncontrada.setBounds(10, 55, 200, 25);
		panel.add(lbMedicacaoEncontrada);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 88, 964, 116);
		panel.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 964, 116);
		panel_1.add(scrollPane);

		jtMedicacaoEncontrada = new JTable();
		jtMedicacaoEncontrada.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome do medicamento",
				"Código", "Descrição", "Fabricante", "Bula", "Princípio Ativo", "Observação adicional" }));
		scrollPane.setViewportView(jtMedicacaoEncontrada);

		btnBuscar.addActionListener(this);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(799, 11, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(this);

		// Invoca o controller, que neste caso, é BuscaMedicamentoController, apontando
		// que a ação está descrita nesta parte do código
		this.controller = new BuscaMedicamentoController(this);
	}

	/**
	 * Está recebendo, o evento dos botões que estão na
	 * view.Medicamento.BuscaMedicamento e invoca o controller
	 * controller.Medicamento.BuscaMedicamento para saber qual deve ser a ação
	 * executada
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		controller.executarBotao(e.getSource());

	}

	public void setVisible(boolean b) {
	}

	private void setController(BuscaMedicamentoController buscaMedicamentoController) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public TextField getTfMedicamentoBusca() {
		return tfMedicamentoBusca;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getJtMedicacaoEncontrada() {
		return jtMedicacaoEncontrada;
	}

	public DefaultTableModel getTabelaBuscaMedicamento() {
		return tabelaBuscaMedicamento;
	}

	public BuscaMedicamentoController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		BuscaMedicamento.frame = frame;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setTfMedicamentoBusca(TextField tfMedicamentoBusca) {
		this.tfMedicamentoBusca = tfMedicamentoBusca;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setJtMedicacaoEncontrada(JTable jtMedicacaoEncontrada) {
		this.jtMedicacaoEncontrada = jtMedicacaoEncontrada;
	}

	public void setTabelaBuscaMedicamento(DefaultTableModel tabelaBuscaMedicamento) {
		this.tabelaBuscaMedicamento = tabelaBuscaMedicamento;
	}

}
