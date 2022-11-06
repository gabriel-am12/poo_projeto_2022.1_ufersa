package model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.UsuarioDAO;
import model.dao.BaseInterDAO;
import model.entity.Usuario;

public class UsuarioBO {
	BaseInterDAO<Usuario> dao = new UsuarioDAO();
    public Usuario autenticar(Usuario usuario) {
        ResultSet rs = dao.findBySpecifiedField(usuario, "login");
        try {
            if(rs.next()) {
                if(rs.getString("senha").equals(usuario.getSenha)) {
                    return usuario;
                }
            }
            else return null;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
}