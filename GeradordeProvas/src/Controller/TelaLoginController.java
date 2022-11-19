package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*; 
import model.service.UsuarioBO;
import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.entity.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import View.Telas;
import dto.UsuarioDTO;


public class TelaLoginController {
	@FXML private TextField LoginTextField;
	@FXML private TextField SenhaTextField;
	@FXML private Label ErroAut;
	@FXML private Button BotaoCriarConta;
	@FXML private Button BotaoLogin;
	@FXML private Button BotaoEsqueceuSenha;
	private static UsuarioBO usuBO = new UsuarioBO();
	private Integer ReturnAutenticar;
	
	public void Login(ActionEvent event) {
		try {
			String nome, senha;
			nome = LoginTextField.getText();
			senha = SenhaTextField.getText();
			UsuarioDTO objusuario = new UsuarioDTO();
			objusuario.setLogin(nome);
			objusuario.setSenha(senha);
			UsuarioDAO objusuariodao = new UsuarioDAO();
			ResultSet rsusuario = objusuariodao.logaruser(objusuario);
			if(rsusuario.next()) {
				Telas.TelaDashboard();
			}else {
				ErroAut.setText("Usuario ou senha invalidos!");
				ErroAut.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void CriarConta(ActionEvent event){
		Telas.TeladeCadastro();
	}
	
	@FXML
	public void EsqueceuSenha() {
		Telas.TelaEsqueceuSenha();
	}
}