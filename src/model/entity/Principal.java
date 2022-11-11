package model.entity;

import java.util.List;

import model.dao.BaseDao;
import model.dao.UsuarioDAO;

public class Principal {
	
	//CLASSE UTILIZADA PARA REALIZAR ALGUNS TESTES NO PROGRAMA


	public static void main(String []args) {
		
		
		//TESTANDO A CONEXÃO COM O BANCO DE DADOS OK
		BaseDao dao = new BaseDao();
		System.out.println(dao.getConnection());
		
		//TESTE ADICIONAR USUARIO
		UsuarioDAO dao02 = new UsuarioDAO();
		
		/*
		
		Usuario user = new Usuario();
		user.setEmail("jotave1234@gmail.com");
		user.setLogin("jotave");
		user.setNome("João Vitor");
		user.setSenha("jota123");
		dao02.inserir(user);
		
		Usuario user02 = new Usuario();
		user02.setEmail("jot3232ave1234@gmail.com");
		user02.setLogin("jotave3223");
		user02.setNome("João Vitor3232");
		user02.setSenha("jota1233232");
		dao02.inserir(user);
		
		
		Usuario usermaria = new Usuario();
		usermaria.setEmail("maria010203@hotmail.com");
		usermaria.setLogin("mariabr");
		usermaria.setNome("Maria Eduarda");
		usermaria.setSenha("maria12345");
		dao02.inserir(usermaria);
		
		Usuario userdudu = new Usuario();
		userdudu.setEmail("eduardo@hotmail.com");
		userdudu.setLogin("eduardolol");
		userdudu.setNome("Carlos Eduardo");
		userdudu.setSenha("edubr2022");
		dao02.inserir(userdudu);
		*/
		
		
		
		List<Usuario> usuarios = dao02.listar();
		
		for(Usuario userall: usuarios) {
			System.out.println(userall);
		}
		
	}


}
