package controller.Posologia;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import controller.Medicamento.MedicamentoController;
import controller.Paciente.PacienteController;
import model.Medicamento;
import model.Paciente;
import model.Posologia;
import view.Posologia.CadastroPosologia;
import view.Posologia.PrincipalPosologia;

public class CadastroPosologiaController {

	private CadastroPosologia view;

	public CadastroPosologiaController(CadastroPosologia view) {
		this.view = view;

	}

	public ComboBoxModel<String> listarPacientes() {

		ArrayList<Paciente> listaPacientes = PacienteController.getPacientes();

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		for (Paciente paciente : listaPacientes) {
			model.addElement(paciente.getNome());

		}
		return model;
	}

	public ComboBoxModel<String> listarMedicamentos() {

		ArrayList<Medicamento> listaMedicamentos = MedicamentoController.getMedicamentos();

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		for (Medicamento medicamento : listaMedicamentos) {
			model.addElement(medicamento.getNomeRemedio());

		}
		return model;
	}

	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.limpaCampo();

		}
		if (botaoApertado == view.getBtnAtualizarPacienteMedicamento()) {
			this.atualizaPacienteMedicamento();
		}

		if (botaoApertado == view.getBtnCadastrarPosologia()) {
			this.cadastraPosologia();
		}

	}

	public void limpaCampo() {
		// limpando os campos dos jtextfield's
		view.cbEscolhaPaciente.setSelectedIndex(-1);
		view.cbEscolhaMedicamento.setSelectedIndex(-1);
		view.tfNumeroVezes.setText("");
		view.tfRotinaMedicacao.setText("");
		view.tfHorario1.setText("");
		view.tfHorario2.setText("");
		view.tfHorario3.setText("");
		view.tfHorario4.setText("");
		view.tfHorario5.setText("");
		view.tfHorario6.setText("");
		view.tfDosagem.setText("");
		view.tfAspecto.setText("");
		view.tfDataInicioTratamento.setText("");
		view.tfDataFimTratamento.setText("");
		view.tfObsAdcPosologia.setText("");
		view.tfCodigoPosologia.setText("");

		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		CadastroPosologia.getFrame().dispose();

	}

	public void atualizaPacienteMedicamento() {
		view.cbEscolhaPaciente.removeAllItems();
		view.cbEscolhaMedicamento.removeAllItems();

		view.cbEscolhaPaciente.setModel(listarPacientes());
		view.cbEscolhaMedicamento.setModel(listarMedicamentos());

		view.cbEscolhaPaciente.setSelectedIndex(-1);
		view.cbEscolhaMedicamento.setSelectedIndex(-1);

		JOptionPane.showMessageDialog(null, "Lista de pacientes e medicamentos atualizada!");
	}

	public void cadastraPosologia() {
		String nomePaciente = (String) view.getCbEscolhaPaciente().getSelectedItem();
		String nomeMedicacao = (String) view.getCbEscolhaMedicamento().getSelectedItem();
		String numeroVezes = view.getTfNumeroVezes().getText().trim();
		String rotinaMedicacao = view.getTfRotinaMedicacao().getText().trim();
		String horario1 = view.getTfHorario1().getText().trim();
		String horario2 = view.getTfHorario2().getText().trim();
		String horario3 = view.getTfHorario3().getText().trim();
		String horario4 = view.getTfHorario4().getText().trim();
		String horario5 = view.getTfHorario5().getText().trim();
		String horario6 = view.getTfHorario6().getText().trim();
		String dosagem = view.getTfDosagem().getText().trim();
		String aspectoMedicamento = view.getTfAspecto().getText().trim();
		String dataInicioTratamento = view.getTfDataInicioTratamento().getText().trim();
		String dataFimTratamento = view.getTfDataFimTratamento().getText().trim();
		String observacaoAdicionalPosologia = view.getTfObsAdcPosologia().getText().trim();
		String codigoPosologia = view.getTfCodigoPosologia().getText().trim();

		// A próxima linha valida se as informações foram preenchidas corretamente
		int i, j, k, l, m, n;

		if (view.getTfHorario1().getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")
				|| view.getTfHorario2().getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")
				|| view.getTfHorario4().getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")
				|| view.getTfHorario5().getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")
				|| view.getTfHorario6().getText().matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
			i = 0;
		} else {
			i = 1;
		}

		if (view.getTfDataInicioTratamento().getText().matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$")
				&& view.getTfDataFimTratamento().getText().matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}$")) {
			j = 0;
		} else {
			j = 1;
		}

		if (view.getTfAspecto().getText().isEmpty() && view.getTfRotinaMedicacao().getText().isEmpty()) {
			k = 1;
		} else {
			k = 0;
		}

		if (view.getCbEscolhaPaciente().getSelectedItem() == null
				|| view.getCbEscolhaMedicamento().getSelectedItem() == null) {
			l = 1;
		} else {
			l = 0;
		}

		if (view.getTfCodigoPosologia().getText().matches("^[0-9]{3}$")) {
			m = 0;
		} else {
			m = 1;
		}

		if (view.getTfDosagem().getText().matches("^[0-9]{1}.[0-9]{1}$")
				&& view.getTfNumeroVezes().getText().matches("^[0-9]{1}$")) {
			n = 0;
		} else {
			n = 1;
		}
		if (i == 1 || j == 1 || k == 1 || l == 1 || m == 1 || n == 1) {
			JOptionPane.showMessageDialog(null,
					"Não foi possível realizar o cadastro: os dados da posologia não podem estar vazios!");

		} else {
			Posologia posologia = new Posologia(nomePaciente, nomeMedicacao, numeroVezes, rotinaMedicacao, horario1,
					horario2, horario3, horario4, horario5, horario6, dosagem, aspectoMedicamento, dataInicioTratamento,
					dataFimTratamento, observacaoAdicionalPosologia, codigoPosologia);

			PosologiaController.posologias.add(posologia);
			JOptionPane.showMessageDialog(null, "Cadastro efetivado!");
		}
		System.out.print(PosologiaController.posologias.toString());

		// System.out.println("\n i: " + i + "\n j: " + j + "\n k: " + k + "\n a: " + a
		// + "\n b: " + b + "\n c: " + c);

		// limpando os campos dos jtextfield's
		view.cbEscolhaPaciente.setSelectedIndex(-1);
		view.cbEscolhaMedicamento.setSelectedIndex(-1);
		view.tfNumeroVezes.setText("");
		view.tfRotinaMedicacao.setText("");
		view.tfHorario1.setText("");
		view.tfHorario2.setText("");
		view.tfHorario3.setText("");
		view.tfHorario4.setText("");
		view.tfHorario5.setText("");
		view.tfHorario6.setText("");
		view.tfDosagem.setText("");
		view.tfAspecto.setText("");
		view.tfDataInicioTratamento.setText("");
		view.tfDataFimTratamento.setText("");
		view.tfObsAdcPosologia.setText("");
		view.tfCodigoPosologia.setText("");

	}

}