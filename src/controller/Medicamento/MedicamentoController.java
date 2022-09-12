package controller.Medicamento;

import java.util.ArrayList;

import model.Medicamento;
import view.Medicamento.BuscaMedicamento;
import view.Medicamento.CadastroMedicamento;
import view.Medicamento.EdicaoMedicamento;
import view.Medicamento.ExclusaoMedicamento;
import view.Medicamento.ListaMedicamento;
import view.Medicamento.PrincipalMedicamento;
import view.TelaPrincipal.TelaPrincipal;

/**
 * Realiza a comunicação entre o pacote model e o pacote view.Medicamento por
 * meio dos métodos de: (1) Cadastrar (2) Editar (3) Listar (4) Buscar (5)
 * Excluir. Ou seja, aqui está implementando um sistema de CRUD para o
 * medicamento + busca.
 * 
 * @author Edilberto.
 * @version 09 set 22.
 */

public class MedicamentoController {

	// Arraylist de medicamentos
	public static ArrayList<Medicamento> medicamentos = new ArrayList<>();

	public static ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	private PrincipalMedicamento view_principalMedicamento;

	public MedicamentoController(PrincipalMedicamento principalMedicamento) {
		super();
		this.view_principalMedicamento = principalMedicamento;
	}

	public MedicamentoController() {
	}

	/**
	 * Está recebendo, o evento dos botões que estão tela PrincipalMedicamento e
	 * identifica qual o método deve ser executado.
	 * 
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Medicamento.PrincipalMedicamento.
	 */
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

	/**
	 * Realiza busca de um medicamento na lista por meio do seu nome
	 * 
	 * @param buscarNomeRemedio- string que será utilizada para comparar e
	 *                           selecionar o que se busca.
	 * @return null- retorna os dados do medicamento que está com aquele nome
	 *         buscado
	 */
	// Busca medicamento pelo seu nome
	public Medicamento buscarMedicamentos(String buscarNomeRemedio) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNomeRemedio().equals(buscarNomeRemedio)) {
				return medicamentos.get(i);
			}
		}
		return null;
	}

	/**
	 * Excluio medicamento da lista a partir do seu nome
	 * 
	 * @param excluirNomeRemedio - string que será utilizada para comparar e
	 *                           selecionar o que se busca.
	 * @return null - remove os dados do medicamento que está com aquele nome
	 *         buscado
	 */
	// Exclui medicamento pelo seu nome
	public Medicamento excluirMedicamentos(String excluirNomeRemedio) {
		for (int i = 0; i < medicamentos.size(); i++) {
			if (medicamentos.get(i).getNomeRemedio().equals(excluirNomeRemedio)) {
				return medicamentos.remove(i);
			}
		}
		return null;
	}

	/**
	 * Realizando carregamento de dados aleatórios
	 * 
	 */
	// Dados aleatórios
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

	/**
	 * Os seguintes métodos concretizam a ação dos botões pressionados na tela
	 * PrincpalMedicacao. A execução de cada método abaixo dependerá da cadeia
	 * condicional que está descrito nas linhas 51 a 74
	 * 
	 */
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
