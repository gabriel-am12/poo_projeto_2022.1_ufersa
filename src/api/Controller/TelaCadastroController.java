package api.Controller;

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
import api.dto.UsuarioDTO;

public class TelaCadastroController {
	@FXML private TextField cadastrar_usuario;
	@FXML private TextField cadastrar_nome;
	@FXML private TextField cadastrar_senha;
	@FXML private TextField confirmar_senha;
	@FXML private Label ErroAut;
	@FXML private Button realizar_cadastro;
	@FXML private Button voltar_pagina;
	public String confirmar_Senha;
	private static UsuarioBO userbo = new UsuarioBO();
	
	public void realizar_cadastro(ActionEvent event){
		UsuarioDTO userdto = new UsuarioDTO();
		userdto.setLogin(cadastrar_usuario.getText());
		userdto.setNome(cadastrar_nome.getText());
		userdto.setSenha(cadastrar_senha.getText());
		confirmar_Senha = confirmar_senha.getText();
		ResultSet rs = UsuarioDAO.listar(userdto);
		if (rs.next()) {
			throw new Exception();
		}
		else {
			userbo.autenticar(userdto);
			Telas.telaLogin();
		}
	}
	public void voltar_pagina(ActionEvent event) {
		Telas.telaLogin();
	}
}
