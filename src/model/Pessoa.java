package model;

public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String telefone;
	private String genero;
	private String observacaoAdicionalPessoa;

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

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone
				+ ", genero=" + genero + ", observacaoAdicionalPessoa=" + observacaoAdicionalPessoa + "]" + "\n\n\n";
	}

}
