package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*; 
import model.service.UsuarioBO;
import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.entity.Usuario;
import View.Telas;


public class TelaLoginController {
	@FXML private TextField LoginTextField;
	@FXML private TextField SenhaTextField;
	@FXML private Label ErroAut;
	@FXML private Button BotaoCriarConta;
	@FXML private Button BotaoLogin;
	@FXML private Button BotaoEsqueceuSenha;
	private static BaseInterDAO<Usuario> usuBO = new UsuarioBO<Usuario>();
	private Integer ReturnAutenticar;
	
	@FXML
	public void Login(ActionEvent event) throws Exception {
		Usuario user = new Usuario();
		user.setNome(LoginTextField.getText());
		user.setSenha(SenhaTextField.getText());
		try{
			Usuario Logado = usuBO.autenticar(user);
			if (Logado instanceof Usuario) {
				Telas.telaDisciplinas();
			}
		}
		catch(Exception E){
			E.printStackTrace();
		}
	}
	
	@FXML
	public void CriarConta(ActionEvent event){
		Telas.telaCadastro();
	}
	
	@FXML
	public void EsqueceuSenha(ActionEvent event) {
		
	}
}
