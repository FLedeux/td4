package launch;

import java.net.URL;
import java.util.ResourceBundle;

import factory.DAOFactory;
import factory.Persistance;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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
@FXML	private TextField tf_descripton;
@FXML	private ComboBox<Periodicite> cdd_perio;
	
	
	
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
		Revue r = new Revue(0,tf_titre.getText(),tf_descripton.getText(),Double.valueOf(tf_tarif.getText()),tf_titre.getText()+".png",cdd_perio.getValue().getId());
		daos.getRevueDAO().create(r);
		
	}
	
	public void test_num() {
//on key type check docu oracle et  verif si la touche appuyé est un diggit(isdigit) ou est un .
		
	}




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        System.out.println(this.cdd_perio);
        
        this.cdd_perio.setItems(FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));		
	}
	

}
	