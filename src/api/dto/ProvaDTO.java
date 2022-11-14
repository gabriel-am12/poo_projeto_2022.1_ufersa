package api.dto;

import java.util.Date;

import model.entity.Disciplina;
import model.entity.Questoes;

public class ProvaDTO {
	private int Id;
	private Date Data;;
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
	
    private Disciplina disciplina;
    
	public Date getData() {
		return Data;
	}
	
	public void setData(Date data) {
		this.Data = data;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setId(int id) {
		this.Id = id;
	}
	public int getId(int id) {
		return id;
	}
}
