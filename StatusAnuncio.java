package br.com.getjob.model;

public enum StatusAnuncio {
	
	CRIADO("Criado"),
	ABERTO("Aberto"),
	ALTERADO("Alterado"),
	EXPIRADO("Expirado"),
	BLOQUEADO("Bloqueado"),
	FINALIZADO("Finalizado"),
	DELETADO("Deletado"),
	CANCELADO("Cancelado");
	
	private String descricao;

	StatusAnuncio(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
