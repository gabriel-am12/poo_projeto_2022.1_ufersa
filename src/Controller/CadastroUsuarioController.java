package Controller;

import Dto.UsuarioDTO;
import model.service.UsuarioBO;
import View.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class CadastroUsuarioController {
	@FXML private TextField cadastrar_usuario;
	@FXML private TextField cadastrar_nome;
	@FXML private TextField cadastrar_senha;
	@FXML private TextField cadastrar_email;
		  private UsuarioBO bo = new UsuarioBO();
	
	public void cadastrar() {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setLogin(cadastrar_usuario.getText());
		dto.setNome(cadastrar_nome.getText());
		dto.setEmail(cadastrar_email.getText());
		dto.setLogin(cadastrar_senha.getText());
		bo.autenticar(dto);
		Telas.telaDashboard();
	}

}
