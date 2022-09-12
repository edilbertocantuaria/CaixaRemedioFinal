package model;

import java.util.ArrayList;

/**
 * Cria a classe posologia, onde interagem com medicação e determina quais são
 * as variáveis que devem estar presente quando for trabalhar no quesito
 * posologia.
 * 
 * 
 * @author Edilberto
 * @version 11 set 22
 */
public class Posologia {

	private final ArrayList<Medicamento> medicamentos;

	private String nomePaciente;
	private String nomeMedicamento;
	private String numeroVezes; // quantas vezes a medicação deve ser ingerida, por exemplo, 2x.
	private String rotinaMedicacao; // se a medicação deve ser ingerida diariamente, semanalmente, quinzenalmente,
	private String horario1; // horários da medicações
	private String horario2; // horários da medicações
	private String horario3; // horários da medicações
	private String horario4; // horários da medicações
	private String horario5; // horários da medicações
	private String horario6; // horários da medicações
	private String dosagem; // se deve ingerir meio, 1, 2, 3... "aspecto".
	private String aspectoMedicamento; // se o medicamento é capsula, comprimido, gota...
	private String dataInicioTratamento;
	private String dataFimTratamento;
	private String observacaoAdicionalPosologia;
	private String codigoPosologia;

	/**
	 * Construtor da classe Posologia: diz como tipo Posologia deve ser organizado
	 * dentro do seu ArrayList, definindo também qual deve ser o tipo de variável.
	 * 
	 * @param nomePaciente                 - recebe a string do nome do Paciente.
	 * @param nomeMedicamento              - recebe a string do nome do Medicamento.
	 * @param numeroVezes                  - recebe uma string que informa quantas
	 *                                     vezes o remédio deve ser utilizado.
	 * @param rotinaMedicacao              - recebe a string que informa se aquele
	 *                                     medicamento deve ser consumido
	 *                                     diáriamente, semanalmente, etc.
	 * @param horario1                     - recebe a string que informa qual deve
	 *                                     ser o 1º horário para consumir o
	 *                                     medicamento.
	 * @param horario2                     - recebe a string que informa qual deve
	 *                                     ser o 2º horário para consumir o
	 *                                     medicamento.
	 * @param horario3                     - recebe a string que informa qual deve
	 *                                     ser o 3º horário para consumir o
	 *                                     medicamento.
	 * @param horario4                     - recebe a string que informa qual deve
	 *                                     ser o 4º horário para consumir o
	 *                                     medicamento.
	 * @param horario5                     - recebe a string que informa qual deve
	 *                                     ser o 5º horário para consumir o
	 *                                     medicamento.
	 * @param horario6                     - recebe a string que informa qual deve
	 *                                     ser o 6º horário para consumir o
	 *                                     medicamento.
	 * @param dosagem2                     - recebe a string do nome que informa a
	 *                                     dosagem a ser consumida. Dessa forma pode
	 *                                     consumir 2 + aspecto.
	 * @param aspectoMedicamento           - recebe a string que caracteriza se o
	 *                                     medicamento se apresenta em gota, xarope,
	 *                                     comprimido, capsulas, etc.
	 * @param dataInicioTratamento         - recebe a string que descreve a data
	 *                                     inicial do tratamento
	 * @param dataFimTratamento            - recebe a string que descreve a data
	 *                                     final do tratamento
	 * @param observacaoAdicionalPosologia - recebe a string que recebe um
	 *                                     comentário adicional que o usário julgue
	 *                                     importante
	 * @param codigoPosologia              - recebe a string de 3 dígitos para
	 *                                     identificar a posologia
	 */
	public Posologia(String nomePaciente, String nomeMedicamento, String numeroVezes, String rotinaMedicacao,
			String horario1, String horario2, String horario3, String horario4, String horario5, String horario6,
			String dosagem2, String aspectoMedicamento, String dataInicioTratamento, String dataFimTratamento,
			String observacaoAdicionalPosologia, String codigoPosologia) {
		super();
		this.nomePaciente = nomePaciente;
		this.nomeMedicamento = nomeMedicamento;
		this.numeroVezes = numeroVezes;
		this.rotinaMedicacao = rotinaMedicacao;
		this.horario1 = horario1;
		this.horario2 = horario2;
		this.horario3 = horario3;
		this.horario4 = horario4;
		this.horario5 = horario5;
		this.horario6 = horario6;
		this.dosagem = dosagem2;
		this.aspectoMedicamento = aspectoMedicamento;
		this.dataInicioTratamento = dataInicioTratamento;
		this.dataFimTratamento = dataFimTratamento;
		this.observacaoAdicionalPosologia = observacaoAdicionalPosologia;
		this.codigoPosologia = codigoPosologia;

		this.medicamentos = new ArrayList<>();
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public String getNumeroVezes() {
		return numeroVezes;
	}

	public void setNumeroVezes(String numeroVezes) {
		this.numeroVezes = numeroVezes;
	}

	public String getRotinaMedicacao() {
		return rotinaMedicacao;
	}

	public void setRotinaMedicacao(String rotinaMedicacao) {
		this.rotinaMedicacao = rotinaMedicacao;
	}

	public String getHorario1() {
		return horario1;
	}

	public void setHorario1(String horario1) {
		this.horario1 = horario1;
	}

	public String getHorario2() {
		return horario2;
	}

	public void setHorario2(String horario2) {
		this.horario2 = horario2;
	}

	public String getHorario3() {
		return horario3;
	}

	public void setHorario3(String horario3) {
		this.horario3 = horario3;
	}

	public String getHorario4() {
		return horario4;
	}

	public void setHorario4(String horario4) {
		this.horario4 = horario4;
	}

	public String getHorario5() {
		return horario5;
	}

	public void setHorario5(String horario5) {
		this.horario5 = horario5;
	}

	public String getHorario6() {
		return horario6;
	}

	public void setHorario6(String horario6) {
		this.horario6 = horario6;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getAspectoMedicamento() {
		return aspectoMedicamento;
	}

	public void setAspectoMedicamento(String aspectoMedicamento) {
		this.aspectoMedicamento = aspectoMedicamento;
	}

	public String getDataInicioTratamento() {
		return dataInicioTratamento;
	}

	public void setDataInicioTratamento(String dataInicioTratamento) {
		this.dataInicioTratamento = dataInicioTratamento;
	}

	public String getDataFimTratamento() {
		return dataFimTratamento;
	}

	public void setDataFimTratamento(String dataFimTratamento) {
		this.dataFimTratamento = dataFimTratamento;
	}

	public String getObservacaoAdicionalPosologia() {
		return observacaoAdicionalPosologia;
	}

	public void setObservacaoAdicionalPosologia(String observacaoAdicionalPosologia) {
		this.observacaoAdicionalPosologia = observacaoAdicionalPosologia;
	}

	public ArrayList<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public String getCodigoPosologia() {
		return codigoPosologia;
	}

	public void setCodigoPosologia(String codigoPosologia) {
		this.codigoPosologia = codigoPosologia;
	}

	/**
	 * Método que converte os dados para string, imprimindo seus "valores", não o
	 * seu endereço na memória
	 * 
	 */
	@Override
	public String toString() {
		return "Posologia [medicamentos=" + medicamentos + ",\n\n nomePaciente=" + nomePaciente + ",\n nomeMedicamento="
				+ nomeMedicamento + ",\n numeroVezes=" + numeroVezes + ",\n rotinaMedicacao=" + rotinaMedicacao
				+ ",\n horario1=" + horario1 + ",\n horario2=" + horario2 + ",\n horario3=" + horario3 + ",\n horario4="
				+ horario4 + ",\n horario5=" + horario5 + ",\n horario6=" + horario6 + ",\n dosagem=" + dosagem
				+ ",\n aspectoMedicamento=" + aspectoMedicamento + ",\n dataInicioTratamento=" + dataInicioTratamento
				+ ",\n dataFimTratamento=" + dataFimTratamento + ",\n observacaoAdicionalPosologia="
				+ observacaoAdicionalPosologia + ",\n codigoPosologia=" + codigoPosologia + "]\n\n\n";
	}

}
