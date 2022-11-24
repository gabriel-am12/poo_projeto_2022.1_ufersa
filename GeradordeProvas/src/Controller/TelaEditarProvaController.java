package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import dto.DisciplinaDTO;
import dto.ProvaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dao.DisciplinaDAO;
import model.dao.ProvaDao;
import model.entity.Dificuldade;
import model.entity.Disciplina;
import model.entity.Prova;
import model.service.DisciplinaBO;
import model.service.ProvaBO;

public class TelaEditarProvaController {
    @FXML
    private Button BotaoInicio;

    @FXML
    private Button BotaoProvas;

    @FXML
    private Button BotaoQuestoes;

    @FXML
    private Button BotãoDisciplina;

    @FXML
    private ComboBox<String> NivelDois;

    @FXML
    private ComboBox<String> NivelTres;

    @FXML
    private ComboBox<String> NivelUm;

    @FXML
    private Button Voltar;

    private ObservableList<Dificuldade> obsDificuldades;
	private ObservableList<String> obslevel;
	private ObservableList<String> obssemestre;
	
    @FXML
    private TextField codigo;

    @FXML
    private ComboBox<DisciplinaDTO> combodisciplina;
    
    private ObservableList<DisciplinaDTO> observableListDisciplina;
	private DisciplinaBO bodisc = new DisciplinaBO();
	private ProvaBO bo = new ProvaBO();
	private String[] opcoes = {"1", "2 ","3","4","5","6","7","8","9","10"};
	private String[] semestres = {"2019.1","2019.2","2020.1","2020.2","2021.1","2021.2","2022.1","2022.2"};
	
	 @FXML
	    protected void initialize() {
		  carregarComboBoxDisciplina();
		  carregarQuantidadeNivelTres();
		  carregarSemestres();
	    }
	  public void carregarComboBoxDisciplina() {
		  	List<DisciplinaDTO> disciplinas = bodisc.listar();
		  	observableListDisciplina = FXCollections.observableArrayList(disciplinas);
			combodisciplina.setItems(observableListDisciplina);
	  }
	  
	  public void carregarQuantidadeNivelTres(){
		  obslevel = FXCollections.observableArrayList(opcoes);
		  NivelTres.setItems(obslevel);
		  NivelDois.setItems(obslevel);
		  NivelUm.setItems(obslevel);
	  }
	  
	  public void carregarSemestres() {
		  obssemestre = FXCollections.observableArrayList(semestres);
		  combosemestre.setItems(obssemestre);
	  }
    @FXML
    private ComboBox<String> combosemestre;

    @FXML
    void Disciplinas(ActionEvent event) {
    	Telas.TeladeDisciplina();
    }

    @FXML
    void Inicio(ActionEvent event) {
    	Telas.TelaDashboard();
    }

    @FXML
    void Provas(ActionEvent event) {
    	Telas.TeladeProvas();
    }

    @FXML
    void Questoes(ActionEvent event) {
    	Telas.TeladeQuestoes();
    }

    @FXML
    void Voltar(ActionEvent event) {
    	Telas.TeladeProvas();
    }

    @FXML
    void editar(ActionEvent event) {
    	String capturecod;
		capturecod = codigo.getText();
		Prova provinha = new Prova();
		provinha.setCodigo(capturecod);
		
		ProvaDao provadao = new ProvaDao();
		ResultSet rs = provadao.findBySpecifiedField(provinha, "codigo");
		
		try {
			if (rs.next()){
					String level01 = rs.getString("nivelUm");
					String level02 = rs.getString("nivelDois");
					String level03 = rs.getString("nivelTres");
					String disciplina = rs.getString("disciplina");
					String semestre = rs.getString("semestre");
					NivelUm.setAccessibleText(level01);
					NivelUm.setPromptText(level01);
					NivelDois.setPromptText(level02);
					NivelTres.setPromptText(level03);
					combodisciplina.setPromptText(disciplina);
					combosemestre.setPromptText(semestre);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    public void sair(ActionEvent event) {
		Telas.TeladeLogin();
    }
}
