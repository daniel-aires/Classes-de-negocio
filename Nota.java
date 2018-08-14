package br.com.getjob.model;

public enum Nota {

	UM("1"),
	DOIS("2"),
	TRES("3"),
	QUATRO("4"),
	CINCO("5");
	
	private String descricao;

	Nota(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
