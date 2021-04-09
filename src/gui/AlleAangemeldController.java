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

public class AlleAangemeldController extends BorderPane implements Initializable {
	@FXML
	private ListView<String> lvAlleAangemeld;
	@FXML
	private Button btnAlleAangemeldSpeel;
	@FXML
	private Button btnAlleAangemeldOverzicht;

	private ResourceBundle bundle ;

	private DomeinController dc;

	public AlleAangemeldController(DomeinController dc, Locale l) {
		super();
		this.dc = dc;
		
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l);
		this.bundle = bundle;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AlleAangemeld.fxml"), this.bundle);
		loader.setRoot(this);
		loader.setController(this);
		try
		{
			loader.load();
		}
		catch(IOException ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> spelersnamen = FXCollections.observableArrayList(this.dc.geefSpelersnamen());
		this.lvAlleAangemeld.setItems(spelersnamen);
		
	}

}
