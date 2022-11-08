/**
 * 
 */
/**
 * @author Arthur Peixoto
 *
 */
module poo_projeto_ufersa_20221 {
	requires java.desktop;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.controls;
	opens View to javafx.graphics, javafx.fxml;
}      