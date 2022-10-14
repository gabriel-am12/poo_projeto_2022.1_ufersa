package br.edu.ufersa.sistemageradordeprova.model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sistemageradordeprova.model.dao.QuestoesSubjetivasDao;
import br.edu.ufersa.sistemageradordeprova.model.dao.BaseInterDAO;
import br.edu.ufersa.sistemageradordeprova.model.entities.QuestoesSubjetivas;

public class QuestoesSubjetivasBO {
	BaseInterDAO<QuestoesSubjetivas> dao = new QuestoesSubjetivasDao();
	public boolean adicionar(QuestoesSubjetivas quest) {
		ResultSet rs = dao.findBySpecifiedField(quest, "id_pk");
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
	
	public List<QuestoesSubjetivas> listar(){
		List<QuestoesSubjetivas> questoes = new ArrayList<QuestoesSubjetivas>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				QuestoesSubjetivas quest = new QuestoesSubjetivas();
				quest.setResposta(rs.getString("resposta"));
				quest.setEnunciado(rs.getString("enunciado"));
				quest.setAssunto(rs.getString("assuntos"));
				quest.setDificuldade(rs.getNString("dificuldade"));
				quest.setCodigo(rs.getInt("id_pk"));
				
				questoes.add(quest);
			}
			return questoes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean atualizar (QuestoesSubjetivas quest) {
		
		ResultSet rs = dao.findBySpecifiedField(quest, "id_pk");
		try {
			if(rs!=null && rs.next() ) {
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
		ResultSet rs = dao.findBySpecifiedField(quest, "id_pk");
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
