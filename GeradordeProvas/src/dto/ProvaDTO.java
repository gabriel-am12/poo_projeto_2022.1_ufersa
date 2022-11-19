package dto;

import java.util.Date;

import model.entity.Disciplina;
import model.entity.Questoes;

public class ProvaDTO {
	private int Id;
	private int idDisciplina;
	private String Data;;
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
	
	public String getData() {
		return Data;
	}
	
	public void setData(String data) {
		this.Data = data;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(int disciplina) {
		this.idDisciplina = disciplina;
	}

	public void setId(int id) {
		this.Id = id;
	}
	public int getId(int id) {
		return Id;
	}
}
