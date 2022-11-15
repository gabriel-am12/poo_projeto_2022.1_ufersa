package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.QuestoesObjetivas;
import model.entity.QuestoesSubjetivas;

public class QuestoesObjetivasDAO extends BaseDao<QuestoesObjetivas>{
	public boolean inserir (QuestoesObjetivas quest) {
		String sql = "INSERT INTO tb_questaoobj (codigo,enunciado,tipo,assuntos,dificuldade,resposta,fk_disciplina,opcao01,opcao02,opcao03,opcao04,opcao05) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
			pst.setString(2, quest.getEnunciado());
			pst.setInt(3, quest.getTipo());
			pst.setString(4, quest.getAssunto());
			pst.setInt(5, quest.getDificuldade());
			pst.setString(6, quest.getResposta());
			pst.setInt(7, quest.getIdDisciplina());
			pst.setString(8, quest.getOpcao01());
			pst.setString(9, quest.getOpcao02());
			pst.setString(10, quest.getOpcao03());
			pst.setString(11, quest.getOpcao04());
			pst.setString(12, quest.getOpcao05());
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
	public boolean alterar(QuestoesObjetivas quest) {
		String sql = "UPDATE tb_questaoobj SET codigo=?,enunciado=?,tipo=?,assuntos=?,dificuldade=?,resposta=?,fk_disciplina=?,opcao01=?,opcao02=?,opcao03=?,opcao04=?,opcao05=? WHERE codigo=? ";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, quest.getCodigo());
			pst.setString(2, quest.getEnunciado());
			pst.setInt(3, quest.getTipo());
			pst.setString(4, quest.getAssunto());
			pst.setInt(5, quest.getDificuldade());
			pst.setString(6, quest.getResposta());
			pst.setInt(7, quest.getIdDisciplina());
			pst.setString(8, quest.getOpcao01());
			pst.setString(9, quest.getOpcao02());
			pst.setString(10, quest.getOpcao03());
			pst.setString(11, quest.getOpcao04());
			pst.setString(12, quest.getOpcao05());
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
				a.setDificuldade(rs.getInt("dificuldade"));
				//a.setDisciplina(rs.getObject("fk_disciplina"));
				a.setIdDisciplina(rs.getInt("fk_disciplina"));
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
				pst.setInt(1, e.getDificuldade());
			case "opcao01":
				pst.setString(1, e.getOpcao01());
			case "opcao02":
				pst.setString(1, e.getOpcao02());
			case "opcao03":
				pst.setString(1, e.getOpcao03());
			case "opcao04":
				pst.setString(1, e.getOpcao04());
			case "opcao05":
				pst.setString(1, e.getOpcao05());
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