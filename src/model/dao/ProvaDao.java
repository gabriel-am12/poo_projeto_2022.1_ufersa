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
			pst.setString(2,prova.getQuestao());
			pst.setString(3, prova.getDisciplina());
			pst.setDate(4, prova.getData());
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
			pst.setString(2, provinha.getQuestao());
			pst.setString(3, provinha.getDisciplina());
			pst.setDate(4, provinha.getData());
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
				provinhaaa.setQuestao(rs.getString("questao"));
				provinhaaa.setDisciplina(rs.getString("disciplina"));
				provinhaaa.setData(rs.getDate("data"));
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
				
			case "Questao":
				pst.setQuestao(1, provazinha.getQuestao());
				break;
				
			case "Disciplina":
				pst.setDisciplina(1, provazinha.getDisciplina());
				break;
				
			case "Data":
				pst.setDate(1, provazinha.getData());
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
