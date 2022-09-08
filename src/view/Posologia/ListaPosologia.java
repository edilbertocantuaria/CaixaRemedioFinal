package view.Posologia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaPosologia {

	private static JFrame frame = new JFrame("Lista de posologias");
	private JPanel panel;
	private JButton btnVoltar;
	private JLabel lbSemPosologia = new JLabel("Ainda não há posologias cadastradas =(");
	private JScrollPane scrollPane;
	private DefaultTableModel tabelaPosologia;
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
