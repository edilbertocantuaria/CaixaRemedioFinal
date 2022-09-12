package controller.Paciente;

import java.util.ArrayList;

import model.Paciente;
import model.Pessoa;
import view.Paciente.BuscaPaciente;
import view.Paciente.CadastroPaciente;
import view.Paciente.EdicaoPaciente;
import view.Paciente.ExclusaoPaciente;
import view.Paciente.ListaPaciente;
import view.Paciente.PrincipalPaciente;
import view.TelaPrincipal.TelaPrincipal;

/**
 * Realiza a comunicação entre o pacote model e o pacote view.Paciente por meio
 * dos métodos de: (1) Cadastrar (2) Editar (3) Listar (4) Buscar (5) Excluir.
 * Ou seja, aqui está implementando um sistema de CRUD para o medicamento +
 * busca.
 * 
 * @author Edilberto
 * @version 09 set 22.
 */
public class PacienteController {

	// ArrayList de pacientes
	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

	public static ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	private PrincipalPaciente view_principalPaciente;

	public PacienteController(PrincipalPaciente principalPaciente) {
		super();
		this.view_principalPaciente = principalPaciente;
	}

	/**
	 * Está recebendo, o evento dos botões que estão tela PrincipalMedicamento e
	 * identifica qual o método deve ser executado.
	 * 
	 * @param botaoApertado - evento que é descrito na
	 *                      view.Paciente.PrincipalPaciente
	 */
	public void executarBotao(Object botaoApertado) {
		if (botaoApertado == view_principalPaciente.getBtnVoltar()) {
			this.executarBotaoVoltar();
		}

		if (botaoApertado == view_principalPaciente.getBtnCadastrarPaciente()) {
			this.executarBotaoCadastrarPaciente();
		}

		if (botaoApertado == view_principalPaciente.getBtnEditarPaciente()) {
			this.executarBotaoEditarPaciente();
		}

		if (botaoApertado == view_principalPaciente.getBtnListarPaciente()) {
			this.executarBotaoListarPaciente();
		}

		if (botaoApertado == view_principalPaciente.getBtnBuscarPaciente()) {
			this.executarBotaoBuscarPaciente();
		}

		if (botaoApertado == view_principalPaciente.getBtnExcluirPaciente()) {
			this.executarBotaoExcluirPaciente();
		}

	}

	/**
	 * Realiza busca de um paciente na lista por meio do seu CPF
	 * 
	 * @param buscarCPFPaciente - string que será utilizada para comparar e
	 *                          selecionar o que se busca.
	 * @return null- retorna os dados do paciente que está com aquele CPF buscado
	 */
	// Busca paciente pelo seu CPF
	public Pessoa buscarPacientes(String buscarCPFPaciente) {
		for (int i = 0; i < pacientes.size(); i++) {
			if (pacientes.get(i).getCpf().equals(buscarCPFPaciente)) {
				return pacientes.get(i);
			}
		}
		return null;
	}

	/**
	 * Exclui o paciente da lista a partir do seu CPF
	 * 
	 * @param excluirCPFPaciente - string que será utilizada para comparar e
	 *                           selecionar o que se busca.
	 * @return null - remove os dados da posologia que está com aquele código
	 *         buscado
	 */
	// Exclui medicamento pelo seu cpf
	public Paciente excluirPacientes(String excluirCPFPaciente) {
		for (int i = 0; i < pacientes.size(); i++) {
			if (pacientes.get(i).getCpf().equals(excluirCPFPaciente)) {
				return pacientes.remove(i);
			}
		}
		return null;
	}

	/**
	 * Realizando carregamento de dados aleatórios
	 * 
	 */
	// Dados aleatórios
	public static void dadosPaciente() {
		Paciente pacienteA = new Paciente("Edilberto", "123.456.789-10", "25/02/1998", "(61) 98126-6760", "Masculino",
				"Rinite alérgica");
		Paciente pacienteB = new Paciente("Fran", "000.000.000-00", "03/04/1976", "(61) 93622-3517", "Feminino",
				"Problemas de pele e enxaquecas");
		Paciente pacienteC = new Paciente("Eurico", "999.999.999-99", "29/05/1946", "(61) 93621-4932", "Masculino",
				"Apresenta baixo índice plaquetário");
		pacientes.add(pacienteA);
		pacientes.add(pacienteB);
		pacientes.add(pacienteC);
	}

	/**
	 * Os seguintes métodos concretizam a ação dos botões pressionados
	 * view.PrincpalPaciente. A execução de cada método abaixo dependerá da cadeia
	 * condicional que está descrito nas linhas 47 a 72
	 * 
	 */
	private void executarBotaoVoltar() {
		TelaPrincipal obj = new TelaPrincipal();
		obj.setVisible(true);
		view_principalPaciente.dispose();
	}

	private void executarBotaoCadastrarPaciente() {
		CadastroPaciente obj = new CadastroPaciente();
		obj.setVisible(true);
		view_principalPaciente.dispose();
	}

	private void executarBotaoEditarPaciente() {
		EdicaoPaciente obj = new EdicaoPaciente();
		obj.setVisible(true);
		view_principalPaciente.dispose();
	}

	private void executarBotaoListarPaciente() {
		ListaPaciente obj = new ListaPaciente();
		obj.setVisible(true);
		view_principalPaciente.dispose();
	}

	private void executarBotaoBuscarPaciente() {
		BuscaPaciente<Paciente> obj = new BuscaPaciente<Paciente>();
		obj.setVisible(true);
		view_principalPaciente.dispose();
	}

	private void executarBotaoExcluirPaciente() {
		ExclusaoPaciente obj = new ExclusaoPaciente();
		obj.setVisible(true);
		view_principalPaciente.dispose();
	}

}
