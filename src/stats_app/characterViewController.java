/**
 * 
 */
package stats_app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author olubeno
 *
 */
public class characterViewController implements Initializable {
	
    @FXML
    private Pane mainPane;
    
    private Champ_List champions;
    //@FXML private Label champNameLabel;
    //@FXML private Label champBanLabel;
    //@FXML private Label champWinLabel;
    @FXML private ImageView pic;
    @FXML
    private TextField enterChamp;

    @FXML
    private TableView<Champ_List> tableView;

    @FXML
    private TableColumn<Champ_List, String> champCol;

    @FXML
    private TableColumn<Champ_List, String> banCol;

    @FXML
    private TableColumn<Champ_List, String> winCol;
    
@FXML
private TableColumn<Champ_List, String> popCol;

@FXML
private ListView<Champ_List> listView;



    @FXML
    private Button goButton;
    
    @FXML
    void goClick(ActionEvent event) {
    	try {
			Element doc1;
			String search = enterChamp.getText();
			String champ_name;
			String ban_rate;
			String win_rate;
			String pop_percent;
			
				doc1 = Jsoup.connect("https://www.leagueofgraphs.com/champions/stats/by-champion-name").get();
			
			//Setting up columns for table
			
			
			ObservableList<Champ_List> champions = FXCollections.observableArrayList(); //List for values
			
			//tableView.setItems(initData(Champ_List));

			Elements champ = doc1.select("table.data_table").select("tbody").first().children();
			
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
			
			
			
		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    }
    
	//Method accepts champ initialized
	public void initData(Champ_List name) {
		champions = name;
		champCol.setText(champions.getChamp_Name());
		banCol.setText(champions.getBan_Rate());
		winCol.setText(champions.getWin_Rate());	
	}

	public void changeScreenButtonPush (ActionEvent event) throws IOException{
		Parent champViewParent = FXMLLoader.load(getClass().getResource("Project5New.fxml"));
    	Scene champViewScene = new Scene(champViewParent);
    	
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(champViewScene);
    	window.show();
	}
	
	


	public void initialize() {
		try {
			Element doc1;
			String search = enterChamp.getText();
			String champ_name;
			String ban_rate;
			String win_rate;
			String pop_percent;
			
				doc1 = Jsoup.connect("https://www.leagueofgraphs.com/champions/stats/by-champion-name").get();
			
			//Setting up columns for table
			
			
			ObservableList<Champ_List> champions = FXCollections.observableArrayList(); //List for values
			
			//table.setItems(champions);

			Elements champ = doc1.select("table.data_table").select("tbody").first().children();
			
			for(Element row : champ) {
				champ_name = row.select("td:eq(1)").select("a").select("span").text();
				ban_rate = row.select("td:eq(4)").select("div:eq(1)").select("span").text();
				win_rate = row.select("td:eq(3)").select("div:eq(1)").select("span").text();
				pop_percent = row.select("td:eq(2)").select("div:eq(1)").select("span").text();
				String temp = champ_name; //Removing extra lines from table
				if (temp.equals("")) {
					row.remove();
				}
				if(search == champ_name)
				{
					System.out.println(search);
					System.out.println(champ_name);
				champions.add( new Champ_List(champ_name,ban_rate, win_rate, pop_percent));
				tableView.setItems(champions);
				}else {
					tableView.setItems(null);
				}
			}
			
			
		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
	}

	public void initData(ObservableList<Champ_List> selectedItems) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
