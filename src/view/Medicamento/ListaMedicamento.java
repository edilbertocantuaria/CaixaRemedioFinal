package view.Medicamento;

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

import controller.MedicamentoController;
import model.Medicamento;

/**
 * É a tela para a listagem dos medicamentos. Ela busca exibir as informações de
 * todos medicamentos presentes no ArrayList medicamentos.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */
public class ListaMedicamento {
	private static JFrame frame = new JFrame("Lista de Medicamentos");
	private JLabel lbSemMedicamento = new JLabel("Ainda não há medicamentos cadastrados =(");
	private JButton btnVoltar;
	private JPanel panel;
	private JTable jtMedicacao;
	private JScrollPane scrollPane;
	private DefaultTableModel tabelaMedicacao;

	/**
	 * Define as dimensões físicas da tela ListaMedicamento
	 * 
	 * @version 09 set 22.
	 */

	public ListaMedicamento() {
		frame.setSize(577, 280);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponentes(panel);

		frame.setVisible(true);

	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		ListaMedicamento.frame = frame;
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na tela
	 * ListaMedicamento
	 * 
	 * @version 09 out 22.
	 */

	private void placeComponentes(JPanel panel) {

		/*
		 * caso não tenha medicação cadastrada, imprime uma label informando que não
		 * medicamento cadastrado. Caso contrário irá imprimir uma JTable listando.
		 */
		if (MedicamentoController.medicamentos.isEmpty()) {

			lbSemMedicamento.setFont(new Font("Arial", Font.BOLD, 15));
			lbSemMedicamento.setHorizontalAlignment(SwingConstants.CENTER);
			lbSemMedicamento.setBounds(10, 66, 541, 61);
			panel.add(lbSemMedicamento);

		} else {

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 29, 541, 134);
			panel.add(scrollPane);

			jtMedicacao = new JTable();
			jtMedicacao.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Medicamento", "Descrição", "Observação Adicional" })); // Define as colunas
			scrollPane.setViewportView(jtMedicacao);

			tabelaMedicacao = (DefaultTableModel) jtMedicacao.getModel();

			// criando a tabela de medicamentos inicial
			for (int i = 0; i < MedicamentoController.medicamentos.size(); i++) {

				/*
				 * Invoca a classe controller.MedicamentoController para pegar o medicamento que
				 * se encontra na posição i do ArrayList medicamentos
				 */
				Medicamento medicamento = MedicamentoController.medicamentos.get(i);

				/*
				 * Pede para imprimir somente alguns dados solicitados, na ordem pré-definida na
				 * linha 88,
				 */
				tabelaMedicacao.addRow(new String[] { medicamento.getNomeRemedio(), medicamento.getDescricao(),
						medicamento.getObservacaoAdicionalMedicamento() });

			}
		}
		frame.repaint();
		jtMedicacao.updateUI();

		System.out.println(MedicamentoController.medicamentos.toString());

		/**
		 * Determina a ação do btnVoltar, que neste caso fecha a tela ListaMedicamento e
		 * abre a tela PrincipalMedicamento
		 * 
		 * @version 09 set. 22.
		 */
		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 190, 23);
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrincipalMedicamento obj = new PrincipalMedicamento();
				obj.setVisible(true);
				frame.dispose();

			}
		});

		panel.setLayout(null);
		panel.add(btnVoltar);

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
