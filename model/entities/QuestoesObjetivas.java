package br.edu.ufersa.sistemageradordeprova.model.entities;

public class QuestoesObjetivas extends Questoes {
	private String opcao01;
	private String opcao02;
	private String opcao03;
	private String opcao04;
	private String opcao05;
	private String resposta;
	
	public QuestoesObjetivas(int codigo, int tipo, String enunciado, Disciplina disciplina, String assunto,
			String dificuldade, String opcao01, String opcao02, String opcao03, String opcao04, String opcao05,
			String resposta) {
		super(codigo, tipo, enunciado, disciplina, assunto, dificuldade);
		this.opcao01 = opcao01;
		this.opcao02 = opcao02;
		this.opcao03 = opcao03;
		this.opcao04 = opcao04;
		this.opcao05 = opcao05;
		this.resposta = resposta;
	}
	
	public QuestoesObjetivas() {
		
	}
	public String getOpcao01() {
		return opcao01;
	}
	public void setOpcao01(String opcao01) {
		this.opcao01 = opcao01;
	}
	public String getOpcao02() {
		return opcao02;
	}
	public void setOpcao02(String opcao02) {
		this.opcao02 = opcao02;
	}
	public String getOpcao03() {
		return opcao03;
	}
	public void setOpcao03(String opcao03) {
		this.opcao03 = opcao03;
	}
	public String getOpcao04() {
		return opcao04;
	}
	public void setOpcao04(String opcao04) {
		this.opcao04 = opcao04;
	}
	public String getOpcao05() {
		return opcao05;
	}
	public void setOpcao05(String opcao05) {
		this.opcao05 = opcao05;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
