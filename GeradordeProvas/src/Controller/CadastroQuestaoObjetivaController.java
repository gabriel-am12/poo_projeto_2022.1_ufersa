package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import View.Telas;
import dto.DisciplinaDTO;
import dto.QuestoesObjetivasDTO;
import dto.UsuarioDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.dao.DisciplinaDAO;
import model.entity.Dificuldade;
import model.entity.Disciplina;
import model.service.DisciplinaBO;
import model.service.QuestoesObjetivasBO;
import model.service.UsuarioBO;

public class CadastroQuestaoObjetivaController {
	  @FXML private TextField assunto;
	  @FXML private TextField codigo;
	  @FXML private TextField enunciado;
	  @FXML private TextField opcao01;
	  @FXML private TextField opcao02;
      @FXML private TextField opcao03;
      @FXML private TextField opcao04;
      @FXML private TextField opcao05;
      @FXML private ToggleGroup grupo;
      @FXML private ComboBox<Dificuldade> combodificuldade;
      		private List<Dificuldade> dificuldades = new ArrayList<>();
      		private ObservableList<Dificuldade> obsDificuldades;
	@FXML	private ComboBox<DisciplinaDTO> combodisciplina;
			private ObservableList<DisciplinaDTO> observableListDisciplina;
			private DisciplinaBO bo = new DisciplinaBO();
			private QuestoesObjetivasBO questbo = new QuestoesObjetivasBO();
	  
		@FXML
	    void cadastrar(ActionEvent event) {
		  DisciplinaDTO disc = combodisciplina.getSelectionModel().getSelectedItem();
		  System.out.println("disciplina selecionada: " + disc.getNome());
		  System.out.println("id da disciplina " + disc.getId());
		  String enun = enunciado.getText();
		  System.out.println("enunciado: " + enun);
		  
		  Dificuldade dificuldade = combodificuldade.getSelectionModel().getSelectedItem();
		  System.out.println("dificuldade selecionada: " + dificuldade.getNome());
		  RadioButton radio = (RadioButton) grupo.getSelectedToggle();
		  System.out.println("gabarito: " + radio.getText());
		  String gab = radio.getText();
		  
		  QuestoesObjetivasDTO dto = new QuestoesObjetivasDTO();
		  	String disciplina = disc.getNome();
		  	dto.setCodigo(codigo.getText());
		  	dto.setAssunto(assunto.getText());
		  	dto.setDificuldade(dificuldade.getNome());
		  	dto.setEnunciado(enunciado.getText());
		  	dto.setOpcao01(opcao01.getText());
		  	dto.setDisciplina(disciplina);
		  	dto.setOpcao02(opcao02.getText());
		  	dto.setOpcao03(opcao03.getText());
		  	dto.setOpcao04(opcao04.getText());
		  	dto.setOpcao05(opcao05.getText());
		  	switch(gab) {
		  	case "a)":
		  		dto.setResposta(opcao01.getText());
		  		break;
		  	case "b)":
		  		dto.setResposta(opcao02.getText());
		  		break;
		  	case "c)":
		  		dto.setResposta(opcao03.getText());
		  		break;
		  	case "d)":
		  		dto.setResposta(opcao04.getText());
		  		break;
		  	case "e)":
		  		dto.setResposta(opcao05.getText());
		  		break;
		  	default:
		  		dto.setResposta("Gabarito não cadastrado no sistema!");
		  	}
		  	questbo.adicionar(dto);
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
	    
	    /*0
	    Vector<Integer> iddisciplina = new Vector<Integer>();
	   private ObservableList<Disciplina> obsdisciplina;
	    public void mostrarvaloresdisciplina() {
	    	try {
	    		DisciplinaDAO disc = new DisciplinaDAO();
	    		ResultSet rs = disc.findAll();
	    		
	    		while(rs.next()) {
	    			
	    			iddisciplina.addElement(rs.getInt(1));
	    			combodisciplina.getItems().add(rs.getInt(2));
	    			
	    		}
	    	}catch(SQLException e) {
	    		e.fillInStackTrace();
	    	}
	    }*/
	    
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
