package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import View.Telas;
import dto.DisciplinaDTO;
import dto.ProvaDTO;
import dto.QuestoesSubjetivasDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.entity.Dificuldade;
import model.service.DisciplinaBO;
import model.service.ProvaBO;

public class TelaCadastroProvaController {
	@FXML private ComboBox<String> NivelUm;
	@FXML private ComboBox<String> NivelDois;
	@FXML private ComboBox<String> NivelTres;
	@FXML private ComboBox<String> combosemestre;
	@FXML private TextField codigo;
	private ObservableList<Dificuldade> obsDificuldades;
	private ObservableList<String> obslevel;
	private ObservableList<String> obssemestre;
	@FXML	private ComboBox<DisciplinaDTO> combodisciplina;
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
	    void cadastrar(ActionEvent event) {
		  DisciplinaDTO disc = combodisciplina.getSelectionModel().getSelectedItem();
		  String semestre = combosemestre.getSelectionModel().getSelectedItem();
		  String level01 = NivelUm.getSelectionModel().getSelectedItem();
		  String level02 = NivelDois.getSelectionModel().getSelectedItem();
		  String level03 = NivelTres.getSelectionModel().getSelectedItem();
		  System.out.println("Informações da prova:\nQuantidade de questões nivel 01: "+ level01);
		  System.out.println("Quantidade de questões nivel 02: "+ level02);
		  System.out.println("Quantidade de questões nivel 03: "+ level03);
		  System.out.println("Semestre da prova: "+ semestre);
		  System.out.println("Disciplina: " + disc.getNome());
		  System.out.println("codigo: " + codigo.getText());
		  ProvaDTO dto = new ProvaDTO();
		  String disciplina = disc.getNome();
		  dto.setDisciplina(disciplina);
		  dto.setNivelUm(level01);
		  dto.setNivelDois(level02);
		  dto.setNivelTres(level03);
		  dto.setSemestre(semestre);
		  dto.setCodigo(codigo.getText());
		  bo.adicionar(dto);
		  Telas.TeladeProvas();
		}
	  
	/*
	public void CadastrarProva(ActionEvent event) {
		try { 
			ProvaDTO prova = new ProvaDTO();
			if (DisciplinaTexto.getText().length() < 1) {
				throw new Exception(); 
				} 
			prova.setDisciplina(DisciplinaTexto.getText()); 
			int quantNivelUm = Integer.parseInt(NivelUm.getValue());
			int quantNivelDois = Integer.parseInt(NivelDois.getValue());
			int quantNivelTres = Integer.parseInt(NivelTres.getValue());
			for (int a = 0; a < quantNivelUm; a++) {
				prova.setNivelUm(prova.getNivelUm());
			}
			for (int a = 0; a < quantNivelDois; a++) {
				prova.setNivelDois(prova.getNivelDois());
			}
			for (int a = 0; a < quantNivelTres; a++) {
				prova.setNivelTres(prova.getNivelTres());
			}
			if (quantNivelUm + quantNivelDois + quantNivelTres == 0) {
				throw new Exception();
			}
			try {  
				bo.adicionar(prova);
				} 
			catch (Exception e) {
				throw new Exception(); 
				} 
				try { 
					Telas.TeladeProvas();
					} 
				catch (Exception e) { 
					// TODO Auto-generated catch block 
					e.printStackTrace(); 
					 } 
				} 
		catch (Exception e) {
		
		}
	}
	*/
	 
	public void Voltar(ActionEvent event){
		Telas.TeladeProvas();
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
    public void sair(ActionEvent event) {
		Telas.TeladeLogin();
    }
}
