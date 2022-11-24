package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import View.Telas;
import dto.DisciplinaDTO;
import dto.QuestoesSubjetivasDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.dao.QuestoesSubjetivasDAO;
import model.entity.Dificuldade;
import model.entity.Disciplina;
import model.entity.QuestoesSubjetivas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaEditarQuestaoSubjetivaController {

    @FXML
    private TextField AssuntoTexto;

    @FXML
    private Button BotaoInicio;

    @FXML
    private Button BotaoProvas;

    @FXML
    private Button BotaoQuestoes;

    @FXML
    private Button BotãoDisciplina;

    @FXML
    private ComboBox<Dificuldade> DificuldadeChoiceBox;

    @FXML
    private ComboBox<Disciplina> DisciplinaChoiceBox;

    @FXML
    private TextField EnunciadoTexto;

    @FXML
    private TextField RespostaTexto;

    @FXML
    private Button buttonOk;

    @FXML
    private TextField codigo;

    private List<Dificuldade> dificuldades = new ArrayList<>();
	private ObservableList<Dificuldade> obsDificuldades;
	private List<Dificuldade> disciplinas = new ArrayList<>();
	private ObservableList<Dificuldade> obsDisciplinas;
		
	@FXML
    void editar(ActionEvent event) {
		
		  

    }
	
	public void buscar(ActionEvent event)
	{
		String codig;
		codig = codigo.getText();
		QuestoesSubjetivas quests = new QuestoesSubjetivas();
		quests.setCodigo(codig);
		
		QuestoesSubjetivasDAO questsubDAO = new QuestoesSubjetivasDAO();
		ResultSet rs = questsubDAO.findBySpecifiedField(quests, "codigo");
		System.out.print(rs);
		
		/*
		quests.setAssunto(rs.getString("assunto"));
		quests.setEnunciado(rs.getString("enunciado"));
		quests.setResposta(rs.getString("resposta"));
		*/
		try {
			if (rs.next()){
				 int empNum = rs.getInt("id");
				 String codigo = rs.getString("codigo");
				    String enunciado = rs.getString("enunciado");
				    String tipo = rs.getString("tipo");
				    String assuntos = rs.getString("assuntos");
				    String datacriacao = rs.getString("data_criacao");
				    String dificuldade = rs.getString("dificuldade");
				    String disciplina= rs.getString("disciplina");
				    String resposta = rs.getString("resposta");
				    EnunciadoTexto.setText(enunciado);
				    RespostaTexto.setText(resposta);
				    AssuntoTexto.setText(assuntos);
			/*Dificuldade dificuldade = new Dificuldade(1,quests.getDificuldade());
				dificuldades.add(dificuldade);
				obsDificuldades = FXCollections.observableArrayList(dificuldades);
				DificuldadeChoiceBox.setItems(obsDificuldades);*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}