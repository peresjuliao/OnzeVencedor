package br.com.javamagazine.onzevencedor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.javamagazine.onzevencedor.entity.Atleta;

@Repository("atletaDao")
public class AtletaDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;

	public void setEntityManager(
			EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Atleta> findAll(){
		String jpql = " SELECT at from Atleta at order by at.nome";
		Query query = entityManager.createQuery(jpql);
		List<Atleta> atletas = (List<Atleta>) query.getResultList();
		return atletas;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Atleta> findByClube(Integer idfClube){
		String jpql = " SELECT at from Atleta at" +
				" JOIN at.clube c" +
				" WHERE c.idf = :idfClube " +
				" ORDER BY at.nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("idfClube", idfClube);
		List<Atleta> atleta = (List<Atleta>) query.getResultList();
		return atleta;
	}

	@Transactional
	public Atleta create(Atleta atleta){
		entityManager.persist(atleta);
		return atleta;
	}

	@Transactional
	public void update(Atleta atleta){
		entityManager.merge(atleta);
	}

	@Transactional
	public void delete(Atleta atleta){
		atleta = entityManager.find(Atleta.class, atleta.getIdf());
		entityManager.remove(atleta);
	}
}