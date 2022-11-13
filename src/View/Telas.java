package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage stage;
	public static void main (String args[]) {
		launch(); 
	}
	private void setStage(Stage st) {
		stage =st;
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// PRIMEIRA INTERFACE QUE SEJA EXECUTADA
		setStage(arg0);
		arg0.setTitle("Sistema Gerador de Provas");
		telaDashboard();
	}
	
	// CADA METODO IRÁ REALIZAR COMANDOS QUE VÃO ABRIR CADA TELA
	
	public static void telaCadastroDisciplina() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/cadastroDisciplina.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Tela de Cadastro de Disciplinas");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void listarDisciplinas() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/listarDisciplina.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Disciplinas");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void telaDashboard() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaDashboard.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Menu Principal");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TeladeLogin() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeLogin.fxml")); 
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Realizar Login");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TeladeCadastro() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeCadastro.fxml")); 
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastrar Usuario");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
