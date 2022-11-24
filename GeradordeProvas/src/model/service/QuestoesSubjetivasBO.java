package model.service;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.QuestoesSubjetivasDTO;
import model.dao.QuestoesSubjetivasDAO;
import model.dao.BaseInterDAO;
import model.entity.QuestoesSubjetivas;

public class QuestoesSubjetivasBO {
	BaseInterDAO<QuestoesSubjetivas> dao = new QuestoesSubjetivasDAO();
	public boolean adicionar(QuestoesSubjetivasDTO dto) {
		QuestoesSubjetivas quest = QuestoesSubjetivas.converter(dto);
		
		ResultSet rs = dao.findBySpecifiedField(quest, "codigo");
		try {
			if(rs==null || !(rs.next()) ) {
				if(dao.inserir(quest) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public List<QuestoesSubjetivasDTO> listar(){
		List<QuestoesSubjetivasDTO> questoes = new ArrayList<QuestoesSubjetivasDTO>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				QuestoesSubjetivasDTO quest = new QuestoesSubjetivasDTO();
				quest.setCodigo(rs.getString("codigo"));
				quest.setAssunto(rs.getString("assuntos"));
				quest.setDificuldade(rs.getString("dificuldade"));
				quest.setEnunciado(rs.getString("enunciado"));
				quest.setDisciplina(rs.getString("disciplina"));
				quest.setResposta(rs.getString("resposta"));
				quest.setTipo(rs.getInt("tipo"));
				//aluno.setId(rs.getInt("id"));
				
				questoes.add(quest);
			}
			return questoes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean atualizar (QuestoesSubjetivasDTO dto) {
		QuestoesSubjetivas quest = QuestoesSubjetivas.converter(dto);
		ResultSet rs = dao.findBySpecifiedField(quest, "codigo");
		try {
			if(rs!=null && rs.next()) {
				if(dao.alterar(quest) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
	public boolean apagar (QuestoesSubjetivas quest) {
		ResultSet rs = dao.findBySpecifiedField(quest, "codigo");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.deletar(quest) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}
}
