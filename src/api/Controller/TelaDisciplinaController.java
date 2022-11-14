package api.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entity.Disciplina;
import model.entity.Questoes;
import model.entity.QuestoesObjetivas;
import model.service.DisciplinaBO;
import model.service.QuestoesObjetivasBO;
import model.service.QuestoesSubjetivasBO;

public class TelaDisciplinaController {
	@FXML private Button BotãoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	@FXML private Button CadastrarDisciplina;
	@FXML private Button EditarDisciplina;
	@FXML private Button RemoverDisciplina;
	@FXML private TableView<Disciplina> TabelaDisciplinas;
	@FXML private TableColumn<Disciplina, String> ColunaDisciplinasID;
	@FXML private TableColumn<Disciplina, String> ColunaDisciplinasNome;
	@FXML private TableColumn<Disciplina, String> ColunaDisciplinasAssunto;
	private DisciplinaBO bo = new DisciplinaBO();
    private ObservableList<Disciplina> listaDeDisciplinas;
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarDisciplinas();
	}
	public void listarDisciplinas() {
		List<Disciplina> disciplinas = bo.listar();
		listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		ColunaDisciplinasID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		ColunaDisciplinasNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		ColunaDisciplinasAssunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));
		TabelaDisciplinas.setItems(listaDeDisciplinas);
	}

	public void CadastrarDisciplina(ActionEvent event) {
		Telas.telaCadastrarDisciplina();
	}
	
	public void EditarDisciplina(ActionEvent event) {
		try { 
			if (TabelaDisciplinas.getSelectionModel().getSelectedItem() == null) 
				{ 
			throw new Exception();
				} 	
			else {
			Telas.telaEditarDisciplina();
				}
			}
		catch(Exception E) {
				
		}
		
	}
		
	public void RemoverDisciplina(ActionEvent event) {
		QuestoesObjetivasBO bo2 = new QuestoesObjetivasBO();
		QuestoesSubjetivasBO bo3 = new QuestoesSubjetivasBO();
		try { 
			if (TabelaDisciplinas.getSelectionModel().getSelectedItem() == null) 
		{ 
			throw new Exception();
		} 
			bo.remover(TabelaDisciplinas.getSelectionModel().getSelectedItem());
			List<QuestoesObjetivas> questoesobjetiva = bo2.listar();
			for (Questoes questaoobjetiva : questoesobjetiva) { 
				if (questaoobjetiva.getIdDisciplina() == TabelaDisciplinas.getSelectionModel().getSelectedItem().getCodigo()) { 
					bo2.remover(questaoobjetiva); 
					} 
				}
			for (Questoes questaosubjetiva : questoesobjetiva) { 
				if (questaosubjetiva.getIdDisciplina() == TabelaDisciplinas.getSelectionModel().getSelectedItem().getCodigo()) { 
					bo2.remover(questaosubjetiva); 
					} 
				}
			TabelaDisciplinas.getItems().removeAll(TabelaDisciplinas.getSelectionModel().getSelectedItem());
		}
		
		catch(Exception E) {
			
		}
	}
	
	public void Disciplinas(ActionEvent event){
		Telas.telaDisciplinas();
	}
	public void Questoes(ActionEvent event){
		Telas.telaQuestoes();
	}
	public void Inicio(ActionEvent event){
		Telas.telaCadastro();
	}
	public void Provas(ActionEvent event){
		Telas.telaProva();
	}
}
