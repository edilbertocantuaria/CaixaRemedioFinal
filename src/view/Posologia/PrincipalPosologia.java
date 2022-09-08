package view.Posologia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.PosologiaController;

public class PrincipalPosologia extends JFrame implements ActionListener {

	private static JFrame PrincipalPosologia = new JFrame("Posologia - Caixa de Remédios");

	private final JPanel panelPosologias;
	private final JLabel lbPosologias;

	private final JButton btnCadastrarPosologia;
	private final JButton btnEditarPosologia;
	private JButton btnListarPosologia;
	private final JButton btnBuscarPosologia;
	private final JButton btnExcluirPosologia;
	private final JButton btnVoltar;

	private final PosologiaController controller;

	public PrincipalPosologia() {
		setResizable(false);
		setTitle("Caixa de remédio - T8.1M");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 275, 316);
		getContentPane().setLayout(null);

		// PosologiaS
		panelPosologias = new JPanel();
		panelPosologias.setBounds(20, 95, 229, 170);
		getContentPane().add(panelPosologias);
		panelPosologias.setLayout(null);

		lbPosologias = new JLabel("Posologias");
		lbPosologias.setFont(new Font("Arial", Font.BOLD, 15));
		lbPosologias.setHorizontalAlignment(SwingConstants.CENTER);
		lbPosologias.setBounds(20, 45, 229, 39);
		getContentPane().add(lbPosologias);

		btnCadastrarPosologia = new JButton("Cadastrar Posologia");
		btnCadastrarPosologia.setBounds(10, 9, 205, 23);
		panelPosologias.add(btnCadastrarPosologia);

		btnEditarPosologia = new JButton("Editar Posologias");
		btnEditarPosologia.setBounds(10, 41, 205, 23);
		panelPosologias.add(btnEditarPosologia);

		btnListarPosologia = new JButton("Listar Posologias");
		btnListarPosologia.setBounds(10, 73, 205, 23);
		panelPosologias.add(btnListarPosologia);

		btnBuscarPosologia = new JButton("Buscar Posologia");
		btnBuscarPosologia.setBounds(10, 105, 205, 23);
		panelPosologias.add(btnBuscarPosologia);

		btnExcluirPosologia = new JButton("Excluir Posologia");
		btnExcluirPosologia.setBounds(10, 137, 205, 23);
		panelPosologias.add(btnExcluirPosologia);

		btnVoltar = new JButton("Voltar para o menu inicial");
		btnVoltar.setBounds(20, 11, 229, 23);
		getContentPane().add(btnVoltar);

		btnCadastrarPosologia.addActionListener(this);
		btnEditarPosologia.addActionListener(this);
		btnListarPosologia.addActionListener(this);
		btnBuscarPosologia.addActionListener(this);
		btnExcluirPosologia.addActionListener(this);
		btnVoltar.addActionListener(this);

		this.controller = new PosologiaController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		controller.executarBotao(e.getSource());
	}

	public static JFrame getPrincipalPosologia() {
		return PrincipalPosologia;
	}

	public static void setPrincipalPosologia(JFrame principalPosologia) {
		PrincipalPosologia = principalPosologia;
	}

	public JPanel getPanelPosologias() {
		return panelPosologias;
	}

	public JLabel getLbPosologias() {
		return lbPosologias;
	}

	public JButton getBtnCadastrarPosologia() {
		return btnCadastrarPosologia;
	}

	public JButton getBtnEditarPosologia() {
		return btnEditarPosologia;
	}

	public JButton getBtnListarPosologia() {
		return btnListarPosologia;
	}

	public JButton getBtnBuscarPosologia() {
		return btnBuscarPosologia;
	}

	public JButton getBtnExcluirPosologia() {
		return btnExcluirPosologia;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public PosologiaController getController() {
		return controller;
	}
}
