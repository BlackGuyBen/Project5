package stats_app;

import java.io.IOException;
/**
 * Sample Skeleton for 'Project5.fxml' Controller Class
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



//Import from SceneBuilder
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Project5_Controller implements Initializable {

    @FXML // fx:id="Project5_Controller"
    private AnchorPane Project5_Controller; // Value injected by FXMLLoader

    @FXML // fx:id="Project5_Controller1"
    private AnchorPane Project5_Controller1; // Value injected by FXMLLoader

    @FXML // fx:id="bkgrndImage"
    private ImageView bkgrndImage; // Value injected by FXMLLoader

    @FXML // fx:id="menu"
    private MenuBar menu; // Value injected by FXMLLoader

    @FXML // fx:id="leagueSite"
    private MenuItem leagueSite; // Value injected by FXMLLoader

    @FXML // fx:id="table"
    private TableView<Champ_List> table; // Value injected by FXMLLoader

    	@FXML // fx:id="champCol"
    	private TableColumn<Champ_List, String> champCol; // Value injected by FXMLLoader

    	@FXML // fx:id="popCol"
    	private TableColumn<Champ_List, String> popCol; // Value injected by FXMLLoader

    	@FXML // fx:id="winCol"
    	private TableColumn<Champ_List, String> winCol; // Value injected by FXMLLoader

    	@FXML // fx:id="banCol"
    	private TableColumn<Champ_List, String> banCol; // Value injected by FXMLLoader
    	
    @FXML // fx:id="enterChamp"
    private TextField enterChamp; // Value injected by FXMLLoader

    @FXML // fx:id="banner"
    private Label banner; // Value injected by FXMLLoader

    @FXML // fx:id="leagueLogo"
    private ImageView leagueLogo; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="popSort"
    private RadioButton popSort; // Value injected by FXMLLoader

    @FXML // fx:id="winSort"
    private RadioButton winSort; // Value injected by FXMLLoader

    @FXML // fx:id="banSort"
    private RadioButton banSort; // Value injected by FXMLLoader

    @FXML
    void searchChamps(ActionEvent event) throws IOException {
    	
    	//DECLARATIONS:
    	String search;
    	
    	String champ_name;
    	String ban_rate;
    	String win_rate;
    	String pop_percent;
    	
    	//Initialize Champ_List Columns
    	champCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    	popCol.setCellValueFactory(cellData -> cellData.getValue().popProperty());
    	winCol.setCellValueFactory(cellData -> cellData.getValue().winProperty());
    	banCol.setCellValueFactory(cellData -> cellData.getValue().banProperty());
    	
    	search = enterChamp.getText();
    	
		Document doc = Jsoup.connect("https://www.leagueofgraphs.com/champions/stats/by-champion-name").get();
		
		//Get the elements you need
		//Elements table = doc.getElementsByClass("data_table");
		//Elements EachChamp = doc.select("table.data_table").select("tbody:eq(0)").select("tr");
		Elements EachChamp = doc.select("table.data_table").select("tbody").first().children();
		
		for (Element row : EachChamp) {
			
			champ_name = row.child(0).text();
			ban_rate = row.child(1).text();
			win_rate = row.child(2).text();
			pop_percent = row.child(3).text();
			
			
			//Could use regex to sort but this is easier...
			if(champ_name.equals(search)) {
				Champ_List.add(champ_name, ban_rate, win_rate, pop_percent);
				table.getSortOrder().add(champCol);
			}else if (banSort.isDisabled() == false) {
				table.getSortOrder().add(banCol);
				Champ_List.add(champ_name,  ban_rate, win_rate, pop_percent);
			}else if (winSort.isDisabled() == false) {
				table.getSortOrder().add(winCol);
				Champ_List.add(champ_name, ban_rate, win_rate, pop_percent);
			}else if (popSort.isDisabled() == false) {
				table.getSortOrder().add(popCol);
				Champ_List.add(champ_name, ban_rate, win_rate, pop_percent);
			}
			
					///Make sure to have the search add the rest of the champs after.
			System.out.println(row.text());			
		}

    }

    @FXML
    void sortByBan(ActionEvent event) throws IOException {
    	//Declarations  	

    }

    @FXML
    void sortByChamp(ActionEvent event) throws IOException{

    }

    @FXML
    void sortByPop(ActionEvent event) throws IOException {

    }

    @FXML
    void sortByWin(ActionEvent event) throws IOException{

    }


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	Document doc;
	try {
		doc = Jsoup.connect("https://www.leagueofgraphs.com/champions/stats/by-champion-name").get();
	
	
	//Get the elements you need
	//Elements table = doc.getElementsByClass("data_table");
	Elements champ = doc.select("table.data_table").select("tbody:eq(0)").select("tr");
	
	for (Element col : champ) {
		System.out.println(col.text());			
	}
	}
	 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}

