package br.com.getjob.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
*
* @author DanielFilho
*/
@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "profissao_seq", sequenceName = "profissao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissao_seq")
	private Long id;

	@Column(nullable = false, length = 60)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "profissao_pai_id")
	private Profissao profissaoPai;

	@OneToMany(mappedBy = "profissaoPai", cascade = CascadeType.ALL)
	private List<Profissao> niveis = new ArrayList<>();

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

	public Profissao getProfissaoPai() {
		return profissaoPai;
	}

	public void setProfissaoPai(Profissao profissaoPai) {
		this.profissaoPai = profissaoPai;
	}

	public List<Profissao> getNiveis() {
		return niveis;
	}

	public void setNiveis(List<Profissao> niveis) {
		this.niveis = niveis;
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
		Profissao other = (Profissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
