package launch;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lanch_revue extends Application{

@FXML	private Label lbl_display;
@FXML	private  TextField tf_taif;
@FXML	private TextField  tf_titre;
@FXML	private TextField tf_descripton;
@FXML	private ComboBox cdd_perio;
	
	
	
	@Override 
	public void start(Stage primaryStage) {
		try {
			URL fxmlURL=getClass().getResource("revue.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = fxmlLoader.load();
			Scene scene = new Scene((VBox) root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ma premiÃ¨re fenÃªtre JavaFX");
			primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	
	
	public static void main(String[] args) {
		launch(args);

	}

	
	public void creation() {
// crée, mais verif si titre et périodicité selectionné
	}
	
	public void test_num() {
//on key type check docu oracle et  verif si la touche appuyé est un diggit(isdigit) ou est un .
		
	}
	

}
	