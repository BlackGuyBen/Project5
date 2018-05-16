package stats_app;

import java.awt.Desktop;
import java.io.IOException;
/**
 * Sample Skeleton for 'Project5.fxml' Controller Class
 */
/*import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;*/
import java.net.URI;
import java.net.URISyntaxException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
//Import from SceneBuilder
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

public class Project5_Controller {


    @FXML // fx:id="base"
    private AnchorPane base; // Value injected by FXMLLoader
 

   // @FXML // fx:id="Project5_Controller1"
   // private AnchorPane Project5_Controller1; // Value injected by FXMLLoader

    @FXML // fx:id="bkgrndImage"
    private ImageView bkgrndImage; // Value injected by FXMLLoader

    @FXML // fx:id="menu"
    private MenuBar menu; // Value injected by FXMLLoader

    @FXML // fx:id="menuFile"
    private Menu menuFile; // Value injected by FXMLLoader

    @FXML // fx:id="menuClose"
    private MenuItem menuClose; // Value injected by FXMLLoader

    @FXML // fx:id="menuEdit"
    private Menu menuEdit; // Value injected by FXMLLoader

    @FXML // fx:id="menuDelete"
    private MenuItem menuDelete; // Value injected by FXMLLoader

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
    
    @FXML
    void goToLeague(ActionEvent event) throws IOException, URISyntaxException {
    	Desktop d = Desktop.getDesktop();
    	d.browse(new URI("https://www.leagueofgraphs.com/champions/stats/by-champion-name"));
    }
 


    @FXML
    void searchChamps(ActionEvent event) throws IOException {
    	
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("characterView.fxml"));
    	Parent tableParent = loader.load();
    	
    	Scene tableScene = new Scene(tableParent);
    	
    	characterViewController controller = loader.getController();
    	//controller.initData(table.getSelectionModel().getSelectedItems());
    	controller.initData(table.getSelectionModel().getSelectedItems());
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableScene);
    	window.show();
    	
		

		
		//COME BACK TO THIS SEARCH FOR NEW WINDOW W/CHAMPION
    }

    @FXML
    void sortByBan(ActionEvent event) throws IOException {
    	
    }

    //ChampView will change to new window
    @FXML
    void champView(ActionEvent event) throws IOException {
    	
    }

public void initialize() {
	// TODO Auto-generated method stub
	try {
	Document doc;
	//String search = enterChamp.getText();
	String champ_name;
	String ban_rate;
	String win_rate;
	String pop_percent;
	
		doc = Jsoup.connect("https://www.leagueofgraphs.com/champions/stats/by-champion-name").get();
	
	//Setting up columns for table
		
		champCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		popCol.setCellValueFactory(cellData -> cellData.getValue().popProperty());
		winCol.setCellValueFactory(cellData -> cellData.getValue().winProperty());
		banCol.setCellValueFactory(cellData -> cellData.getValue().banProperty());
	
	
	ObservableList<Champ_List> champions = FXCollections.observableArrayList(); //List for values
	
	//table.setItems(champions);

	Elements champ = doc.select("table.data_table").select("tbody").first().children();
	
	for(Element row : champ) {
		champ_name = row.select("td:eq(1)").select("a").select("span").text();
		ban_rate = row.select("td:eq(4)").select("div:eq(1)").select("span").text();
		win_rate = row.select("td:eq(3)").select("div:eq(1)").select("span").text();
		pop_percent = row.select("td:eq(2)").select("div:eq(1)").select("span").text();
		String temp = champ_name; //Removing extra lines from table
		if (temp.equals("")) {
			row.remove();
		}else {
		
		champions.add( new Champ_List(champ_name,ban_rate, win_rate, pop_percent));
		}
	}
	
		//System.out.println(champions);
	
	BackgroundImage bkgrnd = new BackgroundImage(new Image("stats_app/lolwp.jpg"),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	
	base.setBackground(new Background(bkgrnd));
	table.setItems(champions);
	
	//FILTERING FOR SORT
	FilteredList<Champ_List> filtered = new FilteredList<>(champions,p -> true);
	
	enterChamp.textProperty().addListener((observable,oldValue,newValue) ->{
		filtered.setPredicate(name ->{
			if (newValue == null || newValue.isEmpty()) {
				return true;
			}
			
			String lowerCaseFilter = newValue.toLowerCase();
			//SORT TABLE BY EACH COLUMN
			if (name.getChamp_Name().toLowerCase().contains(lowerCaseFilter)) {
				return true;
			} else if (name.getBan_Rate().contains(lowerCaseFilter)) {
				return true;
			} else if (name.getWin_Rate().contains(lowerCaseFilter)) {
				return true;
			} else if (name.getPop_Percent().contains(lowerCaseFilter)) {
				return true;
			}
			return false;
		});
	});
	
	SortedList<Champ_List> sortedData = new SortedList<>(filtered);
	sortedData.comparatorProperty().bind(table.comparatorProperty()); //BIND SORTED DATA TO TABLE
	table.setItems(sortedData);
	
	}
	 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
}
}

