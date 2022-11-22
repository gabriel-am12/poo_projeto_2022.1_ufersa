package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import dto.DisciplinaDTO;
import dto.QuestoesObjetivasDTO;
import dto.QuestoesSubjetivasDTO;
import model.entity.Disciplina;
import model.entity.QuestoesObjetivas;
import model.entity.QuestoesSubjetivas;
import model.service.QuestoesObjetivasBO;
import model.service.QuestoesSubjetivasBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TeladeQuestoesController implements Initializable{
	@FXML private TableColumn<QuestoesSubjetivasDTO, String> columnDificuldadeSubjetivas;
	   @FXML private TableColumn<QuestoesSubjetivasDTO, String> columnDisciplinaSubjetivas;
	   @FXML private TableColumn<QuestoesSubjetivasDTO, String> columnEnunciadoSubjetivas;
	   @FXML private TableColumn<QuestoesSubjetivasDTO, String> columnRespostaSubjetiva;
	   @FXML private TableView<QuestoesSubjetivasDTO> tabelaQuestoesSubjetivas;
	   
	   @FXML private TableColumn<QuestoesObjetivasDTO, String> columnDificuldadeObjetivas;
	   @FXML private TableColumn<QuestoesObjetivasDTO, String> columnDisciplinaObjetivas;
	   @FXML private TableColumn<QuestoesObjetivasDTO, String> columnEnunciadoObjetivas;
	   @FXML private TableColumn<QuestoesObjetivasDTO, String> columnResposta;
	   @FXML private TableView<QuestoesObjetivasDTO> tabelaQuestoesObjetivas;
	   
	   private QuestoesSubjetivasBO bo = new QuestoesSubjetivasBO();
	   private ObservableList<QuestoesSubjetivasDTO> listaDeQuestoesSubjetivas;
	    
	   
	   private QuestoesObjetivasBO bo2 = new QuestoesObjetivasBO();
	   private ObservableList<QuestoesObjetivasDTO> listaDeQuestoesObjetivas;
	   
	   
	   @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			listarQuestoesSubjetivas();
			listarQuestoesObjetivas();
		}
		public void listarQuestoesSubjetivas() {
			List<QuestoesSubjetivasDTO> questoes = bo.listar();
			listaDeQuestoesSubjetivas = FXCollections.observableArrayList(questoes);
			columnEnunciadoSubjetivas.setCellValueFactory(new PropertyValueFactory<>("enunciado"));
			columnDificuldadeSubjetivas.setCellValueFactory(new PropertyValueFactory<>("dificuldade"));
			columnRespostaSubjetiva.setCellValueFactory(new PropertyValueFactory<>("resposta"));
			columnDisciplinaSubjetivas.setCellValueFactory(new PropertyValueFactory<>("fk_disciplina"));
			tabelaQuestoesSubjetivas.setItems(listaDeQuestoesSubjetivas);
		}
		
		public void listarQuestoesObjetivas() {
			List<QuestoesObjetivasDTO> questoes = bo2.listar();
			listaDeQuestoesObjetivas = FXCollections.observableArrayList(questoes);
			columnEnunciadoObjetivas.setCellValueFactory(new PropertyValueFactory<>("enunciado"));
			columnDificuldadeObjetivas.setCellValueFactory(new PropertyValueFactory<>("dificuldade"));
			columnResposta.setCellValueFactory(new PropertyValueFactory<>("resposta"));
			columnDisciplinaObjetivas.setCellValueFactory(new PropertyValueFactory<>("fk_disciplina"));
			tabelaQuestoesObjetivas.setItems(listaDeQuestoesObjetivas);
		}
	
	public void adicionar(){
		Telas.TelaTipodeQuestao();
	}
	
	public void inicio() {
		Telas.TelaDashboard();
	}
	
	public void provas() {
		Telas.TeladeProvas();
	}
	
	public void disciplinas() {
		Telas.TeladeDisciplina();
	}
	
	public void questoes() {
		Telas.TeladeQuestoes();
	}
	String cod;
	int j = 0;
	
	public void RemoverQuestao(ActionEvent event) {
	
	}
	
	   @FXML
	    void selecionaritemtabelaObjetivas(MouseEvent event) {
		   	int i = tabelaQuestoesObjetivas.getSelectionModel().getSelectedIndex();
		   	QuestoesObjetivasDTO quest = (QuestoesObjetivasDTO)tabelaQuestoesObjetivas.getItems().get(i);
		   	System.out.println(quest.getCodigo());
		   	cod = quest.getCodigo();
		   	j = 1;
	    }
	   
	   @FXML
	    void selecionaritemtabelaSubjetivas(MouseEvent event) {
			int i = tabelaQuestoesSubjetivas.getSelectionModel().getSelectedIndex();
		   	QuestoesSubjetivasDTO quest = (QuestoesSubjetivasDTO)tabelaQuestoesSubjetivas.getItems().get(i);
		   	System.out.println(quest.getCodigo());
		   	cod = quest.getCodigo();
		    j = 2;
	    }
	
}
