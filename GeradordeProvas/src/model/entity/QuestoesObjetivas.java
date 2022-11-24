package model.entity;
import java.util.ArrayList;

import dto.DisciplinaDTO;
import dto.QuestoesObjetivasDTO;

public class QuestoesObjetivas extends Questoes {
	private String opcao01;
	private String opcao02;
	private String opcao03;
	private String opcao04;
	private String opcao05;
	private String resposta;

	public QuestoesObjetivas(String codigo, int tipo, String enunciado, String disciplina, String assunto,
			String dificuldade) {
		super(codigo, tipo, enunciado, disciplina, assunto, dificuldade);
		// TODO Auto-generated constructor stub
	}

	public QuestoesObjetivas() {
		
	}
	
	public String getOpcao01() {
		return opcao01;
	}
	
	public void setOpcao01(String opcao01) {
		if (opcao01 == null || opcao01.isEmpty()){
			System.out.println("Dados n�o validados");
		}else{
			this.opcao01 = opcao01;
		}
	}
	
	public String getOpcao02() {
		return opcao02;
	}
	
	public void setOpcao02(String opcao02) {
		if (opcao02 == null || opcao02.isEmpty()){
			System.out.println("Dados n�o validados");
		}else{
			this.opcao02 = opcao02;
		}
	}
	
	public String getOpcao03() {
		return opcao03;
	}
	
	public void setOpcao03(String opcao03) {
		if (opcao03 == null || opcao03.isEmpty()){
			System.out.println("Dados n�o validados");
		}else{
			this.opcao03 = opcao03;
		}
	}
	
	public String getOpcao04() {
		return opcao04;
	}
	
	public void setOpcao04(String opcao04) {
		if (opcao04 == null || opcao04.isEmpty()){
			System.out.println("Dados n�o validados");
		}else{
			this.opcao04 = opcao04;
		}
	}
	
	public String getOpcao05() {
		return opcao05;
	}
	
	public void setOpcao05(String opcao05) {
		if (opcao05 == null || opcao05.isEmpty()){
			System.out.println("Dados n�o validados");
		}else{
			this.opcao05 = opcao05;
		}
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) {
		if (resposta == null || resposta.isEmpty()){
			System.out.println("Dados n�o validados");
		}else{
			this.resposta = resposta;
		}
	}
	
	  public String toString() {
		  	String frase="";
		  	frase = "\nId = " + this.getId();
		  	frase = frase + "\nCodigo = " + this.getCodigo();
		  	frase = frase + "\nDificuldade = " + this.getDificuldade();
		  	frase = frase + "\nAssunto = " + this.getAssunto();
		  	frase = frase + "\nEnunciado = " + this.getEnunciado();
		  	frase = frase + "\nA) = " + this.opcao01;
		  	frase = frase + "\nB) = " + this.opcao02;
		  	frase = frase + "\nC) = " + this.opcao03;
		  	frase = frase + "\nD) = " + this.opcao04;
		  	frase = frase + "\nE) = " + this.opcao05;
		  	frase = frase + "\nResposta = " + this.resposta;
		  	return frase;
		  }
	  
	  public static QuestoesObjetivas converter(QuestoesObjetivasDTO dto) {
		  QuestoesObjetivas quest = new QuestoesObjetivas();
		  quest.setCodigo(dto.getCodigo());
		  quest.setTipo(dto.getTipo());
		  quest.setAssunto(dto.getAssunto());
		  quest.setDificuldade(dto.getDificuldade());
		  quest.setDisciplina(dto.getDisciplina());
		  quest.setEnunciado(dto.getEnunciado());
		  quest.setIdDisciplina(dto.getIdDisciplina());
		  quest.setOpcao01(dto.getOpcao01());
		  quest.setOpcao02(dto.getOpcao02());
		  quest.setOpcao03(dto.getOpcao03());
		  quest.setOpcao04(dto.getOpcao04());
		  quest.setOpcao05(dto.getOpcao05());
		  quest.setResposta(dto.getResposta());
		return quest;
		}
}