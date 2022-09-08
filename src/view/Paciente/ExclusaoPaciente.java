package view.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import controller.PacienteController;

public class ExclusaoPaciente {
	private static JFrame frame = new JFrame("Excluir Paciente");
	private JLabel instrucao;
	private JFormattedTextField jftCPFBusca;
	private JButton btnApagarPaciente;
	private JButton btnVoltar;

	public ExclusaoPaciente() {
		frame.setSize(400, 280);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException erro1) {

			System.err.println("Erro na formatação!" + erro1.getMessage());
			erro1.printStackTrace();
		}

		instrucao = new JLabel("Digite o CPF ");
		instrucao.setBounds(20, 10, 80, 25);
		panel.add(instrucao);

		jftCPFBusca = new JFormattedTextField(mascaraCPF);
		jftCPFBusca.setBounds(110, 10, 100, 25);
		panel.add(jftCPFBusca);

		btnApagarPaciente = new JButton("Excluir Paciente");
		btnApagarPaciente.setBounds(10, 50, 146, 25);
		panel.add(btnApagarPaciente);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object botaoApertado = e.getSource();

				if (botaoApertado == btnVoltar) {
					jftCPFBusca.setText("");// limpando os campos dos jtextfield's
					PrincipalPaciente obj = new PrincipalPaciente();
					obj.setVisible(true);
					frame.dispose();

				}
			}
		});

		btnApagarPaciente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String cpf = jftCPFBusca.getText();

					PacienteController pacienteController = new PacienteController();
					pacienteController.excluirPacientes(cpf);

					System.out.println(PacienteController.pacientes.toString());
					JOptionPane.showMessageDialog(null, "Paciente excluido!");

					// deixa o cursor dentro desse jtextfield's
					jftCPFBusca.requestFocus();

					// limpando os campos dos jtextfield's
					jftCPFBusca.setText("");

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "CPF inválido!");
				}
			}
		});

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
