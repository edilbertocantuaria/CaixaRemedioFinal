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

import controller.Posologia.CadastroPosologiaController;

/**
 * É a tela para a cadastro dos posologias. Ela recebe o os dados necessários e
 * envia para o controller.Posologia.CadastroPosologiaController e, se já
 * cadastrado no ArrayList, exibe uma mensagem informando a existência deste..
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class CadastroPosologia implements ActionListener {

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

	private JButton btnCadastrarPosologia;
	private JButton btnVoltar;

	private CadastroPosologiaController controller;
	private JLabel lbCodigoInfo;

	public JButton btnAtualizarPacienteMedicamento;

	/**
	 * Define as dimensões físicas da view.Posologia.CadastroPosologia
	 * 
	 */

	public CadastroPosologia() {
		frame.setSize(705, 525);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na
	 * view.Posologia.CadastroPosologia CadastroPosologia
	 * 
	 */
	private void placeComponents(JPanel panel) {
		setController(new CadastroPosologiaController(this));

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
		lbRotinaMedicacao.setBounds(10, 124, 251, 14);
		panel.add(lbRotinaMedicacao);
		lbRotinaExemplo = new JLabel("(Diariamente, semanalmente, quinzenalmente, etc.)");
		lbRotinaExemplo.setBounds(10, 137, 300, 14);
		panel.add(lbRotinaExemplo);
		tfRotinaMedicacao = new JTextField();
		tfRotinaMedicacao.setBounds(379, 121, 300, 20);
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
		tfHorario6.setBounds(639, 167, 40, 20);
		panel.add(tfHorario6);

		lbDosagem = new JLabel("Dosagem (digitar apenas número):");
		lbDosagem.setBounds(10, 216, 342, 14);
		panel.add(lbDosagem);
		lbDosagemExemplo = new JLabel("(exemplos:0.5, 1.0, 2.0, etc.)");
		lbDosagemExemplo.setBounds(10, 229, 257, 14);
		panel.add(lbDosagemExemplo);
		tfDosagem = new JFormattedTextField(mascaraDosagem);
		tfDosagem.setBounds(379, 213, 300, 20);
		panel.add(tfDosagem);
		tfDosagem.setColumns(10);

		lbNumeroVezes = new JLabel("Número de vezes que o remédio deve ser consumido por dia:");
		lbNumeroVezes.setAutoscrolls(true);
		lbNumeroVezes.setBounds(10, 78, 390, 14);
		panel.add(lbNumeroVezes);
		tfNumeroVezes = new JFormattedTextField(mascaraNumeroVezes);
		tfNumeroVezes.setBounds(579, 75, 100, 20);
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
		tfObsAdcPosologia.setBounds(379, 351, 300, 20);
		panel.add(tfObsAdcPosologia);

		lbAspecto = new JLabel("Aspecto:");
		lbAspecto.setBounds(10, 262, 66, 14);
		panel.add(lbAspecto);
		tfAspecto = new JTextField();
		tfAspecto.setColumns(10);
		tfAspecto.setBounds(379, 259, 300, 20);
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
		tfDataFimTratamento.setBounds(579, 305, 100, 20);
		panel.add(tfDataFimTratamento);
		lbDataExemplo_2 = new JLabel("(DD/MM/AAAA)");
		lbDataExemplo_2.setBounds(362, 321, 257, 14);
		panel.add(lbDataExemplo_2);

		lbCodigo = new JLabel("Código de até 3 dígitos");
		lbCodigo.setBounds(10, 400, 251, 14);
		panel.add(lbCodigo);
		lbCodigoInfo = new JLabel("Esse código será utilizado para localizar a posologia");
		lbCodigoInfo.setBounds(10, 413, 296, 14);
		panel.add(lbCodigoInfo);
		tfCodigoPosologia = new JFormattedTextField(mascaraCodigo);
		tfCodigoPosologia.setBounds(597, 397, 82, 20);
		panel.add(tfCodigoPosologia);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(10, 454, 210, 23);
		panel.add(btnVoltar);

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
		cbEscolhaMedicamento.setBounds(490, 28, 189, 22);
		panel.add(cbEscolhaMedicamento);

		cbEscolhaPaciente.setModel(controller.listarPacientes());
		cbEscolhaPaciente.setSelectedIndex(-1);
		cbEscolhaMedicamento.setModel(controller.listarMedicamentos());
		cbEscolhaMedicamento.setSelectedIndex(-1);

		btnCadastrarPosologia = new JButton("Cadastrar Posologia");
		btnCadastrarPosologia.addActionListener(this);
		btnCadastrarPosologia.setBounds(504, 454, 175, 23);
		panel.add(btnCadastrarPosologia);

		btnAtualizarPacienteMedicamento = new JButton("Atualizar Pacientes e Medicamentos");
		btnAtualizarPacienteMedicamento.addActionListener(this);
		btnAtualizarPacienteMedicamento.setBounds(232, 454, 259, 23);
		panel.add(btnAtualizarPacienteMedicamento);

		// Invoca o controller, que neste caso, é CadastroPosologiaController, apontando
		// que a ação está descrita nesta parte do código
		this.controller = new CadastroPosologiaController(this);
	}

	/**
	 * Está recebendo, o evento dos botões que estão na
	 * view.Posologia.CadastroPosologia e invoca o controller
	 * controller.Posologia.CadastroPosologia para saber qual deve ser a ação
	 * executada
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JTextField getTfNumeroVezes() {
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

	public JButton getBtnCadastrarPosologia() {
		return btnCadastrarPosologia;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public CadastroPosologiaController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		CadastroPosologia.frame = frame;
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

	public void setBtnCadastrarPosologia(JButton btnCadastrarPosologia) {
		this.btnCadastrarPosologia = btnCadastrarPosologia;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnAtualizarPacienteMedicamento() {
		return btnAtualizarPacienteMedicamento;
	}

	public void setBtnAtualizarPacienteMedicamento(JButton btnAtualizarPacienteMedicamento) {
		this.btnAtualizarPacienteMedicamento = btnAtualizarPacienteMedicamento;
	}

	public void setController(CadastroPosologiaController controller) {
		this.controller = controller;
	}
}
