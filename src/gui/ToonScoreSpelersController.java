package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
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
import talen.Language;

public class ToonScoreSpelersController extends BorderPane implements Initializable {
	@FXML
    private ListView<String> lvEindScores;
	@FXML
    private ListView<String> lvGebruikersNamen;
	
	private DomeinController dc;
	
	private ResourceBundle bundle ;
	private Language language = Language.getInstance();

	public ToonScoreSpelersController(DomeinController dc, Locale l) {
		super();
		this.dc = dc;
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l);
		this.bundle = bundle;
		language.stelTaalIn(l.getLanguage(), l.getCountry());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ToonScoreSpelers.fxml"), this.bundle);
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

