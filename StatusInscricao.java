package br.com.getjob.model;

public enum StatusInscricao {

	INSCRITO("Inscrito"),
	SELECIONADO("Selecionado"),
	NAO_SELECIODADO("Não Selecionado");
	
	private String descricao;

	StatusInscricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
