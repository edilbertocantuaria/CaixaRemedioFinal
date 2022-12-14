package view.Medicamento;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Medicamento.EdicaoMedicamentoController;

/**
 * É a tela para a edição dosmedicamentos. Ela recebe o nome do medicamento,
 * envia para o controller.Medicamento.EdicaoMedicamentoController e, se
 * cadastrado no ArrayList, exibe as informações deste e permite modificações. e
 * permite alterá-lo.
 * 
 * @author Caetano.
 * @version 09 set 22.
 */

public class EdicaoMedicamento implements ActionListener {
	private static JFrame frame = new JFrame("Editar Paciente");
	public JButton btnEditarMedicamento_edicao;
	public JButton btnVoltar;
	public JButton btnAtualizarCadastroMedicamento;

	private EdicaoMedicamentoController controller;

	public JTextField tfNomeMedicamento;
	public JTextField tfCodigo;
	public JTextField tfDescricao;
	public JTextField tfFabricante;
	public JTextField tfBula;
	public JTextField tfPrincipioAtivo;
	public JTextField tfObsAdcMedicamento;
	public TextField tfMedicamentoEdicao;

	private JLabel lbObsAdcMedicamento;
	private JLabel lbPrincipioAtivo;
	private JLabel lbFabricante;
	private JLabel lbBula;
	private JLabel lbBulaExemplo;
	private JLabel lbDescricao;
	private JLabel lbCodigo;
	private JLabel lbNomeMedicamentoInfo;
	private JLabel lbNomeMedicamento;
	private JLabel lbNomeMedicamentoBuscaInfo;
	private JLabel lbNomeMedicamentoBusca;
	private JPanel panel;

	/**
	 * Define as dimensões físicas da view.Medicamento.EdicaoMedicamento
	 * 
	 */
	public EdicaoMedicamento() {
		frame.setSize(725, 480);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na
	 * view.Medicamento.EdicaoMedicamento EdicaoMedicamento
	 * 
	 */
	private void placeComponents(JPanel panel) {
		setController(new EdicaoMedicamentoController(this));
		panel.setLayout(null);

		lbNomeMedicamentoBusca = new JLabel("Digite o nome do medicamento: ");
		lbNomeMedicamentoBusca.setBounds(10, 6, 200, 25);
		panel.add(lbNomeMedicamentoBusca);

		lbNomeMedicamentoBuscaInfo = new JLabel("(tudo maiúsculo)");
		lbNomeMedicamentoBuscaInfo.setBounds(10, 19, 200, 25);
		panel.add(lbNomeMedicamentoBuscaInfo);

		tfMedicamentoEdicao = new TextField();
		tfMedicamentoEdicao.setBounds(511, 6, 188, 25);
		panel.add(tfMedicamentoEdicao);

		lbNomeMedicamento = new JLabel("Nome do medicamento:");
		lbNomeMedicamento.setAutoscrolls(true);
		lbNomeMedicamento.setBounds(10, 87, 390, 14);
		panel.add(lbNomeMedicamento);

		lbNomeMedicamentoInfo = new JLabel("(tudo maiúsculo)");
		lbNomeMedicamentoInfo.setAutoscrolls(true);
		lbNomeMedicamentoInfo.setBounds(10, 100, 390, 14);
		panel.add(lbNomeMedicamentoInfo);

		tfNomeMedicamento = new JTextField();
		tfNomeMedicamento.setEnabled(false);
		tfNomeMedicamento.setEditable(false);
		tfNomeMedicamento.setColumns(10);
		tfNomeMedicamento.setBounds(399, 84, 300, 20);
		panel.add(tfNomeMedicamento);

		lbCodigo = new JLabel("Codigo de barras:");
		lbCodigo.setBounds(10, 133, 251, 14);
		panel.add(lbCodigo);

		tfCodigo = new JTextField();
		tfCodigo.setEnabled(false);
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(399, 130, 300, 20);
		panel.add(tfCodigo);

		lbDescricao = new JLabel("Descrição do medicamento:");
		lbDescricao.setBounds(10, 179, 259, 14);
		panel.add(lbDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setEnabled(false);
		tfDescricao.setEditable(false);
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(399, 176, 300, 20);
		panel.add(tfDescricao);

		lbFabricante = new JLabel("Fabricante:");
		lbFabricante.setBounds(10, 225, 342, 14);
		panel.add(lbFabricante);

		tfFabricante = new JTextField();
		tfFabricante.setEnabled(false);
		tfFabricante.setEditable(false);
		tfFabricante.setColumns(10);
		tfFabricante.setBounds(399, 222, 300, 20);
		panel.add(tfFabricante);

		lbBula = new JLabel("Bula:");
		lbBula.setBounds(10, 271, 66, 14);
		panel.add(lbBula);

		lbBulaExemplo = new JLabel("(Pode inserir um link que redireciona para a bula da medicação)");
		lbBulaExemplo.setBounds(10, 284, 412, 14);
		panel.add(lbBulaExemplo);

		tfBula = new JTextField();
		tfBula.setEnabled(false);
		tfBula.setEditable(false);
		tfBula.setColumns(10);
		tfBula.setBounds(399, 268, 300, 20);
		panel.add(tfBula);

		lbPrincipioAtivo = new JLabel("Princípio ativo do medicamento:");
		lbPrincipioAtivo.setBounds(10, 317, 330, 14);
		panel.add(lbPrincipioAtivo);

		tfPrincipioAtivo = new JTextField();
		tfPrincipioAtivo.setEnabled(false);
		tfPrincipioAtivo.setEditable(false);
		tfPrincipioAtivo.setColumns(10);
		tfPrincipioAtivo.setBounds(399, 314, 300, 20);
		panel.add(tfPrincipioAtivo);

		lbObsAdcMedicamento = new JLabel("Observações adicionais");
		lbObsAdcMedicamento.setBounds(10, 363, 300, 14);
		panel.add(lbObsAdcMedicamento);

		tfObsAdcMedicamento = new JTextField();
		tfObsAdcMedicamento.setEnabled(false);
		tfObsAdcMedicamento.setEditable(false);
		tfObsAdcMedicamento.setColumns(10);
		tfObsAdcMedicamento.setBounds(399, 360, 300, 20);
		panel.add(tfObsAdcMedicamento);

		btnEditarMedicamento_edicao = new JButton("Editar Medicamento");
		btnEditarMedicamento_edicao.addActionListener(this);
		btnEditarMedicamento_edicao.setBounds(10, 50, 175, 25);
		panel.add(btnEditarMedicamento_edicao);

		btnAtualizarCadastroMedicamento = new JButton("Atualizar cadastro");
		btnAtualizarCadastroMedicamento.setEnabled(false);
		btnAtualizarCadastroMedicamento.addActionListener(this);

		btnAtualizarCadastroMedicamento.setBounds(524, 407, 175, 23);
		panel.add(btnAtualizarCadastroMedicamento);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 407, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(this);

		// Invoca o controller, que neste caso, é EdicaoMedicamentoController, apontando
		// que a ação está descrita nesta parte do código
		this.controller = new EdicaoMedicamentoController(this);
	}

	/**
	 * Está recebendo, o evento dos botões que estão na
	 * view.Medicamento.EdicaoMedicamento e invoca o controller
	 * controller.Medicamento.EdicaoMedicamento para saber qual deve ser a ação
	 * executada
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	private void setController(EdicaoMedicamentoController edicaoMedicamentoController) {
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JButton getBtnEditarMedicamento_edicao() {
		return btnEditarMedicamento_edicao;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public EdicaoMedicamentoController getController() {
		return controller;
	}

	public JButton getBtnAtualizarCadastroMedicamento() {
		return btnAtualizarCadastroMedicamento;
	}

	public JTextField getTfNomeMedicamento() {
		return tfNomeMedicamento;
	}

	public JTextField getTfCodigo() {
		return tfCodigo;
	}

	public JTextField getTfDescricao() {
		return tfDescricao;
	}

	public JTextField getTfFabricante() {
		return tfFabricante;
	}

	public JTextField getTfBula() {
		return tfBula;
	}

	public JTextField getTfPrincipioAtivo() {
		return tfPrincipioAtivo;
	}

	public JTextField getTfObsAdcMedicamento() {
		return tfObsAdcMedicamento;
	}

	public TextField getTfMedicamentoEdicao() {
		return tfMedicamentoEdicao;
	}

	public JPanel getPanel() {
		return panel;
	}

	public static void setFrame(JFrame frame) {
		EdicaoMedicamento.frame = frame;
	}

	public void setBtnEditarMedicamento_edicao(JButton btnEditarMedicamento_edicao) {
		this.btnEditarMedicamento_edicao = btnEditarMedicamento_edicao;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setBtnAtualizarCadastroMedicamento(JButton btnAtualizarCadastroMedicamento) {
		this.btnAtualizarCadastroMedicamento = btnAtualizarCadastroMedicamento;
	}

	public void setTfNomeMedicamento(JTextField tfNomeMedicamento) {
		this.tfNomeMedicamento = tfNomeMedicamento;
	}

	public void setTfCodigo(JTextField tfCodigo) {
		this.tfCodigo = tfCodigo;
	}

	public void setTfDescricao(JTextField tfDescricao) {
		this.tfDescricao = tfDescricao;
	}

	public void setTfFabricante(JTextField tfFabricante) {
		this.tfFabricante = tfFabricante;
	}

	public void setTfBula(JTextField tfBula) {
		this.tfBula = tfBula;
	}

	public void setTfPrincipioAtivo(JTextField tfPrincipioAtivo) {
		this.tfPrincipioAtivo = tfPrincipioAtivo;
	}

	public void setTfObsAdcMedicamento(JTextField tfObsAdcMedicamento) {
		this.tfObsAdcMedicamento = tfObsAdcMedicamento;
	}

	public void setTfMedicamentoEdicao(TextField tfMedicamentoEdicao) {
		this.tfMedicamentoEdicao = tfMedicamentoEdicao;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
