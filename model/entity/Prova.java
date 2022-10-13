package model.entities;


import java.time.LocalDate;
import java.util.Random;

public class Prova {
	private int id;
	private String Questao;
	private String Discplina;
	private LocalDate Data;
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
					setQuestao(getQuestao());
				}
	}
	public String getQuestao() {
		return Questao;
	}
	public void setQuestao(String questao) {
		this.Questao = questao;
	}
	public String getDisciplina() {
		return Discplina;
	}
	public void setDisciplina(String disciplina) {
		this.Discplina = disciplina;
	}
	public LocalDate getData() {
		return Data;
	}
	public void setData(LocalDate data) {
		this.Data = data;
	}
	
	
}
