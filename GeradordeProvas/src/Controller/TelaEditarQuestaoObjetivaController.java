package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import View.Telas;
import dto.DisciplinaDTO;
import dto.QuestoesObjetivasDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.dao.DisciplinaDAO;
import model.dao.QuestoesObjetivasDAO;
import model.dao.QuestoesSubjetivasDAO;
import model.entity.Dificuldade;
import model.entity.Disciplina;
import model.entity.QuestoesObjetivas;
import model.entity.QuestoesSubjetivas;
import model.service.DisciplinaBO;
import model.service.QuestoesObjetivasBO;

public class TelaEditarQuestaoObjetivaController {

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

    @FXML private ComboBox<Dificuldade> combodificuldade;
    private List<Dificuldade> dificuldades = new ArrayList<>();
		private ObservableList<Dificuldade> obsDificuldades;
	@FXML private ComboBox<DisciplinaDTO> combodisciplina;
	private ObservableList<DisciplinaDTO> observableListDisciplina;
	private DisciplinaBO bo = new DisciplinaBO();
	private QuestoesObjetivasBO questbo = new QuestoesObjetivasBO();
    @FXML
    private TextField EnunciadoTexto;

    @FXML
    private TextField OpcaoATexto;

    @FXML
    private TextField OpcaoBTexto;

    @FXML
    private TextField OpcaoCTexto;

    @FXML
    private TextField OpcaoDTexto;

    @FXML
    private TextField OpcaoETexto;

    @FXML
    private TextField codigo;

    @FXML
    private Button editar;

    @FXML
    private ToggleGroup grupo;

    @FXML
    private Button voltar;

   
    @FXML
    void buscar(ActionEvent event)
	{
		String codig;
		codig = codigo.getText();
		QuestoesObjetivas quests = new QuestoesObjetivas();
		quests.setCodigo(codig);
		
		QuestoesObjetivasDAO questobjDAO = new QuestoesObjetivasDAO();
		ResultSet rs = questobjDAO.findBySpecifiedField(quests, "codigo");
		System.out.print(rs);
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
				    String opcao01 = rs.getString("opcao01");
				    String opcao02 = rs.getString("opcao02");
				    String opcao03 = rs.getString("opcao03");
				    String opcao04 = rs.getString("opcao04");
				    String opcao05 = rs.getString("opcao05");
				    OpcaoATexto.setText(opcao01);
				    OpcaoBTexto.setText(opcao02);
				    OpcaoCTexto.setText(opcao03);
				    OpcaoDTexto.setText(opcao04);
				    OpcaoETexto.setText(opcao05);
				    EnunciadoTexto.setText(enunciado);
				    AssuntoTexto.setText(assuntos);
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
    	Telas.TelaTipodeQuestaoEditar();
    }
    
    @FXML
    void editar(ActionEvent event) {
    	DisciplinaDTO disc = combodisciplina.getSelectionModel().getSelectedItem();
		  System.out.println("disciplina selecionada: " + disc.getNome());
		  System.out.println("id da disciplina " + disc.getId());
		  
		  String enun = EnunciadoTexto.getText();
		  System.out.println("enunciado: " + enun);
		  
		  Dificuldade dificuldade = combodificuldade.getSelectionModel().getSelectedItem();
		  System.out.println("dificuldade selecionada: " + dificuldade.getNome());
		 RadioButton radio = (RadioButton) grupo.getSelectedToggle();
		  System.out.println("gabarito: " + radio.getText());
		  String gab = radio.getText();
		  
		  QuestoesObjetivasDTO dto = new QuestoesObjetivasDTO();
	  		String disciplina = disc.getNome();
		  	dto.setAssunto(AssuntoTexto.getText());
		  	System.out.println(dto.getAssunto());
		  	dto.setDificuldade(dificuldade.getNome());
		  	dto.setEnunciado(EnunciadoTexto.getText());
		  	dto.setOpcao01(OpcaoATexto.getText());
		  	dto.setDisciplina(disciplina);
		  	dto.setId(disc.getId());
		  	dto.setOpcao02(OpcaoBTexto.getText());
		  	dto.setOpcao03(OpcaoCTexto.getText());
		  	dto.setOpcao04(OpcaoDTexto.getText());
		  	dto.setOpcao05(OpcaoETexto.getText());
		  	
		  	switch(gab) {
		  	case "a)":
		  		dto.setResposta(OpcaoATexto.getText());
		  		break;
		  	case "b)":
		  		dto.setResposta(OpcaoBTexto.getText());
		  		break;
		  	case "c)":
		  		dto.setResposta(OpcaoCTexto.getText());
		  		break;
		  	case "d)":
		  		dto.setResposta(OpcaoDTexto.getText());
		  		break;
		  	case "e)":
		  		dto.setResposta(OpcaoETexto.getText());
		  		break;
		  	default:
		  		dto.setResposta("Gabarito não cadastrado no sistema!");
		  	}
		  	try {
		  		boolean retonoz;
			  	retonoz = questbo.atualizar(dto);
			  	System.out.print(retonoz);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: "+e);
			}

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
  
  @FXML
  public void sair(ActionEvent event) {
		Telas.TeladeLogin();
  }
}