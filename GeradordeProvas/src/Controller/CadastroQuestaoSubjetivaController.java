package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import View.Telas;
import dto.DisciplinaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.DisciplinaDAO;
import model.entity.Disciplina;
import model.service.DisciplinaBO;

public class CadastroQuestaoSubjetivaController {
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

    @FXML
    private ComboBox<String> cbxdificuldade;

    @FXML
    private ComboBox<DisciplinaDTO> combodisciplina;
    
    private DisciplinaBO bo = new DisciplinaBO();
    private ObservableList<DisciplinaDTO> listaDeDisciplinas;
    
    
    @FXML
    protected void initialize() {
    	comboboxdisciplina();
    }
    
    @FXML
    void comboboxdisciplina() {
    	List<DisciplinaDTO> disciplinas = bo.listar();
		listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		combodisciplina.setItems(listaDeDisciplinas);
		
    }
    
    @FXML
    void clicado(MouseEvent event) {
    	combodisciplina.getValue();
    }
    
}
