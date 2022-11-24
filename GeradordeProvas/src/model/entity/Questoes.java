package model.entity;

public abstract class Questoes {
	private int id;
	private int idDisciplina;
	private String codigo;
	private int tipo;
	private String enunciado;
	private String disciplina;
	private String assunto;
	private String dificuldade;
	
	public Questoes(String codigo, int tipo, String enunciado, String disciplina, String assunto, String dificuldade) {
		setCodigo(codigo);
		setTipo(tipo);
		setEnunciado(enunciado);
		setDisciplina(disciplina);
		setAssunto(assunto);
		setDificuldade(dificuldade);
	}
	
	public Questoes() {
		
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		if (tipo > 0 && tipo < 5) {
			this.tipo = tipo;
		} else {
			this.tipo = 0;
		}
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()){
			System.out.println("Dados não validados");
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
	
	public String getDisciplina() {
		return disciplina;
	}
	
	public int getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	public void setDisciplina(String disciplina) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
