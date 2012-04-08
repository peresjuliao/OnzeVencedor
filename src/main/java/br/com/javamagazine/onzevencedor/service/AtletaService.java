package br.com.javamagazine.onzevencedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.javamagazine.onzevencedor.dao.AtletaDAO;
import br.com.javamagazine.onzevencedor.entity.Atleta;

@Service("atletaService")
@Transactional
public class AtletaService {

	@Autowired
	private AtletaDAO dao;

	@Transactional
	public List<Atleta> getAllAtletas(){
		return dao.findAll();
	}
	@Transactional
	public List<Atleta> getAtletasByClube(Integer idfClube){
		return dao.findByClube(idfClube);
	}
	@Transactional
	public Atleta createAtleta(Atleta atleta){
		return dao.create(atleta);
	}
	@Transactional
	public void updateAtleta(Atleta atleta){
		dao.update(atleta);
	}
	@Transactional
	public void deleteAtleta(Atleta atleta){
		dao.delete(atleta);
	}
}
