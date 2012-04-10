package br.com.javamagazine.onzevencedor.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Clube implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDF_CLUBE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idf;
	
	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="clube")
	private List<Atleta> atletas;
	
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

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	@Override
	public String toString() {
		if(idf != null)
			return idf.toString();
		else
			return "";
	}
	
}
