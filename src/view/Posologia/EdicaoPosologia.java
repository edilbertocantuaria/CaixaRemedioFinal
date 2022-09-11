package view.Posologia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.Posologia.EdicaoPosologiaController;

public class EdicaoPosologia implements ActionListener {

	private static JFrame frame = new JFrame("Cadastro de Posologia");

	public JFormattedTextField tfNumeroVezes;
	public JTextField tfRotinaMedicacao;
	public JTextField tfDosagem;
	public JTextField tfObsAdcPosologia;
	public JTextField tfAspecto;
	public JTextField tfDataInicioTratamento;
	public JTextField tfDataFimTratamento;
	public JFormattedTextField tfHorario1;
	public JFormattedTextField tfHorario2;
	public JFormattedTextField tfHorario3;
	public JFormattedTextField tfHorario4;
	public JFormattedTextField tfHorario5;
	public JFormattedTextField tfHorario6;
	public JFormattedTextField tfCodigoPosologia;
	public JComboBox<String> cbEscolhaPaciente;
	public JComboBox<String> cbEscolhaMedicamento;

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
	private JLabel lbCodigo;
	private JLabel lbEscolhaMedicamento;
	private JLabel lbEscolhaPaciente;

	private JPanel panel;

	public JButton btnAtualizarPosologia;
	public JButton btnVoltar;

	private EdicaoPosologiaController controller;
	private JLabel lbCodigoInfo;

	public JButton btnEditarPosologia_edicao;

	public JFormattedTextField jftCodPosologiaBusca;

	public JLabel lbCod;

	public EdicaoPosologia() {
		frame.setSize(680, 595);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		setController(new EdicaoPosologiaController(null));

		panel.setLayout(null);

		MaskFormatter mascaraDataInicial = null;
		MaskFormatter mascaraDataFinal = null;
		MaskFormatter mascaraHora = null;
		MaskFormatter mascaraDosagem = null;
		MaskFormatter mascaraNumeroVezes = null;
		MaskFormatter mascaraCodigo = null;

		try {
			mascaraDataInicial = new MaskFormatter("##/##/####");
			mascaraDataFinal = new MaskFormatter("##/##/####");
			mascaraHora = new MaskFormatter("##:##");
			mascaraDosagem = new MaskFormatter("#.#");
			mascaraNumeroVezes = new MaskFormatter("#");
			mascaraCodigo = new MaskFormatter("###");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		lbRotinaMedicacao = new JLabel("Rotina da medicação:");
		lbRotinaMedicacao.setBounds(10, 192, 251, 14);
		panel.add(lbRotinaMedicacao);
		lbRotinaExemplo = new JLabel("(Diariamente, semanalmente, quinzenalmente, etc.)");
		lbRotinaExemplo.setBounds(10, 205, 300, 14);
		panel.add(lbRotinaExemplo);
		tfRotinaMedicacao = new JTextField();
		tfRotinaMedicacao.setEditable(false);
		tfRotinaMedicacao.setEnabled(false);
		tfRotinaMedicacao.setBounds(354, 189, 300, 20);
		panel.add(tfRotinaMedicacao);
		tfRotinaMedicacao.setColumns(10);

		lbHorario = new JLabel("Horário de ingestão do medicamento:");
		lbHorario.setBounds(10, 238, 259, 14);
		panel.add(lbHorario);
		lbHorarioExemplo = new JLabel("(Inserir pelo menos um horário)");
		lbHorarioExemplo.setBounds(10, 251, 354, 14);
		panel.add(lbHorarioExemplo);

		tfHorario1 = new JFormattedTextField(mascaraHora);
		tfHorario1.setEnabled(false);
		tfHorario1.setEditable(false);
		tfHorario1.setBounds(362, 235, 40, 20);
		panel.add(tfHorario1);
		tfHorario1.setColumns(10);

		tfHorario2 = new JFormattedTextField(mascaraHora);
		tfHorario2.setEnabled(false);
		tfHorario2.setEditable(false);
		tfHorario2.setColumns(10);
		tfHorario2.setBounds(412, 235, 40, 20);
		panel.add(tfHorario2);

		tfHorario3 = new JFormattedTextField(mascaraHora);
		tfHorario3.setEnabled(false);
		tfHorario3.setEditable(false);
		tfHorario3.setColumns(10);
		tfHorario3.setBounds(462, 235, 40, 20);
		panel.add(tfHorario3);

		tfHorario4 = new JFormattedTextField(mascaraHora);
		tfHorario4.setEnabled(false);
		tfHorario4.setEditable(false);
		tfHorario4.setColumns(10);
		tfHorario4.setBounds(522, 235, 40, 20);
		panel.add(tfHorario4);

		tfHorario5 = new JFormattedTextField(mascaraHora);
		tfHorario5.setEnabled(false);
		tfHorario5.setEditable(false);
		tfHorario5.setColumns(10);
		tfHorario5.setBounds(572, 235, 40, 20);
		panel.add(tfHorario5);

		tfHorario6 = new JFormattedTextField(mascaraHora);
		tfHorario6.setEnabled(false);
		tfHorario6.setEditable(false);
		tfHorario6.setColumns(10);
		tfHorario6.setBounds(614, 235, 40, 20);
		panel.add(tfHorario6);

		lbDosagem = new JLabel("Dosagem (digitar apenas número):");
		lbDosagem.setBounds(10, 284, 342, 14);
		panel.add(lbDosagem);
		lbDosagemExemplo = new JLabel("(exemplos:0.5, 1.0, 2.0, etc.)");
		lbDosagemExemplo.setBounds(10, 297, 257, 14);
		panel.add(lbDosagemExemplo);
		tfDosagem = new JFormattedTextField(mascaraDosagem);
		tfDosagem.setEditable(false);
		tfDosagem.setEnabled(false);
		tfDosagem.setBounds(354, 281, 300, 20);
		panel.add(tfDosagem);
		tfDosagem.setColumns(10);

		lbNumeroVezes = new JLabel("Número de vezes que o remédio deve ser consumido por dia:");
		lbNumeroVezes.setAutoscrolls(true);
		lbNumeroVezes.setBounds(10, 146, 390, 14);
		panel.add(lbNumeroVezes);
		tfNumeroVezes = new JFormattedTextField(mascaraNumeroVezes);
		tfNumeroVezes.setEditable(false);
		tfNumeroVezes.setEnabled(false);
		tfNumeroVezes.setBounds(554, 143, 100, 20);
		panel.add(tfNumeroVezes);
		tfNumeroVezes.setColumns(10);
		lbNumeroVezesExemplo = new JLabel("(digitar apenas números)");
		lbNumeroVezesExemplo.setAutoscrolls(true);
		lbNumeroVezesExemplo.setBounds(10, 159, 390, 14);
		panel.add(lbNumeroVezesExemplo);

		lbObsAdcPosologia = new JLabel("Observações adicionais");
		lbObsAdcPosologia.setBounds(10, 422, 300, 14);
		panel.add(lbObsAdcPosologia);
		tfObsAdcPosologia = new JTextField();
		tfObsAdcPosologia.setEditable(false);
		tfObsAdcPosologia.setEnabled(false);
		tfObsAdcPosologia.setColumns(10);
		tfObsAdcPosologia.setBounds(354, 419, 300, 20);
		panel.add(tfObsAdcPosologia);

		lbAspecto = new JLabel("Aspecto:");
		lbAspecto.setBounds(10, 330, 66, 14);
		panel.add(lbAspecto);
		tfAspecto = new JTextField();
		tfAspecto.setEditable(false);
		tfAspecto.setEnabled(false);
		tfAspecto.setColumns(10);
		tfAspecto.setBounds(354, 327, 300, 20);
		panel.add(tfAspecto);
		lbAspectoExemplo = new JLabel("(Comprimido, capsula, gota, etc.)");
		lbAspectoExemplo.setBounds(10, 343, 257, 14);
		panel.add(lbAspectoExemplo);

		lbDataInicioTratamento = new JLabel("Data de início do tratamento:");
		lbDataInicioTratamento.setBounds(10, 376, 330, 14);
		panel.add(lbDataInicioTratamento);
		tfDataInicioTratamento = new JFormattedTextField(mascaraDataInicial);
		tfDataInicioTratamento.setEditable(false);
		tfDataInicioTratamento.setEnabled(false);
		tfDataInicioTratamento.setColumns(10);
		tfDataInicioTratamento.setBounds(206, 373, 100, 20);
		panel.add(tfDataInicioTratamento);
		lbDataExemplo_1 = new JLabel("(DD/MM/AAAA)");
		lbDataExemplo_1.setBounds(10, 389, 257, 14);
		panel.add(lbDataExemplo_1);

		lbDataTérminoTratamento = new JLabel("Data de término do tratamento:");
		lbDataTérminoTratamento.setBounds(362, 376, 343, 14);
		panel.add(lbDataTérminoTratamento);
		tfDataFimTratamento = new JFormattedTextField(mascaraDataFinal);
		tfDataFimTratamento.setEditable(false);
		tfDataFimTratamento.setEnabled(false);
		tfDataFimTratamento.setColumns(10);
		tfDataFimTratamento.setBounds(554, 373, 100, 20);
		panel.add(tfDataFimTratamento);
		lbDataExemplo_2 = new JLabel("(DD/MM/AAAA)");
		lbDataExemplo_2.setBounds(362, 389, 257, 14);
		panel.add(lbDataExemplo_2);

		lbCodigo = new JLabel("Código de até 3 dígitos");
		lbCodigo.setBounds(10, 468, 251, 14);
		panel.add(lbCodigo);
		lbCodigoInfo = new JLabel("Esse código será utilizado para localizar a posologia");
		lbCodigoInfo.setBounds(10, 481, 296, 14);
		panel.add(lbCodigoInfo);
		tfCodigoPosologia = new JFormattedTextField(mascaraCodigo);
		tfCodigoPosologia.setEditable(false);
		tfCodigoPosologia.setEnabled(false);
		tfCodigoPosologia.setBounds(572, 465, 82, 20);
		panel.add(tfCodigoPosologia);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(10, 522, 210, 23);
		panel.add(btnVoltar);

		cbEscolhaPaciente = new JComboBox<String>();
		cbEscolhaPaciente.setEnabled(false);
		cbEscolhaPaciente.setBounds(86, 96, 189, 22);
		panel.add(cbEscolhaPaciente);

		lbEscolhaPaciente = new JLabel("Paciente:");
		lbEscolhaPaciente.setBounds(10, 100, 94, 14);
		panel.add(lbEscolhaPaciente);

		lbEscolhaMedicamento = new JLabel("Medicamento:");
		lbEscolhaMedicamento.setBounds(362, 100, 94, 14);
		panel.add(lbEscolhaMedicamento);

		cbEscolhaMedicamento = new JComboBox<String>();
		cbEscolhaMedicamento.setEnabled(false);
		cbEscolhaMedicamento.setBounds(465, 96, 189, 22);
		panel.add(cbEscolhaMedicamento);

		cbEscolhaPaciente.setModel(controller.listarPacientes());
		cbEscolhaPaciente.setSelectedIndex(-1);
		cbEscolhaMedicamento.setModel(controller.listarMedicamentos());
		cbEscolhaMedicamento.setSelectedIndex(-1);

		btnAtualizarPosologia = new JButton("Cadastrar Posologia");
		btnAtualizarPosologia.setEnabled(false);
		btnAtualizarPosologia.addActionListener(this);
		btnAtualizarPosologia.setBounds(479, 522, 175, 23);
		panel.add(btnAtualizarPosologia);

		lbCod = new JLabel("Código da posologia:");
		lbCod.setBounds(10, 11, 146, 25);
		panel.add(lbCod);

		jftCodPosologiaBusca = new JFormattedTextField(mascaraCodigo);
		jftCodPosologiaBusca.setBounds(161, 11, 100, 25);
		panel.add(jftCodPosologiaBusca);

		btnEditarPosologia_edicao = new JButton("Editar Posologia");
		btnEditarPosologia_edicao.addActionListener(this);
		btnEditarPosologia_edicao.setBounds(10, 51, 146, 25);
		panel.add(btnEditarPosologia_edicao);

		this.controller = new EdicaoPosologiaController(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public void setController(EdicaoPosologiaController controller) {
		this.controller = controller;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JFormattedTextField getTfNumeroVezes() {
		return tfNumeroVezes;
	}

	public JTextField getTfRotinaMedicacao() {
		return tfRotinaMedicacao;
	}

	public JTextField getTfDosagem() {
		return tfDosagem;
	}

	public JTextField getTfObsAdcPosologia() {
		return tfObsAdcPosologia;
	}

	public JTextField getTfAspecto() {
		return tfAspecto;
	}

	public JTextField getTfDataInicioTratamento() {
		return tfDataInicioTratamento;
	}

	public JTextField getTfDataFimTratamento() {
		return tfDataFimTratamento;
	}

	public JFormattedTextField getTfHorario1() {
		return tfHorario1;
	}

	public JFormattedTextField getTfHorario2() {
		return tfHorario2;
	}

	public JFormattedTextField getTfHorario3() {
		return tfHorario3;
	}

	public JFormattedTextField getTfHorario4() {
		return tfHorario4;
	}

	public JFormattedTextField getTfHorario5() {
		return tfHorario5;
	}

	public JFormattedTextField getTfHorario6() {
		return tfHorario6;
	}

	public JFormattedTextField getTfCodigoPosologia() {
		return tfCodigoPosologia;
	}

	public JComboBox<String> getCbEscolhaPaciente() {
		return cbEscolhaPaciente;
	}

	public JComboBox<String> getCbEscolhaMedicamento() {
		return cbEscolhaMedicamento;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBtnAtualizarPosologia() {
		return btnAtualizarPosologia;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public EdicaoPosologiaController getController() {
		return controller;
	}

	public JButton getBtnEditarPosologia_edicao() {
		return btnEditarPosologia_edicao;
	}

	public JFormattedTextField getJftCodBusca() {
		return jftCodPosologiaBusca;
	}

	public JLabel getLbCod() {
		return lbCod;
	}

	public static void setFrame(JFrame frame) {
		EdicaoPosologia.frame = frame;
	}

	public void setTfNumeroVezes(JFormattedTextField tfNumeroVezes) {
		this.tfNumeroVezes = tfNumeroVezes;
	}

	public void setTfRotinaMedicacao(JTextField tfRotinaMedicacao) {
		this.tfRotinaMedicacao = tfRotinaMedicacao;
	}

	public void setTfDosagem(JTextField tfDosagem) {
		this.tfDosagem = tfDosagem;
	}

	public void setTfObsAdcPosologia(JTextField tfObsAdcPosologia) {
		this.tfObsAdcPosologia = tfObsAdcPosologia;
	}

	public void setTfAspecto(JTextField tfAspecto) {
		this.tfAspecto = tfAspecto;
	}

	public void setTfDataInicioTratamento(JTextField tfDataInicioTratamento) {
		this.tfDataInicioTratamento = tfDataInicioTratamento;
	}

	public void setTfDataFimTratamento(JTextField tfDataFimTratamento) {
		this.tfDataFimTratamento = tfDataFimTratamento;
	}

	public void setTfHorario1(JFormattedTextField tfHorario1) {
		this.tfHorario1 = tfHorario1;
	}

	public void setTfHorario2(JFormattedTextField tfHorario2) {
		this.tfHorario2 = tfHorario2;
	}

	public void setTfHorario3(JFormattedTextField tfHorario3) {
		this.tfHorario3 = tfHorario3;
	}

	public void setTfHorario4(JFormattedTextField tfHorario4) {
		this.tfHorario4 = tfHorario4;
	}

	public void setTfHorario5(JFormattedTextField tfHorario5) {
		this.tfHorario5 = tfHorario5;
	}

	public void setTfHorario6(JFormattedTextField tfHorario6) {
		this.tfHorario6 = tfHorario6;
	}

	public void setTfCodigoPosologia(JFormattedTextField tfCodigoPosologia) {
		this.tfCodigoPosologia = tfCodigoPosologia;
	}

	public void setCbEscolhaPaciente(JComboBox<String> cbEscolhaPaciente) {
		this.cbEscolhaPaciente = cbEscolhaPaciente;
	}

	public void setCbEscolhaMedicamento(JComboBox<String> cbEscolhaMedicamento) {
		this.cbEscolhaMedicamento = cbEscolhaMedicamento;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setBtnAtualizarPosologia(JButton btnAtualizarPosologia) {
		this.btnAtualizarPosologia = btnAtualizarPosologia;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setBtnEditarPosologia_edicao(JButton btnEditarPosologia_edicao) {
		this.btnEditarPosologia_edicao = btnEditarPosologia_edicao;
	}

	public void setJftCPFBusca(JFormattedTextField jftCodPosologiaBusca) {
		this.jftCodPosologiaBusca = jftCodPosologiaBusca;
	}

	public void setLbCod(JLabel lbCod) {
		this.lbCod = lbCod;
	}

}
