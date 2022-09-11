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

import controller.Paciente.EdicaoPacienteController;

public class EdicaoPaciente implements ActionListener {

	private static JFrame frame = new JFrame("Editar Paciente");

	public JFormattedTextField jftCPFBusca;
	public JTextField tfNomePaciente;
	public JTextField tfGenero;
	public JTextField tfObsAdcPaciente;
	public JFormattedTextField tfCPF;
	public JFormattedTextField tfDataNascimento;
	public JFormattedTextField tfTelefone;

	public JButton btnAtualizarCadastroPaciente;
	public JButton btnEditarPaciente_edicao;
	public JButton btnVoltar;

	private JLabel lbCpf;
	private JLabel lbNomePaciente;
	private JLabel lbCPF;
	private JLabel lbCPFinfo;
	private JLabel lbDataNascimento;
	private JLabel lbTelefone;
	private JLabel lbGenero;
	private JLabel lbObsAdcPaciente;
	private JPanel panel;

	private EdicaoPacienteController controller;

	public EdicaoPaciente() {
		frame.setSize(500, 420);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		setController(new EdicaoPacienteController(this));
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

		lbCpf = new JLabel("CPF:");
		lbCpf.setBounds(10, 10, 90, 25);
		panel.add(lbCpf);

		lbNomePaciente = new JLabel("Nome");
		lbNomePaciente.setBounds(10, 99, 46, 14);
		panel.add(lbNomePaciente);

		tfNomePaciente = new JTextField();
		tfNomePaciente.setEnabled(false);
		tfNomePaciente.setEditable(false);
		tfNomePaciente.setColumns(10);
		tfNomePaciente.setBounds(158, 96, 319, 20);
		panel.add(tfNomePaciente);

		lbCPF = new JLabel("CPF");
		lbCPF.setBounds(10, 138, 110, 14);
		panel.add(lbCPF);

		lbCPFinfo = new JLabel("(apenas números)");
		lbCPFinfo.setBounds(10, 151, 110, 16);
		panel.add(lbCPFinfo);

		tfCPF = new JFormattedTextField(mascaraCPF);
		tfCPF.setEnabled(false);
		tfCPF.setEditable(false);
		tfCPF.setBounds(158, 135, 319, 20);
		panel.add(tfCPF);

		lbDataNascimento = new JLabel("Data de nascimento");
		lbDataNascimento.setBounds(10, 177, 248, 14);
		panel.add(lbDataNascimento);

		tfDataNascimento = new JFormattedTextField(mascaraData);
		tfDataNascimento.setEnabled(false);
		tfDataNascimento.setEditable(false);
		tfDataNascimento.setBounds(158, 174, 319, 20);
		panel.add(tfDataNascimento);

		lbTelefone = new JLabel("Telefone");
		lbTelefone.setBounds(10, 216, 110, 14);
		panel.add(lbTelefone);

		tfTelefone = new JFormattedTextField(mascaraTel);
		tfTelefone.setEnabled(false);
		tfTelefone.setEditable(false);
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(159, 213, 319, 20);
		panel.add(tfTelefone);

		lbGenero = new JLabel("Gênero");
		lbGenero.setBounds(10, 255, 46, 14);
		panel.add(lbGenero);

		tfGenero = new JTextField();
		tfGenero.setEnabled(false);
		tfGenero.setEditable(false);
		tfGenero.setColumns(10);
		tfGenero.setBounds(158, 252, 319, 20);
		panel.add(tfGenero);

		lbObsAdcPaciente = new JLabel("Observações adicionais");
		lbObsAdcPaciente.setBounds(10, 294, 303, 14);
		panel.add(lbObsAdcPaciente);

		tfObsAdcPaciente = new JTextField();
		tfObsAdcPaciente.setEnabled(false);
		tfObsAdcPaciente.setEditable(false);
		tfObsAdcPaciente.setColumns(10);
		tfObsAdcPaciente.setBounds(158, 291, 319, 20);
		panel.add(tfObsAdcPaciente);

		btnAtualizarCadastroPaciente = new JButton("Atualizar cadastro");
		btnAtualizarCadastroPaciente.setEnabled(false);
		btnAtualizarCadastroPaciente.setBounds(302, 351, 175, 23);
		btnAtualizarCadastroPaciente.addActionListener(this);
		panel.add(btnAtualizarCadastroPaciente);

		jftCPFBusca = new JFormattedTextField(mascaraCPF);
		jftCPFBusca.setBounds(56, 12, 100, 25);
		panel.add(jftCPFBusca);

		btnEditarPaciente_edicao = new JButton("Editar Paciente");
		btnEditarPaciente_edicao.addActionListener(this);
		btnEditarPaciente_edicao.setBounds(10, 50, 146, 25);
		panel.add(btnEditarPaciente_edicao);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 351, 175, 23);
		btnVoltar.addActionListener(this);
		panel.add(btnVoltar);

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

	public JFormattedTextField getJftCPFBusca() {
		return jftCPFBusca;
	}

	public JTextField getTfNomePaciente() {
		return tfNomePaciente;
	}

	public JTextField getTfGenero() {
		return tfGenero;
	}

	public JTextField getTfObsAdcPaciente() {
		return tfObsAdcPaciente;
	}

	public JFormattedTextField getTfCPF() {
		return tfCPF;
	}

	public JFormattedTextField getTfDataNascimento() {
		return tfDataNascimento;
	}

	public JFormattedTextField getTfTelefone() {
		return tfTelefone;
	}

	public JButton getBtnAtualizarCadastroPaciente() {
		return btnAtualizarCadastroPaciente;
	}

	public JButton getBtnEditarPaciente_edicao() {
		return btnEditarPaciente_edicao;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JLabel getInstrucao() {
		return lbCpf;
	}

	public JPanel getPanel() {
		return panel;
	}

	public EdicaoPacienteController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		EdicaoPaciente.frame = frame;
	}

	public void setJftCPFBusca(JFormattedTextField jftCPFBusca) {
		this.jftCPFBusca = jftCPFBusca;
	}

	public void setTfNomePaciente(JTextField tfNomePaciente) {
		this.tfNomePaciente = tfNomePaciente;
	}

	public void setTfGenero(JTextField tfGenero) {
		this.tfGenero = tfGenero;
	}

	public void setTfObsAdcPaciente(JTextField tfObsAdcPaciente) {
		this.tfObsAdcPaciente = tfObsAdcPaciente;
	}

	public void setTfCPF(JFormattedTextField tfCPF) {
		this.tfCPF = tfCPF;
	}

	public void setTfDataNascimento(JFormattedTextField tfDataNascimento) {
		this.tfDataNascimento = tfDataNascimento;
	}

	public void setTfTelefone(JFormattedTextField tfTelefone) {
		this.tfTelefone = tfTelefone;
	}

	public void setBtnAtualizarCadastroPaciente(JButton btnAtualizarCadastroPaciente) {
		this.btnAtualizarCadastroPaciente = btnAtualizarCadastroPaciente;
	}

	public void setBtnEditarPaciente_edicao(JButton btnEditarPaciente_edicao) {
		this.btnEditarPaciente_edicao = btnEditarPaciente_edicao;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setInstrucao(JLabel instrucao) {
		this.lbCpf = instrucao;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setController(EdicaoPacienteController controller) {
		this.controller = controller;
	}

}
