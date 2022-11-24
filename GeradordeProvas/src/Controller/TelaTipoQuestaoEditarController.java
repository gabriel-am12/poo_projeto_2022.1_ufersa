	package Controller;

	import View.Telas;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
public class TelaTipoQuestaoEditarController {

		@FXML
	    void adicionarobjetiva(ActionEvent event) {
			Telas.TelaEditarQuestaoObjetiva();
	    }

	    @FXML
	    void adicionarsubjetiva(ActionEvent event) {
	    	Telas.TelaEditarQuestaoSubjetiva();
	    }

	    @FXML
	    void disciplinas(ActionEvent event) {
	    	Telas.TeladeDisciplina();
	    }

	    @FXML
	    void inicio(ActionEvent event) {
	    	Telas.TelaDashboard();
	    }

	    @FXML
	    void provas(ActionEvent event) {
	    	Telas.TeladeProvas();
	    }

	    @FXML
	    void questoes(ActionEvent event) {
	    	Telas.TeladeQuestoes();
	    }

	    @FXML
	    void voltar() {
	    	Telas.TeladeQuestoes();
	    }
	    
	    @FXML
	    public void sair(ActionEvent event) {
			Telas.TeladeLogin();
	    }
}

