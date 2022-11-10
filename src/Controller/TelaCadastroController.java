package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*; 
import model.service.UsuarioBO;
import model.dao.BaseDao;
import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.entity.Usuario;

import java.sql.ResultSet;

import View.Telas;

public class TelaCadastroController {
	@FXML private TextField cadastrar_usuario;
	@FXML private TextField cadastrar_nome;
	@FXML private TextField cadastrar_senha;
	@FXML private TextField confirmar_senha;
	@FXML private Label ErroAut;
	@FXML private Button realizar_cadastro;
	@FXML private Button voltar_pagina;
	public String confirmar_Senha;
	private static UsuarioDAO<Usuario> usuDAO = new UsuarioDao<Usuario>();
	
	public void realizar_cadastro(ActionEvent event){
		Usuario vo = new Usuario();
		vo.setLogin(cadastrar_usuario.getText());
		vo.setNome(cadastrar_nome.getText());
		vo.setSenha(cadastrar_senha.getText());
		confirmar_Senha = confirmar_senha.getText();
		ResultSet rs = UsuarioDAO.listarPorLogin(vo);
		if (rs.next()) {
			throw new Exception();
		}
		else {
			UsuDAO.cadastrar(vo);
			Telas.telaLogin();
		}
	}
	public void voltar_pagina(ActionEvent event) {
		Telas.telaLogin();
	}
}
