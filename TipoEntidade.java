package br.com.getjob.model;

public enum TipoEntidade {

	CONTRATANTE("Contratante"), CONTRATADO("Contratado"), CANDIDATO("Candidato"), 
	FUNCIONARIO("Funcionário"), ADMINISTRADOR("Administrador"), USUARIO("Usuário");

	private String descricao;

	TipoEntidade(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
