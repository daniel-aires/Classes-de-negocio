package br.com.getjob.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Inscricao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "inscricao_seq", sequenceName = "inscricao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscricao_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "anuncio_id", nullable = false)
	private Anuncio anuncio;

	@NotNull
	@ManyToOne
	private Entidade candidato;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inscricao", nullable = false)
	private Date dataInsricao;

	@NotNull
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private StatusInscricao situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Entidade getCandidato() {
		return candidato;
	}

	public void setCandidato(Entidade candidato) {
		this.candidato = candidato;
	}

	public Date getDataInsricao() {
		return dataInsricao;
	}

	public void setDataInsricao(Date dataInsricao) {
		this.dataInsricao = dataInsricao;
	}

	public StatusInscricao getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusInscricao situacao) {
		this.situacao = situacao;
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
		Inscricao other = (Inscricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
