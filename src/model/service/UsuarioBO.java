package model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dto.UsuarioDTO;

import model.dao.UsuarioDAO;
import model.dao.BaseInterDAO;
import model.entity.Usuario;

public class UsuarioBO {
	BaseInterDAO<Usuario> dao = new UsuarioDAO();
    public UsuarioDTO autenticar(UsuarioDTO dto){
    	Usuario user = Usuario.converter(dto);
        ResultSet rs = dao.findBySpecifiedField(user, "login");
        try {
            if(rs.next()) {
                if(rs.getString("senha").equals(dto.getSenha())) {
                    return dto;
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
