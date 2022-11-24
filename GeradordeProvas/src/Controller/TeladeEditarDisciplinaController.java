package Controller;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import View.Telas;
import dto.DisciplinaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.dao.DisciplinaDAO;
import model.entity.Disciplina;
import model.service.DisciplinaBO;

public class TeladeEditarDisciplinaController implements Initializable{
	@FXML	private TextField Codigo;
	@FXML	private TextField EditarAssuntosTexto;
	@FXML	private TextField EditarNomeTexto;
	@FXML	private TableColumn<DisciplinaDTO, String> columnNome;
	@FXML	private TableColumn<DisciplinaDTO, String> columnCodigo;
	@FXML	private TableView<DisciplinaDTO> tabelaDisciplina;
	
	private DisciplinaBO bo = new DisciplinaBO();
	private ObservableList<DisciplinaDTO> listaDeDisciplinas;
	
	public void listarDisciplinas() {
		List<DisciplinaDTO> disciplinas = bo.listar();
		listaDeDisciplinas = FXCollections.observableArrayList(disciplinas);
		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tabelaDisciplina.setItems(listaDeDisciplinas);
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		listarDisciplinas();
	}
	
	@FXML
    void buscar(ActionEvent event) {
		String capturecod;
		capturecod = Codigo.getText();
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(capturecod);
		
		DisciplinaDAO disciplinadao = new DisciplinaDAO();
		ResultSet rs = disciplinadao.findBySpecifiedField(disciplina, "codigo");
		
		try {
			if (rs.next()){
				 	int empNum = rs.getInt("id");
				 	String codigo = rs.getString("codigo");
				    
				    String nome = rs.getString("nome");
				    String assuntos = rs.getString("assuntos");
				    
				    EditarAssuntosTexto.setText(assuntos);
				    EditarNomeTexto.setText(nome);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
    }
	
	@FXML
    void Disciplinas(ActionEvent event) {
		Telas.TeladeDisciplina();
    }

    @FXML
    void EditarDisciplina(ActionEvent event) {
    	
    	DisciplinaDTO disc = new DisciplinaDTO();
    	disc.setAssuntos(EditarAssuntosTexto.getText());
    	disc.setNome(EditarNomeTexto.getText());
    	if (bo.atualizar(disc)) {
			System.out.println("disciplina editada");
			Telas.TeladeDisciplina();
		}
    
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
    	Telas.TeladeDisciplina();
    }

	/*
	public void EditarDisciplina(ActionEvent event){
		DisciplinaDTO disciplina = tabelaDisciplina.getSelectionModel().getSelectedItem(); 
		try { 
			if (disciplina == null) {
				throw new Exception(); 
				} 
			else { 
				if (EditarNomeTexto.getText().length() < 1 || EditarAssuntosTexto.getText().length() < 1) {
					throw new Exception(); 
					} 
		disciplina.setAssuntos(EditarAssuntosTexto.getText()); 
		disciplina.setNome(EditarNomeTexto.getText()); 
		bo.atualizar(disciplina);  
		listaDeDisciplinas.set(disciplina.getId(), disciplina); 
			} 
		}  
		catch (Exception e) {
			
			} 
		}*/
    
    @FXML
    public void sair(ActionEvent event) {
		Telas.TeladeLogin();
    }
}
