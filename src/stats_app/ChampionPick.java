/**
 * 
 */
package stats_app;

/**
 * @author olubeno
 *
 */


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChampionPick {
	
	private final SimpleStringProperty champ_name;
	private final SimpleStringProperty ban_rate;
	private final SimpleStringProperty win_rate;
	private final SimpleStringProperty pop_percent;
	
	public ChampionPick(String champ_name, String ban_rate, String win_rate, String pop_percent) {
		
		this.champ_name = new SimpleStringProperty(champ_name);
		this.ban_rate = new SimpleStringProperty(ban_rate);
		this.win_rate = new SimpleStringProperty(win_rate);
		this.pop_percent = new SimpleStringProperty(pop_percent);
	}
	
	//Get n Set
	
	//Champ Name
	public void setChamp_Name(String champ) {
		champ_name.set(champ);
	}
	public String getChamp_Name() {
		return champ_name.get();
	}
	public StringProperty nameProperty() {
		return champ_name;
	}
	
	
	//BanRate
	public void setBan_Rate(String bans) {
		ban_rate.set(bans);
	}
	public String getBan_Rate() {
		return ban_rate.get();
	}
	public StringProperty banProperty() {
		return ban_rate;
	}
	
	
	//WinRate
	public void setWin_Rate(String wins) {
		win_rate.set(wins);
	}
	public String getWin_Rate() {
		return win_rate.get();
	}
	public StringProperty winProperty() {
		return win_rate;
	}
	
	
	//Popularity
	public void setPop_Percent(String pop) {
		pop_percent.set(pop);
	}
	public String getPop_Percent() {
		return pop_percent.get();
	}
	public StringProperty popProperty() {
		return pop_percent;
	}

	
	


/*	public static void add(String champ_name, String ban_rate, String win_rate, String pop_percent) {
		// TODO Auto-generated method stub
		
	}*/	

}


