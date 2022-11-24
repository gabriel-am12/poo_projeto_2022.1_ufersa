package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import dto.QuestoesSubjetivasDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.service.QuestoesSubjetivasBO;

public class TelaTipodeQuestaoController{
		
	@FXML
    void adicionarobjetiva(ActionEvent event) {
		Telas.TelaCadastrarQuestaoObjetiva();
    }

    @FXML
    void adicionarsubjetiva(ActionEvent event) {
    	Telas.TelaCadastrarQuestaoSubjetiva();
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
