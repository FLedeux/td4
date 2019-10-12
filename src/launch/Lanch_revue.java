package launch;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lanch_revue extends Application{

	private Label lbl_display;
	private  TextField tf_taif;
	private TextField  tf_titre;
	private TextField tf_descripton;
	private ComboBox cdd_perio;
	
	
	
	@Override 
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("revue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ma première fenêtre JavaFX");
			primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	
	
	public static void main(String[] args) {
		launch(args);

	}

	
	public void creation() {
// si booléen de tarif est false alors pas creer : message d'erreur
	}
	
	public void test_num() {
		//test char par char et fair egaffe a la virgule/point)
		
	}
	

}
	