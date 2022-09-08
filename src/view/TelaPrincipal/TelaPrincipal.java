package view.TelaPrincipal;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.TelaPrincipalController;

public class TelaPrincipal extends JFrame implements ActionListener {

	private static JButton btnPaciente;
	private final JButton btnMedicamento;
	private final JButton btnPosologia;
	private final JLabel lbCaixaRemedios;
	private final JLabel lbAlunoEdilberto;
	private final JLabel lbAlunoCaetano;

	private final TelaPrincipalController controller;
	private JButton btnRotina;

	public TelaPrincipal() {
		setResizable(false);
		setTitle("Caixa de remédio - T8.1M");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 445, 390);
		getContentPane().setLayout(null);

		// NOVA TELA PRINCIPAL
		btnPaciente = new JButton("Paciente");
		btnPaciente.setFont(new Font("Arial", Font.BOLD, 12));
		btnPaciente.setBounds(129, 130, 170, 46);
		getContentPane().add(btnPaciente);

		btnMedicamento = new JButton("Medicamento");
		btnMedicamento.setFont(new Font("Arial", Font.BOLD, 12));
		btnMedicamento.setBounds(129, 184, 170, 46);
		getContentPane().add(btnMedicamento);

		btnPosologia = new JButton("Posologia");
		btnPosologia.setFont(new Font("Arial", Font.BOLD, 12));
		btnPosologia.setBounds(129, 238, 170, 46);
		getContentPane().add(btnPosologia);

		lbCaixaRemedios = new JLabel("Caixa de Remédios - T8.1M");
		lbCaixaRemedios.setHorizontalAlignment(SwingConstants.CENTER);
		lbCaixaRemedios.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lbCaixaRemedios.setBounds(10, 8, 409, 46);
		getContentPane().add(lbCaixaRemedios);

		lbAlunoEdilberto = new JLabel("Edilberto Almeida Cantuaria - 16/0085501");
		lbAlunoEdilberto.setHorizontalAlignment(SwingConstants.CENTER);
		lbAlunoEdilberto.setFont(new Font("Arial", Font.PLAIN, 12));
		lbAlunoEdilberto.setBounds(71, 96, 286, 26);
		getContentPane().add(lbAlunoEdilberto);

		lbAlunoCaetano = new JLabel(" Caetano Santos Lúcio - 18/0144979");
		lbAlunoCaetano.setHorizontalAlignment(SwingConstants.CENTER);
		lbAlunoCaetano.setFont(new Font("Arial", Font.PLAIN, 12));
		lbAlunoCaetano.setBounds(71, 62, 286, 26);
		getContentPane().add(lbAlunoCaetano);

		btnRotina = new JButton("Rotina - Pacientes & Medicamentos");
		btnRotina.setFont(new Font("Arial", Font.BOLD, 12));
		btnRotina.setBounds(100, 292, 228, 46);
		getContentPane().add(btnRotina);

		btnPaciente.addActionListener(this);
		btnMedicamento.addActionListener(this);
		btnPosologia.addActionListener(this);
		btnRotina.addActionListener(this);

		this.controller = new TelaPrincipalController(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());

	}

	public static JButton getBtnPaciente() {
		return btnPaciente;
	}

	public static void setBtnPaciente(JButton btnPaciente) {
		TelaPrincipal.btnPaciente = btnPaciente;
	}

	public JButton getBtnMedicamento() {
		return btnMedicamento;
	}

	public JButton getBtnPosologia() {
		return btnPosologia;
	}

	public JLabel getLbCaixaRemedios() {
		return lbCaixaRemedios;
	}

	public JLabel getLbAlunoEdilberto() {
		return lbAlunoEdilberto;
	}

	public JLabel getLbAlunoCaetano() {
		return lbAlunoCaetano;
	}

	public TelaPrincipalController getController() {
		return controller;
	}

	public JButton getBtnRotina() {
		return btnRotina;
	}

	public void setBtnRotina(JButton btnRotina) {
		this.btnRotina = btnRotina;
	}

}