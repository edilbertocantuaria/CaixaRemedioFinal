package view.Medicamento;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MedicamentoController;
import model.Medicamento;

/**
 * É a tela para a busca dos medicamentos. Ela exibir as informações do
 * medicamento, se eles estiver presente no ArrayList medicamentos.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */
public class BuscaMedicamento {
	private static JFrame frame = new JFrame("Buscar cadastro de medicamento");

	private JPanel panel;
	private JLabel lbInstrucao;
	private JButton btnBuscar;
	private JLabel lbMedicacaoEncontrada;

	private JButton btnVoltar;
	private TextField tfMedicamentoBusca;
	private JLabel lbInstrucaoInfo;

	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable jtMedicacaoEncontrada;

	private DefaultTableModel tabelaBuscaMedicamento;

	/**
	 * Define as dimensões físicas da tela BuscaMedicamento
	 * 
	 * @version 09 set 22.
	 */
	public BuscaMedicamento() {
		frame.setSize(577, 280);

		panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	/**
	 * Define as posições e nomes dos componetes gráficos que estão na tela
	 * BuscaMedicamento
	 * 
	 * @version 09 set 22.
	 */
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		lbInstrucao = new JLabel("Digite o nome do medicamento: ");
		lbInstrucao.setBounds(10, 10, 200, 25);
		panel.add(lbInstrucao);
		lbInstrucaoInfo = new JLabel("(tudo maiúsculo)");
		lbInstrucaoInfo.setBounds(10, 23, 200, 25);
		panel.add(lbInstrucaoInfo);

		tfMedicamentoBusca = new TextField();
		tfMedicamentoBusca.setBounds(260, 10, 200, 25);
		panel.add(tfMedicamentoBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(466, 10, 85, 25);
		panel.add(btnBuscar);

		lbMedicacaoEncontrada = new JLabel("Medicação encontrada");
		lbMedicacaoEncontrada.setBounds(10, 55, 200, 25);
		panel.add(lbMedicacaoEncontrada);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 88, 541, 116);
		panel.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 541, 116);
		panel_1.add(scrollPane);

		jtMedicacaoEncontrada = new JTable();
		jtMedicacaoEncontrada.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome do medicamento",
				"Código", "Descrição", "Fabricante", "Bula", "Princípio Ativo", "Observação adicional" }));
		scrollPane.setViewportView(jtMedicacaoEncontrada);

		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// deixa o cursor dentro desse jtextfield's
				tfMedicamentoBusca.requestFocus();

				String nomeMedicacao = tfMedicamentoBusca.getText();

				MedicamentoController medicamentoController = new MedicamentoController();
				Medicamento resultado = medicamentoController.buscarMedicamentos(nomeMedicacao);

				tabelaBuscaMedicamento = (DefaultTableModel) jtMedicacaoEncontrada.getModel();
				tabelaBuscaMedicamento.addRow(new String[] { resultado.getNomeRemedio(), resultado.getCodigo(),
						resultado.getDescricao(), resultado.getFabricante(), resultado.getBula(),
						resultado.getObservacaoAdicionalMedicamento() });

				JOptionPane.showMessageDialog(null, "Busca efetivada!");

				// deixa o cursor dentro desse jtextfield's
				tfMedicamentoBusca.requestFocus();

				// limpando os campos dos jtextfield's
				tfMedicamentoBusca.setText("");
			}
		});

		btnVoltar = new JButton("Voltar para tela anterior");
		btnVoltar.setBounds(376, 46, 175, 23);
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

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
