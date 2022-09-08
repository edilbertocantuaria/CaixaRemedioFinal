package view.Medicamento;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.MedicamentoController;

public class ExclusaoMedicamento {
	private static JFrame frame = new JFrame("Excluir Medicamento");
	private JLabel instrucao;
	private JLabel lbInstrucaoInfo;
	private TextField tfMedicamentoBusca;
	private JButton btnApagarMedicamento;
	private JButton btnVoltar;

	public ExclusaoMedicamento() {
		frame.setSize(446, 280);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		instrucao = new JLabel("Digite o nome do medicamento: ");
		instrucao.setBounds(10, 10, 200, 25);
		panel.add(instrucao);

		lbInstrucaoInfo = new JLabel("(tudo maiúsculo)");
		lbInstrucaoInfo.setBounds(10, 23, 200, 25);
		panel.add(lbInstrucaoInfo);

		tfMedicamentoBusca = new TextField();
		tfMedicamentoBusca.setBounds(227, 10, 193, 25);
		panel.add(tfMedicamentoBusca);

		btnApagarMedicamento = new JButton("Excluir Medicamento");
		btnApagarMedicamento.setBounds(10, 50, 175, 25);
		panel.add(btnApagarMedicamento);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 175, 23);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object botaoApertado = e.getSource();

				if (botaoApertado == btnVoltar) {
					PrincipalMedicamento obj = new PrincipalMedicamento();
					obj.setVisible(true);
					frame.dispose();

				}
			}
		});

		btnApagarMedicamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// limpando os campos dos jtextfield's
					tfMedicamentoBusca.requestFocus();

					String nomeMedicacao = tfMedicamentoBusca.getText();

					MedicamentoController medicamentoController = new MedicamentoController();
					medicamentoController.excluirMedicamentos(nomeMedicacao);

					JOptionPane.showMessageDialog(null, "Medicamento excluido!");

					// deixa o cursor dentro desse jtextfield's
					tfMedicamentoBusca.requestFocus();

					// limpando os campos dos jtextfield's
					tfMedicamentoBusca.setText("");

					System.out.println(MedicamentoController.medicamentos.toString());

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Medicamento inválido!");
				}
			}
		});

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
