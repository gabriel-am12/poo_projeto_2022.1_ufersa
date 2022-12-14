package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.QuestoesObjetivas;
import model.entity.QuestoesSubjetivas;

public class QuestoesObjetivasDAO extends BaseDao<QuestoesObjetivas>{
	public boolean inserir (QuestoesObjetivas quest) {
		String sql = "INSERT INTO tb_questaoobj (codigo,enunciado,assuntos,dificuldade,resposta,disciplina,opcao01,opcao02,opcao03,opcao04,opcao05) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
			pst.setString(2, quest.getEnunciado());
			//pst.setInt(3, quest.getTipo());
			pst.setString(3, quest.getAssunto());
			pst.setString(4, quest.getDificuldade());
			pst.setString(5, quest.getResposta());
			pst.setString(6, quest.getDisciplina());
			pst.setString(7, quest.getOpcao01());
			pst.setString(8, quest.getOpcao02());
			pst.setString(9, quest.getOpcao03());
			pst.setString(10, quest.getOpcao04());
			pst.setString(11, quest.getOpcao05());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}				
	}
	
	public boolean deletar(QuestoesObjetivas quest) {
		String sql = "DELETE FROM tb_questaoobj WHERE codigo = ?;";
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
	
	@Override
	public boolean alterar(QuestoesObjetivas quest) {
		String sql = "UPDATE tb_questaoobj SET codigo=?,enunciado=?,assuntos=?,dificuldade=?,resposta=?,disciplina=?,opcao01=?,opcao02=?,opcao03=?,opcao04=?,opcao05=? WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
			pst.setString(2, quest.getEnunciado());
			pst.setString(3, quest.getAssunto());
			pst.setString(4, quest.getDificuldade());
			pst.setString(5, quest.getResposta());
			pst.setString(6, quest.getDisciplina());
			pst.setString(7, quest.getOpcao01());
			pst.setString(8, quest.getOpcao02());
			pst.setString(9, quest.getOpcao03());
			pst.setString(10, quest.getOpcao04());
			pst.setString(11, quest.getOpcao05());
			pst.setInt(12, quest.getId());
			pst.executeUpdate();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
	
	public QuestoesObjetivas findById(QuestoesObjetivas quest) {
		String sql = "SELECT * FROM tb_questaoobj WHERE id=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, quest.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				QuestoesObjetivas a = new QuestoesObjetivas();
				a.setAssunto(rs.getString("assuntos"));
				a.setCodigo(rs.getString("codigo"));
				a.setDificuldade(rs.getString("dificuldade"));
				a.setDisciplina(rs.getString("disciplina"));
				a.setResposta(rs.getString("resposta"));
				a.setTipo(rs.getInt("tipo"));
				a.setEnunciado(rs.getString("enunciado"));
				a.setOpcao01(rs.getString("opcao01"));
				a.setOpcao02(rs.getString("opcao02"));
				a.setOpcao03(rs.getString("opcao03"));
				a.setOpcao04(rs.getString("opcao04"));
				a.setOpcao05(rs.getString("opcao05"));
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
		String sql = "SELECT * FROM tb_questaoobj;";
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
	public ResultSet findBySpecifiedField(QuestoesObjetivas e, String field) {
		String sql = "SELECT * FROM tb_questaoobj WHERE " + field +"=? ;";
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
			case "opcao01":
				pst.setString(1, e.getOpcao01());
				break;
			case "opcao02":
				pst.setString(1, e.getOpcao02());
				break;
			case "opcao03":
				pst.setString(1, e.getOpcao03());
				break;
			case "opcao04":
				pst.setString(1, e.getOpcao04());
				break;
			case "opcao05":
				pst.setString(1, e.getOpcao05());
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
	
	public QuestoesObjetivas buscar(QuestoesObjetivas quest) {
		String sql = "SELECT * FROM tb_questaoobj WHERE codigo=? ;";
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
		String sql = "SELECT * FROM tb_questaoobj;";
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