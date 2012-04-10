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
public class Atleta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDF_ATLETA")
	private Integer idf;
	
	private String nome;
	
	@Column(name="DTA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dtaNascimento;
	
	@Column(name="IDF_POSICAO")
	@Enumerated(EnumType.ORDINAL)
	private Posicao posicao;
	
	@ManyToOne
	@JoinColumn(name="IDF_CLUBE")
	private Clube clube;

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
	
	
	
}
