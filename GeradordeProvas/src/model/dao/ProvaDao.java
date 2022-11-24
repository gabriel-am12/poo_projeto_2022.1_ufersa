package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Prova;


public class ProvaDao extends BaseDao<Prova>{
	
	public boolean inserir (Prova prova) {
		String sql = "INSERT INTO tb_prova (semestre,nivelUm,nivelDois,nivelTres,disciplina,codigo) VALUES (?,?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, prova.getSemestre());
			pst.setString(2, prova.getNivelUm());
			pst.setString(3, prova.getNivelDois());
			pst.setString(4, prova.getNivelTres());
			pst.setString(5, prova.getDisciplina());
			pst.setString(6, prova.getCodigo());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(Prova provaa) {
		String sql = "DELETE FROM tb_prova WHERE codigo=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, provaa.getCodigo());
			pst.execute();
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean alterar(Prova provinha) {
		String sql = "UPDATE tb_prova SET id=?,questao=?,disciplina=?,data=? WHERE id=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, provinha.getId());
			pst.setString(2,provinha.getNivelUm());
			pst.setString(3,provinha.getNivelDois());
			pst.setString(4,provinha.getNivelTres());
			pst.setString(5, provinha.getDisciplina());
			pst.setString(6, provinha.getSemestre());
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public Prova findById(Prova provinhaa) {
		String sql = "SELECT * FROM tb_prova WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, provinhaa.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Prova provinhaaa = new Prova();
				provinhaaa.setId(rs.getInt("id"));
				provinhaaa.setNivelUm(rs.getString("nivelUm"));
				provinhaaa.setNivelDois(rs.getString("nivelDois"));
				provinhaaa.setNivelTres(rs.getString("nivelTres"));
				provinhaaa.setDisciplina(rs.getString("disciplina"));
				provinhaaa.setSemestre(rs.getString("semestre"));
				provinhaaa.setCodigo(rs.getString("codigo"));
				return provinhaaa;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_prova;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultSet findBySpecifiedField(Prova provazinha, String field) {
		String sql = "SELECT * FROM tb_prova WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "id":
				pst.setInt(1, provazinha.getId());
				break;
				
			case "Disciplina":
				pst.setString(1, provazinha.getDisciplina());
				break;
				
			case "semestre":
				pst.setString(1, provazinha.getSemestre());
				break;
				
			case "codigo":
				pst.setString(1,provazinha.getCodigo());
				
			default: 
				pst.setInt(1, provazinha.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	
	public Prova buscar(Prova provazinhaa) {
		String sql = "SELECT * FROM tb_prova WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, provazinhaa.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return provazinhaa;
			}
			else return null;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_prova;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			return rs;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}