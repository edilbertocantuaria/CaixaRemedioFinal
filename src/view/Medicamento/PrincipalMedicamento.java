package view.Medicamento;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Medicamento.MedicamentoController;

/**
 * É a tela principal dos medicamentos, onde contém os botões que concedem
 * acesso ao cadastro, edição, listagem, busca, exclusão e retorno para a tela
 * anterior.
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class PrincipalMedicamento extends JFrame implements ActionListener {

	private static JFrame PrincipalMedicamento = new JFrame("Medicamento - Caixa de Remédios");

	private final JPanel panelMedicamentos;
	private final JLabel lbMedicamentos;

	private final JButton btnCadastrarMedicamento;
	private final JButton btnEditarMedicamento;
	private final JButton btnListarMedicamento;
	private final JButton btnBuscarMedicamento;
	private final JButton btnExcluirMedicamento;
	private final JButton btnVoltar;

	private final MedicamentoController controller;

	/**
	 * Defineas as dimensões físicas da view.Medicamento.PrincipalMedicamento as
	 * posições e nomes dos componetes gráficos que estão na referida view
	 */

	public PrincipalMedicamento() {
		setResizable(false);
		setTitle("Caixa de remédio - T8.1M");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 275, 316);
		getContentPane().setLayout(null);

		panelMedicamentos = new JPanel();
		panelMedicamentos.setBounds(20, 95, 229, 170);
		getContentPane().add(panelMedicamentos);
		panelMedicamentos.setLayout(null);

		lbMedicamentos = new JLabel("Medicamentos");
		lbMedicamentos.setFont(new Font("Arial", Font.BOLD, 15));
		lbMedicamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lbMedicamentos.setBounds(20, 45, 229, 39);
		getContentPane().add(lbMedicamentos);

		btnCadastrarMedicamento = new JButton("Cadastrar Medicamento");
		btnCadastrarMedicamento.setBounds(10, 9, 205, 23);
		panelMedicamentos.add(btnCadastrarMedicamento);

		btnEditarMedicamento = new JButton("Editar Medicamentos");
		btnEditarMedicamento.setBounds(10, 41, 205, 23);
		btnEditarMedicamento.addActionListener(this);
		panelMedicamentos.add(btnEditarMedicamento);

		btnListarMedicamento = new JButton("Listar Medicamentos");
		btnListarMedicamento.setBounds(10, 73, 205, 23);
		btnListarMedicamento.addActionListener(this);
		panelMedicamentos.add(btnListarMedicamento);

		btnBuscarMedicamento = new JButton("Buscar Medicamento");
		btnBuscarMedicamento.setBounds(10, 105, 205, 23);
		panelMedicamentos.add(btnBuscarMedicamento);

		btnExcluirMedicamento = new JButton("Excluir Medicamento");
		btnExcluirMedicamento.setBounds(10, 137, 205, 23);
		panelMedicamentos.add(btnExcluirMedicamento);
		panelMedicamentos.add(btnCadastrarMedicamento);

		btnVoltar = new JButton("Voltar para o menu inicial");
		btnVoltar.setBounds(20, 11, 229, 23);
		getContentPane().add(btnVoltar);

		// Diz qual ação o botão deve executar ao ser pressionado
		btnCadastrarMedicamento.addActionListener(this);
		btnEditarMedicamento.addActionListener(this);
		btnListarMedicamento.addActionListener(this);
		btnBuscarMedicamento.addActionListener(this);
		btnExcluirMedicamento.addActionListener(this);
		btnVoltar.addActionListener(this);

		// Invoca o controller, que neste caso, é MedicamentoController, apontando
		// que a ação está descrita nesta parte do código
		this.controller = new MedicamentoController(this);

	}

	/**
	 * Está recebendo, o evento dos botões que estão na
	 * view.Medicamento.PrincipalMedicamento e invoca o controller
	 * controller.Medicamento.MedicamentoController para saber qual deve ser a ação
	 * executada
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public static JFrame getPrincipalMedicamento() {
		return PrincipalMedicamento;
	}

	public static void setPrincipalMedicamento(JFrame principalMedicamento) {
		PrincipalMedicamento = principalMedicamento;
	}

	public JPanel getPanelMedicamentos() {
		return panelMedicamentos;
	}

	public JLabel getLbMedicamentos() {
		return lbMedicamentos;
	}

	public JButton getBtnCadastrarMedicamento() {
		return btnCadastrarMedicamento;
	}

	public JButton getBtnEditarMedicamento() {
		return btnEditarMedicamento;
	}

	public JButton getBtnListarMedicamento() {
		return btnListarMedicamento;
	}

	public JButton getBtnBuscarMedicamento() {
		return btnBuscarMedicamento;
	}

	public JButton getBtnExcluirMedicamento() {
		return btnExcluirMedicamento;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public MedicamentoController getController() {
		return controller;
	}

}
