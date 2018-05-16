package stats_app;
/**
 * 
 */

/**
 * @author olubeno
 *
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Project5 extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		launch(args);
		// TODO Auto-generated method stub
	}
	

	@Override
	public void start(Stage mainStage) throws IOException {
			// TODO Auto-generated method stub

		Parent parent = FXMLLoader.load(getClass().getResource("Project5New.fxml"));
		
		Scene scene = new Scene(parent);
		
		mainStage.getIcons().add(new Image("stats_app/lol.PNG"));
		//mainStage.getIcons().add(new Image("stats_app/lolwp.jpg"));
		
		mainStage.setTitle("League Champion Stats");
		mainStage.setScene(scene);
		mainStage.show();
		
	}

}
