package model.entity; 
import java.util.ArrayList;

import dto.DisciplinaDTO;

public class Disciplina {
	private int id;
	private String codigo;
	private String nome;
	private String assunto;

  ArrayList<Disciplina> listaDeDisciplinas = new ArrayList<Disciplina>();

  //set de nome
  public void setNome(String nome) {
    this.nome = nome;
  }

  //get de nome
  public String getNome() {
    return nome;
  }

  //codigo não pode ser negativo
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  // get de codigo
  public String getCodigo() {
    return codigo;
  }

  // set de assunto
  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  //get de assunto
  public String getAssunto() {
    return assunto;
  }

  // Disciplina
  public static Disciplina converter (DisciplinaDTO disciplinadto) {
	  	Disciplina disciplina = new Disciplina();
	  	disciplina.setCodigo(disciplinadto.getCodigo());
	  	disciplina.setAssunto(disciplinadto.getAssuntos());
	  	disciplina.setNome(disciplinadto.getNome());
	  	disciplina.setId(disciplinadto.getId());
	  return disciplina;
  }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Disciplina(int id, String codigo, String nome, String assunto, ArrayList<Disciplina> listaDeDisciplinas) {
	super();
	this.id = id;
	this.codigo = codigo;
	this.nome = nome;
	this.assunto = assunto;
	this.listaDeDisciplinas = listaDeDisciplinas;
}

@Override
public String toString() {
	return "Disciplina [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", assunto=" + assunto
			+ ", listaDeDisciplinas=" + listaDeDisciplinas + "]";
}

public Disciplina(){
	
}



}
