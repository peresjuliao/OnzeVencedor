package br.com.javamagazine.onzevencedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.javamagazine.onzevencedor.dao.AtletaDAO;
import br.com.javamagazine.onzevencedor.entity.Atleta;

@Service("atletaService")
public class AtletaService {

	@Autowired
	private AtletaDAO dao;

	public List<Atleta> getAllAtletas(){
		return dao.findAll();
	}
	public List<Atleta> getAtletasByClube(Integer idfClube){
		return dao.findByClube(idfClube);
	}
	public Atleta createAtleta(Atleta atleta){
		return dao.create(atleta);
	}
	public void updateAtleta(Atleta atleta){
		dao.update(atleta);
	}
	public void deleteAtleta(Atleta atleta){
		dao.delete(atleta);
	}
}
