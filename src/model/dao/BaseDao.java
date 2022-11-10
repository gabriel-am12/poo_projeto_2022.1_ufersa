package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.Usuario;

public class BaseDao<entity> implements BaseInterDAO<entity>{
	private Connection con;
	
	synchronized public Connection getConnection() {
		if(con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/dbgeradordeprovas","geradordeprovas","geradordeprovas1234");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		else return con;
	}

	@Override
	public boolean inserir(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(entity e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public entity findById(entity e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet findBySpecifiedField(entity e, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario autenticar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
