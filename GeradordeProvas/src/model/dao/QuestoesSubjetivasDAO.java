package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UsuarioDTO;
import model.entity.QuestoesSubjetivas;

public class QuestoesSubjetivasDAO extends BaseDao<QuestoesSubjetivas>{

	public boolean inserir (QuestoesSubjetivas quest) {
		String sql = "INSERT INTO tb_questaosub (codigo,enunciado,tipo,assuntos,dificuldade,resposta,disciplina) VALUES (?,?,?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
			pst.setString(2, quest.getEnunciado());
			pst.setInt(3, quest.getTipo());
			pst.setString(4, quest.getAssunto());
			pst.setString(5, quest.getDificuldade());
			pst.setString(6, quest.getResposta());
			pst.setString(7, quest.getDisciplina());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(QuestoesSubjetivas quest) {
		String sql = "DELETE FROM tb_questaosub WHERE codigo = ?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean alterar(QuestoesSubjetivas quest) {
		String sql = "UPDATE tb_questaosub SET codigo=?,enunciado=?,tipo=?,assuntos=?,dificuldade=?,resposta=?,disciplina=? WHERE codigo=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
			pst.setString(2, quest.getEnunciado());
			pst.setInt(3, quest.getTipo());
			pst.setString(4, quest.getAssunto());
			pst.setString(5, quest.getDificuldade());
			pst.setString(6, quest.getResposta());
			pst.setString(7, quest.getDisciplina());
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public QuestoesSubjetivas findById(QuestoesSubjetivas quest) {
		String sql = "SELECT * FROM tb_questaosub WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, quest.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				QuestoesSubjetivas a = new QuestoesSubjetivas();
				a.setAssunto(rs.getString("assuntos"));
				a.setCodigo(rs.getString("codigo"));
				a.setDificuldade(rs.getString("dificuldade"));
				a.setDisciplina(rs.getString("disciplina"));
				a.setResposta(rs.getString("resposta"));
				a.setTipo(rs.getInt("tipo"));
				a.setEnunciado(rs.getString("enunciado"));
				a.setId(quest.getId());
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
			case "codigo":
				pst.setString(1, e.getCodigo());
				break;
				
			case "assuntos":
				pst.setString(1, e.getAssunto());
				break;
				
			case "enunciado":
				pst.setString(1, e.getEnunciado());
				break;
				
			case "resposta":
				pst.setString(1, e.getResposta());
				break;
				
			case "dificuldade":
				pst.setString(1, e.getDificuldade());
				break;
			case "disciplina":
				pst.setString(1, e.getDisciplina());
			
			default: 
				pst.setInt(1, e.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}
	
	public QuestoesSubjetivas buscar(QuestoesSubjetivas quest) {
		String sql = "SELECT * FROM tb_questaosub WHERE codigo=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
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
