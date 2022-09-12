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

import controller.Paciente.ListaPacienteController;
import controller.Paciente.PacienteController;
import model.Paciente;

/**
 * É a tela para a listagem dos pacientes. Ela recebe o nome do paciente, envia
 * para o controller.Paciente.EdicaoPacienteController e, se cadastrado no
 * ArrayList, lista-o.
 * 
 * @author Caetano.
 * @version 09 set 22.
 */
public class ListaPaciente implements ActionListener {
	private static JFrame frame = new JFrame("Lista de pacientes");
	private JLabel lbSemMedicamento = new JLabel("Ainda não há pacientes cadastrados =(");
	public JButton btnVoltar;
	private JPanel panel;
	private JScrollPane scrollPane;
	public JTable jtPaciente;
	public DefaultTableModel tabelaPaciente;

	private ListaPacienteController controller;
	public JButton btnAtualizar;

	/**
	 * Define as dimensões físicas da view.Paciente.EdicaoPaciente
	 * 
	 */
	public ListaPaciente() {

		frame.setSize(800, 280);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponentes(panel);

		frame.setVisible(true);

	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na
	 * view.Paciente.EdicaoPaciente EdicaoPaciente
	 */
	private void placeComponentes(JPanel panel) {
		setController(new ListaPacienteController(this));

		if (PacienteController.pacientes.isEmpty()) {
			lbSemMedicamento.setFont(new Font("Arial", Font.BOLD, 15));
			lbSemMedicamento.setHorizontalAlignment(SwingConstants.CENTER);
			lbSemMedicamento.setBounds(10, 66, 541, 61);
			panel.add(lbSemMedicamento);
		} else {

			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 29, 764, 134);
			panel.add(scrollPane);

			jtPaciente = new JTable();
			jtPaciente.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF",
					"Data de Nascimento", "Telefone", "Gênero", "Observação Adicional" }));
			scrollPane.setViewportView(jtPaciente);

			tabelaPaciente = (DefaultTableModel) jtPaciente.getModel();

			// criando a tabela de pacientes inicial
			for (int i = 0; i < PacienteController.pacientes.size(); i++) {

				Paciente paciente = PacienteController.pacientes.get(i);

				tabelaPaciente.addRow(new String[] { paciente.getNome(), paciente.getCpf(),
						paciente.getDataNascimento(), paciente.getTelefone(), paciente.getGenero(),
						paciente.getObservacaoAdicionalPessoa() });
			}

		}
		// System.out.println(PacienteController.pacientes);

		btnAtualizar = new JButton("Atualizar lista");
		btnAtualizar.addActionListener(this);
		btnAtualizar.setBounds(584, 207, 190, 23);
		panel.add(btnAtualizar);

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(10, 207, 190, 23);
		btnVoltar.addActionListener(this);
		panel.setLayout(null);
		panel.add(btnVoltar);

		// Invoca o controller, que neste caso, é EdicaoPacienteController, apontando
		// que a ação está descrita nesta parte do código
		this.controller = new ListaPacienteController(this);
	}

	/**
	 * Está recebendo, o evento dos botões que estão na view.Paciente.EdicaoPaciente
	 * e invoca o controller controller.Paciente.EdicaoPaciente para saber qual deve
	 * ser a ação executada
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executarBotao(e.getSource());
	}

	public void setVisible(boolean b) {
	}

	public static JFrame getFrame() {
		return frame;
	}

	public JLabel getLbSemMedicamento() {
		return lbSemMedicamento;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getJtPaciente() {
		return jtPaciente;
	}

	public DefaultTableModel getTabelaPaciente() {
		return tabelaPaciente;
	}

	public ListaPacienteController getController() {
		return controller;
	}

	public static void setFrame(JFrame frame) {
		ListaPaciente.frame = frame;
	}

	public void setLbSemMedicamento(JLabel lbSemMedicamento) {
		this.lbSemMedicamento = lbSemMedicamento;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public void setBtnAtualizar(JButton btnAtualizar) {
		this.btnAtualizar = btnAtualizar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setJtPaciente(JTable jtPaciente) {
		this.jtPaciente = jtPaciente;
	}

	public void setTabelaPaciente(DefaultTableModel tabelaPaciente) {
		this.tabelaPaciente = tabelaPaciente;
	}

	private void setController(ListaPacienteController listaPacienteController) {
	}
}
