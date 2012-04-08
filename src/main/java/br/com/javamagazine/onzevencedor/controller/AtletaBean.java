package br.com.javamagazine.onzevencedor.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.javamagazine.onzevencedor.entity.Atleta;
import br.com.javamagazine.onzevencedor.entity.Clube;
import br.com.javamagazine.onzevencedor.entity.Posicao;
import br.com.javamagazine.onzevencedor.service.AtletaService;
import br.com.javamagazine.onzevencedor.service.ClubeService;

@ManagedBean(name="atletaBean")
@ViewScoped
public class AtletaBean extends BaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Atleta atleta;
	private List<Clube> clubes;
	private boolean editMode;
	private Integer idfClube;
	private Integer filtroIdfClube;
	private List<Atleta> atletas;

	@ManagedProperty("#{clubeService}")
	private ClubeService clubeService;
	
	@ManagedProperty("#{atletaService}")
	private AtletaService atletaService;
	
	public void salvar(){

		Clube clube = new Clube();
		clube.setIdf(idfClube);
		atleta.setClube(clube);
		if(atleta.getIdf() == null || atleta.getIdf().intValue() == 0){
			atletaService.createAtleta(atleta);
			addInfoMessage("Atleta criado com sucesso");
			atleta = new Atleta();
		}
		else{
			atletaService.updateAtleta(atleta);
			addInfoMessage("Atleta alterado com sucesso");
		}
		
	}
	
	public void create(){
		this.atleta = new Atleta();
		this.editMode = true;
	}
	
	public void update(){
		idfClube = atleta.getClube().getIdf();
		this.editMode = true;
	}
	
	public void cancel(){
		this.editMode = false;
		filtroIdfClube = null;
		atletas = atletaService.getAllAtletas();
	}
	
	public void delete(){
		atletaService.deleteAtleta(atleta);
		System.out.println("deletou");
		if(filtroIdfClube == null || filtroIdfClube.intValue() == 0)
			atletas = atletaService.getAllAtletas();
		else
			atletas = atletaService.getAtletasByClube(filtroIdfClube);
		System.out.println("Atletas " +atletas.size());
	}
	
	public void filtrarAtletaPorClube(AjaxBehaviorEvent event){
		System.out.println("Filtro idf Clube :" +filtroIdfClube);
		if(filtroIdfClube != null){
			atletas = atletaService.getAtletasByClube(filtroIdfClube);
		}else{
			atletas = atletaService.getAllAtletas();
		}
	}

	
	public Atleta getAtleta() {
		if(atleta == null){
			atleta = new Atleta();
		}
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public Posicao[] getPosicoes() {
		return Posicao.values();
	}
	public List<Clube> getClubes() {
		if(clubes == null){
			clubes = clubeService.getAllClubes();
		}
		return clubes;
	}
	public void setClubes(List<Clube> clubes) {
		this.clubes = clubes;
	}
	public ClubeService getClubeService() {
		return clubeService;
	}
	public void setClubeService(ClubeService clubeService) {
		this.clubeService = clubeService;
	}


	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public Integer getIdfClube() {
		return idfClube;
	}

	public void setIdfClube(Integer idfClube) {
		this.idfClube = idfClube;
	}

	public AtletaService getAtletaService() {
		return atletaService;
	}

	public void setAtletaService(AtletaService atletaService) {
		this.atletaService = atletaService;
	}

	public Integer getFiltroIdfClube() {
		return filtroIdfClube;
	}

	public void setFiltroIdfClube(Integer filtroIdfClube) {
		this.filtroIdfClube = filtroIdfClube;
	}

	public List<Atleta> getAtletas() {
		if(atletas == null){
			atletas = atletaService.getAllAtletas();
		}
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}
}