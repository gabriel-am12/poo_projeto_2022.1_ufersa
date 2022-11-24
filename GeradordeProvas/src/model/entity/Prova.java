
package model.entity;

import java.util.Date;
import java.util.Random;

import dto.ProvaDTO;


public class Prova {
		private int id;
		private String Discplina;
		private String semestre;
		private String codigo;
		private String nivelUm;
	    private String nivelDois;
	    private String nivelTres; 
	    
		public String getSemestre() {
			return semestre;
		}
		public void setSemestre(String semestre) {
			this.semestre = semestre;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
 
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
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDisciplina() {
			return Discplina;
		}
		public void setDisciplina(String disciplina) {
			this.Discplina = disciplina;
		}
		
		public static Prova converter(ProvaDTO provadto) {
			Prova prova = new Prova();
			prova.setNivelUm(provadto.getNivelUm());
			prova.setNivelDois(provadto.getNivelDois());
			prova.setNivelTres(provadto.getNivelTres());
			prova.setDisciplina(provadto.getDisciplina());
		  	prova.setSemestre(provadto.getSemestre());
		  	prova.setCodigo(provadto.getCodigo());
			return prova;
		}
		
	}

