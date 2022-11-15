package model.entity;

import dto.QuestoesSubjetivasDTO;

public class QuestoesSubjetivas extends Questoes {
	private String resposta;

	public QuestoesSubjetivas(String codigo, int tipo, String enunciado, Disciplina disciplina, String assunto,
			int dificuldade) {
		super(codigo, tipo, enunciado, disciplina, assunto, dificuldade);
		// TODO Auto-generated constructor stub
	}

	public QuestoesSubjetivas() {
		
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
	
	/*
	 * public static Aluno converter(AlunoDTO dto) {
		Aluno aluno = new Aluno();
		aluno.setCpf(dto.getCpf());
		aluno.setEndereco(dto.getEndereco());
		aluno.setNome(dto.getNome());
		aluno.setTelefone(dto.getTelefone());
		return aluno;
	}
	 * 
	 * */
	public static QuestoesSubjetivas converter(QuestoesSubjetivasDTO dto) {
		QuestoesSubjetivas quest = new QuestoesSubjetivas();
		quest.setAssunto(dto.getAssunto());
		quest.setCodigo(dto.getCodigo());
		quest.setDificuldade(dto.getDificuldade());
		quest.setDisciplina(dto.getDisciplina());
		quest.setEnunciado(dto.getEnunciado());
		quest.setIdDisciplina(dto.getIdDisciplina());
		quest.setTipo(dto.getTipo());
		quest.setResposta(dto.getResposta());
		return quest;
	}
}
	
