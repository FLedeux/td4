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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import metier.Periodicite;
import metier.Revue;

public class Lanch_revue extends Application implements Initializable {

@FXML	private Label lbl_display;
@FXML	private  TextField tf_tarif;
@FXML	private TextField  tf_titre;
@FXML	private TextField tf_description;
@FXML	private ComboBox<Periodicite> cbb_perio;
	
	
	
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
		lbl_display.setText("");
		boolean creation = true;
		if(tf_titre.getText().trim()=="") {
			lbl_display.setText("le titre ne dois pas être vide; ");
			creation = false;
		}
		if((tf_tarif.getText().trim()=="")&&(Double.valueOf(tf_tarif.getText().trim())==0)) {
			lbl_display.setText(lbl_display.getText()+"le prix ne dois pas être vide ou égale a zéro; ");
			creation=false;
		}
		if(cbb_perio.getValue()==null) {
			lbl_display.setText(lbl_display.getText()+"il faut choisir une periodicité");
			creation=false;
		}
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
		if(creation) {
			Revue r = new Revue(0,tf_titre.getText(),tf_description.getText(),Double.valueOf(tf_tarif.getText()),tf_titre.getText()+".png",cbb_perio.getValue().getId());
			daos.getRevueDAO().create(r);
		}
	}
	
	public void test_num() {
//on key type check docu oracle et  verif si la touche appuyé est un diggit(isdigit) ou est un .
		
	}




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        this.cbb_perio.setItems( FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));		
	}
	

}
	