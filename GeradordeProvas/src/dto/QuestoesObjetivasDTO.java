package dto;

import model.entity.Disciplina;

public class QuestoesObjetivasDTO {
	private int id;
	private int idDisciplina;
	private String codigo;
	private int tipo;
	private String enunciado;
	private Disciplina disciplina;
	private String assunto;
	private int dificuldade;
	private String opcao01;
	private String opcao02;
	private String opcao03;
	private String opcao04;
	private String opcao05;
	private String resposta;

	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
