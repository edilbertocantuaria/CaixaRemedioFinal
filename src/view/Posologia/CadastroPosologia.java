package view.Posologia;

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

import controller.PosologiaController;
import model.Posologia;

public class CadastroPosologia {

	private static JFrame frame = new JFrame("Cadastro de Posologia");

	private JTextField tfNumeroVezes;
	private JTextField tfRotinaMedicacao;
	private JTextField tfHorario1;
	private JTextField tfDosagem;
	private JTextField tfObsAdcPosologia;
	private JTextField tfAspecto;
	private JTextField tfDataInicioTratamento;
	private JTextField tfDataFimTratamento;
	private JLabel lbNumeroVezes;
	private JLabel lbRotinaMedicacao;
	private JLabel lbHorario;
	private JLabel lbDosagem;
	private JLabel lbObsAdcPosologia;
	private JLabel lbRotinaExemplo;
	private JLabel lbDosagemExemplo;
	private JLabel lbAspecto;
	private JLabel lbAspectoExemplo;
	private JLabel lbDataInicioTratamento;
	private JLabel lbDataTérminoTratamento;
	private JLabel lbHorarioExemplo;
	private JLabel lbDataExemplo_1;
	private JLabel lbDataExemplo_2;
	private JLabel lbNumeroVezesExemplo;
	private JButton btnCadastrarPosologia;
	private JButton btnVoltar;

	private JComboBox<String> cbEscolhaPaciente;
	private JComboBox<String> cbEscolhaMedicamento;
	private JLabel lbEscolhaPaciente;

	private JPanel panel;
	private JLabel lbEscolhaMedicamento;

	private PosologiaController controller;

	private JFormattedTextField tfHorario2;

	private JFormattedTextField tfHorario3;

	private JFormattedTextField tfHorario4;

	private JFormattedTextField tfHorario5;

	private JFormattedTextField tfHorario6;

	public CadastroPosologia() {
		frame.setSize(700, 470);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		MaskFormatter mascaraDataInicial = null;
		MaskFormatter mascaraDataFinal = null;
		MaskFormatter mascaraHora = null;
		MaskFormatter mascaraDosagem = null;

		try {
			mascaraDataInicial = new MaskFormatter("##/##/####");
			mascaraDataFinal = new MaskFormatter("##/##/####");
			mascaraHora = new MaskFormatter("##:##");
			mascaraDosagem = new MaskFormatter("#.#");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		lbRotinaMedicacao = new JLabel("Rotina da medicação:");
		lbRotinaMedicacao.setBounds(10, 124, 251, 14);
		panel.add(lbRotinaMedicacao);
		lbRotinaExemplo = new JLabel("(Diariamente, semanalmente, quinzenalmente, etc.)");
		lbRotinaExemplo.setBounds(10, 137, 300, 14);
		panel.add(lbRotinaExemplo);
		tfRotinaMedicacao = new JTextField();
		tfRotinaMedicacao.setBounds(362, 121, 300, 20);
		panel.add(tfRotinaMedicacao);
		tfRotinaMedicacao.setColumns(10);

		lbHorario = new JLabel("Horário de ingestão do medicamento:");
		lbHorario.setBounds(10, 170, 259, 14);
		panel.add(lbHorario);
		lbHorarioExemplo = new JLabel("(Inserir pelo menos um horário)");
		lbHorarioExemplo.setBounds(10, 183, 354, 14);
		panel.add(lbHorarioExemplo);

		tfHorario1 = new JFormattedTextField(mascaraHora);
		tfHorario1.setBounds(362, 167, 40, 20);
		panel.add(tfHorario1);
		tfHorario1.setColumns(10);

		tfHorario2 = new JFormattedTextField(mascaraHora);
		tfHorario2.setColumns(10);
		tfHorario2.setBounds(412, 167, 40, 20);
		panel.add(tfHorario2);

		tfHorario3 = new JFormattedTextField(mascaraHora);
		tfHorario3.setColumns(10);
		tfHorario3.setBounds(462, 167, 40, 20);
		panel.add(tfHorario3);

		tfHorario4 = new JFormattedTextField(mascaraHora);
		tfHorario4.setColumns(10);
		tfHorario4.setBounds(522, 167, 40, 20);
		panel.add(tfHorario4);

		tfHorario5 = new JFormattedTextField(mascaraHora);
		tfHorario5.setColumns(10);
		tfHorario5.setBounds(572, 167, 40, 20);
		panel.add(tfHorario5);

		tfHorario6 = new JFormattedTextField(mascaraHora);
		tfHorario6.setColumns(10);
		tfHorario6.setBounds(622, 167, 40, 20);
		panel.add(tfHorario6);

		lbDosagem = new JLabel("Dosagem (digitar apenas número):");
		lbDosagem.setBounds(10, 216, 342, 14);
		panel.add(lbDosagem);
		lbDosagemExemplo = new JLabel("(exemplos:0.5, 1.0, 2.0, etc.)");
		lbDosagemExemplo.setBounds(10, 229, 257, 14);
		panel.add(lbDosagemExemplo);
		tfDosagem = new JFormattedTextField(mascaraDosagem);
		tfDosagem.setBounds(362, 213, 300, 20);
		panel.add(tfDosagem);
		tfDosagem.setColumns(10);

		lbNumeroVezes = new JLabel("Número de vezes que o remédio deve ser consumido por dia:");
		lbNumeroVezes.setAutoscrolls(true);
		lbNumeroVezes.setBounds(10, 78, 390, 14);
		panel.add(lbNumeroVezes);
		tfNumeroVezes = new JTextField();
		tfNumeroVezes.setBounds(561, 75, 100, 20);
		panel.add(tfNumeroVezes);
		tfNumeroVezes.setColumns(10);
		lbNumeroVezesExemplo = new JLabel("(digitar apenas números)");
		lbNumeroVezesExemplo.setAutoscrolls(true);
		lbNumeroVezesExemplo.setBounds(10, 91, 390, 14);
		panel.add(lbNumeroVezesExemplo);

		lbObsAdcPosologia = new JLabel("Observações adicionais");
		lbObsAdcPosologia.setBounds(10, 354, 300, 14);
		panel.add(lbObsAdcPosologia);
		tfObsAdcPosologia = new JTextField();
		tfObsAdcPosologia.setColumns(10);
		tfObsAdcPosologia.setBounds(362, 351, 300, 20);
		panel.add(tfObsAdcPosologia);

		lbAspecto = new JLabel("Aspecto:");
		lbAspecto.setBounds(10, 262, 66, 14);
		panel.add(lbAspecto);
		tfAspecto = new JTextField();
		tfAspecto.setColumns(10);
		tfAspecto.setBounds(362, 259, 300, 20);
		panel.add(tfAspecto);
		lbAspectoExemplo = new JLabel("(Comprimido, capsula, gota, etc.)");
		lbAspectoExemplo.setBounds(10, 275, 257, 14);
		panel.add(lbAspectoExemplo);

		lbDataInicioTratamento = new JLabel("Data de início do tratamento:");
		lbDataInicioTratamento.setBounds(10, 308, 330, 14);
		panel.add(lbDataInicioTratamento);
		tfDataInicioTratamento = new JFormattedTextField(mascaraDataInicial);
		tfDataInicioTratamento.setColumns(10);
		tfDataInicioTratamento.setBounds(206, 305, 100, 20);
		panel.add(tfDataInicioTratamento);
		lbDataExemplo_1 = new JLabel("(DD/MM/AAAA)");
		lbDataExemplo_1.setBounds(10, 321, 257, 14);
		panel.add(lbDataExemplo_1);

		lbDataTérminoTratamento = new JLabel("Data de término do tratamento:");
		lbDataTérminoTratamento.setBounds(362, 308, 343, 14);
		panel.add(lbDataTérminoTratamento);
		tfDataFimTratamento = new JFormattedTextField(mascaraDataFinal);
		tfDataFimTratamento.setColumns(10);
		tfDataFimTratamento.setBounds(562, 305, 100, 20);
		panel.add(tfDataFimTratamento);
		lbDataExemplo_2 = new JLabel("(DD/MM/AAAA)");
		lbDataExemplo_2.setBounds(362, 321, 257, 14);
		panel.add(lbDataExemplo_2);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object botaoApertado = e.getSource();

				if (botaoApertado == btnVoltar) {
					// limpando os campos dos jtextfield's
					cbEscolhaPaciente.setSelectedItem("");
					cbEscolhaMedicamento.setSelectedItem("");
					tfNumeroVezes.setText("");
					tfRotinaMedicacao.setText("");
					tfHorario1.setText("");
					tfHorario2.setText("");
					tfHorario3.setText("");
					tfHorario4.setText("");
					tfHorario5.setText("");
					tfHorario6.setText("");
					tfDosagem.setText("");
					tfAspecto.setText("");
					tfDataInicioTratamento.setText("");
					tfDataFimTratamento.setText("");
					tfObsAdcPosologia.setText("");

					PrincipalPosologia obj = new PrincipalPosologia();
					obj.setVisible(true);
					frame.dispose();

				}
			}
		});
		panel.add(btnVoltar);
		btnVoltar.setBounds(10, 388, 210, 23);

		cbEscolhaPaciente = new JComboBox<String>();
		cbEscolhaPaciente.setBounds(86, 28, 189, 22);
		panel.add(cbEscolhaPaciente);

		lbEscolhaPaciente = new JLabel("Paciente:");
		lbEscolhaPaciente.setBounds(10, 32, 94, 14);
		panel.add(lbEscolhaPaciente);

		lbEscolhaMedicamento = new JLabel("Medicamento:");
		lbEscolhaMedicamento.setBounds(362, 32, 94, 14);
		panel.add(lbEscolhaMedicamento);

		cbEscolhaMedicamento = new JComboBox<String>();
		cbEscolhaMedicamento.setBounds(468, 28, 189, 22);
		panel.add(cbEscolhaMedicamento);

		this.controller = new PosologiaController(this);
		cbEscolhaPaciente.setModel(controller.listarPacientes());
		cbEscolhaMedicamento.setModel(controller.listarMedicamentos());

		btnCadastrarPosologia = new JButton("Cadastrar Posologia");
		btnCadastrarPosologia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastraPosologia();
			}

			public void cadastraPosologia() {

				// deixa o cursor dentro desse jtextfield's
				// cbEscolhaPaciente.requestFocus();
				// cbEscolhaMedicamento.requestFocus();

				// cadastra a posologia
				String nomePaciente = (String) getCbEscolhaPaciente().getSelectedItem();
				String nomeMedicacao = (String) getCbEscolhaMedicamento().getSelectedItem();
				int numeroVezes = Integer.parseInt(getTfNumeroVezes().getText().trim());
				String rotinaMedicacao = getTfRotinaMedicacao().getText().trim();
				String horario1 = getTfHorario1().getText().trim();
				String horario2 = getTfHorario1().getText().trim();
				String horario3 = getTfHorario1().getText().trim();
				String horario4 = getTfHorario1().getText().trim();
				String horario5 = getTfHorario1().getText().trim();
				String horario6 = getTfHorario1().getText().trim();
				float dosagem = Float.parseFloat(getTfDosagem().getText().trim());
				String aspectoMedicamento = getTfAspecto().getText().trim();
				String dataInicioTratamento = getTfDataInicioTratamento().getText().trim();
				String dataFimTratamento = getTfDataFimTratamento().getText().trim();
				String observacaoAdicionalPosologia = getTfObsAdcPosologia().getText().trim();

				Posologia posologia = new Posologia(nomePaciente, nomeMedicacao, numeroVezes, rotinaMedicacao, horario1,
						horario2, horario3, horario4, horario5, horario6, dosagem, aspectoMedicamento,
						dataInicioTratamento, dataFimTratamento, observacaoAdicionalPosologia);

				PosologiaController.posologias.add(posologia);

				PosologiaController.posologias.toString();

				System.out.print(PosologiaController.posologias.toString());

				JOptionPane.showMessageDialog(null, "Cadastro efetivado!");

				// limpando os campos dos jtextfield's
				cbEscolhaPaciente.setSelectedItem("");
				cbEscolhaMedicamento.setSelectedItem("");
				tfNumeroVezes.setText("");
				tfRotinaMedicacao.setText("");
				tfHorario1.setText("");
				tfHorario2.setText("");
				tfHorario3.setText("");
				tfHorario4.setText("");
				tfHorario5.setText("");
				tfHorario6.setText("");
				tfDosagem.setText("");
				tfAspecto.setText("");
				tfDataInicioTratamento.setText("");
				tfDataFimTratamento.setText("");
				tfObsAdcPosologia.setText("");

				// deixa o cursor dentro desse jtextfield's
				cbEscolhaPaciente.requestFocus();
				cbEscolhaMedicamento.requestFocus();

			}

		});
		btnCadastrarPosologia.setBounds(487, 388, 175, 23);
		panel.add(btnCadastrarPosologia);

	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		CadastroPosologia.frame = frame;
	}

	public JTextField getTfNumeroVezes() {
		return tfNumeroVezes;
	}

	public void setTfNumeroVezes(JTextField tfNumeroVezes) {
		this.tfNumeroVezes = tfNumeroVezes;
	}

	public JTextField getTfRotinaMedicacao() {
		return tfRotinaMedicacao;
	}

	public void setTfRotinaMedicacao(JTextField tfRotinaMedicacao) {
		this.tfRotinaMedicacao = tfRotinaMedicacao;
	}

	public JTextField getTfHorario1() {
		return tfHorario1;
	}

	public void setTfHorario1(JTextField tfHorario1) {
		this.tfHorario1 = tfHorario1;
	}

	public JTextField getTfDosagem() {
		return tfDosagem;
	}

	public void setTfDosagem(JTextField tfDosagem) {
		this.tfDosagem = tfDosagem;
	}

	public JTextField getTfObsAdcPosologia() {
		return tfObsAdcPosologia;
	}

	public void setTfObsAdcPosologia(JTextField tfObsAdcPosologia) {
		this.tfObsAdcPosologia = tfObsAdcPosologia;
	}

	public JTextField getTfAspecto() {
		return tfAspecto;
	}

	public void setTfAspecto(JTextField tfAspecto) {
		this.tfAspecto = tfAspecto;
	}

	public JTextField getTfDataInicioTratamento() {
		return tfDataInicioTratamento;
	}

	public void setTfDataInicioTratamento(JTextField tfDataInicioTratamento) {
		this.tfDataInicioTratamento = tfDataInicioTratamento;
	}

	public JTextField getTfDataFimTratamento() {
		return tfDataFimTratamento;
	}

	public void setTfDataFimTratamento(JTextField tfDataFimTratamento) {
		this.tfDataFimTratamento = tfDataFimTratamento;
	}

	public JLabel getLbNumeroVezes() {
		return lbNumeroVezes;
	}

	public void setLbNumeroVezes(JLabel lbNumeroVezes) {
		this.lbNumeroVezes = lbNumeroVezes;
	}

	public JLabel getLbRotinaMedicacao() {
		return lbRotinaMedicacao;
	}

	public void setLbRotinaMedicacao(JLabel lbRotinaMedicacao) {
		this.lbRotinaMedicacao = lbRotinaMedicacao;
	}

	public JLabel getLbHorario() {
		return lbHorario;
	}

	public void setLbHorario(JLabel lbHorario) {
		this.lbHorario = lbHorario;
	}

	public JLabel getLbDosagem() {
		return lbDosagem;
	}

	public void setLbDosagem(JLabel lbDosagem) {
		this.lbDosagem = lbDosagem;
	}

	public JLabel getLbObsAdcPosologia() {
		return lbObsAdcPosologia;
	}

	public void setLbObsAdcPosologia(JLabel lbObsAdcPosologia) {
		this.lbObsAdcPosologia = lbObsAdcPosologia;
	}

	public JLabel getLbRotinaExemplo() {
		return lbRotinaExemplo;
	}

	public void setLbRotinaExemplo(JLabel lbRotinaExemplo) {
		this.lbRotinaExemplo = lbRotinaExemplo;
	}

	public JLabel getLbDosagemExemplo() {
		return lbDosagemExemplo;
	}

	public void setLbDosagemExemplo(JLabel lbDosagemExemplo) {
		this.lbDosagemExemplo = lbDosagemExemplo;
	}

	public JLabel getLbAspecto() {
		return lbAspecto;
	}

	public void setLbAspecto(JLabel lbAspecto) {
		this.lbAspecto = lbAspecto;
	}

	public JLabel getLbAspectoExemplo() {
		return lbAspectoExemplo;
	}

	public void setLbAspectoExemplo(JLabel lbAspectoExemplo) {
		this.lbAspectoExemplo = lbAspectoExemplo;
	}

	public JLabel getLbDataInicioTratamento() {
		return lbDataInicioTratamento;
	}

	public void setLbDataInicioTratamento(JLabel lbDataInicioTratamento) {
		this.lbDataInicioTratamento = lbDataInicioTratamento;
	}

	public JLabel getLbDataTérminoTratamento() {
		return lbDataTérminoTratamento;
	}

	public void setLbDataTérminoTratamento(JLabel lbDataTérminoTratamento) {
		this.lbDataTérminoTratamento = lbDataTérminoTratamento;
	}

	public JLabel getLbHorarioExemplo() {
		return lbHorarioExemplo;
	}

	public void setLbHorarioExemplo(JLabel lbHorarioExemplo) {
		this.lbHorarioExemplo = lbHorarioExemplo;
	}

	public JLabel getLbDataExemplo_1() {
		return lbDataExemplo_1;
	}

	public void setLbDataExemplo_1(JLabel lbDataExemplo_1) {
		this.lbDataExemplo_1 = lbDataExemplo_1;
	}

	public JLabel getLbDataExemplo_2() {
		return lbDataExemplo_2;
	}

	public void setLbDataExemplo_2(JLabel lbDataExemplo_2) {
		this.lbDataExemplo_2 = lbDataExemplo_2;
	}

	public JLabel getLbNumeroVezesExemplo() {
		return lbNumeroVezesExemplo;
	}

	public void setLbNumeroVezesExemplo(JLabel lbNumeroVezesExemplo) {
		this.lbNumeroVezesExemplo = lbNumeroVezesExemplo;
	}

	public JButton getBtnCadastrarPosologia() {
		return btnCadastrarPosologia;
	}

	public void setBtnCadastrarPosologia(JButton btnCadastrarPosologia) {
		this.btnCadastrarPosologia = btnCadastrarPosologia;
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

	public JComboBox<String> getCbEscolhaMedicamento() {
		return cbEscolhaMedicamento;
	}

	public void setCbEscolhaMedicamento(JComboBox<String> cbEscolhaMedicamento) {
		this.cbEscolhaMedicamento = cbEscolhaMedicamento;
	}

	public JLabel getLbEscolhaPaciente() {
		return lbEscolhaPaciente;
	}

	public void setLbEscolhaPaciente(JLabel lbEscolhaPaciente) {
		this.lbEscolhaPaciente = lbEscolhaPaciente;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLbEscolhaMedicamento() {
		return lbEscolhaMedicamento;
	}

	public void setLbEscolhaMedicamento(JLabel lbEscolhaMedicamento) {
		this.lbEscolhaMedicamento = lbEscolhaMedicamento;
	}

	public PosologiaController getController() {
		return controller;
	}

	public void setController(PosologiaController controller) {
		this.controller = controller;
	}

	public JFormattedTextField getTfHorario2() {
		return tfHorario2;
	}

	public void setTfHorario2(JFormattedTextField tfHorario2) {
		this.tfHorario2 = tfHorario2;
	}

	public JFormattedTextField getTfHorario3() {
		return tfHorario3;
	}

	public void setTfHorario3(JFormattedTextField tfHorario3) {
		this.tfHorario3 = tfHorario3;
	}

	public JFormattedTextField getTfHorario4() {
		return tfHorario4;
	}

	public void setTfHorario4(JFormattedTextField tfHorario4) {
		this.tfHorario4 = tfHorario4;
	}

	public JFormattedTextField getTfHorario5() {
		return tfHorario5;
	}

	public void setTfHorario5(JFormattedTextField tfHorario5) {
		this.tfHorario5 = tfHorario5;
	}

	public JFormattedTextField getTfHorario6() {
		return tfHorario6;
	}

	public void setTfHorario6(JFormattedTextField tfHorario6) {
		this.tfHorario6 = tfHorario6;
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
