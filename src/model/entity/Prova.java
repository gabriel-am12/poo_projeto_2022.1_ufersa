package model.entity;

import java.util.Date;
import java.util.Random;

import api.dto.ProvaDTO;


public class Prova {
	private int id;
	
	private Disciplina Discplina;
	private Date Data;
	private int nivelUm;
    private int nivelDois;
    private int nivelTres; 
    public int getNivelUm() {
		return nivelUm;
	}
	public void setNivelUm(int nivelUm) {
		this.nivelUm = nivelUm;
	}
	public int getNivelDois() {
		return nivelDois;
	}
	public void setNivelDois(int nivelDois) {
		this.nivelDois = nivelDois;
	}
	public int getNivelTres() {
		return nivelTres;
	}
	public void setNivelTres(int nivelTres) {
		this.nivelTres = nivelTres;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Disciplina getDisciplina() {
		return Discplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.Discplina = disciplina;
	}
	public java.sql.Date getData() {
		return (java.sql.Date) Data;
	}
	public void setData(Date data) {
		this.Data = data;
	}
	
	public Prova converter(ProvaDTO provadto) {
		Prova prova = new Prova();
		prova.setNivelUm(provadto.getNivelUm());
		prova.setNivelDois(provadto.getNivelDois());
		prova.setNivelTres(provadto.getNivelTres());
	  	prova.setDisciplina(provadto.getDisciplina());
	  	prova.setData(provadto.getData());
		return prova;
	}
	
}
