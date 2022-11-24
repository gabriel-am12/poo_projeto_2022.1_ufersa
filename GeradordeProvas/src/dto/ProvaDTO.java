package dto;

import java.util.Date;

import model.entity.Disciplina;
import model.entity.Questoes;

public class ProvaDTO {
	private int id;
	private String semestre;
	private String codigo;
    private String nivelUm;
    private String nivelDois;
    private String nivelTres;
    private String disciplina;
    
    public String getNivelUm() {
		return nivelUm;
	}

	public void setNivelUm(String nivelUm) {
		this.nivelUm = nivelUm;
	}

	public String getNivelDois() {
		return nivelDois;
	}

	public void setNivelDois(String nivelDois) {
		this.nivelDois = nivelDois;
	}

	public String getNivelTres() {
		return nivelTres;
	}

	public void setNivelTres(String nivelTres) {
		this.nivelTres = nivelTres;
	}
    
	public String getSemestre() {
		return semestre;
	}
	
	public void setSemestre(String data) {
		this.semestre = data;
	}
	public String getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(String string) {
		this.disciplina = string;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId(int id) {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
