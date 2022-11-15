package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*; 
import model.service.UsuarioBO;
import model.dao.BaseInterDAO;
import model.dao.UsuarioDAO;
import model.entity.Usuario;
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
	
	/*
	@FXML
	public void Login(ActionEvent event) throws Exception {
		UsuarioDTO user = new UsuarioDTO();
		user.setLogin(LoginTextField.getText());
		user.setSenha(SenhaTextField.getText());
		try{
			Usuario Logado = usuBO.autenticar(user);
			if (Logado instanceof Usuario) {
				Telas.TelaDashboard();
			}
		}
		catch(Exception E){
			E.printStackTrace();
			ErroAut.setText("Usuario ou senha invalidos!");
			ErroAut.setVisible(true);
		}
	}
	*/
	
	@FXML protected void Login(ActionEvent event)  throws Exception{
		Usuario user = new Usuario();
		boolean allSet = user.autenticar(LoginTextField.getText(), SenhaTextField.getText());
	
		if(allSet) {
			Telas.TelaDashboard();
		}else {
		ErroAut.setText("Usuario ou senha invalidos!");
		ErroAut.setVisible(true);
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