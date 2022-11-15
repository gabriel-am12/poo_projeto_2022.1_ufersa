package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.Usuario;

public class UsuarioDAO extends BaseDao<Usuario>{

    public Usuario findById(Usuario usuario) {
        String sql = "SELECT * FROM tb_usuario WHERE id=? ;";
        try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, usuario.getId_usuario());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				Usuario user = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setId_usuario(usuario.getId_usuario());
				return user;
			}
			else return null;
		
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
    }

	public boolean cadastrar (Usuario usuario) {
		String sql = "INSERT INTO tb_usuario (login,senha) VALUES (?,?);";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			pst.execute();
			return true;		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean inserir(Usuario usuario) {
		String sql = "INSERT INTO tb_usuario (nome,email,login,senha) VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getLogin());
			pst.setString(4, usuario.getSenha());
			pst.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removerByLogin(Usuario usuario) {
		String sql = "DELETE FROM tb_usuario WHERE login = ?";
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, usuario.getLogin());
			pst.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Usuario> listar(){
		String sql = "SELECT * FROM tb_usuario";
		Statement st;
		ResultSet rs;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Usuario vo = new Usuario();
				vo.setId_usuario(rs.getInt("id"));
				vo.setEmail(rs.getString("email"));
				vo.setNome(rs.getString("nome"));
				vo.setLogin(rs.getString("login"));
				vo.setSenha(rs.getString("senha"));
				usuarios.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void editar(Usuario vo) {
		String sql = "UPDATE tb_usuario SET nome = ? WHERE id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getId_usuario());
			ptst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}