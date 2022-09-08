package model;

public class Medicamento {

	// Dados necesários para construir a classe Medicamento.
	private String nomeRemedio;
	private String codigo;
	private String descricao;
	private String fabricante;
	private String bula;
	private String principioAtivo;
	private String observacaoAdicionalMedicamento;

	// Construtor da classe medicamento
	public Medicamento(String nomeRemedio, String codigo, String descricao, String fabricante, String bula,
			String principioAtivo, String observacaoAdicionalMedicamento) {
		super();
		this.nomeRemedio = nomeRemedio;
		this.codigo = codigo;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.bula = bula;
		this.principioAtivo = principioAtivo;
		this.observacaoAdicionalMedicamento = observacaoAdicionalMedicamento;
	}

	// Atribui valores às variáveis do construtor
	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getBula() {
		return bula;
	}

	public void setBula(String bula) {
		this.bula = bula;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getObservacaoAdicionalMedicamento() {
		return observacaoAdicionalMedicamento;
	}

	public void setObservacaoAdicionalMedicamento(String observacaoAdicionalMedicamento) {
		this.observacaoAdicionalMedicamento = observacaoAdicionalMedicamento;
	}

	@Override
	// Converte os dados para string, imprimindo seus "valroes", não seu endereço na
	// memória.
	public String toString() {
		return "Medicamento [nomeRemedio=" + nomeRemedio + ", codigo=" + codigo + ", descricao=" + descricao
				+ ", fabricante=" + fabricante + ", bula=" + bula + ", principioAtivo=" + principioAtivo
				+ ", observacaoAdicionalMedicamento=" + observacaoAdicionalMedicamento + "]" + "\n\n\n";
	}
}
