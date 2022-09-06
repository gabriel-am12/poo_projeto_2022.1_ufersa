package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Prova{
private LocalDate dataCriacao;
private Disciplina disciplina;
private Questoes questoes;
private static int codigo;

public Prova getProva(int codigo){
    for(Prova provaRetorno : provas){
        if(provaRetorno.codigo.equals(codigo)){
            return provaRetorno;
        } 
    }
}

private void quantquestoes(int qntquestoes) {
    Random gerador = new Random();
            for(int x; qntquestoes > x; x++){
                int y = gerador.nextInt(codigo);
                setQuestao(getQuestao(y));
            }
}


List<Prova> provas = new ArrayList <Prova>();

public List<Prova> buscarProvaPorDisciplina(Disciplina disciplina){
    List<Prova> listaRetorno = new ArrayList <Prova>(); //Criando uma lista para salvar todos os elementos necessários na hora do return 

    for(Prova provinha : provas){
        if(provinha.disciplina.equals(disciplina)){ //fazendo o teste
            System.out.println(provinha.disciplina);
            System.out.println(provinha.questoes);
            System.out.println(provinha.dataCriacao);

            listaRetorno.add(provinha); //adicionando a provinha a lista de retorno
        }


    }
    return listaRetorno;
}


public List<Prova> buscarProvaPorSemestre(LocalDate Dia){
    List<Prova> listaRetorno = new ArrayList <Prova>();

    for(Prova provinha : provas){
        if(provinha.dataCriacao.equals(Dia)){
            System.out.println(provinha.disciplina);
            System.out.println(provinha.questoes);
            System.out.println(provinha.dataCriacao);

            listaRetorno.add(provinha);
        } 
    }
    return listaRetorno;
}

public void cadastrarProva (int codigo, Disciplina disciplina, int qntquestoes, LocalDate data ){
    int dificuldadeVezes;
    Prova provinhaNova = new Prova();
    if(codigo < 0 ||  disciplina == null || qntquestoes < 0 || data == null){
            provinhaNova.disciplina = disciplina;
            provinhaNova.dataCriacao = data;
            quantquestoes(qntquestoes);
            provinhaNova.codigo = codigo++; 
    }
    else{
        provinhaNova.codigo = codigo++;
        provinhaNova.disciplina = setDisciplina();
        provinhaNova.questoes = setQuestao();

    }
    provas.add(provinhaNova);
} 

public void removerProva (int codigo){
            codigo--;
            provas.remove(codigo);
    }

public void editarProva (int codigo, Disciplina disciplina, int qntquestoes, LocalDate data ){
    int dificuldadeVezes; 
    for(Prova provinhaNova : provas){
        if(provinhaNova.codigo.equals(codigo)){
            provinhaNova.disciplina = disciplina;
            provinhaNova.dataCriacao = data;
            quantquestoes(qntquestoes);

            provas.set(codigo, provinhaNova);
        } 
    }
}

public List<Prova> gerarRelatório(){
    List<Prova> listaRetorno = new ArrayList <Prova>();
    for(Prova provinha : provas){
            System.out.println(provinha.codigo);
            System.out.println(provinha.disciplina);
            System.out.println(provinha.questoes);
            System.out.println(provinha.dataCriacao);

            listaRetorno.add(provinha);
        } 
    return listaRetorno;
}

public List<Prova> buscarProvaPorCodigo(int codigo){
    List<Prova> listaRetorno = new ArrayList <Prova>();

    for(Prova provinha : provas){
        if(provinha.codigo.equals(codigo)){
            System.out.println(provinha.disciplina);
            System.out.println(provinha.questoes);
            System.out.println(provinha.dataCriacao);

            listaRetorno.add(provinha);
        } 
    }
    return listaRetorno;
}
}


