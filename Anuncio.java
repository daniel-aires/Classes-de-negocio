package br.com.getjob.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "anuncio")
public class Anuncio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "anuncio_seq", sequenceName = "anuncio_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anuncio_seq")
	private Long id;

	@Column(precision = 10, scale = 2)
	private BigDecimal taxaAnuncio;

	@Transient
	private static final BigDecimal custoServico = BigDecimal.TEN;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_expiracao")
	private Date dataExpiracao;

	@NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 50)
	private String titulo;

	@NotBlank
	@Size(max = 500)
	@Column(nullable = false, length = 500)
	private String descricao;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicial", nullable = false)
	private Date dataInicial;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_final", nullable = false)
	private Date dataFinal;

	@Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorTotal;

	@DecimalMin(value = "50")
	@Column(name = "valor_final", nullable = false, precision = 10, scale = 2)
	private BigDecimal valor;

	
	private EnderecoLocal enderecoLocal;

	@JoinColumn(name = "contratante_id", nullable = false)
	private Long contratante;

	
	@OneToMany
	private List<Entidade> candidato = new ArrayList<Entidade>();

	@NotNull
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private StatusAnuncio status;

	@OneToMany(mappedBy = "anuncio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Inscricao> inscricoes = new ArrayList<Inscricao>();

	@NotNull
	private String local;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTaxaAnuncio(BigDecimal taxaAnuncio) {
		this.taxaAnuncio = taxaAnuncio;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExpiracao() {
		Calendar dataVencimento = Calendar.getInstance();
		dataVencimento.add(Calendar.DAY_OF_MONTH, 30);
		this.setDataExpiracao(new Date(dataVencimento.getTimeInMillis()));;
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicial() {

		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public BigDecimal getTaxaAnuncio() {
		if (valor != null) {
			this.taxaAnuncio = valor.multiply(custoServico).divide(valor);
		}
		return taxaAnuncio;
	}

	public BigDecimal getValorTotal() {
		if (valor != null && taxaAnuncio != null) {
			this.valorTotal = valor.subtract(taxaAnuncio);
		}
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
	 public EnderecoLocal getEnderecoLocal() { 
		return enderecoLocal; 
	}
	 
	 public void setEnderecoLocal(EnderecoLocal enderecoLocal) {
	 this.enderecoLocal = enderecoLocal; }
	 

	public Long getContratante() {
		return contratante;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setContratante(Long contratante) {
		this.contratante = contratante;
	}

	public List<Entidade> getCandidato() {
		return candidato;
	}

	public void setCandidato(List<Entidade> candidato) {
		this.candidato = candidato;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public StatusAnuncio getStatus() {
		return status;
	}

	public void setStatus(StatusAnuncio status) {
		this.status = status;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
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
		Anuncio other = (Anuncio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	 @Transient 
	public BigDecimal getValorSubtotal() { 
		return this.getValorTotal().subtract(this.getValorTotal()).add(this.taxaAnuncio);
	 }
	
	@Transient
	public boolean isNovo() {
		return getId() == null;
	}

	@Transient
	public boolean isAberto() {
		return StatusAnuncio.ABERTO.equals(this.getStatus());
	}

	@Transient
	private boolean isCancelado() {
		return StatusAnuncio.CANCELADO.equals(this.getStatus());
	}

	@Transient
	private boolean isFinalizado() {
		return StatusAnuncio.FINALIZADO.equals(this.getStatus());
	}

	@Transient
	public boolean isCancelavel() {
		return this.isAberto() && !this.isCancelado();
	}

	@Transient
	public boolean isNaoCancelavel() {
		return !this.isCancelavel();
	}

	@Transient
	public boolean isAlteravel() {
		return this.isAberto();
	}

	@Transient
	public boolean isNaoAlteravel() {
		return !this.isAlteravel();
	}

}
