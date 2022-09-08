package view.Paciente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.PacienteController;
import model.Paciente;

public class ListaPaciente {
	private static JFrame frame = new JFrame("Lista de pacientes");
	private JLabel lbSemMedicamento = new JLabel("Ainda não há pacientes cadastrados =(");
	private JButton btnVoltar;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable jtPaciente;
	private DefaultTableModel tabelaPaciente;

	public ListaPaciente() {
		frame.setSize(577, 280);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponentes(panel);

		frame.setVisible(true);

	}

	private void placeComponentes(JPanel panel) {
		if (PacienteController.pacientes.isEmpty()) {
			lbSemMedicamento.setFont(new Font("Arial", Font.BOLD, 15));
			lbSemMedicamento.setHorizontalAlignment(SwingConstants.CENTER);
			lbSemMedicamento.setBounds(10, 66, 541, 61);
			panel.add(lbSemMedicamento);
		} else {

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 29, 541, 134);
			panel.add(scrollPane);

			jtPaciente = new JTable();
			jtPaciente.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Paciente", "CPF", "Observação Adicional" }));
			scrollPane.setViewportView(jtPaciente);

			tabelaPaciente = (DefaultTableModel) jtPaciente.getModel();

			// criando a tabela de pacientes inicial
			for (int i = 0; i < PacienteController.pacientes.size(); i++) {

				Paciente paciente = PacienteController.pacientes.get(i);

				tabelaPaciente.addRow(new String[] { paciente.getNome(), paciente.getCpf(),
						paciente.getObservacaoAdicionalPessoa() });

			}

		}

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 190, 23);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object botaoApertado = e.getSource();

				if (botaoApertado == btnVoltar) {
					PrincipalPaciente obj = new PrincipalPaciente();
					obj.setVisible(true);
					frame.dispose();

				}
			}
		});
		panel.setLayout(null);
		panel.add(btnVoltar);

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
