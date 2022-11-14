package api.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import View.Telas;
import api.dto.ProvaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entity.Questoes;
import model.entity.QuestoesObjetivas;
import model.service.ProvaBO;

public class TelaProvaController {
	@FXML private Button BotãoDisciplina;
	@FXML private Button BotaoQuestoes;
	@FXML private Button BotaoInicio;
	@FXML private Button BotaoProvas;
	@FXML private Button CadastrarProva;
	@FXML private Button EditarProva;
	@FXML private Button RemoverProva;
	@FXML private Button GerarRelatorio;
	@FXML private TextField TextoBuscarProva;
	@FXML private TableView<ProvaDTO> TabelaProvas;
	@FXML private TableColumn<ProvaDTO, String> ColunaProvasID;
	@FXML private TableColumn<ProvaDTO, String> ColunaProvasNivelUm;
	@FXML private TableColumn<ProvaDTO, String> ColunaProvasNivelDois;
	@FXML private TableColumn<ProvaDTO, String> ColunaProvasNivelTres;
	@FXML private TableColumn<ProvaDTO, String> ColunaProvasDisciplina;
	private ProvaBO bo = new ProvaBO();
    private ObservableList<ProvaDTO> listaDeProvas;
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarProvas();
	}
	public void listarProvas() {
		List<ProvaDTO> provas = bo.listar();
		listaDeProvas = FXCollections.observableArrayList(provas);
		ColunaProvasID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		ColunaProvasNivelUm.setCellValueFactory(new PropertyValueFactory<>("NívelUm"));
		ColunaProvasNivelDois.setCellValueFactory(new PropertyValueFactory<>("NívelDois"));
		ColunaProvasNivelTres.setCellValueFactory(new PropertyValueFactory<>("NívelTres"));
		ColunaProvasDisciplina.setCellValueFactory(new PropertyValueFactory<>("assunto"));
		TabelaProvas.setItems(listaDeProvas);
	}
	
	public void CadastrarProva(ActionEvent event){
		Telas.telaCadastrarProva();
	}
	
	public void GerarRelatorio(ActionEvent event){
		
	}
	
	public void EditarProva(ActionEvent event){
		Telas.telaEditarProva();
	}
	
	public void RemoverProva(ActionEvent event){
		try { 
			if (TabelaProvas.getSelectionModel().getSelectedItem() == null) 
		{ 
			throw new Exception();
		} 
			bo.remover(TabelaProvas.getSelectionModel().getSelectedItem());
			TabelaProvas.getItems().removeAll(TabelaProvas.getSelectionModel().getSelectedItem());
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
