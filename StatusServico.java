package br.com.getjob.model;

public enum StatusServico {

	AGUARDANDO_INICIO("Aguardando inicio"),
	EM_ANDAMENTO("Em andamento"),
	FINALIZADO("Finalizado");
	
	private String descricao;

	StatusServico(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
