package controller.Posologia;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import controller.Medicamento.MedicamentoController;
import controller.Paciente.PacienteController;
import model.Medicamento;
import model.Paciente;
import model.Posologia;
import view.Posologia.BuscaPosologia;
import view.Posologia.CadastroPosologia;
import view.Posologia.EdicaoPosologia;
import view.Posologia.ExclusaoPosologia;
import view.Posologia.ListaPosologia;
import view.Posologia.PrincipalPosologia;
import view.TelaPrincipal.TelaPrincipal;

/*
 * Realiza a comunicação entre os pacotes model (paciente e posologia), o pacote controlles (PacienteController) e o pacote view.Posologia por meio
 * dos métodos de: (1) Cadastrar (2) Editar (3) Listar (4) Buscar (5) Excluir.
 * Ou seja, aqui está implementando um sistema de CRUD para o paciente + busca.
 */

public class PosologiaController {

	public static List<Posologia> posologias = new ArrayList<>();

	public static ArrayList<Posologia> getPosologias() {
		return (ArrayList<Posologia>) posologias;
	}

	private PrincipalPosologia view_principalPosologia;
	private CadastroPosologia view_cadastroPosologia;
	private ListaPosologia view_listaPosologia;
	private EdicaoPosologia view_EdicaoPosologia;

	public PosologiaController(PrincipalPosologia principalPosologia) {
		super();
		this.view_principalPosologia = principalPosologia;
	}

	public PosologiaController(CadastroPosologia cadastroPosologia) {
		super();
		this.setView_cadastroPosologia(cadastroPosologia);
	}

	public PosologiaController(EdicaoPosologia edicaoPosologia) {
		super();
		this.setView_EdicaoPosologia(edicaoPosologia);
	}

	public void executarBotao(Object botaoApertado) {

		if (botaoApertado == view_principalPosologia.getBtnVoltar()) {
			this.executarBotaoVoltar();
		}
		if (botaoApertado == view_principalPosologia.getBtnCadastrarPosologia()) {
			this.executarBotaoCadastrarPosologia();
		}

		if (botaoApertado == view_principalPosologia.getBtnEditarPosologia()) {
			this.executarBotaoEditarPosologia();
		}

		if (botaoApertado == view_principalPosologia.getBtnListarPosologia()) {
			this.executarBotaoListarPosologia();
		}

		if (botaoApertado == view_principalPosologia.getBtnBuscarPosologia()) {
			this.executarBotaoBuscarPosologia();
		}
		if (botaoApertado == view_principalPosologia.getBtnExcluirPosologia()) {
			this.executarBotaoExcluirPosologia();
		}
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

	// Realiza a busca de uma posologia na lista por meio do código
	public static Posologia buscarPosologia(String buscarCodigoPosologia) {
		for (int i = 0; i < posologias.size(); i++) {
			if (posologias.get(i).getCodigoPosologia().equals(buscarCodigoPosologia)) {
				return posologias.get(i);
			}
		}
		return null;
	}

	// Exclui o paciente da lista a partir do seu cpf
	public static Posologia excluirPosologia(String excluirCODPosologia) {
		for (int i = 0; i < posologias.size(); i++) {
			if (posologias.get(i).getCodigoPosologia().equals(excluirCODPosologia)) {
				return posologias.remove(i);
			}
		}
		return null;
	}

	// Carrega dados na lista de posologias
	public static void dadosPosologia() {

		Posologia posologiaA = new Posologia("Edilberto", "LORATAMED", "2", "diariamente", "08:00", "20:00", "", "", "",
				"", "1.0", "comprimido", "03/09/2022", "10/09/2022", "", "123");

		Posologia posologiaB = new Posologia("Fran", "NEOCOPAN COMPOSTO", "1", "diariamente", "07:00", "15:00", "23:00",
				"", "", "", "1.0", "cápsula", "04/09/2022", "11/09/2022", "", "456");

		Posologia posologiaC = new Posologia("Eurico", "REFENOL", "2", "diariamente", "10:00", "", "", "", "", "",
				"1.0", "comprimido", "10/08/2022", "10/09/2022", "", "789");

		posologias.add(posologiaA);
		posologias.add(posologiaB);
		posologias.add(posologiaC);
	}

	private void executarBotaoVoltar() {
		TelaPrincipal obj = new TelaPrincipal();
		obj.setVisible(true);
		view_principalPosologia.dispose();
	}

	private void executarBotaoCadastrarPosologia() {
		CadastroPosologia obj = new CadastroPosologia();
		obj.setVisible(true);
		view_principalPosologia.dispose();
	}

	private void executarBotaoEditarPosologia() {
		EdicaoPosologia obj = new EdicaoPosologia();
		obj.setVisible(true);
		view_principalPosologia.dispose();
	}

	private void executarBotaoListarPosologia() {
		ListaPosologia obj = new ListaPosologia();
		obj.setVisible(true);
		view_principalPosologia.dispose();
	}

	private void executarBotaoBuscarPosologia() {
		BuscaPosologia obj = new BuscaPosologia();
		obj.setVisible(true);
		view_principalPosologia.dispose();
	}

	private void executarBotaoExcluirPosologia() {
		ExclusaoPosologia obj = new ExclusaoPosologia();
		obj.setVisible(true);
		view_principalPosologia.dispose();
	}

	public PrincipalPosologia getView_principalPosologia() {
		return view_principalPosologia;
	}

	public void setView_principalPosologia(PrincipalPosologia view_principalPosologia) {
		this.view_principalPosologia = view_principalPosologia;
	}

	public CadastroPosologia getView_cadastroPosologia() {
		return view_cadastroPosologia;
	}

	public void setView_cadastroPosologia(CadastroPosologia view_cadastroPosologia) {
		this.view_cadastroPosologia = view_cadastroPosologia;
	}

	public ListaPosologia getView_listaPosologia() {
		return view_listaPosologia;
	}

	public void setView_listaPosologia(ListaPosologia view_listaPosologia) {
		this.view_listaPosologia = view_listaPosologia;
	}

	public static void setPosologias(List<Posologia> posologias) {
		PosologiaController.posologias = posologias;
	}

	public EdicaoPosologia getView_EdicaoPosologia() {
		return view_EdicaoPosologia;
	}

	public void setView_EdicaoPosologia(EdicaoPosologia view_EdicaoPosologia) {
		this.view_EdicaoPosologia = view_EdicaoPosologia;
	}

}