package model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProvaDTO;
import model.dao.ProvaDao;
import model.dao.BaseInterDAO;
import model.entity.Disciplina;
import model.entity.Prova;
import model.entity.Questoes;

public class ProvaBO /*extends BaseBO<Prova> implements BaseInterBO<Prova>*/{
	BaseInterDAO<Prova> dao = new ProvaDao();
	public boolean adicionar(ProvaDTO provaa) {
		Prova prova = Prova.converter(provaa);
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
	
	public List<ProvaDTO> listar(){
		List<ProvaDTO> provas = new ArrayList<ProvaDTO>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				//at? agora ta correto
				ProvaDTO prova = new ProvaDTO();
				prova.setId(rs.getInt("id"));
				prova.setNivelUm(rs.getString("nivelUm"));
				prova.setNivelDois(rs.getString("nivelDois"));
				prova.setNivelTres(rs.getString("nivelTres"));
				prova.setDisciplina(rs.getString("disciplina"));
				prova.setSemestre(rs.getString("semestre"));
				prova.setCodigo(rs.getString("codigo"));
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
	public boolean apagar (Prova provadto) {
		ResultSet rs = dao.findBySpecifiedField(provadto, "codigo");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.deletar(provadto) == true)
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
