package model.entity; 
import java.util.ArrayList;

import Dto.DisciplinaDTO;

public class Disciplina {
	private int id;
	private String codigo;
	private String nome;
	private String assuntos;

  ArrayList<Disciplina> listaDeDisciplinas = new ArrayList<Disciplina>();

  
  //set de nome
  public void setNome(String nome) {
	  if(nome != null && !nome.isEmpty())
		  this.nome = nome;
  }

  //get de nome
  public String getNome() {
    return nome;
  }

  //codigo não pode ser negativo
  public void setCodigo(String codigo) {
	  if(codigo != null && !codigo.isEmpty())
		  this.codigo = codigo;
  }

  // get de codigo
  public String getCodigo() {
    return codigo;
  }

  // set de assunto
  public void setAssuntos(String assuntos) {
	  if(assuntos != null && !assuntos.isEmpty())
		  this.assuntos = assuntos;
  }

  //get de assunto
  public String getAssuntos() {
    return assuntos;
  }


public int getId() {
	return id;
}

public void setId(int id) {
	if(id < 0){
		Math.abs(id);
		this.id = id;
		}else{
		this.id = id;
		}
}

//CRIAÇÃO DE ALGUNS CONSTRUTORES

	public Disciplina(int id, String codigo, String nome, String assunto) {
		setId(id);
		setCodigo(codigo);
		setNome(nome);
		setAssuntos(assunto);
	}
  
  public Disciplina() {
  	
  }

  public Disciplina(String codigo, String nome) {
  	setCodigo(codigo);
  	setNome(nome);
  }
  
//METODO TOSTRING PARA PRINTAR TODAS AS INFORMAÇÕES NA TELA NA HOJE DOS TESTES
  
  public String toString() {
  	String frase="";
  	frase = "\nId = " + this.id;
  	frase = frase + "\nCodigo = " + this.codigo;
  	frase = frase + "\nNome = " + this.nome;
  	frase = frase + "\nAssunto = " + this.assuntos;
  	return frase;
  }
  
  public static Disciplina converter(DisciplinaDTO dto) {
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(dto.getCodigo());
		disciplina.setNome(dto.getNome());
		disciplina.setAssuntos(dto.getAssuntos());
		return disciplina;
	}

}
