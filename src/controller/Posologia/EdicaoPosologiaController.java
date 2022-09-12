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
import view.Posologia.EdicaoPosologia;
import view.Posologia.PrincipalPosologia;

/**
 * Esta classe é responsável pela comunicação entre a classe
 * view.Posologia.EdicaoPosologia e a classe
 * controller.Posologia.PosologiaController, editando um objeto desejado e
 * retornando seus valores e atualizando-os.
 * 
 * @author Edilberto
 * @version 11 set 22.
 *
 */

public class EdicaoPosologiaController {

	private EdicaoPosologia view;

	/**
	 * Chama o método construtor da classe EdicaoPosologia
	 * 
	 * @param view - é a classe view.Posologia.EdicaoPosologia
	 */
	public EdicaoPosologiaController(EdicaoPosologia view) {
		this.view = view;

	}

	/**
	 * Adiciona apenas os nomes dos pacientes cadastrados numa ComboBox.
	 * 
	 * @return - nome dos pacientes salvos no Arraylist pacientes
	 */
	public ComboBoxModel<String> listarPacientes() {

		ArrayList<Paciente> listaPacientes = PacienteController.getPacientes();

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		for (Paciente paciente : listaPacientes) {
			model.addElement(paciente.getNome());

		}
		return model;
	}

	/**
	 * Adiciona apenas os nomes dos medicamentos cadastrados numa ComboBox.
	 * 
	 * @return - nome dos pacientes salvos no Arraylist pacientes
	 */
	public ComboBoxModel<String> listarMedicamentos() {

		ArrayList<Medicamento> listaMedicamentos = MedicamentoController.getMedicamentos();

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		for (Medicamento medicamento : listaMedicamentos) {
			model.addElement(medicamento.getNomeRemedio());

		}
		return model;
	}

	/**
	 * Está recebendo, o evento dos botões que estão em
	 * view.Posologia.EdicaoPosologia e identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Posologia.EdicaoPosologia
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view.getBtnVoltar()) {
			this.voltaTelaAnterior();

		}
		if (botaoApertado == view.getBtnEditarPosologia_edicao()) {
			this.edicaoPosologia();
		}

		if (botaoApertado == view.getBtnAtualizarPosologia()) {
			this.atualizaPosologia();
		}

	}

	/**
	 * Ao clicar no botão Voltar, este método limpa os campos e retorna para a tela
	 * view.Posologia.PrincipalPosologia
	 * 
	 */
	public void voltaTelaAnterior() {
		// limpando os campos dos jtextfield's
		view.jftCodPosologiaBusca.setText("");

		// desabilita o botão de atualizar paciente
		view.btnAtualizarPosologia.setEnabled(false);

		PrincipalPosologia obj = new PrincipalPosologia();
		obj.setVisible(true);
		EdicaoPosologia.getFrame().dispose();
	}

	/**
	 * Ao clicar no botão para editar, este método invoca a classe
	 * PosologiaController, procurando pelo método buscarPosologias, passando como
	 * parâmetro o código da posologia, retornando os dados solicidados que compõem
	 * o ArrayList posologias
	 * 
	 */

	public void edicaoPosologia() {
		view.jftCodPosologiaBusca.requestFocus();

		if (view.jftCodPosologiaBusca.getText().matches("^[0-9]{3}$")) {
			String cod = view.jftCodPosologiaBusca.getText();

			// Invoca o controller para que ele procure a posologia pelo seu código no
			// método buscarPosologia.
			Posologia resultado = PosologiaController.buscarPosologia(cod);

			if (resultado == null) {
				JOptionPane.showMessageDialog(null, "Posologia não cadastrada ou código inválido!");
			} else {

				view.cbEscolhaPaciente.setEnabled(true);
				view.cbEscolhaMedicamento.setSelectedIndex(-1);

				view.cbEscolhaMedicamento.setEnabled(true);
				view.cbEscolhaPaciente.setSelectedIndex(-1);

				view.tfRotinaMedicacao.setText(resultado.getRotinaMedicacao());
				view.tfRotinaMedicacao.setEditable(true);
				view.tfRotinaMedicacao.setEnabled(true);

				view.tfHorario1.setText(resultado.getHorario1());
				view.tfHorario1.setEnabled(true);
				view.tfHorario1.setEditable(true);

				view.tfHorario2.setText(resultado.getHorario2());
				view.tfHorario2.setEnabled(true);
				view.tfHorario2.setEditable(true);

				view.tfHorario3.setText(resultado.getHorario3());
				view.tfHorario3.setEnabled(true);
				view.tfHorario3.setEditable(true);

				view.tfHorario4.setText(resultado.getHorario4());
				view.tfHorario4.setEnabled(true);
				view.tfHorario4.setEditable(true);

				view.tfHorario5.setText(resultado.getHorario5());
				view.tfHorario5.setEnabled(true);
				view.tfHorario5.setEditable(true);

				view.tfHorario6.setText(resultado.getHorario6());
				view.tfHorario6.setEnabled(true);
				view.tfHorario6.setEditable(true);

				view.tfDosagem.setText(resultado.getDosagem());
				view.tfDosagem.setEditable(true);
				view.tfDosagem.setEnabled(true);

				view.tfNumeroVezes.setText(resultado.getNumeroVezes());
				view.tfNumeroVezes.setEditable(true);
				view.tfNumeroVezes.setEnabled(true);

				view.tfObsAdcPosologia.setText(resultado.getObservacaoAdicionalPosologia());
				view.tfObsAdcPosologia.setEditable(true);
				view.tfObsAdcPosologia.setEnabled(true);

				view.tfAspecto.setText(resultado.getAspectoMedicamento());
				view.tfAspecto.setEditable(true);
				view.tfAspecto.setEnabled(true);

				view.tfDataInicioTratamento.setText(resultado.getDataInicioTratamento());
				view.tfDataInicioTratamento.setEditable(true);
				view.tfDataInicioTratamento.setEnabled(true);

				view.tfDataFimTratamento.setText(resultado.getDataFimTratamento());
				view.tfDataFimTratamento.setEditable(true);
				view.tfDataFimTratamento.setEnabled(true);

				view.tfCodigoPosologia.setText(resultado.getCodigoPosologia());
				view.tfCodigoPosologia.setEditable(true);
				view.tfCodigoPosologia.setEnabled(true);

				view.btnAtualizarPosologia.setEnabled(true);

			}
		} else

		{
			JOptionPane.showMessageDialog(null, "Posologia não cadastrada ou código inválido!");
		}
	}

	/**
	 * Ao clicar no botão para atualizar, este método invoca a classe
	 * PosologiaController, atualizando os dados existentes no ArrayList posologias
	 * pelos dados que estão inseridos na view.EditarPosologia, sem mudar sua
	 * posição dentro do ArryList, somente as informações
	 */
	public void atualizaPosologia() {

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

		// A próxima linha valida se as informações foram preenchidas corretamente. As
		// variáveis recebem 0 se os campos estão preenchidos conforme o esperado, caso
		// contrário, 1
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

		if (view.getTfAspecto().getText().isEmpty() || view.getTfRotinaMedicacao().getText().isEmpty()) {
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
					"Não foi possível atualizar cadastro: os dados da posologia não podem estar vazios!");

			//

		} else {
			// Invoca o controller para que ele atualize a posologia, substituindo as
			// informações antigas e inserindo as novas

			String cod = view.jftCodPosologiaBusca.getText();
			Posologia resultado = PosologiaController.buscarPosologia(cod);

			resultado.setNomePaciente(nomePaciente);
			resultado.setNomeMedicamento(nomeMedicacao);
			resultado.setNumeroVezes(numeroVezes);
			resultado.setRotinaMedicacao(rotinaMedicacao);
			resultado.setHorario1(horario1);
			resultado.setHorario2(horario2);
			resultado.setHorario3(horario3);
			resultado.setHorario4(horario4);
			resultado.setHorario5(horario5);
			resultado.setHorario6(horario6);
			resultado.setDosagem(dosagem);
			resultado.setAspectoMedicamento(aspectoMedicamento);
			resultado.setDataInicioTratamento(dataInicioTratamento);
			resultado.setDataFimTratamento(dataFimTratamento);
			resultado.setObservacaoAdicionalPosologia(observacaoAdicionalPosologia);
			resultado.setCodigoPosologia(codigoPosologia);

			// System.out.println(PosologiaController.posologias.toString());
			JOptionPane.showMessageDialog(null, "Atualização efetivada!");

			// limpando os campos dos jtextfield's
			view.jftCodPosologiaBusca.setText("");
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

			// desabilitando a edição/inserção de texto nos jtexview.tfield's
			view.cbEscolhaPaciente.setEnabled(false);
			view.cbEscolhaPaciente.setSelectedIndex(-1);

			view.cbEscolhaMedicamento.setEnabled(false);
			view.cbEscolhaMedicamento.setSelectedIndex(-1);

			view.tfRotinaMedicacao.setEditable(false);
			view.tfRotinaMedicacao.setEnabled(false);

			view.tfHorario1.setEnabled(false);
			view.tfHorario1.setEditable(false);

			view.tfHorario2.setEnabled(false);
			view.tfHorario2.setEditable(false);

			view.tfHorario3.setEnabled(false);
			view.tfHorario3.setEditable(false);

			view.tfHorario4.setEnabled(false);
			view.tfHorario4.setEditable(false);

			view.tfHorario5.setEnabled(false);
			view.tfHorario5.setEditable(false);

			view.tfHorario6.setEnabled(false);
			view.tfHorario6.setEditable(false);

			view.tfDosagem.setEditable(false);
			view.tfDosagem.setEnabled(false);

			view.tfNumeroVezes.setEditable(false);
			view.tfNumeroVezes.setEnabled(false);

			view.tfObsAdcPosologia.setEditable(false);
			view.tfObsAdcPosologia.setEnabled(false);

			view.tfAspecto.setEditable(false);
			view.tfAspecto.setEnabled(false);

			view.tfDataInicioTratamento.setEditable(false);
			view.tfDataInicioTratamento.setEnabled(false);

			view.tfDataFimTratamento.setEditable(false);
			view.tfDataFimTratamento.setEnabled(false);

			view.tfCodigoPosologia.setEditable(false);
			view.tfCodigoPosologia.setEnabled(false);

			view.btnAtualizarPosologia.setEnabled(false);

		}

	}
}
