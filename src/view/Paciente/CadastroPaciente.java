package view.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.Paciente.CadastroPacienteController;

public class CadastroPaciente implements ActionListener {
	private static JFrame frame = new JFrame("Cadastro de Paciente");

	public JTextField tfNomePaciente;
	public JFormattedTextField tfCPF;
	public JTextField tfDataNascimento;
	public JTextField tfTelefone;
	public JTextField tfGenero;
	public JTextField tfObsAdcPaciente;

	private JLabel lbNomePaciente;
	private JLabel lbDataNascimento;
	private JLabel lbTelefone;
	private JLabel lbGenero;
	private JLabel lbObsAdcPaciente;
	private JLabel lbCPF;
	private JLabel lbCPFinfo;
	private JPanel panel;

	private JButton btnRealizarCadastroPaciente;
	private JButton btnVoltar;

	private CadastroPacienteController controller;

	public CadastroPaciente() {
		frame.setSize(500, 350);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		setController(new CadastroPacienteController(this));
		panel.setLayout(null);

		MaskFormatter mascaraData = null;
		MaskFormatter mascaraCPF = null;
		MaskFormatter mascaraTel = null;

		try {
			mascaraData = new MaskFormatter("##/##/####");
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraTel = new MaskFormatter("(##) #####-####");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		lbNomePaciente = new JLabel("Nome");
		lbNomePaciente.setBounds(10, 25, 46, 14);
		panel.add(lbNomePaciente);

		lbDataNascimento = new JLabel("Data de nascimento");
		lbDataNascimento.setBounds(10, 103, 248, 14);
		panel.add(lbDataNascimento);

		lbTelefone = new JLabel("Telefone");
		lbTelefone.setBounds(10, 142, 110, 14);
		panel.add(lbTelefone);

		lbGenero = new JLabel("Gênero");
		lbGenero.setBounds(10, 181, 46, 14);
		panel.add(lbGenero);

		tfNomePaciente = new JTextField();
		tfNomePaciente.setBounds(158, 22, 319, 20);
		panel.add(tfNomePaciente);
		tfNomePaciente.setColumns(10);

		lbCPF = new JLabel("CPF");
		lbCPF.setBounds(10, 64, 110, 14);
		panel.add(lbCPF);
		lbCPFinfo = new JLabel("(apenas números)");
		lbCPFinfo.setBounds(10, 77, 110, 16);
		panel.add(lbCPFinfo);

		tfCPF = new JFormattedTextField(mascaraCPF);
		tfCPF.setBounds(158, 61, 319, 20);
		panel.add(tfCPF);

		tfDataNascimento = new JFormattedTextField(mascaraData);
		tfDataNascimento.setBounds(158, 100, 319, 20);
		panel.add(tfDataNascimento);

		tfTelefone = new JFormattedTextField(mascaraTel);
		tfTelefone.setBounds(159, 139, 319, 20);
		panel.add(tfTelefone);
		tfTelefone.setColumns(10);

		tfGenero = new JTextField();
		tfGenero.setBounds(158, 178, 319, 20);
		panel.add(tfGenero);
		tfGenero.setColumns(10);

		lbObsAdcPaciente = new JLabel("Observações adicionais");
		lbObsAdcPaciente.setBounds(10, 220, 303, 14);
		panel.add(lbObsAdcPaciente);

		tfObsAdcPaciente = new JTextField();
		tfObsAdcPaciente.setColumns(10);
		tfObsAdcPaciente.setBounds(158, 217, 319, 20);
		panel.add(tfObsAdcPaciente);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 277, 175, 23);
		btnVoltar.addActionListener(this);
		panel.add(btnVoltar);

		btnRealizarCadastroPaciente = new JButton("Realizar cadastro");
		btnRealizarCadastroPaciente.addActionListener(this);
		btnRealizarCadastroPaciente.setBounds(302, 277, 175, 23);
		panel.add(btnRealizarCadastroPaciente);

		this.controller = new CadastroPacienteController(this);

	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		CadastroPaciente.frame = frame;
	}

	public JFormattedTextField getTfCPF() {
		return tfCPF;
	}

	public JLabel getLbCPFinfo() {
		return lbCPFinfo;
	}

	public void setLbCPFinfo(JLabel lbCPFinfo) {
		this.lbCPFinfo = lbCPFinfo;
	}

	public void setTfCPF(JFormattedTextField tfCPF) {
		this.tfCPF = tfCPF;
	}

	public JTextField getTfNomePaciente() {
		return tfNomePaciente;
	}

	public void setTfNomePaciente(JTextField tfNomePaciente) {
		this.tfNomePaciente = tfNomePaciente;
	}

	public JTextField getTfDataNascimento() {
		return tfDataNascimento;
	}

	public void setTfDataNascimento(JTextField tfDataNascimento) {
		this.tfDataNascimento = tfDataNascimento;
	}

	public JTextField getTfTelefone() {
		return tfTelefone;
	}

	public void setTfTelefone(JTextField tfTelefone) {
		this.tfTelefone = tfTelefone;
	}

	public JTextField getTfGenero() {
		return tfGenero;
	}

	public void setTfGenero(JTextField tfGenero) {
		this.tfGenero = tfGenero;
	}

	public JTextField getTfObsAdcPaciente() {
		return tfObsAdcPaciente;
	}

	public void setTfObsAdcPaciente(JTextField tfObsAdcPaciente) {
		this.tfObsAdcPaciente = tfObsAdcPaciente;
	}

	public JButton getBtnRealizarCadastroPaciente() {
		return btnRealizarCadastroPaciente;
	}

	public void setBtnRealizarCadastroPaciente(JButton btnRealizarCadastroPaciente) {
		this.btnRealizarCadastroPaciente = btnRealizarCadastroPaciente;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public CadastroPacienteController getController() {
		return controller;
	}

	public void setController(CadastroPacienteController controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}
}