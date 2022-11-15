 package View;

 import java.io.IOException;
 import javafx.application.Application;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.scene.layout.Pane;
 import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage stage;
	
	private void setStage(Stage st) {
		stage = st;
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		setStage(arg0);
		arg0.setTitle("Sistema Gerador de Provas");
		TeladeLogin();
	}
	
	public static void TelaDashboard() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaDashboard.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela Dashboard");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TeladeCadastrarDisciplina() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeCadastrarDisciplina.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Tela de Cadastrar Disciplina");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TeladeDisciplina() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeDisciplina.fxml"));
			Scene scene = new Scene (root);
			stage.setScene(scene);
			stage.setTitle("Tela de Disciplina");
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TeladeLogin() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeLogin.fxml")); 
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela de Login");
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
			stage.setTitle("Tela de Cadastro");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TeladeQuestoes() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeQuestoes.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela de Questões");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TelaTipodeQuestao() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaTipodeQuestao.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Selecione o tipo");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TelaCadastrarQuestaoSubjetiva() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarQuestaoSubjetiva.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastrando questão subjetiva");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TelaCadastrarQuestaoObjetiva() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarQuestaoObjetiva.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Cadastrando questão subjetiva");
			stage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TelaEsqueceuSenha(){
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaEsqueceuSenha.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela esqueci da senha");
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TeladeProvas() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeProvas.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Provas");
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void TeladeEditarDisciplina() {
		try {
			Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeEditarDisciplina.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela de Editar Disciplina");
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main (String args[]) {
		launch(); 
	}
}
