package view.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.PacienteController;
import model.Pessoa;

public class EdicaoPaciente {
	private static JFrame frame = new JFrame("Editar Paciente");
	private JLabel instrucao;
	private JButton btnEditarPaciente_edicao;
	private JButton btnVoltar;
	private JComboBox<String> cbEscolhaPaciente;

	private PacienteController controller;
	private JTextField tfNomePaciente;
	private JTextField tfGenero;
	private JTextField tfObsAdcPaciente;
	private JLabel lbNomePaciente;
	private JLabel lbCPF;
	private JLabel lbCPFinfo;
	private JFormattedTextField tfCPF;
	private JLabel lbDataNascimento;
	private JFormattedTextField tfDataNascimento;
	private JLabel lbTelefone;
	private JFormattedTextField tfTelefone;
	private JLabel lbGenero;
	private JLabel lbObsAdcPaciente;
	private JButton btnAtualizarCadastroPaciente;
	private JFormattedTextField jftCPFBusca;

	public EdicaoPaciente() {
		frame.setSize(500, 420);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
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

		instrucao = new JLabel("CPF:");
		instrucao.setBounds(10, 10, 90, 25);
		panel.add(instrucao);

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
		btnAtualizarCadastroPaciente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizaPaciente();
			}

			public void atualizaPaciente() {
				try {

					String cpfBusca = jftCPFBusca.getText();

					// Para inserir as informações de um paciente na lista (igual a do cadastro)
					String nomePaciente = getTfNomePaciente().getText().trim();
					String cpf = getTfCPF().getText().trim();
					String dataNascimento = getTfDataNascimento().getText().trim();
					String telefone = getTfTelefone().getText().trim();
					String genero = getTfGenero().getText().trim();
					String observacaoAdicionalPaciente = getTfObsAdcPaciente().getText().trim();

					int i;
					if (getTfCPF().getText() == ".   .   -") {
						i = 0;
					} else {
						i = 1;
					}

					if (getTfNomePaciente().getText().isEmpty() || i != 0 || getTfDataNascimento().getText().isEmpty()
							|| getTfTelefone().getText().isEmpty() || getTfGenero().getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Não foi possível realizar o cadastro: os dados do paciente não podem estar vazios!");
						jftCPFBusca.setText("");
					} else {
						PacienteController pacienteController = new PacienteController();
						Pessoa paciente = pacienteController.buscarPacientes(cpfBusca);

						// Atualiza os dados do paciente
						paciente.setNome(nomePaciente);
						paciente.setCpf(cpf);
						paciente.setDataNascimento(dataNascimento);
						paciente.setTelefone(telefone);
						paciente.setGenero(genero);
						paciente.setObservacaoAdicionalPessoa(observacaoAdicionalPaciente);

						System.out.println(PacienteController.pacientes.toString());
						JOptionPane.showMessageDialog(null, "Atualização efetivada!");
					}

					// limpando os campos dos jtextfield's
					tfNomePaciente.setText("");
					tfCPF.setText("");
					tfDataNascimento.setText("");
					tfTelefone.setText("");
					tfGenero.setText("");
					tfObsAdcPaciente.setText("");
					jftCPFBusca.setText("");

					// desabilitando a edição/inserção de texto nos jtextfield's
					tfNomePaciente.setEnabled(false);
					tfNomePaciente.setEditable(false);
					tfCPF.setEnabled(false);
					tfCPF.setEditable(false);
					tfDataNascimento.setEnabled(false);
					tfDataNascimento.setEditable(false);
					tfTelefone.setEnabled(false);
					tfTelefone.setEditable(false);
					tfGenero.setEnabled(false);
					tfGenero.setEditable(false);
					tfObsAdcPaciente.setEnabled(false);
					tfObsAdcPaciente.setEditable(false);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "CPF inválido!");
				}
			}

		});

		btnAtualizarCadastroPaciente.setBounds(302, 351, 175, 23);
		panel.add(btnAtualizarCadastroPaciente);

		jftCPFBusca = new JFormattedTextField(mascaraCPF);
		jftCPFBusca.setBounds(56, 12, 100, 25);
		panel.add(jftCPFBusca);

		btnEditarPaciente_edicao = new JButton("Editar Paciente");
		btnEditarPaciente_edicao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jftCPFBusca.requestFocus();

				String cpf = jftCPFBusca.getText();

				PacienteController pacienteController = new PacienteController();
				Pessoa resultado = pacienteController.buscarPacientes(cpf);

				btnAtualizarCadastroPaciente.setEnabled(true);

				tfNomePaciente.setText(resultado.getNome());
				tfNomePaciente.setEnabled(true);
				tfNomePaciente.setEditable(true);

				tfCPF.setText(resultado.getCpf());
				tfCPF.setEnabled(true);
				tfCPF.setEditable(true);

				tfDataNascimento.setText(resultado.getDataNascimento());
				tfDataNascimento.setEnabled(true);
				tfDataNascimento.setEditable(true);

				tfTelefone.setText(resultado.getTelefone());
				tfTelefone.setEnabled(true);
				tfTelefone.setEditable(true);

				tfGenero.setText(resultado.getGenero());
				tfGenero.setEnabled(true);
				tfGenero.setEditable(true);

				tfObsAdcPaciente.setText(resultado.getObservacaoAdicionalPessoa());
				tfObsAdcPaciente.setEnabled(true);
				tfObsAdcPaciente.setEditable(true);

			}
		});
		btnEditarPaciente_edicao.setBounds(10, 50, 146, 25);
		panel.add(btnEditarPaciente_edicao);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 351, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object botaoApertado = e.getSource();

				if (botaoApertado == btnVoltar) {
					jftCPFBusca.setText("");
					PrincipalPaciente obj = new PrincipalPaciente();
					obj.setVisible(true);
					frame.dispose();

				}
			}
		});
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		EdicaoPaciente.frame = frame;
	}

	public JLabel getInstrucao() {
		return instrucao;
	}

	public void setInstrucao(JLabel instrucao) {
		this.instrucao = instrucao;
	}

	public JButton getBtnEditarPaciente_edicao() {
		return btnEditarPaciente_edicao;
	}

	public void setBtnEditarPaciente_edicao(JButton btnEditarPaciente_edicao) {
		this.btnEditarPaciente_edicao = btnEditarPaciente_edicao;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JComboBox<String> getCbEscolhaPaciente() {
		return cbEscolhaPaciente;
	}

	public void setCbEscolhaPaciente(JComboBox<String> cbEscolhaPaciente) {
		this.cbEscolhaPaciente = cbEscolhaPaciente;
	}

	public PacienteController getController() {
		return controller;
	}

	public void setController(PacienteController controller) {
		this.controller = controller;
	}

	public JTextField getTfNomePaciente() {
		return tfNomePaciente;
	}

	public void setTfNomePaciente(JTextField tfNomePaciente) {
		this.tfNomePaciente = tfNomePaciente;
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

	public JLabel getLbNomePaciente() {
		return lbNomePaciente;
	}

	public void setLbNomePaciente(JLabel lbNomePaciente) {
		this.lbNomePaciente = lbNomePaciente;
	}

	public JLabel getLbCPF() {
		return lbCPF;
	}

	public void setLbCPF(JLabel lbCPF) {
		this.lbCPF = lbCPF;
	}

	public JLabel getLbCPFinfo() {
		return lbCPFinfo;
	}

	public void setLbCPFinfo(JLabel lbCPFinfo) {
		this.lbCPFinfo = lbCPFinfo;
	}

	public JFormattedTextField getTfCPF() {
		return tfCPF;
	}

	public void setTfCPF(JFormattedTextField tfCPF) {
		this.tfCPF = tfCPF;
	}

	public JLabel getLbDataNascimento() {
		return lbDataNascimento;
	}

	public void setLbDataNascimento(JLabel lbDataNascimento) {
		this.lbDataNascimento = lbDataNascimento;
	}

	public JFormattedTextField getTfDataNascimento() {
		return tfDataNascimento;
	}

	public void setTfDataNascimento(JFormattedTextField tfDataNascimento) {
		this.tfDataNascimento = tfDataNascimento;
	}

	public JLabel getLbTelefone() {
		return lbTelefone;
	}

	public void setLbTelefone(JLabel lbTelefone) {
		this.lbTelefone = lbTelefone;
	}

	public JFormattedTextField getTfTelefone() {
		return tfTelefone;
	}

	public void setTfTelefone(JFormattedTextField tfTelefone) {
		this.tfTelefone = tfTelefone;
	}

	public JLabel getLbGenero() {
		return lbGenero;
	}

	public void setLbGenero(JLabel lbGenero) {
		this.lbGenero = lbGenero;
	}

	public JLabel getLbObsAdcPaciente() {
		return lbObsAdcPaciente;
	}

	public void setLbObsAdcPaciente(JLabel lbObsAdcPaciente) {
		this.lbObsAdcPaciente = lbObsAdcPaciente;
	}

	public JButton getBtnAtualizarCadastroPaciente() {
		return btnAtualizarCadastroPaciente;
	}

	public void setBtnAtualizarCadastroPaciente(JButton btnAtualizarCadastroPaciente) {
		this.btnAtualizarCadastroPaciente = btnAtualizarCadastroPaciente;
	}

	public JFormattedTextField getJftCPFBusca() {
		return jftCPFBusca;
	}

	public void setJftCPFBusca(JFormattedTextField jftCPFBusca) {
		this.jftCPFBusca = jftCPFBusca;
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
