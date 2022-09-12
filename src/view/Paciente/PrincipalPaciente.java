package view.Paciente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Paciente.PacienteController;

/**
 * É a tela principal dos pacientes, onde contém os botões que concedem acesso
 * ao cadastro, edição, listagem, busca, exclusão e retorno para a tela
 * anterior.
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class PrincipalPaciente extends JFrame implements ActionListener {

	private static JFrame PrincipalPaciente = new JFrame("Paciente - Caixa de Remédios");

	private final JPanel panelPacientes;
	private final JLabel lbPacientes;

	private final JButton btnCadastrarPaciente;
	private final JButton btnEditarPaciente;
	private final JButton btnListarPaciente;
	private final JButton btnBuscarPaciente;
	private final JButton btnExcluirPaciente;
	private final JButton btnVoltar;

	private final PacienteController controller;

	/**
	 * Defineas as dimensões físicas da view.Paciente.PrincipalPaciente as posições
	 * e nomes dos componetes gráficos que estão na referida view
	 */
	public PrincipalPaciente() {
		setResizable(false);
		setTitle("Caixa de remédio - T8.1M");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 275, 316);
		getContentPane().setLayout(null);

		panelPacientes = new JPanel();
		panelPacientes.setBounds(20, 95, 229, 170);
		getContentPane().add(panelPacientes);
		panelPacientes.setLayout(null);

		lbPacientes = new JLabel("Pacientes");
		lbPacientes.setFont(new Font("Arial", Font.BOLD, 15));
		lbPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lbPacientes.setBounds(20, 45, 229, 39);
		getContentPane().add(lbPacientes);

		btnCadastrarPaciente = new JButton("Cadastrar Paciente");
		btnCadastrarPaciente.setBounds(10, 9, 205, 23);
		panelPacientes.add(btnCadastrarPaciente);

		btnEditarPaciente = new JButton("Editar Pacientes");
		btnEditarPaciente.setBounds(10, 41, 205, 23);
		btnEditarPaciente.addActionListener(this);
		panelPacientes.add(btnEditarPaciente);

		btnListarPaciente = new JButton("Listar Pacientes");
		btnListarPaciente.setBounds(10, 73, 205, 23);
		btnListarPaciente.addActionListener(this);
		panelPacientes.add(btnListarPaciente);

		btnBuscarPaciente = new JButton("Buscar Paciente");
		btnBuscarPaciente.setBounds(10, 105, 205, 23);
		panelPacientes.add(btnBuscarPaciente);

		btnExcluirPaciente = new JButton("Excluir Paciente");
		btnExcluirPaciente.setBounds(10, 137, 205, 23);
		panelPacientes.add(btnExcluirPaciente);
		panelPacientes.add(btnCadastrarPaciente);

		btnVoltar = new JButton("Voltar para o menu inicial");
		btnVoltar.setBounds(20, 11, 229, 23);
		getContentPane().add(btnVoltar);

		btnCadastrarPaciente.addActionListener(this);
		btnEditarPaciente.addActionListener(this);
		btnListarPaciente.addActionListener(this);
		btnBuscarPaciente.addActionListener(this);
		btnExcluirPaciente.addActionListener(this);
		btnVoltar.addActionListener(this);

		// Invoca o controller, que neste caso, é PacienteController, apontando que
		// a ação está descrita nesta parte do código
		this.controller = new PacienteController(this);

	}

	/**
	 * Está recebendo, o evento dos botões que estão na
	 * view.Paciente.PrincipalPaciente e invoca o controller
	 * controller.Paciente.PacienteController para saber qual deve ser a ação
	 * executada
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public static JFrame getPrincipalPaciente() {
		return PrincipalPaciente;
	}

	public static void setPrincipalPaciente(JFrame principalPaciente) {
		PrincipalPaciente = principalPaciente;
	}

	public JPanel getPanelPacientes() {
		panelPacientes.revalidate();
		panelPacientes.repaint();
		return panelPacientes;
	}

	public JLabel getLbPacientes() {
		return lbPacientes;
	}

	public JButton getBtnCadastrarPaciente() {
		return btnCadastrarPaciente;
	}

	public JButton getBtnEditarPaciente() {
		return btnEditarPaciente;
	}

	public JButton getBtnListarPaciente() {
		return btnListarPaciente;
	}

	public JButton getBtnBuscarPaciente() {
		return btnBuscarPaciente;
	}

	public JButton getBtnExcluirPaciente() {
		return btnExcluirPaciente;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public PacienteController getController() {
		return controller;
	}

}