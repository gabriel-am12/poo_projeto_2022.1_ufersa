package Controller;

import model.service.UsuarioBO;
import View.Telas;
import dto.UsuarioDTO;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class CadastroUsuarioController {
	@FXML private TextField login;
	@FXML private TextField nome;
	@FXML private PasswordField senha;
	@FXML private TextField email;
		  private UsuarioBO bo = new UsuarioBO();
	
	public void cadastrar() throws Exception {
		UsuarioDTO dto = new UsuarioDTO();
		if(senha.getText().length() < 1) {
			throw new Exception();
		}
		else {
		dto.setLogin(login.getText());
		dto.setNome(nome.getText());
		dto.setEmail(email.getText());
		dto.setSenha(senha.getText());
		bo.adicionar(dto);
		Telas.TeladeLogin();
		}
	}
	
	public void voltar() {
		Telas.TeladeLogin();
	}

}
