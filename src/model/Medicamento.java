package model;

/**
 * Esta classe é a responsável por determinar quais são as variáveis que devem
 * estar presente quando for trabalhar no quesito Medicamento.
 * 
 * @author Edilberto
 * @version 09 set 22.
 */
public class Medicamento {

	// Dados necesários para construir a classe Medicamento.
	private String nomeRemedio;
	private String codigo;
	private String descricao;
	private String fabricante;
	private String bula;
	private String principioAtivo;
	private String observacaoAdicionalMedicamento;

	/**
	 * Contrutor da classe medicamento: diz como tipo Medicamento deve ser
	 * organizado dentro do seu ArrayList, definindo também qual deve ser o tipo de
	 * variável.
	 * 
	 * @param nomeRemedio                    - recebe a string do nome da medicação.
	 * @param codigo                         - recebe a string do código de barras
	 *                                       contido na medicação.
	 * @param descricao                      - recebe a string de uma descrição do
	 *                                       medicamento.
	 * @param fabricante                     -recebe a string da empresa fabricante
	 * @param bula                           - recebe a string de algum link que
	 *                                       direcione para a bula do medicamento
	 * @param principioAtivo                 - recebe a string que descreve o
	 *                                       princípio ativo da medicação
	 * @param observacaoAdicionalMedicamento - recebe a string que recebe um
	 *                                       comentário adicional que o usário
	 *                                       julgue importante
	 */
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

	/**
	 * Método que converte os dados para string, imprimindo seus "valores", não o
	 * seu endereço na memória
	 * 
	 */
	@Override
	public String toString() {
		return "Medicamento [nomeRemedio=" + nomeRemedio + ", codigo=" + codigo + ", descricao=" + descricao
				+ ", fabricante=" + fabricante + ", bula=" + bula + ", principioAtivo=" + principioAtivo
				+ ", observacaoAdicionalMedicamento=" + observacaoAdicionalMedicamento + "]" + "\n\n\n";
	}
}
