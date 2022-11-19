package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.dao.DisciplinaDAO;
import model.entity.Disciplina;

public class CadastroQuestaoObjetivaController {
	@FXML
    private ComboBox<?> combodisciplina;
	  @FXML
	    void cadastrar(ActionEvent event) {
		  
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
}
