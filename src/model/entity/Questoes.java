package model.entity;

public abstract class Questoes {
	private int codigo;
	private int tipo;
	private String enunciado;
	private Disciplina disciplina;
	private String assunto;
	private String dificuldade;
	
	public Questoes(int codigo, int tipo, String enunciado, Disciplina disciplina, String assunto, String dificuldade) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.enunciado = enunciado;
		this.disciplina = disciplina;
		this.assunto = assunto;
		this.dificuldade = dificuldade;
	}
	
	public Questoes() {
		
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		if(codigo < 0){
			Math.abs(tipo);
		this.tipo = tipo;
		}else{
		this.tipo = tipo;
		}
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		if(codigo < 0){
			Math.abs(codigo);
		this.codigo = codigo;
		}else{
		this.codigo = codigo;
		}
	}
	
	public String getEnunciado() {
		return enunciado;
	}
	
	public void setEnunciado(String enunciado) {
		if (enunciado == null || enunciado.isEmpty()){
			System.out.println("Dados não validados");
		}else{
			this.enunciado = enunciado;
		}
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		if(disciplina == null){
			System.out.println("Dados não validados");
		}else{
			this.disciplina = disciplina;
		}
	}
	
	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		if (assunto == null || assunto.isEmpty()){
			System.out.println("Dados não validados");
		}else{
			this.assunto = assunto;
		}
	}
	
	public String getDificuldade() {
		return dificuldade;
	}
	
	public void setDificuldade(String dificuldade) {
		if (dificuldade == null || dificuldade.isEmpty()){
			System.out.println("Dados não validados");
		}else{
			this.dificuldade = dificuldade;
		}
	}
	
}
