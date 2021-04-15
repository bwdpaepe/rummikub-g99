package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import domein.DomeinController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class ToonScoreSpelersController extends BorderPane implements Initializable {
	@FXML
    private ListView<String> lvEindScores;
	@FXML
    private ListView<String> lvGebruikersNamen;
	
	private DomeinController dc;

	public ToonScoreSpelersController(DomeinController dc) {
		super();
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ToonScoreSpelers.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try{
			loader.load();
		}
		catch(IOException ex){
			throw new RuntimeException(ex);
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> namenLijst = FXCollections.observableArrayList(this.dc.geefSpelersnamen());
		this.lvEindScores.setItems(namenLijst);
		ObservableList<String> scoresLijst = FXCollections.observableArrayList(this.dc.geefScores());
		this.lvEindScores.setItems(scoresLijst);
	}
	
}
