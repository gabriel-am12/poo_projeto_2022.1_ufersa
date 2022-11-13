package Controller;


import Dto.UsuarioDTO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.service.UsuarioBO;

public class TelaLoginController {
	@FXML private TextField login;
	@FXML private TextField senha;
	private UsuarioBO bo = new UsuarioBO();
	
	public static void realizarlogin() {
		Telas.telaDashboard();
	}
	
	public static void criarconta() {
		Telas.TeladeCadastro();
	}
}
