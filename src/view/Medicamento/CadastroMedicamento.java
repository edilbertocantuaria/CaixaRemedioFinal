package view.Medicamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Medicamento.CadastroMedicamentoController;

/**
 * É a tela para o cadastro dos medicamentos, onde ocorre create + read do CRUD.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */

public class CadastroMedicamento implements ActionListener {
	private static JFrame frame = new JFrame("Cadastro de Medicamento");

	public JTextField tfNomeMedicamento;
	public JTextField tfCodigo;
	public JTextField tfDescricao;
	public JTextField tfFabricante;
	public JTextField tfObsAdcMedicamento;
	public JTextField tfBula;
	public JTextField tfPrincipioAtivo;

	private JLabel lbNomeMedicamento;
	private JLabel lbCodigo;
	private JLabel lbDescricao;
	private JLabel lbFabricante;
	private JLabel lbObsAdcMedicamento;
	private JLabel lbBula;
	private JLabel lbBulaExemplo;
	private JLabel lbPrincipioAtivo;

	private JButton btnCadastrarMedicamento;
	private JButton btnVoltar;

	private JPanel panel;
	private JLabel lbNomeMedicamentoInfo;

	private CadastroMedicamentoController controller;

	/**
	 * Define as dimensões físicas da tela CadastroMedicamento
	 * 
	 * @version 09 set 22.
	 */

	public CadastroMedicamento() {
		frame.setSize(725, 410);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na tela
	 * CadastroMedicamento
	 * 
	 * @version 09 out 22.
	 */
	private void placeComponents(JPanel panel) {
		setController(new CadastroMedicamentoController(this));
		panel.setLayout(null);

		lbCodigo = new JLabel("Codigo de barras:");
		lbCodigo.setBounds(10, 78, 251, 14);
		panel.add(lbCodigo);
		tfCodigo = new JTextField();
		tfCodigo.setBounds(399, 75, 300, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);

		lbDescricao = new JLabel("Descrição do medicamento:");
		lbDescricao.setBounds(10, 124, 259, 14);
		panel.add(lbDescricao);
		tfDescricao = new JTextField();
		tfDescricao.setBounds(399, 121, 300, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);

		lbFabricante = new JLabel("Fabricante:");
		lbFabricante.setBounds(10, 170, 342, 14);
		panel.add(lbFabricante);
		tfFabricante = new JTextField();
		tfFabricante.setBounds(399, 167, 300, 20);
		panel.add(tfFabricante);
		tfFabricante.setColumns(10);

		lbNomeMedicamento = new JLabel("Nome do medicamento:");
		lbNomeMedicamento.setAutoscrolls(true);
		lbNomeMedicamento.setBounds(10, 32, 390, 14);
		panel.add(lbNomeMedicamento);
		lbNomeMedicamentoInfo = new JLabel("(tudo maiúsculo)");
		lbNomeMedicamentoInfo.setAutoscrolls(true);
		lbNomeMedicamentoInfo.setBounds(10, 45, 390, 14);
		panel.add(lbNomeMedicamentoInfo);
		tfNomeMedicamento = new JTextField();
		tfNomeMedicamento.setBounds(399, 29, 300, 20);
		panel.add(tfNomeMedicamento);
		tfNomeMedicamento.setColumns(10);

		lbObsAdcMedicamento = new JLabel("Observações adicionais");
		lbObsAdcMedicamento.setBounds(10, 308, 300, 14);
		panel.add(lbObsAdcMedicamento);
		tfObsAdcMedicamento = new JTextField();
		tfObsAdcMedicamento.setColumns(10);
		tfObsAdcMedicamento.setBounds(399, 305, 300, 20);
		panel.add(tfObsAdcMedicamento);

		lbBula = new JLabel("Bula:");
		lbBula.setBounds(10, 216, 66, 14);
		panel.add(lbBula);
		tfBula = new JTextField();
		tfBula.setColumns(10);
		tfBula.setBounds(399, 213, 300, 20);
		panel.add(tfBula);
		lbBulaExemplo = new JLabel("(Pode inserir um link que redireciona para a bula da medicação)");
		lbBulaExemplo.setBounds(10, 229, 412, 14);
		panel.add(lbBulaExemplo);

		lbPrincipioAtivo = new JLabel("Princípio ativo do medicamento:");
		lbPrincipioAtivo.setBounds(10, 262, 330, 14);
		panel.add(lbPrincipioAtivo);
		tfPrincipioAtivo = new JTextField();
		tfPrincipioAtivo.setColumns(10);
		tfPrincipioAtivo.setBounds(399, 259, 300, 20);
		panel.add(tfPrincipioAtivo);

		/**
		 * Determina a ação do btnVoltar, que neste caso fecha a tela
		 * CadastroMedicamento e abre a tela PrincipalMedicamento
		 * 
		 * @version 09 set. 22.
		 */
		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 337, 175, 23);
		btnVoltar.addActionListener(this);
		panel.add(btnVoltar);

		/**
		 * Determina a ação do btnCadastro, que neste caso fecha a tela
		 * PrincipalMedicamento e abre a tela CadastroMedicamento, solicitando os dados
		 * necessários
		 * 
		 * @version 09 set. 22.
		 */

		btnCadastrarMedicamento = new JButton("Cadastrar Medicamento");
		btnCadastrarMedicamento.addActionListener(this);
		btnCadastrarMedicamento.setBounds(524, 336, 175, 23);
		panel.add(btnCadastrarMedicamento);

		this.controller = new CadastroMedicamentoController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public CadastroMedicamentoController getController() {
		return controller;
	}

	public void setController(CadastroMedicamentoController controller) {
		this.controller = controller;
	}

	public static JFrame getFrame() {
		return frame;
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

	public JTextField getTfObsAdcMedicamento() {
		return tfObsAdcMedicamento;
	}

	public JTextField getTfBula() {
		return tfBula;
	}

	public JTextField getTfPrincipioAtivo() {
		return tfPrincipioAtivo;
	}

	public JButton getBtnCadastrarMedicamento() {
		return btnCadastrarMedicamento;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public static void setFrame(JFrame frame) {
		CadastroMedicamento.frame = frame;
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

	public void setTfObsAdcMedicamento(JTextField tfObsAdcMedicamento) {
		this.tfObsAdcMedicamento = tfObsAdcMedicamento;
	}

	public void setTfBula(JTextField tfBula) {
		this.tfBula = tfBula;
	}

	public void setTfPrincipioAtivo(JTextField tfPrincipioAtivo) {
		this.tfPrincipioAtivo = tfPrincipioAtivo;
	}

	public void setBtnCadastrarMedicamento(JButton btnCadastrarMedicamento) {
		this.btnCadastrarMedicamento = btnCadastrarMedicamento;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
