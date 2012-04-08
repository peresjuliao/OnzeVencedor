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
public class Clube implements Serializable {

	private static final long serialVersionUID = -8148341461939869086L;
	
	@Id
	@Column(name="IDF_CLUBE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idf;
	
	@Column(name = "NOME")
	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="clube")
	private List<Atleta> atletas;
	
    public Clube() {
		
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

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
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
		Clube other = (Clube) obj;
		if (idf == null) {
			if (other.idf != null)
				return false;
		} else if (!idf.equals(other.idf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clube [idf=" + idf + ", nome=" + nome + ", atletas=" + atletas
				+ "]";
	}
    
    

}
