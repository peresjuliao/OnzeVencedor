package br.com.javamagazine.onzevencedor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Atleta implements Serializable {

	private static final long serialVersionUID = -370016001147031854L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDF_ATLETA")
	private Integer idf;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DTA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dtaNascimento;
	
	@Column(name = "IDF_POSICAO")
	@Enumerated(EnumType.ORDINAL)
	private Posicao posicao;
	
	@ManyToOne
	@JoinColumn(name = "IDF_CLUBE")
	private Clube clube;
	
	public Atleta() {
		
	}

	public Integer getIdf() {
		return idf;
	}

	public void setIdf(Integer idf) {
		this.idf = idf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtaNascimento() {
		return dtaNascimento;
	}

	public void setDtaNascimento(Date dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idf == null) ? 0 : idf.hashCode());
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
		Atleta other = (Atleta) obj;
		if (idf == null) {
			if (other.idf != null)
				return false;
		} else if (!idf.equals(other.idf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atleta [idf=" + idf + ", nome=" + nome + ", dtaNascimento="
				+ dtaNascimento + ", posicao=" + posicao + ", clube=" + clube
				+ "]";
	}
	
	

}
