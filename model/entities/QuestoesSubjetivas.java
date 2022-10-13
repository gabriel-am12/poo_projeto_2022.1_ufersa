package br.edu.ufersa.sistemageradordeprova.model.entities;

public class QuestoesSubjetivas extends Questoes {
	private String resposta;

	public QuestoesSubjetivas(int codigo, int tipo, String enunciado, Disciplina disciplina, String assunto,
			String dificuldade, String resposta) {
		super(codigo, tipo, enunciado, disciplina, assunto, dificuldade);
		this.resposta = resposta;
	}
	
	public QuestoesSubjetivas() {
		
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
	
}
