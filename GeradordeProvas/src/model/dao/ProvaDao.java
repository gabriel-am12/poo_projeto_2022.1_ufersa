package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Prova;


public class ProvaDao extends BaseDao<Prova>{
	
	public boolean inserir (Prova prova) {
		String sql = "INSERT INTO tb_prova  (codigo,questao,disciplinas,data) VALUES (?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, prova.getId());
			pst.setInt(2,prova.getNivelUm());
			pst.setInt(3,prova.getNivelDois());
			pst.setInt(4,prova.getNivelTres());
			pst.setInt(5, prova.getIdDisciplina());
			pst.setString(6, prova.getData());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(Prova provaa) {
		String sql = "DELETE FROM tb_prova WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, provaa.getId());
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
			pst.setInt(2,provinha.getNivelUm());
			pst.setInt(3,provinha.getNivelDois());
			pst.setInt(4,provinha.getNivelTres());
			pst.setInt(5, provinha.getIdDisciplina());
			pst.setString(6, provinha.getData());
			pst.execute();
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
				provinhaaa.setNivelUm(rs.getInt("nivelUm"));
				provinhaaa.setNivelDois(rs.getInt("nivelDois"));
				provinhaaa.setNivelTres(rs.getInt("nivelTres"));
				provinhaaa.setIdDisciplina(rs.getInt("disciplina"));
				provinhaaa.setData(rs.getString("data"));
				provinhaaa.setId(provinhaa.getId());
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
				pst.setInt(1, provazinha.getIdDisciplina());
				break;
				
			case "Data":
				pst.setString(1, provazinha.getData());
				break;
			
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