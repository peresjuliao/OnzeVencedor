package br.com.javamagazine.onzevencedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.javamagazine.onzevencedor.dao.ClubeDAO;
import br.com.javamagazine.onzevencedor.entity.Clube;

@Service("clubeService")
@Transactional
public class ClubeService {
	
	@Autowired
	private ClubeDAO dao;
	
	@Transactional
	public List<Clube> getAllClubes(){
		
		return dao.findAll();
		
	}
	@Transactional
	public List<Clube> getClubesByName(String nomeClube){
		
		return dao.findByName(nomeClube);
		
	}

	@Transactional
	public Clube createClube(Clube clube){
		
		return dao.create(clube);
		
	}

	@Transactional
	public void updateClube(Clube clube){
		
		dao.update(clube);
		
	}

	@Transactional
	public void deleteClube(Clube clube){
		
		dao.delete(clube);
		
	}

	@Transactional
	public void setDao(ClubeDAO dao) {
		this.dao = dao;
	}

}
