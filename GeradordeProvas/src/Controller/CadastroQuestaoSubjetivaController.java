package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import View.Telas;
import dto.DisciplinaDTO;
import dto.QuestoesObjetivasDTO;
import dto.QuestoesSubjetivasDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.DisciplinaDAO;
import model.entity.Dificuldade;
import model.entity.Disciplina;
import model.service.DisciplinaBO;
import model.service.QuestoesObjetivasBO;
import model.service.QuestoesSubjetivasBO;

public class CadastroQuestaoSubjetivaController {
	 @FXML private TextField assunto;
	  @FXML private TextField codigo;
	  @FXML private TextField enunciado;
	  @FXML private TextField resposta;
     @FXML private ComboBox<Dificuldade> combodificuldade;
     		private List<Dificuldade> dificuldades = new ArrayList<>();
     		private ObservableList<Dificuldade> obsDificuldades;
	@FXML	private ComboBox<DisciplinaDTO> combodisciplina;
			private ObservableList<DisciplinaDTO> observableListDisciplina;
			private DisciplinaBO bo = new DisciplinaBO();
			private QuestoesSubjetivasBO questsub = new QuestoesSubjetivasBO();
	  
		@FXML
	    void cadastrar(ActionEvent event) {
		  DisciplinaDTO disc = combodisciplina.getSelectionModel().getSelectedItem();
		  System.out.println("disciplina selecionada: " + disc.getNome());
		  System.out.println("id da disciplina " + disc.getId());
		  String enun = enunciado.getText();
		  System.out.println("enunciado: " + enun);
		  
		  Dificuldade dificuldade = combodificuldade.getSelectionModel().getSelectedItem();
		  System.out.println("dificuldade selecionada: " + dificuldade.getNome());
		  
		  QuestoesSubjetivasDTO dto = new QuestoesSubjetivasDTO();
		  String disciplina = disc.getNome();
		  	dto.setIdDisciplina(disc.getId());
		  	dto.setCodigo(codigo.getText());
		  	dto.setAssunto(assunto.getText());
		  	dto.setDificuldade(dificuldade.getNome());
		  	dto.setDisciplina(disciplina);
		  	dto.setEnunciado(enunciado.getText());
		  	dto.setResposta(resposta.getText());
		  	questsub.adicionar(dto);
		  	Telas.TeladeQuestoes();
		}
	  
	  @FXML
	    protected void initialize() {
		  carregarComboBoxDisciplina();
		  carregarDificuldade();
	    }
	  
	  public void carregarComboBoxDisciplina() {
		  	List<DisciplinaDTO> disciplinas = bo.listar();
		  	observableListDisciplina = FXCollections.observableArrayList(disciplinas);
			combodisciplina.setItems(observableListDisciplina);
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
	    public void sair(ActionEvent event) {
			Telas.TeladeLogin();
	    }
	    
	    public void carregarDificuldade() {
	    	Dificuldade dificuldade01 = new Dificuldade(1,"Facil");
	    	Dificuldade dificuldade02 = new Dificuldade(1,"Medio");
	    	Dificuldade dificuldade03 = new Dificuldade(1,"Dificil");
	    	dificuldades.add(dificuldade01);
	    	dificuldades.add(dificuldade02);
	    	dificuldades.add(dificuldade03);
	    	obsDificuldades = FXCollections.observableArrayList(dificuldades);
	    	combodificuldade.setItems(obsDificuldades);
	    }
    
}
