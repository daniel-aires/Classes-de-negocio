package br.com.getjob.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import br.com.getjob.model.validation.FisicaGroup;
import br.com.getjob.model.validation.JuridicaGroup;

@Entity
public class Entidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "entidade_seq", sequenceName = "entidade_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entidade_seq")
	private Long id;

	@NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 20)
	private String nome;

	@Email
	@NotBlank
	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 20)
	private String senha;
	
	//@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@ManyToMany
	@JoinTable(name = "entidade_grupo", joinColumns = @JoinColumn(name = "entidade_id"), inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<Grupo> grupos = new ArrayList<>();

	@NotNull
	@Min(18)
	@Column(nullable = false, length = 2)
	private Integer idade;

	private String foto;

	@CNPJ(groups = JuridicaGroup.class)
	@CPF(groups = FisicaGroup.class)
	@NotNull
	@Column(name = "documento_receita_federal", nullable = false, length = 14)
	private String documentoReceitaFederal;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco = new Endereco();

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "telefone_id", nullable = false)
	private Telefone telefone = new Telefone();

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private TipoEntidade tipoEntidade;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private TipoUsuario tipoUsuario;

	@ManyToOne
	@JoinColumn(name = "profissao_id", nullable = false)
	private Profissao profissoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}

	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public TipoEntidade getTipoEntidade() {
		return tipoEntidade;
	}

	public void setTipoEntidade(TipoEntidade tipoEntidade) {
		this.tipoEntidade = tipoEntidade;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Profissao getProfissoes() {
		return profissoes;
	}

	public void setProfissoes(Profissao profissoes) {
		this.profissoes = profissoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidade other = (Entidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
