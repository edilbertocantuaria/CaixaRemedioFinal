package view.Posologia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.Posologia.BuscaPosologiaController;

public class BuscaPosologia implements ActionListener {

	private static JFrame frame = new JFrame("Buscar cadastro de posologia");
	private JPanel panel;
	private JLabel lbCodigo;

	public JFormattedTextField jftCodPosologiaBusca;
	public JButton btnBuscar;
	public JButton btnVoltar;

	public JTable jtPosologiaEncontrada;
	public DefaultTableModel tabelaBuscaPosologia;

	private JLabel lbPosologiaEncontrada;

	private JPanel panel_1;
	private JScrollPane scrollPane;

	private BuscaPosologiaController controller;

	public BuscaPosologia() {
		frame.setSize(1375, 500);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		setController(new BuscaPosologiaController(this));
		panel.setLayout(null);

		MaskFormatter mascaraCodigo = null;
		try {
			mascaraCodigo = new MaskFormatter("###");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		lbCodigo = new JLabel("Digite o Código ");
		lbCodigo.setBounds(20, 10, 80, 25);
		panel.add(lbCodigo);

		jftCodPosologiaBusca = new JFormattedTextField(mascaraCodigo);
		jftCodPosologiaBusca.setBounds(110, 10, 100, 25);
		panel.add(jftCodPosologiaBusca);

		lbPosologiaEncontrada = new JLabel("Posologia encontrada");
		lbPosologiaEncontrada.setBounds(10, 55, 200, 25);
		panel.add(lbPosologiaEncontrada);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 80, 1339, 155);
		panel.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1339, 155);
		panel_1.add(scrollPane);

		jtPosologiaEncontrada = new JTable();
		jtPosologiaEncontrada.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Cód.", "Nome Paciente", "Medicamento", "Nº de vezes", "Rotina", "Horário 1",
						"Horário 2", "Horário 3", "Horário 4", "Horário 5", "Horário 6", "Dosagem", "Aspecto",
						"Data Início", "Data Final", "Obs. Adicional" }));
		scrollPane.setViewportView(jtPosologiaEncontrada);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(238, 10, 85, 25);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(1174, 11, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(this);

		this.controller = new BuscaPosologiaController(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	private void setController(BuscaPosologiaController buscaPosologiaController) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JFormattedTextField getJftCodPosologiaBusca() {
		return jftCodPosologiaBusca;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JTable getJtPosologiaEncontrada() {
		return jtPosologiaEncontrada;
	}

	public DefaultTableModel getTabelaBuscaPosologia() {
		return tabelaBuscaPosologia;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public BuscaPosologiaController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		BuscaPosologia.frame = frame;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setJftCodPosologiaBusca(JFormattedTextField jftCodPosologiaBusca) {
		this.jftCodPosologiaBusca = jftCodPosologiaBusca;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setJtPosologiaEncontrada(JTable jtPosologiaEncontrada) {
		this.jtPosologiaEncontrada = jtPosologiaEncontrada;
	}

	public void setTabelaBuscaPosologia(DefaultTableModel tabelaBuscaPosologia) {
		this.tabelaBuscaPosologia = tabelaBuscaPosologia;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}
