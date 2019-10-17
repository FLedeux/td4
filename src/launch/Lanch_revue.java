package launch;

import java.net.URL;
import java.util.ResourceBundle;

import factory.DAOFactory;
import factory.Persistance;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import metier.Periodicite;
import metier.Revue;

public class Lanch_revue extends Application implements Initializable {

@FXML	private Label lbl_display;
@FXML	private TextField  tf_titre;
@FXML	private TextField tf_description;
@FXML	private TextField tf_tarif;
@FXML	private ComboBox<Periodicite> cbb_perio;
@FXML 	private Button b_creer;
	
	
	
	@Override 
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("revue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			primaryStage.setScene(scene);	
			primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	
	
	
	
	public static void main(String[] args) {
		launch(args);

	}

	
	public void creation() {
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
		Revue r = new Revue(0,tf_titre.getText(),tf_description.getText(),Double.valueOf(tf_tarif.getText()),tf_titre.getText()+".png",cbb_perio.getValue().getId());
		daos.getRevueDAO().create(r);
		lbl_display.setText(r.toString());
	}
	
	@FXML
	public void test_num(KeyEvent key) {
		
		boolean consumed = false;
		if(!Character.isDigit(key.getCharacter().charAt(0))&&(key.getCharacter().charAt(0)!='.')) {
				key.consume();
				consumed=true;
			}
		else if((key.getCharacter().charAt(0)=='.')&&(tf_tarif.getText().contains("."))){
				key.consume();
				consumed=true;
		}
		if((!tf_titre.getText().isEmpty()) && ((!consumed)||(!tf_tarif.getText().isEmpty())) && (cbb_perio.getValue()!=null)) {
			b_creer.setDisable(false);
		}
		else b_creer.setDisable(true);
		}
	
	
	public void test_vide(KeyEvent key) {
		if(Character.isLetterOrDigit(key.getCharacter().charAt(0))&& (!tf_tarif.getText().isEmpty()) && (cbb_perio.getValue()!=null)) {
			b_creer.setDisable(false);
		}
		else b_creer.setDisable(true);
	}
			




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        this.cbb_perio.setItems( FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));		
	}
	

}
	