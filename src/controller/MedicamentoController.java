package controller;

import java.util.ArrayList;
import java.util.List;

import model.Medicamento;
import view.Medicamento.BuscaMedicamento;
import view.Medicamento.CadastroMedicamento;
import view.Medicamento.EdicaoMedicamento;
import view.Medicamento.ExclusaoMedicamento;
import view.Medicamento.ListaMedicamento;
import view.Medicamento.PrincipalMedicamento;
import view.TelaPrincipal.TelaPrincipal;

/*
 * Realiza a comunicação entre o pacote model e o pacote view.Medicamento por meio
 * dos métodos de: (1) Cadastrar (2) Editar (3) Listar (4) Buscar (5) Excluir.
 * Ou seja, aqui está implementando um sistema de CRUD para o medicamento + busca.
 */

public class MedicamentoController {

	public static List<Medicamento> medicamentos = new ArrayList<>();

	public static ArrayList<Medicamento> getMedicamentos() {
		return (ArrayList<Medicamento>) medicamentos;
	}

	private PrincipalMedicamento view_principalMedicamento;

	public MedicamentoController(PrincipalMedicamento principalMedicamento) {
		super();
		this.view_principalMedicamento = principalMedicamento;
	}

	public MedicamentoController() {
		// TODO Auto-generated constructor stub
	}

	public void executarBotao(Object botaoApertado) {

		if (botaoApertado == view_principalMedicamento.getBtnVoltar()) {
			this.executarBotaoVoltar();
		}

		if (botaoApertado == view_principalMedicamento.getBtnCadastrarMedicamento()) {
			this.executarBotaoCadastrarMedicamento();
		}

		if (botaoApertado == view_principalMedicamento.getBtnEditarMedicamento()) {
			this.executarBotaoEditarMedicamento();
		}
		if (botaoApertado == view_principalMedicamento.getBtnListarMedicamento()) {
			this.executarBotaoListarMedicamento();
		}
		if (botaoApertado == view_principalMedicamento.getBtnBuscarMedicamento()) {
			this.executarBotaoBuscarMedicamento();
		}
		if (botaoApertado == view_principalMedicamento.getBtnExcluirMedicamento()) {
			this.executarBotaoExcluirMedicamento();
		}

	}

	// Realiza a busca de um medicamento na lista por meio de um nome podendo
	public Medicamento buscarMedicamentos(String buscarNomeRemedio) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNomeRemedio().equals(buscarNomeRemedio)) {
				return medicamentos.get(i);
			}
		}
		return null;
		// "Medicamento não encontrado! ";
	}

	// Exclui o medicamento da lista a partir do seu nome
	public void excluirMedicamentos(String excluirNomeRemedio) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNomeRemedio().equals(excluirNomeRemedio)) {
				medicamentos.remove(i);
			}
		}
	}

	// Carrega dados na lista de medicamentos
	public static void dadosMedicamento() {
		Medicamento medicamentoA = new Medicamento("NEOCOPAN COMPOSTO", "786006217459",
				"Para cólicas e dores intensas na região da barriga", "União Química",
				"https://bula.medicinanet.com.br/bula/3623/neocopan.htm",
				"Butilbrometo de escopalamina 10mg, dipirona 250mg", "Vencimento 09/23");

		Medicamento medicamentoB = new Medicamento("REFENOL", "7896331703443", "Para gripe e resfriado", "Kley hertz",
				"https://consultaremedios.com.br/resfenol/bula",
				"paracetamol 400mg, maleato de clorfeniramina 4mg, cloridato de fenilefrina 4mg", "Vencimento 04/24");

		Medicamento medicamentoC = new Medicamento("LORATAMED", "7896523202822",
				"Antialérgico, alivio da coceira, espirro e coriza", "CIMED",
				"https://consultaremedios.com.br/loratamed/bula", "Loratadina 10mg", "Vencimento 04/23");

		medicamentos.add(medicamentoA);
		medicamentos.add(medicamentoB);
		medicamentos.add(medicamentoC);
	}

	private void executarBotaoVoltar() {
		TelaPrincipal obj = new TelaPrincipal();
		obj.setVisible(true);
		view_principalMedicamento.dispose();
	}

	private void executarBotaoCadastrarMedicamento() {
		CadastroMedicamento obj = new CadastroMedicamento();
		obj.setVisible(true);
		view_principalMedicamento.dispose();
	}

	private void executarBotaoEditarMedicamento() {
		EdicaoMedicamento obj = new EdicaoMedicamento();
		obj.setVisible(true);
		view_principalMedicamento.dispose();
	}

	private void executarBotaoListarMedicamento() {
		ListaMedicamento obj = new ListaMedicamento();
		obj.setVisible(true);
		view_principalMedicamento.dispose();
	}

	private void executarBotaoBuscarMedicamento() {
		BuscaMedicamento obj = new BuscaMedicamento();
		obj.setVisible(true);
		view_principalMedicamento.dispose();
	}

	private void executarBotaoExcluirMedicamento() {
		ExclusaoMedicamento obj = new ExclusaoMedicamento();
		obj.setVisible(true);
		view_principalMedicamento.dispose();
	}
}
