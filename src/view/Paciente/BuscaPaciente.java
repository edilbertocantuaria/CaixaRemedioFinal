package view.Paciente;

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

import controller.Paciente.BuscaPacienteController;

public class BuscaPaciente<Pessoa> implements ActionListener {
	private static JFrame frame = new JFrame("Buscar cadastro de paciente");
	private JPanel panel;
	private JLabel lbCPF;

	public JFormattedTextField jftCPFBusca;
	public JButton btnBuscar;
	public JButton btnVoltar;

	public JTable jtPacienteEncontrado;
	public DefaultTableModel tabelaBuscaPaciente;

	private JLabel lbPacienteEncontrado;

	private JPanel panel_1;
	private JScrollPane scrollPane;

	private BuscaPacienteController controller;

	public BuscaPaciente() {
		frame.setSize(800, 280);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		setController(new BuscaPacienteController(this));
		panel.setLayout(null);

		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		lbCPF = new JLabel("Digite o CPF ");
		lbCPF.setBounds(20, 10, 80, 25);
		panel.add(lbCPF);

		jftCPFBusca = new JFormattedTextField(mascaraCPF);
		jftCPFBusca.setBounds(110, 10, 100, 25);
		panel.add(jftCPFBusca);

		lbPacienteEncontrado = new JLabel("Paciente encontrado");
		lbPacienteEncontrado.setBounds(10, 55, 200, 25);
		panel.add(lbPacienteEncontrado);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 80, 764, 155);
		panel.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 764, 155);
		panel_1.add(scrollPane);

		jtPacienteEncontrado = new JTable();
		jtPacienteEncontrado.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "Data de Nascimento", "Telefone", "Gênero", "Observação Adicional" }));
		scrollPane.setViewportView(jtPacienteEncontrado);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(220, 10, 85, 25);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(599, 11, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(this);

		this.controller = new BuscaPacienteController(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JFormattedTextField getJftCPFBusca() {
		return jftCPFBusca;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getJtPacienteEncontrado() {
		return jtPacienteEncontrado;
	}

	public DefaultTableModel getTabelaBuscaPaciente() {
		return tabelaBuscaPaciente;
	}

	public BuscaPacienteController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		BuscaPaciente.frame = frame;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setJftCPFBusca(JFormattedTextField jftCPFBusca) {
		this.jftCPFBusca = jftCPFBusca;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setJtPacienteEncontrado(JTable jtPacienteEncontrado) {
		this.jtPacienteEncontrado = jtPacienteEncontrado;
	}

	public void setTabelaBuscaPaciente(DefaultTableModel tabelaBuscaPaciente) {
		this.tabelaBuscaPaciente = tabelaBuscaPaciente;
	}

	public void setController(BuscaPacienteController controller) {
		this.controller = controller;
	}

}
