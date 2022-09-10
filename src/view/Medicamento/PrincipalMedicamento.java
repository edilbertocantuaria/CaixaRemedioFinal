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

	/*
	 * Invoca a classe controller para a referida tela, que, neste caso, é
	 * controller.MedicamentoController
	 */
	private final MedicamentoController controller;

	// Define os elementos gráficos da tela PrincipalMedicamento
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

		/**
		 * Invoca a classe controller.MedicamentoController para executar o comando. É
		 * como se dissesse "O comando que você quer está descrito em no lugar tal!".
		 * 
		 * @version 09 set 22.
		 */
		this.controller = new MedicamentoController(this);

	}

	/**
	 * Sobrescrita. É um comando que diz "Identifiquei a ação que você executou, e
	 * ela está descrita em tal lugar" Esse "tal lugar" é a classe
	 * controller.MedicamentoController, que vai procurar pelo método executarBotao,
	 * que terá como parâmetro o evento ocorrido.
	 * 
	 * @version 09 set 22.
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
