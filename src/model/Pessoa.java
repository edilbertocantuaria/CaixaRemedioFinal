package model;

/**
 * Cria a classe abstrata Pessoa, classe Pai da classe Paciente Pessoa e
 * determina quais são as variáveis que devem estar presente quando for
 * trabalhar no quesito Paciente, classe filho.
 * 
 * @author Edilberto
 * @version 11 set. 22.
 */

public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String telefone;
	private String genero;
	private String observacaoAdicionalPessoa;

	/**
	 * Construtor da classe Pessoa: diz como tipo Pessoa deve ser organizado dentro
	 * do seu ArrayList, definindo também qual deve ser o tipo de variável.
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
	public Pessoa(String nome, String cpf, String dataNascimento, String telefone, String genero,
			String observacaoAdicionalPessoa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.genero = genero;
		this.observacaoAdicionalPessoa = observacaoAdicionalPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getObservacaoAdicionalPessoa() {
		return observacaoAdicionalPessoa;
	}

	public void setObservacaoAdicionalPessoa(String observacaoAdicionalPessoa) {
		this.observacaoAdicionalPessoa = observacaoAdicionalPessoa;
	}

	/**
	 * Método que converte os dados para string, imprimindo seus "valores", não o
	 * seu endereço na memória
	 * 
	 */
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone
				+ ", genero=" + genero + ", observacaoAdicionalPessoa=" + observacaoAdicionalPessoa + "]" + "\n\n\n";
	}

}
