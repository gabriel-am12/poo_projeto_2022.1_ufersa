package br.edu.ufersa.sistemageradordeprova.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ufersa.sistemageradordeprova.model.entities.QuestoesObjetivas;
import br.edu.ufersa.sistemageradordeprova.model.entities.QuestoesSubjetivas;

public class QuestoesSubjetivasDao extends BaseDao<QuestoesSubjetivas>{
	public boolean inserir (QuestoesSubjetivas quest) {
		String sql = "INSERT INTO tb_questaosub (enunciado,tipo,assuntos,dificuldade,pk_disciplina,resposta) VALUES (?,?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getEnunciado());
			pst.setInt(2, quest.getTipo());
			pst.setString(3, quest.getAssunto());
			pst.setString(4, quest.getDificuldade());
			pst.setObject(5, quest.getDisciplina());
			pst.setString(6, quest.getResposta());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(QuestoesSubjetivas quest) {
		String sql = "DELETE FROM tb_questaosub WHERE id_pk=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setLong(1, quest.getCodigo());
			pst.execute();
			
			return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean alterar(QuestoesSubjetivas quest) {
		String sql = "UPDATE tb_questaosub SET enunciado=?,assuntos=?,dificuldade=?,resposta=? WHERE id_pk=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getEnunciado());
			pst.setString(2, quest.getAssunto() );
			pst.setString(3, quest.getDificuldade());
			pst.setString(4, quest.getResposta());
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	

	public QuestoesSubjetivas findById(QuestoesSubjetivas e) {
		String sql = "SELECT * FROM tb_questaosub WHERE id_pk=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, e.getCodigo());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				QuestoesSubjetivas a = new QuestoesSubjetivas();
				a.setEnunciado(rs.getString("enunciado"));
				a.setTipo(rs.getInt("tipo"));
				a.setAssunto(rs.getString("assuntos"));
				a.setDificuldade(rs.getString("dificuldade"));
				a.setResposta(rs.getString("resposta"));
				
				a.setCodigo(e.getCodigo());
				return a;
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
		String sql = "SELECT * FROM tb_questaosub;";
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
	public ResultSet findBySpecifiedField(QuestoesSubjetivas e, String field) {
		String sql = "SELECT * FROM tb_questaosub WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "enunciado":
				pst.setString(1, e.getEnunciado());
				break;
				
			case "dificuldade":
				pst.setString(1, e.getDificuldade());
				break;
				
			case "resposta":
				pst.setString(1, e.getResposta());
				break;
				
			default: 
				pst.setInt(1, e.getCodigo());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	
	public QuestoesObjetivas buscar(QuestoesObjetivas quest) {
		String sql = "SELECT * FROM tb_questaosub WHERE id_pk=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, quest.getCodigo());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return quest;
			}
			else return null;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet buscar() {
		String sql = "SELECT * FROM tb_questaosub;";
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
