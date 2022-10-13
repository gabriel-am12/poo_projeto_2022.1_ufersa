package model.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ProvaDao;
import model.dao.BaseInterDAO;
import model.entities.Prova;

public class ProvaBO {
	BaseInterDAO<Prova> dao = new ProvaDao();
	public boolean adicionar(Prova prova) {
		ResultSet rs = dao.findBySpecifiedField(prova, "id");
		try {
			if(rs==null || !(rs.next()) ) {
				if(dao.inserir(prova) == true)
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
	public List<Prova> listar(){
		List<Prova> provas = new ArrayList<Prova>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				Prova prova = new Prova();
				prova.setId(rs.getInt("id"));
				prova.setQuestao(rs.getString("questão"));
				prova.setDisciplina(rs.getString("disciplina"));
				prova.setData(rs.getLocalDate("Data"));
				
				provas.add(prova);
			}
			return provas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean atualizar (Prova prova) {
		
		ResultSet rs = dao.findBySpecifiedField(prova, "id");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.alterar(prova) == true)
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
	public boolean apagar (Prova prova) {
		ResultSet rs = dao.findBySpecifiedField(prova, "id");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.deletar(prova) == true)
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
