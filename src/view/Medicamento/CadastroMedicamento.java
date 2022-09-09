package view.Medicamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MedicamentoController;
import model.Medicamento;

/**
 * É a tela para o cadastro dos medicamentos, onde ocorre create + read do CRUD.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */

public class CadastroMedicamento {
	private static JFrame frame = new JFrame("Cadastro de Medicamento");

	private JTextField tfNomeMedicamento;
	private JTextField tfCodigo;
	private JTextField tfDescricao;
	private JTextField tfFabricante;
	private JTextField tfObsAdcMedicamento;
	private JTextField tfBula;
	private JTextField tfPrincipioAtivo;
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

	/**
	 * Define as dimensões físicas da tela CadastroMedicamento
	 * 
	 * @version 09 set 22.
	 */

	public CadastroMedicamento() {
		frame.setSize(700, 410);

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
		panel.setLayout(null);

		lbCodigo = new JLabel("Codigo de barras:");
		lbCodigo.setBounds(10, 78, 251, 14);
		panel.add(lbCodigo);
		tfCodigo = new JTextField();
		tfCodigo.setBounds(362, 75, 300, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);

		lbDescricao = new JLabel("Descrição do medicamento:");
		lbDescricao.setBounds(10, 124, 259, 14);
		panel.add(lbDescricao);
		tfDescricao = new JTextField();
		tfDescricao.setBounds(363, 121, 300, 20);
		panel.add(tfDescricao);
		tfDescricao.setColumns(10);

		lbFabricante = new JLabel("Fabricante:");
		lbFabricante.setBounds(10, 170, 342, 14);
		panel.add(lbFabricante);
		tfFabricante = new JTextField();
		tfFabricante.setBounds(362, 167, 300, 20);
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
		tfNomeMedicamento.setBounds(362, 29, 300, 20);
		panel.add(tfNomeMedicamento);
		tfNomeMedicamento.setColumns(10);

		lbObsAdcMedicamento = new JLabel("Observações adicionais");
		lbObsAdcMedicamento.setBounds(10, 308, 300, 14);
		panel.add(lbObsAdcMedicamento);
		tfObsAdcMedicamento = new JTextField();
		tfObsAdcMedicamento.setColumns(10);
		tfObsAdcMedicamento.setBounds(362, 305, 300, 20);
		panel.add(tfObsAdcMedicamento);

		lbBula = new JLabel("Bula:");
		lbBula.setBounds(10, 216, 66, 14);
		panel.add(lbBula);
		tfBula = new JTextField();
		tfBula.setColumns(10);
		tfBula.setBounds(362, 213, 300, 20);
		panel.add(tfBula);
		lbBulaExemplo = new JLabel("(Pode inserir um link que redireciona para a bula da medicação)");
		lbBulaExemplo.setBounds(10, 229, 342, 14);
		panel.add(lbBulaExemplo);

		lbPrincipioAtivo = new JLabel("Princípio ativo do medicamento:");
		lbPrincipioAtivo.setBounds(10, 262, 330, 14);
		panel.add(lbPrincipioAtivo);
		tfPrincipioAtivo = new JTextField();
		tfPrincipioAtivo.setColumns(10);
		tfPrincipioAtivo.setBounds(362, 259, 300, 20);
		panel.add(tfPrincipioAtivo);

		/**
		 * Determina a ação do btnVoltar, que neste caso fecha a tela
		 * CadastroMedicamento e abre a tela PrincipalMedicamento
		 * 
		 * @version 09 set. 22.
		 */
		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 337, 175, 23);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PrincipalMedicamento obj = new PrincipalMedicamento();
				obj.setVisible(true);
				frame.dispose();

			}
		});
		panel.add(btnVoltar);

		/**
		 * Determina a ação do btnCadastro, que neste caso fecha a tela
		 * PrincipalMedicamento e abre a tela CadastroMedicamento, solicitando os dados
		 * necessários
		 * 
		 * @version 09 set. 22.
		 */

		btnCadastrarMedicamento = new JButton("Cadastrar Medicamento");
		btnCadastrarMedicamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastraMedicamento();
			}

			public void cadastraMedicamento() {
				// deixa o cursor dentro desse jtextfield's
				tfNomeMedicamento.requestFocus();

				// Cadastra as informações de um medicamento na lista

				String nomeRemedio = getTfNomeMedicamento().getText().trim();
				String codigo = getTfCodigo().getText().trim();
				String descricao = getTfDescricao().getText().trim();
				String fabricante = getTfFabricante().getText().trim();
				String bula = getTfBula().getText().trim();
				String principioAtivo = getTfPrincipioAtivo().getText().trim();
				String observacaoAdicionalMedicamento = getTfObsAdcMedicamento().getText().trim();

				/**
				 * Adiciona os dados inseridos acima no ArrayList medicamentos. Este ArrayList
				 * está em controller.MedicamentoController, linhas 23 a 26.
				 * 
				 * @version 09 set 22
				 */

				if (getTfNomeMedicamento().getText().isEmpty() || getTfCodigo().getText().isEmpty()
						|| getTfDescricao().getText().isEmpty() || getTfFabricante().getText().isEmpty()
						|| getTfBula().getText().isEmpty() || getTfPrincipioAtivo().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Não foi possível realizar o cadastro: os dados do medicamento não podem estar vazios!");

				} else {
					Medicamento medicamento = new Medicamento(nomeRemedio, codigo, descricao, fabricante, bula,
							principioAtivo, observacaoAdicionalMedicamento);
					MedicamentoController.medicamentos.add(medicamento);
					JOptionPane.showMessageDialog(null, "Cadastro efetivado!");
				}

				System.out.println(MedicamentoController.medicamentos.toString());

				// limpando os campos dos jtextfield's
				tfNomeMedicamento.setText("");
				tfCodigo.setText("");
				tfDescricao.setText("");
				tfFabricante.setText("");
				tfBula.setText("");
				tfPrincipioAtivo.setText("");
				tfObsAdcMedicamento.setText("");

				// deixa o cursor dentro desse jtextfield's
				tfNomeMedicamento.requestFocus();

			}
		});
		btnCadastrarMedicamento.setBounds(487, 337, 175, 23);
		panel.add(btnCadastrarMedicamento);

	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		CadastroMedicamento.frame = frame;
	}

	public JTextField getTfNomeMedicamento() {
		return tfNomeMedicamento;
	}

	public void setTfNomeMedicamento(JTextField tfNomeMedicamento) {
		this.tfNomeMedicamento = tfNomeMedicamento;
	}

	public JTextField getTfCodigo() {
		return tfCodigo;
	}

	public void setTfCodigo(JTextField tfCodigo) {
		this.tfCodigo = tfCodigo;
	}

	public JTextField getTfDescricao() {
		return tfDescricao;
	}

	public void setTfDescricao(JTextField tfDescricao) {
		this.tfDescricao = tfDescricao;
	}

	public JTextField getTfFabricante() {
		return tfFabricante;
	}

	public void setTfFabricante(JTextField tfFabricante) {
		this.tfFabricante = tfFabricante;
	}

	public JTextField getTfObsAdcMedicamento() {
		return tfObsAdcMedicamento;
	}

	public void setTfObsAdcMedicamento(JTextField tfObsAdcMedicamento) {
		this.tfObsAdcMedicamento = tfObsAdcMedicamento;
	}

	public JTextField getTfBula() {
		return tfBula;
	}

	public void setTfBula(JTextField tfBula) {
		this.tfBula = tfBula;
	}

	public JTextField getTfPrincipioAtivo() {
		return tfPrincipioAtivo;
	}

	public void setTfPrincipioAtivo(JTextField tfPrincipioAtivo) {
		this.tfPrincipioAtivo = tfPrincipioAtivo;
	}

	public JLabel getLbNomeMedicamento() {
		return lbNomeMedicamento;
	}

	public void setLbNomeMedicamento(JLabel lbNomeMedicamento) {
		this.lbNomeMedicamento = lbNomeMedicamento;
	}

	public JLabel getLbCodigo() {
		return lbCodigo;
	}

	public void setLbCodigo(JLabel lbCodigo) {
		this.lbCodigo = lbCodigo;
	}

	public JLabel getLbDescricao() {
		return lbDescricao;
	}

	public void setLbDescricao(JLabel lbDescricao) {
		this.lbDescricao = lbDescricao;
	}

	public JLabel getLbFabricante() {
		return lbFabricante;
	}

	public void setLbFabricante(JLabel lbFabricante) {
		this.lbFabricante = lbFabricante;
	}

	public JLabel getLbObsAdcMedicamento() {
		return lbObsAdcMedicamento;
	}

	public void setLbObsAdcMedicamento(JLabel lbObsAdcMedicamento) {
		this.lbObsAdcMedicamento = lbObsAdcMedicamento;
	}

	public JLabel getLbBula() {
		return lbBula;
	}

	public void setLbBula(JLabel lbBula) {
		this.lbBula = lbBula;
	}

	public JLabel getLbBulaExemplo() {
		return lbBulaExemplo;
	}

	public void setLbBulaExemplo(JLabel lbBulaExemplo) {
		this.lbBulaExemplo = lbBulaExemplo;
	}

	public JLabel getLbPrincipioAtivo() {
		return lbPrincipioAtivo;
	}

	public void setLbPrincipioAtivo(JLabel lbPrincipioAtivo) {
		this.lbPrincipioAtivo = lbPrincipioAtivo;
	}

	public JButton getBtnCadastrarMedicamento() {
		return btnCadastrarMedicamento;
	}

	public void setBtnCadastrarMedicamento(JButton btnCadastrarMedicamento) {
		this.btnCadastrarMedicamento = btnCadastrarMedicamento;
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
}
