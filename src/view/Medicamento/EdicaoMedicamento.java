package view.Medicamento;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MedicamentoController;
import controller.PacienteController;
import model.Medicamento;

public class EdicaoMedicamento {
	private static JFrame frame = new JFrame("Editar Paciente");
	private JButton btnEditarMedicamento_edicao;
	private JButton btnVoltar;
	private JComboBox<String> cbEscolhaPaciente;

	private MedicamentoController controller;
	private JButton btnAtualizarCadastroMedicamento;

	private JTextField tfNomeMedicamento;
	private JTextField tfCodigo;
	private JTextField tfDescricao;
	private JTextField tfFabricante;
	private JTextField tfBula;
	private JTextField tfPrincipioAtivo;
	private JTextField tfObsAdcMedicamento;
	private JLabel lbObsAdcMedicamento;
	private JLabel lbPrincipioAtivo;
	private JLabel lbFabricante;
	private JLabel lbBula;
	private JLabel lbBulaExemplo;
	private JLabel lbDescricao;
	private JLabel lbCodigo;
	private JLabel lbNomeMedicamentoInfo;
	private JLabel lbNomeMedicamento;
	private TextField tfMedicamentoEdicao;
	private JLabel lbInstrucaoInfo;
	private JLabel lbInstrucao;
	private JPanel panel;

	public EdicaoMedicamento() {
		frame.setSize(700, 480);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		lbInstrucao = new JLabel("Digite o nome do medicamento: ");
		lbInstrucao.setBounds(10, 6, 200, 25);
		panel.add(lbInstrucao);

		lbInstrucaoInfo = new JLabel("(tudo maiúsculo)");
		lbInstrucaoInfo.setBounds(10, 19, 200, 25);
		panel.add(lbInstrucaoInfo);

		tfMedicamentoEdicao = new TextField();
		tfMedicamentoEdicao.setBounds(486, 6, 188, 25);
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
		tfNomeMedicamento.setBounds(374, 84, 300, 20);
		panel.add(tfNomeMedicamento);

		lbCodigo = new JLabel("Codigo de barras:");
		lbCodigo.setBounds(10, 133, 251, 14);
		panel.add(lbCodigo);

		tfCodigo = new JTextField();
		tfCodigo.setEnabled(false);
		tfCodigo.setEditable(false);
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(374, 130, 300, 20);
		panel.add(tfCodigo);

		lbDescricao = new JLabel("Descrição do medicamento:");
		lbDescricao.setBounds(10, 179, 259, 14);
		panel.add(lbDescricao);

		tfDescricao = new JTextField();
		tfDescricao.setEnabled(false);
		tfDescricao.setEditable(false);
		tfDescricao.setColumns(10);
		tfDescricao.setBounds(374, 176, 300, 20);
		panel.add(tfDescricao);

		lbFabricante = new JLabel("Fabricante:");
		lbFabricante.setBounds(10, 225, 342, 14);
		panel.add(lbFabricante);

		tfFabricante = new JTextField();
		tfFabricante.setEnabled(false);
		tfFabricante.setEditable(false);
		tfFabricante.setColumns(10);
		tfFabricante.setBounds(374, 222, 300, 20);
		panel.add(tfFabricante);

		lbBula = new JLabel("Bula:");
		lbBula.setBounds(10, 271, 66, 14);
		panel.add(lbBula);

		lbBulaExemplo = new JLabel("(Pode inserir um link que redireciona para a bula da medicação)");
		lbBulaExemplo.setBounds(10, 284, 342, 14);
		panel.add(lbBulaExemplo);

		tfBula = new JTextField();
		tfBula.setEnabled(false);
		tfBula.setEditable(false);
		tfBula.setColumns(10);
		tfBula.setBounds(374, 268, 300, 20);
		panel.add(tfBula);

		lbPrincipioAtivo = new JLabel("Princípio ativo do medicamento:");
		lbPrincipioAtivo.setBounds(10, 317, 330, 14);
		panel.add(lbPrincipioAtivo);

		tfPrincipioAtivo = new JTextField();
		tfPrincipioAtivo.setEnabled(false);
		tfPrincipioAtivo.setEditable(false);
		tfPrincipioAtivo.setColumns(10);
		tfPrincipioAtivo.setBounds(374, 314, 300, 20);
		panel.add(tfPrincipioAtivo);

		lbObsAdcMedicamento = new JLabel("Observações adicionais");
		lbObsAdcMedicamento.setBounds(10, 363, 300, 14);
		panel.add(lbObsAdcMedicamento);

		tfObsAdcMedicamento = new JTextField();
		tfObsAdcMedicamento.setEnabled(false);
		tfObsAdcMedicamento.setEditable(false);
		tfObsAdcMedicamento.setColumns(10);
		tfObsAdcMedicamento.setBounds(374, 360, 300, 20);
		panel.add(tfObsAdcMedicamento);

		btnAtualizarCadastroMedicamento = new JButton("Atualizar cadastro");
		btnAtualizarCadastroMedicamento.setEnabled(false);
		btnAtualizarCadastroMedicamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizaMedicamento();
			}

			public void atualizaMedicamento() {
				try {

					tfMedicamentoEdicao.requestFocus();

					String nomeMedicacao = tfMedicamentoEdicao.getText();

					MedicamentoController medicamentoController = new MedicamentoController();
					Medicamento medicamento = medicamentoController.buscarMedicamentos(nomeMedicacao);

					// Para inserir as informações de um medicamento na lista (igual a do cadastro)

					// Cadastra as informações de um medicamento na lista
					String nomeRemedio = getTfNomeMedicamento().getText().trim();
					String codigo = getTfCodigo().getText().trim();
					String descricao = getTfDescricao().getText().trim();
					String fabricante = getTfFabricante().getText().trim();
					String bula = getTfBula().getText().trim();
					String principioAtivo = getTfPrincipioAtivo().getText().trim();
					String observacaoAdicionalMedicamento = getTfObsAdcMedicamento().getText().trim();

					// Atualiza os dados do medicamento
					medicamento.setNomeRemedio(nomeRemedio);
					medicamento.setCodigo(codigo);
					medicamento.setDescricao(descricao);
					medicamento.setFabricante(fabricante);
					medicamento.setBula(bula);
					medicamento.setPrincipioAtivo(principioAtivo);
					medicamento.setObservacaoAdicionalMedicamento(observacaoAdicionalMedicamento);

					if (getTfNomeMedicamento().getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Não foi possível realizar atualizar o cadastro: o nome do medicamento não pode estar vazio!");
					} else {

						System.out.println(PacienteController.pacientes.toString());
						JOptionPane.showMessageDialog(null, "Atualização efetivada!");
					}

					// limpando os campos dos jtextfield's
					tfMedicamentoEdicao.setText("");
					tfNomeMedicamento.setText("");
					tfCodigo.setText("");
					tfDescricao.setText("");
					tfFabricante.setText("");
					tfBula.setText("");
					tfPrincipioAtivo.setText("");
					tfObsAdcMedicamento.setText("");

					// desabilitando a edição/inserção de texto nos jtextfield's
					tfNomeMedicamento.setEnabled(false);
					tfNomeMedicamento.setEditable(false);
					tfCodigo.setEnabled(false);
					tfCodigo.setEditable(false);
					tfDescricao.setEnabled(false);
					tfDescricao.setEditable(false);
					tfFabricante.setEnabled(false);
					tfFabricante.setEditable(false);
					tfBula.setEnabled(false);
					tfBula.setEditable(false);
					tfPrincipioAtivo.setEnabled(false);
					tfPrincipioAtivo.setEditable(false);
					tfObsAdcMedicamento.setEnabled(false);
					tfObsAdcMedicamento.setEditable(false);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Nome inválido!");
				}
			}

		});

		btnAtualizarCadastroMedicamento.setBounds(499, 407, 175, 23);
		panel.add(btnAtualizarCadastroMedicamento);

		btnEditarMedicamento_edicao = new JButton("Editar Medicamento");
		btnEditarMedicamento_edicao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfMedicamentoEdicao.requestFocus();

				String nomeMedicacao = tfMedicamentoEdicao.getText();

				MedicamentoController medicamentoController = new MedicamentoController();
				Medicamento resultado = medicamentoController.buscarMedicamentos(nomeMedicacao);

				btnAtualizarCadastroMedicamento.setEnabled(true);

				tfNomeMedicamento.setText(resultado.getNomeRemedio());
				tfNomeMedicamento.setEnabled(true);
				tfNomeMedicamento.setEditable(true);

				tfCodigo.setText(resultado.getCodigo());
				tfCodigo.setEnabled(true);
				tfCodigo.setEditable(true);

				tfDescricao.setText(resultado.getDescricao());
				tfDescricao.setEnabled(true);
				tfDescricao.setEditable(true);

				tfFabricante.setText(resultado.getFabricante());
				tfFabricante.setEnabled(true);
				tfFabricante.setEditable(true);

				tfBula.setText(resultado.getBula());
				tfBula.setEnabled(true);
				tfBula.setEditable(true);

				tfPrincipioAtivo.setText(resultado.getPrincipioAtivo());
				tfPrincipioAtivo.setEnabled(true);
				tfPrincipioAtivo.setEditable(true);

				tfObsAdcMedicamento.setText(resultado.getObservacaoAdicionalMedicamento());
				tfObsAdcMedicamento.setEnabled(true);
				tfObsAdcMedicamento.setEditable(true);

			}
		});
		btnEditarMedicamento_edicao.setBounds(10, 50, 175, 25);
		panel.add(btnEditarMedicamento_edicao);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 407, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object botaoApertado = e.getSource();

				if (botaoApertado == btnVoltar) {
					tfMedicamentoEdicao.setText("");
					PrincipalMedicamento obj = new PrincipalMedicamento();
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
		EdicaoMedicamento.frame = frame;
	}

	public JButton getBtnEditarMedicamento_edicao() {
		return btnEditarMedicamento_edicao;
	}

	public void setBtnEditarMedicamento_edicao(JButton btnEditarMedicamento_edicao) {
		this.btnEditarMedicamento_edicao = btnEditarMedicamento_edicao;
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

	public MedicamentoController getController() {
		return controller;
	}

	public void setController(MedicamentoController controller) {
		this.controller = controller;
	}

	public JButton getBtnAtualizarCadastroMedicamento() {
		return btnAtualizarCadastroMedicamento;
	}

	public void setBtnAtualizarCadastroMedicamento(JButton btnAtualizarCadastroMedicamento) {
		this.btnAtualizarCadastroMedicamento = btnAtualizarCadastroMedicamento;
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

	public JTextField getTfObsAdcMedicamento() {
		return tfObsAdcMedicamento;
	}

	public void setTfObsAdcMedicamento(JTextField tfObsAdcMedicamento) {
		this.tfObsAdcMedicamento = tfObsAdcMedicamento;
	}

	public JLabel getLbObsAdcMedicamento() {
		return lbObsAdcMedicamento;
	}

	public void setLbObsAdcMedicamento(JLabel lbObsAdcMedicamento) {
		this.lbObsAdcMedicamento = lbObsAdcMedicamento;
	}

	public JLabel getLbPrincipioAtivo() {
		return lbPrincipioAtivo;
	}

	public void setLbPrincipioAtivo(JLabel lbPrincipioAtivo) {
		this.lbPrincipioAtivo = lbPrincipioAtivo;
	}

	public JLabel getLbFabricante() {
		return lbFabricante;
	}

	public void setLbFabricante(JLabel lbFabricante) {
		this.lbFabricante = lbFabricante;
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

	public JLabel getLbDescricao() {
		return lbDescricao;
	}

	public void setLbDescricao(JLabel lbDescricao) {
		this.lbDescricao = lbDescricao;
	}

	public JLabel getLbCodigo() {
		return lbCodigo;
	}

	public void setLbCodigo(JLabel lbCodigo) {
		this.lbCodigo = lbCodigo;
	}

	public JLabel getLbNomeMedicamentoInfo() {
		return lbNomeMedicamentoInfo;
	}

	public void setLbNomeMedicamentoInfo(JLabel lbNomeMedicamentoInfo) {
		this.lbNomeMedicamentoInfo = lbNomeMedicamentoInfo;
	}

	public JLabel getLbNomeMedicamento() {
		return lbNomeMedicamento;
	}

	public void setLbNomeMedicamento(JLabel lbNomeMedicamento) {
		this.lbNomeMedicamento = lbNomeMedicamento;
	}

	public TextField getTfMedicamentoEdicao() {
		return tfMedicamentoEdicao;
	}

	public void setTfMedicamentoEdicao(TextField tfMedicamentoEdicao) {
		this.tfMedicamentoEdicao = tfMedicamentoEdicao;
	}

	public JLabel getLbInstrucaoInfo() {
		return lbInstrucaoInfo;
	}

	public void setLbInstrucaoInfo(JLabel lbInstrucaoInfo) {
		this.lbInstrucaoInfo = lbInstrucaoInfo;
	}

	public JLabel getLbInstrucao() {
		return lbInstrucao;
	}

	public void setLbInstrucao(JLabel lbInstrucao) {
		this.lbInstrucao = lbInstrucao;
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
