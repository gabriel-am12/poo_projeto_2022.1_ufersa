
package model.entity;

import java.util.Date;
import java.util.Random;

import dto.ProvaDTO;


public class Prova {
		private int id;
		private int IdDisciplina;
		private String Data;
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
		public int getIdDisciplina() {
			return IdDisciplina;
		}
		public void setIdDisciplina(int disciplina) {
			this.IdDisciplina = disciplina;
		}
		public String getData() {
			return Data;
		}
		public void setData(String data) {
			this.Data = data;
		}
		
		public Prova converter(ProvaDTO provadto) {
			Prova prova = new Prova();
			prova.setNivelUm(provadto.getNivelUm());
			prova.setNivelDois(provadto.getNivelDois());
			prova.setNivelTres(provadto.getNivelTres());
		  	prova.setIdDisciplina(provadto.getIdDisciplina());
		  	prova.setData(provadto.getData());
			return prova;
		}
		
	}

