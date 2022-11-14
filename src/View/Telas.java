package View;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Telas extends Application {
	private static Stage primaryStage;

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}

	public void start(Stage pS) throws Exception {
		setPrimaryStage(pS);
		pS.setTitle("GeradorDeProvas");
		pS.show();
		telaLogin();
	}

	public static void telaLogin(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeLogin.fxml"));
			Pane LoginScreen = loader.load();
			Scene cena = new Scene(LoginScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaCadastro(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeCadastro.fxml"));
			Pane CadastroScreen = loader.load();
			Scene cena = new Scene(CadastroScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void telaEsqueceuSenha(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TelaEsqueceuSenha.fxml"));
			Pane DisciplinaScreen = loader.load();
			Scene cena = new Scene(DisciplinaScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void telaDisciplinas(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeDisiciplina.fxml"));
			Pane DisciplinaScreen = loader.load();
			Scene cena = new Scene(DisciplinaScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaCadastrarDisciplina(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeCadastrarDisciplina.fxml"));
			Pane CadastroDisciplinaScreen = loader.load();
			Scene cena = new Scene(CadastroDisciplinaScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void telaEditarDisciplina(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeEditarDisciplina.fxml"));
			Pane CadastroDisciplinaScreen = loader.load();
			Scene cena = new Scene(CadastroDisciplinaScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaQuestoes(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeQuestoes.fxml"));
			Pane QuestaoScreen = loader.load();
			Scene cena = new Scene(QuestaoScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaCadastrarQuestao(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeCadastroQuestao.fxml"));
			Pane CadastroQuestaoScreen = loader.load();
			Scene cena = new Scene(CadastroQuestaoScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaEditarQuestao(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeEditarQuestoes.fxml"));
			Pane EditarQuestaoScreen = loader.load();
			Scene cena = new Scene(EditarQuestaoScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaProva(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeProvas.fxml"));
			Pane ProvaScreen = loader.load();
			Scene cena = new Scene(ProvaScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaEditarProva(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TeladeEditarProva.fxml"));
			Pane EditarProvaScreen = loader.load();
			Scene cena = new Scene(EditarProvaScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void telaCadastrarProva(){
		try {
			FXMLLoader loader = new FXMLLoader(Telas.class.getResource("/TelaCadastrodeProva.fxml"));
			Pane CadastroProvaScreen = loader.load();
			Scene cena = new Scene(CadastroProvaScreen);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch();
	}
}