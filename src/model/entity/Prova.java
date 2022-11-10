package model.entity;

import java.util.Date;
import java.util.Random;


public class Prova {
	private int id;
	private Questoes Questao;
	private Disciplina Discplina;
	private Date Data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private void quantQuestoes(int qntquestoes) {
		Random gerador = new Random();
		int y = 0;
				for(int x = 0; qntquestoes < x; x++){
					y = gerador.nextInt(qntquestoes);
					setQuestao(findbyId(y));
				}
	}
	public Questoes getQuestao() {
		return Questao;
	}
	public void setQuestao(Questoes questao) {
		this.Questao = questao;
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
	
	
}
