package model.entity;

import java.util.ArrayList;

public class Questoes{
	//Atributos da classe "Questoes"
	private int codigo;
	private int tipo;
	private String enunciado;
	private String gabarito;
	private Disciplina disciplina;
	private String assunto;
	private String dificuldade;
	
	//---------------------------------------------------------------------------------------------------------------//
	
	//Cria��o de um array dinamico, com a finalidade de comportar as quest�es
	
	ArrayList<Questoes> listaDeQuestoes = new ArrayList<>();
	
	//---------------------------------------------------------------------------------------------------------------//
	
	//Cria��o do construtor de Questoes
	
	public Questoes(){

	}
	
	public Questoes(int codigo, int tipo, String enunciado, String gabarito, Disciplina disciplina, String assunto,String dificuldade) {
		setCodigo(codigo);
		setTipo(tipo);
		setEnunciado(enunciado);
		setGabarito(gabarito);
		setAssunto(assunto);
		setDificuldade(dificuldade);
		setDisciplina(disciplina);
		
		getCodigo();
		getTipo();
		getEnunciado();
		getGabarito();
		getAssunto();
		getDificuldade();
		getDisciplina();
	}
	
	//---------------------------------------------------------------------------------------------------------------//
	
	//Criando os Gets e os Sets
	
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		if(tipo < 0){
			Math.abs(tipo);
		this.tipo = tipo;
		}else{
			this.tipo = tipo;
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
	public String getGabarito() {
		return gabarito;
	}
	public void setGabarito(String gabarito) {
		if (gabarito == null || gabarito.isEmpty()){
			System.out.println("Dados não validados");
		}else{
			this.gabarito = gabarito;
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
	
	//---------------------------------------------------------------------------------------------------------------//
	
	//Criando os m�todos necessarios para realizar todas as fun��es (cadastrar, editar , excluir e buscar)
	
	public void cadastrarQuestao(int codigo, int tipo, String enunciado, String gabarito, Disciplina disciplina, String assunto,String dificuldade){
		Questoes questoes;
		questoes = new Questoes(codigo, tipo, enunciado, gabarito, disciplina,assunto,dificuldade);
		listaDeQuestoes.add(questoes);
	} 
	
	//Fun��o extra caso seja necessario mostrar todas as quest�es
	public void listar() {
		System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
		System.out.println("Enunciado da quest�o: " + this.enunciado);
		System.out.println("Gabarito da quest�o: " + this.gabarito);
	}
	
	public void listarQuestao() {
		System.out.println("Listando todas as quest�es armazenadas: ");
		for (Questoes questoeslista: listaDeQuestoes) {
			questoeslista.listar();
		}
	}
	
	public void buscarQuestoesPorAssunto(String assunto) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.assunto == assunto) {
				System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
				System.out.println("Enunciado da quest�o: " + this.enunciado);
				System.out.println("Gabarito da quest�o: " + this.gabarito);
			}
		}
	}
	
	public void buscarQuestoesPorDisciplina(Disciplina disciplina) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.disciplina == disciplina) {
				System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
				System.out.println("Enunciado da quest�o: " + this.enunciado);
				System.out.println("Gabarito da quest�o: " + this.gabarito);
			}
		}
	}
	
	public void buscarQuestoesPorDificuldade(String dificuldade) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.dificuldade == dificuldade) {
				System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
				System.out.println("Enunciado da quest�o: " + this.enunciado);
				System.out.println("Gabarito da quest�o: " + this.gabarito);
			}
		}
	}
	
	
	public void editarQuestao(int codigo) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.codigo == codigo) {
				questoes.assunto = assunto;
				questoes.dificuldade = dificuldade;
				questoes.enunciado = enunciado;
				questoes.gabarito = gabarito;
				questoes.tipo = tipo;
				
				listaDeQuestoes.set(codigo, questoes);
			}
		}
	}
	
	public void removerQuestao(int codigo) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.codigo == codigo) {
				listaDeQuestoes.remove(questoes);
			}
		}
	}
	
	
}
