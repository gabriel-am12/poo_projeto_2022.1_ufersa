package model.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UsuarioDTO;
import model.dao.UsuarioDAO;
import model.dao.BaseInterDAO;
import model.entity.Usuario;

public class UsuarioBO {
	BaseInterDAO<Usuario> dao = new UsuarioDAO();
	/*
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
    }*/
	
	public Usuario autenticar(UsuarioDTO dto) {
		Usuario user = Usuario.converter(dto);
		
		ResultSet rs = dao.findBySpecifiedField(user, "login");
		try {
            if(rs.next()) {
            	System.out.println("Usuario existe");
                if(rs.getString("senha").equals(user.getSenha())) {
                    return user;
                }
                else { 
                	System.out.println("Usuario nao existe");
                	return null;
                }
            }
            else return null;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	
	public boolean adicionar(UsuarioDTO dto) {
		Usuario user = Usuario.converter(dto);
		
		ResultSet rs = dao.findBySpecifiedField(user, "login");
		try {
			if(rs==null || !(rs.next()) ) {
				if(dao.inserir(user) == true)
					return true;
					else return false;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
		
	}
}
