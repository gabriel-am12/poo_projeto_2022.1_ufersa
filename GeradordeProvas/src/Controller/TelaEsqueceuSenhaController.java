package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.dao.UsuarioDAO;
import model.entity.Usuario;

public class TelaEsqueceuSenhaController {
    @FXML
    private TextField CodigoTexto;
    
    @FXML
    private Label mostrarsenha;
    
    @FXML
    public void buscar(ActionEvent event) {
    	String capturecod;
		capturecod = CodigoTexto.getText();
		Usuario user = new Usuario();
		user.setEmail(capturecod);
		UsuarioDAO userdao = new UsuarioDAO();
		ResultSet rs = userdao.findBySpecifiedField(user, "email");
		try {
			if (rs.next()){
				 	String senha = rs.getString("senha");
				 	mostrarsenha.setText("Sua senha é " + senha);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void voltar(ActionEvent event) {
    	Telas.TeladeLogin();
    }
}
