package model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.QuestoesObjetivasDTO;
import model.entity.QuestoesObjetivas;
import model.dao.QuestoesObjetivasDAO;

public class QuestoesObjetivasBO{
	QuestoesObjetivasDAO dao =  new QuestoesObjetivasDAO();
	public boolean adicionar(QuestoesObjetivasDTO dto) {
		QuestoesObjetivas quest = QuestoesObjetivas.converter(dto);
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
	public List<QuestoesObjetivasDTO> listar(){
		List<QuestoesObjetivasDTO> questoes = new ArrayList<QuestoesObjetivasDTO>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				QuestoesObjetivasDTO quest = new QuestoesObjetivasDTO();
				quest.setCodigo(rs.getString("codigo"));
				quest.setAssunto(rs.getString("assuntos"));
				quest.setDificuldade(rs.getString("dificuldade"));
				quest.setEnunciado(rs.getString("enunciado"));
				quest.setOpcao01(rs.getString("opcao01"));
				quest.setOpcao02(rs.getString("opcao02"));
				quest.setDisciplina(rs.getString("disciplina"));
				quest.setOpcao03(rs.getString("opcao03"));
				quest.setOpcao04(rs.getString("opcao04"));
				quest.setOpcao05(rs.getString("opcao05"));
				quest.setResposta(rs.getString("resposta"));
				questoes.add(quest);
			}
			return questoes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean atualizar (QuestoesObjetivasDTO dto){
		QuestoesObjetivas quest = QuestoesObjetivas.converter(dto);
		ResultSet rs = dao.findBySpecifiedField(quest, "codigo");
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
	public boolean apagar (QuestoesObjetivas quest) {
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
