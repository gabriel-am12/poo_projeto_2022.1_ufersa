package model.entity; 
import java.util.ArrayList;

import api.dto.DisciplinaDTO;

public class Disciplina {
  private int codigo;
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
  public void setCodigo(int codigo) {
    if(codigo < 0)
      Math.abs(codigo); // usando Math.abs para deixar o valor absoluto
      this.codigo = codigo;

    this.codigo = codigo;
  }

  // get de codigo
  public int getCodigo() {
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
	  	disciplina.setAssunto(disciplinadto.getAssuntos());
	  	disciplina.setNome(disciplinadto.getNome());
	  return disciplina;
  }
}