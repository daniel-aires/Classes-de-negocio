package br.com.getjob.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class EnderecoLocal implements Serializable {

	private static final long serialVersionUID = 1L;
    
    @Size(max = 150)
    @Column(name = "servico_logradouro", nullable = false, length = 150)
	private String logradouro;

    @Size(max = 20)
    @Column(name = "servico_numero", nullable = false, length = 10)
	private String numero;

    @Size(max = 150)
    @Column(name = "servico_complemento", length = 150)
	private String complemento;

    @Size(max = 150)
    @Column(name = "servico_bairro", length = 150)
	private String bairro;

    @NotBlank
    @Size(max = 60)
    @Column(name = "servico_cidade", nullable = false, length = 60)
	private String cidade;


    @Size(max = 60)
    @Column(name = "servico_uf", nullable = false, length = 60)
	private String uf;

    @Size(max = 9)
    @Column(name = "servico_cep", nullable = false, length = 9)
	private Long cep;


	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

}
