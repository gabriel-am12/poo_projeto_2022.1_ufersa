package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Disciplina;

public class DisciplinaDAO extends BaseDao<Disciplina>{

    public boolean inserir (Disciplina disciplina) {
        String sql = "INSERT INTO tb_disciplina (codigo,nome,assuntos) VALUES (?,?,?);";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, disciplina.getCodigo());
			pst.setString(2, disciplina.getNome());
			pst.setString(3, disciplina.getAssunto());
			pst.execute();
			return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletar(Disciplina disciplina) {
        String sql = "DELETE FROM tb_disciplina WHERE codigo = ?;";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
            pst.setString(1, disciplina.getCodigo());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Disciplina disciplina) {
        String sql = "UPDATE tb_disciplina SET codigo=?,nome=?,assuntos=? WHERE codigo =?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, disciplina.getCodigo());
			pst.setString(2, disciplina.getNome());
			pst.setString(3, disciplina.getAssunto());
			pst.executeUpdate();
			
			return true;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
    }

    public Disciplina findById(Disciplina e) {
		String sql = "SELECT * FROM tb_disciplina WHERE id=?;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, e.getId());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Disciplina a = new Disciplina();
				a.setCodigo(rs.getString("codigo"));
				a.setNome(rs.getString("nome"));
				a.setAssunto(rs.getString("assuntos"));
				a.setId(e.getId());
				return a;
			}
			else return null;
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

    @Override
	public ResultSet findAll() {
		String sql = "SELECT * FROM tb_disciplina;";
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
	public ResultSet findBySpecifiedField(Disciplina disciplina, String field) {
		String sql = "SELECT * FROM tb_disciplina WHERE " + field +"=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			switch (field) {
			case "codigo":
				pst.setString(1,disciplina.getCodigo());
				break;
				
			case "nome":
				pst.setString(1,disciplina.getNome());
				break;
				
			case "assuntos":
				pst.setString(1,disciplina.getAssunto());
				break;
				
			default: 
				pst.setInt(1,disciplina.getId());
			}
			
			ResultSet rs = pst.executeQuery();
			return rs;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

    public Disciplina buscar(Disciplina disciplina) {
		String sql = "SELECT * FROM tb_disciplina WHERE codigo=? ;";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, disciplina.getCodigo());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return disciplina;
			}
			else return null;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

    public ResultSet buscar() {
		String sql = "SELECT * FROM tb_disciplina;";
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