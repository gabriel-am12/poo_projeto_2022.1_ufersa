package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import dto.DisciplinaDTO;
import dto.ProvaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.entity.Disciplina;
import model.entity.Prova;
import model.entity.QuestoesObjetivas;
import model.service.DisciplinaBO;
import model.service.ProvaBO;

public class TelaProvaController implements Initializable{
	@FXML private Button BotãoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	 String cod;
	@FXML
    private TableColumn<ProvaDTO, String> ColunaProvasDisciplina;

    @FXML
    private TableColumn<ProvaDTO, String> ColunaProvasID;

    @FXML
    private TableColumn<ProvaDTO, String> ColunaProvasNivelDois;

    @FXML
    private TableColumn<ProvaDTO, String> ColunaProvasNivelTres;

    @FXML
    private TableColumn<ProvaDTO, String> ColunaProvasNivelUm;

    @FXML
    private TableColumn<ProvaDTO, String> ColunaProvasSemestre;
    
    @FXML
    private TableColumn<ProvaDTO, String> ColunaProvaCodigo;
    
    @FXML
    private TableView<ProvaDTO> TabelaProvas;
	
    private ProvaBO bo = new ProvaBO();
    private ObservableList<ProvaDTO> listaDeProvas;
    
    public void initialize(URL arg0, ResourceBundle arg1) { 
		listarProva();
	}
    
    public void listarProva() {
		List<ProvaDTO> provas = bo.listar();
		listaDeProvas = FXCollections.observableArrayList(provas);
		ColunaProvasDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
		ColunaProvasNivelDois.setCellValueFactory(new PropertyValueFactory<>("nivelDois"));
		ColunaProvasNivelTres.setCellValueFactory(new PropertyValueFactory<>("nivelTres"));
		ColunaProvasNivelUm.setCellValueFactory(new PropertyValueFactory<>("nivelUm"));
		ColunaProvasSemestre.setCellValueFactory(new PropertyValueFactory<>("semestre"));
		ColunaProvaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		TabelaProvas.setItems(listaDeProvas);
	}
	   
    @FXML
   public void RemoverProva(ActionEvent event) {
	    Prova dto = new Prova();
		dto.setCodigo(cod);
		bo.apagar(dto);
		Telas.TeladeProvas();
    }
	    @FXML
	   public void sair(ActionEvent event) {
	    	Telas.TeladeLogin();
	    }
    
	@FXML
    void CadastrarDisciplina(ActionEvent event) {
		Telas.TeladeCadastrarProva();
    }

    @FXML
    void EditarDisciplina(ActionEvent event) {
    	Telas.TeladeEditarProva();
    }
	
	public void Disciplinas(ActionEvent event){
		Telas.TeladeDisciplina();
	}
	public void Questoes(ActionEvent event){
		Telas.TeladeQuestoes();
	}
	public void Inicio(ActionEvent event){
		Telas.TelaDashboard();
	}
	public void Provas(ActionEvent event){
		Telas.TeladeProvas();
	}	
	   @FXML
	    void selecionaritemtabela(MouseEvent event) {
		   	int i = TabelaProvas.getSelectionModel().getSelectedIndex();
		   	ProvaDTO provinha = (ProvaDTO)TabelaProvas.getItems().get(i);
		   	System.out.println(provinha.getCodigo());
		   	cod = provinha.getCodigo();
	    }
}