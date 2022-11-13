package model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dto.DisciplinaDTO;
import model.entity.Disciplina;
import model.dao.DisciplinaDAO;
import model.dao.BaseInterDAO;

public class DisciplinaBO{
	BaseInterDAO<Disciplina> dao = new DisciplinaDAO();
	public boolean adicionar(DisciplinaDTO dto) {
		Disciplina disciplina = Disciplina.converter(dto);
		
		ResultSet rs = dao.findBySpecifiedField(disciplina, "codigo");
		try {
			if(rs==null || !(rs.next()) ) {
				if(dao.inserir(disciplina) == true)
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
	public List<DisciplinaDTO> listar(){
		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
		ResultSet rs = dao.findAll();
		try {
			while(rs.next()) {
				DisciplinaDTO disciplina = new DisciplinaDTO();
				disciplina.setCodigo(rs.getString("codigo"));
				disciplina.setAssuntos(rs.getString("assuntos"));
				disciplina.setNome(rs.getString("nome"));
				
				//aluno.setId(rs.getInt("id"));
				
				disciplinas.add(disciplina);
			}
			return disciplinas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean atualizar (Disciplina disciplina) {
		
		ResultSet rs = dao.findBySpecifiedField(disciplina, "codigo");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.alterar(disciplina) == true)
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
	public boolean apagar (Disciplina disciplina) {
		ResultSet rs = dao.findBySpecifiedField(disciplina, "codigo");
		try {
			if(rs!=null && rs.next() ) {
				if(dao.deletar(disciplina) == true)
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
