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

import controller.Posologia.ListaPosologiaController;
import controller.Posologia.PosologiaController;
import model.Posologia;

/**
 * É a tela para a listagem das posologias. Ela recebe o nome do posologia,
 * envia para o controller.Posologia.EdicaoPosologiaController e, se cadastrado
 * no ArrayList, lista-o.
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class ListaPosologia implements ActionListener {

	private static JFrame frame = new JFrame("Lista de posologias");
	private JPanel panel;
	public JButton btnVoltar;
	private JLabel lbSemPosologia = new JLabel("Ainda não há posologias cadastradas =(");
	public DefaultTableModel tabelaPosologia;
	private JScrollPane scrollPane;
	public JTable jtPosologia;
	public JButton btnAtualizar;

	private ListaPosologiaController controller;

	/**
	 * Define as dimensões físicas da view.Posologia.EdicaoPosologia
	 * 
	 */
	public ListaPosologia() {
		frame.setSize(1375, 470);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponentes(panel);
		panel.setLayout(null);

		frame.setVisible(true);

	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na
	 * view.Posologia.EdicaoPosologia EdicaoPosologia
	 * 
	 */
	private void placeComponentes(JPanel panel) {
		setController(new ListaPosologiaController(this));

		if (PosologiaController.posologias.isEmpty()) {
			lbSemPosologia.setFont(new Font("Arial", Font.BOLD, 15));
			lbSemPosologia.setHorizontalAlignment(SwingConstants.CENTER);
			lbSemPosologia.setBounds(10, 66, 541, 61);
			panel.add(lbSemPosologia);
		} else {

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 1339, 318);
			panel.add(scrollPane);

			jtPosologia = new JTable();
			jtPosologia.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Cód. Posologia", "Nome", "Medicamento", "Nº vezes", "Rotina", "Horário 01",
							"Horário 02", "Horário 03", "Horário 04", "Horário 05", "Horário 06", "Dosagem", "Aspecto",
							"Data início", "Data término", "Obs. Adicional" }));
			scrollPane.setViewportView(jtPosologia);

			// criando a tabela de posologia inicial
			for (int i = 0; i < PosologiaController.posologias.size(); i++) {

				Posologia posologia = PosologiaController.posologias.get(i);

				tabelaPosologia = (DefaultTableModel) jtPosologia.getModel();

				tabelaPosologia.addRow(new String[] { posologia.getCodigoPosologia(), posologia.getNomePaciente(),
						posologia.getNomeMedicamento(), (posologia.getNumeroVezes()), (posologia.getRotinaMedicacao()),
						posologia.getHorario1(), posologia.getHorario2(), posologia.getHorario3(),
						posologia.getHorario4(), posologia.getHorario5(), posologia.getHorario6(),
						(posologia.getDosagem()), (posologia.getAspectoMedicamento()),
						posologia.getDataInicioTratamento(), posologia.getDataFimTratamento(),
						posologia.getObservacaoAdicionalPosologia() });
			}
		}

		btnAtualizar = new JButton("Atualizar lista");
		btnAtualizar.setBounds(1139, 397, 210, 23);
		btnAtualizar.addActionListener(this);
		panel.add(btnAtualizar);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 397, 210, 23);
		btnVoltar.addActionListener(this);
		panel.add(btnVoltar);

		// Invoca o controller, que neste caso, é EdicaoPosologiaController,
		// apontandoque a ação está descrita nesta parte do código
		this.controller = new ListaPosologiaController(this);

	}

	/**
	 * Está recebendo, o evento dos botões que estão na
	 * view.Posologia.EdicaoPosologia e invoca o controller
	 * controller.Posologia.EdicaoPosologia para saber qual deve ser a ação
	 * executada
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	private void setController(ListaPosologiaController listaPosologiaController) {
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public DefaultTableModel getTabelaPosologia() {
		return tabelaPosologia;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getJtPosologia() {
		return jtPosologia;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public ListaPosologiaController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		ListaPosologia.frame = frame;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setTabelaPosologia(DefaultTableModel tabelaPosologia) {
		this.tabelaPosologia = tabelaPosologia;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setJtPosologia(JTable jtPosologia) {
		this.jtPosologia = jtPosologia;
	}

	public void setBtnAtualizar(JButton btnAtualizar) {
		this.btnAtualizar = btnAtualizar;
	}

}
