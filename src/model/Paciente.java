package model;

import java.util.ArrayList;

/**
 * Cria a classe Paciente, que herda os atributos e métodos da classe abstrata
 * Pessoa.
 * 
 * @author Edilberto
 * @version 11 set 22.
 */
public class Paciente extends Pessoa {
	/**
	 * Cria um ArrayList do tipo Posologia que recebe posologia.
	 */
	private final ArrayList<Posologia> posologias;

	/**
	 * Construtores herdados da classe Pessoa: diz como tipo Paciente deve ser
	 * organizado dentro do seu ArrayList, definindo também qual deve ser o tipo de
	 * variável.
	 * 
	 * @param nomePaciente                - recebe a string do nome do Paciente.
	 * @param cpf                         - recebe a string do CPF do paciente
	 * @param dataNascimento              - recebe uma string da data de nascimento
	 *                                    do Paciente.
	 * @param telefone                    - recebe uma string telefone do Paciente.
	 * @param genero                      - recebe uma string do gênero do Paciente.
	 * @param observacaoAdicionalPaciente - recebe a string que recebe um comentário
	 *                                    adicional que o usário julgue importante
	 */
	public Paciente(String nomePaciente, String cpf, String dataNascimento, String telefone, String genero,
			String observacaoAdicionalPaciente) {
		super(nomePaciente, cpf, dataNascimento, telefone, genero, observacaoAdicionalPaciente);
		this.posologias = new ArrayList<>();

	}

	public ArrayList<Posologia> getPosologias() {
		return posologias;
	}

	/**
	 * Método que converte os dados para string, imprimindo seus "valores", não o
	 * seu endereço na memória
	 * 
	 */
	@Override
	public String toString() {
		return super.toString() + "-------------------------------------> Paciente [rotinas=" + posologias + "]"
				+ "\n\n\n";
	}

}
