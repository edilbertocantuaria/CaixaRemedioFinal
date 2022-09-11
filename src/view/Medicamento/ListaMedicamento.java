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

import controller.Medicamento.ListaMedicamentoController;
import controller.Medicamento.MedicamentoController;
import model.Medicamento;

/**
 * É a tela para a listagem dos medicamentos. Ela busca exibir as informações de
 * todos medicamentos presentes no ArrayList medicamentos.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */
public class ListaMedicamento implements ActionListener {
	private static JFrame frame = new JFrame("Lista de Medicamentos");
	private JLabel lbSemMedicamento = new JLabel("Ainda não há medicamentos cadastrados =(");

	public JButton btnVoltar;
	public JButton btnAtualizar;

	private JPanel panel;
	public JTable jtMedicacao;
	private JScrollPane scrollPane;
	public DefaultTableModel tabelaMedicacao;

	private ListaMedicamentoController controller;

	/**
	 * Define as dimensões físicas da tela ListaMedicamento
	 * 
	 * @version 09 set 22.
	 */

	public ListaMedicamento() {
		frame.setSize(1000, 280);

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
		setController(new ListaMedicamentoController(this));

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
			scrollPane.setBounds(10, 29, 964, 134);
			panel.add(scrollPane);

			jtMedicacao = new JTable();
			jtMedicacao.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome do medicamento",
					"Código", "Descrição", "Fabricante", "Bula", "Princípio Ativo", "Observação adicional" })); // Define
																												// as
																												// colunas
			scrollPane.setViewportView(jtMedicacao);

			tabelaMedicacao = (DefaultTableModel) jtMedicacao.getModel();

			// criando a tabela de medicamentos inicial
			for (int i = 0; i < MedicamentoController.medicamentos.size(); i++) {

				Medicamento medicamento = MedicamentoController.medicamentos.get(i);
				tabelaMedicacao.addRow(new String[] { medicamento.getNomeRemedio(), medicamento.getCodigo(),
						medicamento.getDescricao(), medicamento.getFabricante(), medicamento.getBula(),
						medicamento.getObservacaoAdicionalMedicamento() });

			}
		}

		// System.out.println(MedicamentoController.medicamentos.toString());

		btnAtualizar = new JButton("Atualizar lista");
		btnAtualizar.setBounds(784, 207, 190, 23);
		btnAtualizar.addActionListener(this);
		panel.add(btnAtualizar);
		/**
		 * Determina a ação do btnVoltar, que neste caso fecha a tela ListaMedicamento e
		 * abre a tela PrincipalMedicamento
		 * 
		 * @version 09 set. 22.
		 */
		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 190, 23);
		btnVoltar.addActionListener(this);

		panel.setLayout(null);
		panel.add(btnVoltar);

		this.controller = new ListaMedicamentoController(this);

	}

	private void setController(ListaMedicamentoController listaMedicamentoController) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JTable getJtMedicacao() {
		return jtMedicacao;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public DefaultTableModel getTabelaMedicacao() {
		return tabelaMedicacao;
	}

	public ListaMedicamentoController getController() {
		return controller;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setBtnAtualizar(JButton btnAtualizar) {
		this.btnAtualizar = btnAtualizar;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setJtMedicacao(JTable jtMedicacao) {
		this.jtMedicacao = jtMedicacao;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setTabelaMedicacao(DefaultTableModel tabelaMedicacao) {
		this.tabelaMedicacao = tabelaMedicacao;
	}

}
