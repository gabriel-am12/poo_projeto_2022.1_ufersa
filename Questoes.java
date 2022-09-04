package entity;

import java.util.ArrayList;
import java.util.List;

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
	
	//Criação de um array dinamico, com a finalidade de comportar as questões
	
	ArrayList<Questoes> listaDeQuestoes = new ArrayList<>();
	
	//---------------------------------------------------------------------------------------------------------------//
	
	//Criação do construtor de Questoes
	
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
		if(codigo < 0)
			Math.abs(codigo);
		this.codigo = codigo;
		
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
	public String getGabarito() {
		return gabarito;
	}
	public void setGabarito(String gabarito) {
		this.gabarito = gabarito;
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
	public String getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	//---------------------------------------------------------------------------------------------------------------//
	
	//Criando os métodos necessarios para realizar todas as funções (cadastrar, editar , excluir e buscar)
	
	public void cadastrarQuestao(int codigo, int tipo, String enunciado, String gabarito, Disciplina disciplina, String assunto,String dificuldade){
		Questoes questoes;
		questoes = new Questoes(codigo, tipo, enunciado, gabarito, disciplina,assunto,dificuldade);
		listaDeQuestoes.add(questoes);
	} 
	
	//Função extra caso seja necessario mostrar todas as questões
	public void listar() {
		System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
		System.out.println("Enunciado da questão: " + this.enunciado);
		System.out.println("Gabarito da questão: " + this.gabarito);
	}
	
	public void listarQuestao() {
		System.out.println("Listando todas as questões armazenadas: ");
		for (Questoes questoeslista: listaDeQuestoes) {
			questoeslista.listar();
		}
	}
	
	public void buscarQuestoesPorAssunto(String assunto) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.assunto == assunto) {
				System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
				System.out.println("Enunciado da questão: " + this.enunciado);
				System.out.println("Gabarito da questão: " + this.gabarito);
			}
		}
	}
	
	public void buscarQuestoesPorDisciplina(Disciplina disciplina) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.disciplina == disciplina) {
				System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
				System.out.println("Enunciado da questão: " + this.enunciado);
				System.out.println("Gabarito da questão: " + this.gabarito);
			}
		}
	}
	
	public void buscarQuestoesPorDificuldade(String dificuldade) {
		for(Questoes questoes : listaDeQuestoes) {
			if(questoes.dificuldade == dificuldade) {
				System.out.println("Questao de codigo " + this.codigo + " referente a disciplina " + this.disciplina + " sobre " + this.assunto + " do tipo " + this.tipo + " de dificuldade " + this.dificuldade);
				System.out.println("Enunciado da questão: " + this.enunciado);
				System.out.println("Gabarito da questão: " + this.gabarito);
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
