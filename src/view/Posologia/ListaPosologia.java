package view.Posologia;

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

import controller.PosologiaController;
import model.Posologia;

public class ListaPosologia {

	private static JFrame frame = new JFrame("Lista de posologias");
	private JPanel panel;
	private JButton btnVoltar;
	private JLabel lbSemPosologia = new JLabel("Ainda não há posologias cadastradas =(");
	private DefaultTableModel tabelaPosologia;
	private JScrollPane scrollPane;
	private JTable jtListaRotinaPacienteMedicamento;

	public ListaPosologia() {
		frame.setSize(910, 470);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponentes(panel);
		panel.setLayout(null);

		frame.setVisible(true);

	}

	private void placeComponentes(JPanel panel) {
		if (PosologiaController.posologias.isEmpty()) {
			lbSemPosologia.setFont(new Font("Arial", Font.BOLD, 15));
			lbSemPosologia.setHorizontalAlignment(SwingConstants.CENTER);
			lbSemPosologia.setBounds(10, 66, 541, 61);
			panel.add(lbSemPosologia);
		} else {

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 874, 318);
			panel.add(scrollPane);

			jtListaRotinaPacienteMedicamento = new JTable();
			jtListaRotinaPacienteMedicamento.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Nome", "Medicamento", "Dosagem", "Horário 01", "Horário 02", "Horário 03",
							"Horário 04", "Horário 05", "Horário 06", "Data início", "Data término" }));
			scrollPane.setViewportView(jtListaRotinaPacienteMedicamento);

			// criando a tabela de posologia inicial
			for (int i = 0; i < PosologiaController.posologias.size(); i++) {

				Posologia posologia = PosologiaController.posologias.get(i);

				tabelaPosologia = (DefaultTableModel) jtListaRotinaPacienteMedicamento.getModel();

				tabelaPosologia.addRow(new String[] { posologia.getNomePaciente(), posologia.getNomeMedicamento(),
						Float.toString(posologia.getDosagem()), posologia.getHorario1(), posologia.getHorario2(),
						posologia.getHorario3(), posologia.getHorario4(), posologia.getHorario5(),
						posologia.getHorario6(), posologia.getDataInicioTratamento(),
						posologia.getDataFimTratamento() });
			}
		}

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 397, 210, 23);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object botaoApertado = e.getSource();

				if (botaoApertado == btnVoltar) {
					PrincipalPosologia obj = new PrincipalPosologia();
					obj.setVisible(true);
					frame.dispose();

				}
			}
		});
		panel.add(btnVoltar);

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
