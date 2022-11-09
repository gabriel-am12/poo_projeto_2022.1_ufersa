package View;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
		pS.setTitle("GerTest");
		telaLogin();
	}

	public static void telaLogin() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getClassLoader().getResource("src/View/VE/TeladeLogin.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static void telaCadastro() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaDeCadastro.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaDisciplinas() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TeladeDisciplina.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaCadastrarDisciplina() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarDisciplina.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaQuestoes() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaQuestoes.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaCadastrarQuestao() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastroQuestao.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaEditarQuestao() throws Exception {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaEditarQuestao.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaProva() throws IOException {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaProva.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaQuestoesDaProva() throws IOException {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaQuestoesProva.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void telaCadastrarQuestoesNaProva() throws IOException {
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/TelaCadastrarQuestoesProva.fxml"));

		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}