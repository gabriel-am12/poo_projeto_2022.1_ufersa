package Controller;

import java.util.List;

import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.dao.DisciplinaDAO;
import model.entity.Disciplina;

public class CadastroQuestaoObjetivaController {
	  @FXML
	    void cadastrar(ActionEvent event) {
		  
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
	    void voltar(ActionEvent event) {
	    	Telas.TelaTipodeQuestao();
	    }
}
