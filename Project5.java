package stats_app;
/**
 * 
 */

/**
 * @author olubeno
 *
 */

import java.io.IOException;


/*import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

//import java.util.*;

//import java.io.*;
//import java.util.regex.*;
//import java.util.List;


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

		Parent parent = 
				FXMLLoader.load(getClass().getResource("Project5.fxml"));
		
		Scene scene = new Scene(parent);
		
		mainStage.getIcons().add(new Image("League_of_Legends_logo.PNG"));
		mainStage.getIcons().add(new Image("League-of-Legends-Background-Wallpaper-03517.jpg"));
		
		mainStage.setTitle("League Champion Stats");
		mainStage.setScene(scene);
		mainStage.show();
		
	}

}
