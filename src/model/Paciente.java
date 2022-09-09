package model;

import java.util.ArrayList;

public class Paciente extends Pessoa {

	private final ArrayList<Posologia> posologias;

	public Paciente(String nomePaciente, String cpf, String dataNascimento, String telefone, String genero,
			String observacaoAdicionalPaciente) {
		super(nomePaciente, cpf, dataNascimento, telefone, genero, observacaoAdicionalPaciente);

		this.posologias = new ArrayList<>();

	}

	public ArrayList<Posologia> getPosologias() {
		return posologias;
	}

	@Override
	public String toString() {
		return super.toString() + "-------------------------------------> Paciente [rotinas=" + posologias + "]"
				+ "\n\n\n";
	}

}
