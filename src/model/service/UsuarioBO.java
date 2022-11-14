package model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import api.dto.UsuarioDTO;
import model.dao.UsuarioDAO;
import model.dao.BaseInterDAO;
import model.entity.Usuario;

public class UsuarioBO {
	BaseInterDAO<Usuario> dao = new UsuarioDAO();
    public Usuario autenticar(UsuarioDTO userdto){
    	Usuario user = Usuario.converter(userdto);
        ResultSet rs = dao.findBySpecifiedField(user, "login");
        try {
            if(rs.next()) {
                if(rs.getString("senha").equals(user.getSenha())) {
                    return user;
                }
                else return null;
            }
            else return null;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
}