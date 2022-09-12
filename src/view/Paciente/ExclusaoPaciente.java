package view.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import controller.Paciente.ExclusaoPacienteController;

/**
 * É a tela para a exclusão dos pacientes. Ela recebe o nome do paciente, envia
 * para o controller.Paciente.EdicaoPacienteController e, se cadastrado no
 * ArrayList, permite a remoção.
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class ExclusaoPaciente implements ActionListener {
	private static JFrame frame = new JFrame("Excluir Paciente");
	private JLabel lbCPF;
	public JFormattedTextField jftCPFBusca;
	public JButton btnApagarPaciente;
	public JButton btnVoltar;

	private ExclusaoPacienteController controller;

	/**
	 * Define as dimensões físicas da view.Paciente.EdicaoPaciente
	 * 
	 */
	public ExclusaoPaciente() {
		frame.setSize(400, 280);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na
	 * view.Paciente.EdicaoPaciente EdicaoPaciente
	 * 
	 */

	private void placeComponents(JPanel panel) {
		setController(new ExclusaoPacienteController(this));
		panel.setLayout(null);

		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		lbCPF = new JLabel("Digite o CPF ");
		lbCPF.setBounds(20, 10, 80, 25);
		panel.add(lbCPF);

		jftCPFBusca = new JFormattedTextField(mascaraCPF);
		jftCPFBusca.setBounds(110, 10, 100, 25);
		panel.add(jftCPFBusca);

		btnApagarPaciente = new JButton("Excluir Paciente");
		btnApagarPaciente.setBounds(10, 50, 146, 25);
		btnApagarPaciente.addActionListener(this);
		panel.add(btnApagarPaciente);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 175, 23);
		btnVoltar.addActionListener(this);
		panel.add(btnVoltar);

		// Invoca o controller, que neste caso, é EdicaoPacienteController, apontando
		// que a ação está descrita nesta parte do código
		this.controller = new ExclusaoPacienteController(this);
	}

	/**
	 * Está recebendo, o evento dos botões que estão na view.Paciente.EdicaoPaciente
	 * e invoca o controller controller.Paciente.EdicaoPaciente para saber qual deve
	 * ser a ação executada
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JLabel getLbCPF() {
		return lbCPF;
	}

	public JFormattedTextField getJftCPFBusca() {
		return jftCPFBusca;
	}

	public JButton getBtnApagarPaciente() {
		return btnApagarPaciente;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public ExclusaoPacienteController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		ExclusaoPaciente.frame = frame;
	}

	public void setLbCPF(JLabel lbCPF) {
		this.lbCPF = lbCPF;
	}

	public void setJftCPFBusca(JFormattedTextField jftCPFBusca) {
		this.jftCPFBusca = jftCPFBusca;
	}

	public void setBtnApagarPaciente(JButton btnApagarPaciente) {
		this.btnApagarPaciente = btnApagarPaciente;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	private void setController(ExclusaoPacienteController exclusaoPacienteController) {
	}
}
