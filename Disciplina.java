import java.util.ArrayList;

public class Disciplina {
  private String nome;
  private int codigo;
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
  public Disciplina(String nome, int codigo, String assunto) {
    setNome(nome);
    getNome();
    setCodigo(codigo);
    getCodigo();
    setAssunto(assunto);
    getAssunto();
  }

  // metodo para cadastrar uma disciplina
  public void cadastrarDisciplina(String nome, int codigo, String assunto) {
    Disciplina disciplina;
    disciplina = new Disciplina(nome, codigo, assunto );
    listaDeDisciplinas.add(disciplina);
  }

  // metodo para editar uma disciplina
  public void editarDisciplina(String nome, int codigo, String assunto) {
    for(Disciplina disciplina : listaDeDisciplinas) {
      if(disciplina.codigo == codigo) {
        disciplina.nome = nome;
        disciplina.codigo = codigo;
        disciplina.assunto = assunto;

        listaDeDisciplinas.set(codigo, disciplina);
      }
    }
  }

  // metodo para remover uma disciplina
  public void removerDisciplina(int codigo) {
    for(Disciplina disciplina : listaDeDisciplinas) {
      if(disciplina.codigo == codigo) {
        listaDeDisciplinas.remove(disciplina);
      }
    }
  }
  
}