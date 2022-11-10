package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				usuario.setEmai1(rs.getString("email"));
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
		String sql = "INSERT INTO tb_usuario  (login,senha) VALUES (?,?);";
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
}