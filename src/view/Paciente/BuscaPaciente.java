package view.Paciente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.PacienteController;

public class BuscaPaciente<Pessoa> {
	private static JFrame frame = new JFrame("Buscar cadastro de paciente");
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JPanel panel;
	private JLabel lbInstrucao;
	private JFormattedTextField jftCPFBusca;
	private JButton btnBuscar;
	private JLabel lbPacienteEncontrado;
	private JButton btnVoltar;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable jtPacienteEncontrado;
	private DefaultTableModel tabelaBuscaPaciente;

	public BuscaPaciente() {
		frame.setSize(577, 280);

		panel = new JPanel();
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

		lbInstrucao = new JLabel("Digite o CPF ");
		lbInstrucao.setBounds(20, 10, 80, 25);
		panel.add(lbInstrucao);

		jftCPFBusca = new JFormattedTextField(mascaraCPF);
		jftCPFBusca.setBounds(110, 10, 100, 25);
		panel.add(jftCPFBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(466, 10, 85, 25);
		panel.add(btnBuscar);

		lbPacienteEncontrado = new JLabel("Paciente encontrado");
		lbPacienteEncontrado.setBounds(10, 55, 200, 25);
		panel.add(lbPacienteEncontrado);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 80, 541, 155);
		panel.add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 541, 155);
		panel_1.add(scrollPane);

		jtPacienteEncontrado = new JTable();
		jtPacienteEncontrado.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "Data de Nascimento", "Telefone", "Gênero", "Observação Adicional" }));
		scrollPane.setViewportView(jtPacienteEncontrado);

		btnBuscar.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				// deixa o cursor dentro desse jtextfield's
				jftCPFBusca.requestFocus();

				String cpf = jftCPFBusca.getText();

				PacienteController pacienteController = new PacienteController();
				Pessoa resultado = (Pessoa) pacienteController.buscarPacientes(cpf);

				tabelaBuscaPaciente = (DefaultTableModel) jtPacienteEncontrado.getModel();
				tabelaBuscaPaciente.addRow(new String[] { ((model.Pessoa) resultado).getNome(),
						((model.Pessoa) resultado).getCpf(), ((model.Pessoa) resultado).getDataNascimento(),
						((model.Pessoa) resultado).getTelefone(), ((model.Pessoa) resultado).getGenero(),
						((model.Pessoa) resultado).getObservacaoAdicionalPessoa() });

				// PacienteController.pacientes.toString();
				JOptionPane.showMessageDialog(null, "Busca efetivada!");

				// deixa o cursor dentro desse jtextfield's
				jftCPFBusca.requestFocus();

				// limpando os campos dos jtextfield's
				jftCPFBusca.setText("");

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
					((DefaultTableModel) jtPacienteEncontrado.getModel()).setRowCount(0);
					jftCPFBusca.setText("");// limpando os campos dos jtextfield's
					PrincipalPaciente obj = new PrincipalPaciente();
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
