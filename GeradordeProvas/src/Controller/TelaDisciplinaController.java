package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import dto.DisciplinaDTO;
import dto.UsuarioDTO;
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
import model.dao.DisciplinaDAO;
import model.entity.Disciplina;
import model.entity.Questoes;
import model.service.DisciplinaBO;
import model.service.QuestoesObjetivasBO;
import model.service.QuestoesSubjetivasBO;

public class TelaDisciplinaController implements Initializable{
	@FXML private Button BotaoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	@FXML private Button Buscar;
	@FXML private TextField TextoBuscar;
	@FXML private Button CadastrarDisciplina;
	@FXML private Button EditarDisciplina;
	@FXML private Button RemoverDisciplina;
	@FXML private TableView<DisciplinaDTO> tabelaDisciplina;
	@FXML private TableColumn<DisciplinaDTO, String> columnCodigo;
	@FXML private TableColumn<DisciplinaDTO, String> columnNome;
	@FXML private TableColumn<DisciplinaDTO, String> columnAssunto;
	private DisciplinaBO bo = new DisciplinaBO();
    private ObservableList<DisciplinaDTO> listaDeDisciplinas;
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarDisciplinas();
	}
	public void listarDisciplinas() {
		List<DisciplinaDTO> disciplinas = bo.listar();
		listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnAssunto.setCellValueFactory(new PropertyValueFactory<>("assuntos"));
		tabelaDisciplina.setItems(listaDeDisciplinas);
	}
	
	public void buscar() {
		if (BuscarTexto.getText().length() < 1) {
			throw new Exception();
		}
		else {
		List<DisciplinaDTO> disciplinas = bo.listar();
		ObservableList<DisciplinaDTO> listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		for(int x = 0; x <disciplinas.size();x++) {
			if(disciplinas.get(x).getNome().contains(BuscarTexto.getText())){
				listaDeDisciplinas.add(disciplinas.get(x));
			}
			tabelaDisciplina.setItems(listaDeDisciplinas);
		}
		}
	}

	public void CadastrarDisciplina(ActionEvent event) {
		Telas.TeladeCadastrarDisciplina();
	}
	
	public void EditarDisciplina(ActionEvent event) {
		Telas.TeladeEditarDisciplina();
	}
	
	public void RemoverDisciplina(ActionEvent event) {
		Disciplina dto = new Disciplina();
		dto.setCodigo(cod);
		bo.apagar(dto);
		Telas.TeladeDisciplina();
	}
	
	/*
	@FXML
	protected void linhaselecionada(MouseEvent e) {
		int i = tabelaDisciplina.getSelectionModel().getSelectedIndex();
		Disciplina disc = (Disciplina)tabelaDisciplina.getItems().get(i);
	}*/
	
	/*
	public void EditarDisciplina(ActionEvent event) {
		try { 
			if (TabelaDisciplinas.getSelectionModel().getSelectedItem() == null) 
				{ 
			throw new Exception();
				} 	
			else {
			Telas.TeladeEditarDisciplina();
				}
			}
		catch(Exception E) {
				
		}
		
	}*/
	
	
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
	
	String cod;
	   @FXML
	    void selecionaritemtabela(MouseEvent event) {
		   	int i = tabelaDisciplina.getSelectionModel().getSelectedIndex();
		   	DisciplinaDTO disc = (DisciplinaDTO)tabelaDisciplina.getItems().get(i);
		   	System.out.println(disc.getNome());
		   	cod = disc.getCodigo();
	    }
	   

}