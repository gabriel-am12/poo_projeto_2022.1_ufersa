package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import model.entity.Usuario;

public interface BaseInterDAO<entity> {
	public Connection getConnection();
	public boolean inserir (entity e);
	public boolean deletar(entity e);
	public boolean alterar(entity e);
	public entity findById(entity e);
	public ResultSet findAll();
	public ResultSet findBySpecifiedField(entity e, String field);
	Usuario autenticar(Usuario usuario);  
}
