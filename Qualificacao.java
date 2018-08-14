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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Qualificacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "qualificacao_seq", sequenceName = "qualificacao_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qualificacao_seq")
	private Long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
	private Date dataQualificacao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "servico_id", nullable = false)
	private Servico servico;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "qualificado_id", nullable = false)
	private Entidade qualificado;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "qualificante_id", nullable = false)
	private Entidade qualificante;

	@NotBlank
	@Size(max = 200)
	@Column(nullable = false, length = 200)
	private String comentario;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, length = 15)
	private Nota nota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataQualificacao() {
		return dataQualificacao;
	}

	public void setDataQualificacao(Date dataQualificacao) {
		this.dataQualificacao = dataQualificacao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Entidade getQualificado() {
		return qualificado;
	}

	public void setQualificado(Entidade qualificado) {
		this.qualificado = qualificado;
	}

	public Entidade getQualificante() {
		return qualificante;
	}

	public void setQualificante(Entidade qualificante) {
		this.qualificante = qualificante;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
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
		Qualificacao other = (Qualificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
