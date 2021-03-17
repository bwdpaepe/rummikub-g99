package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class AlleAangemeldController extends BorderPane {
	@FXML
	private ListView lvAlleAangemeld;
	@FXML
	private Button btnAlleAangemeldSpeel;
	@FXML
	private Button btnAlleAangemeldOverzicht;

	private DomeinController dc;

	public AlleAangemeldController(DomeinController dc) {
		super();
		this.dc = dc;
		ObservableList<String> spelersnamen = FXCollections.observableArrayList(dc.geefSpelersnamen());
		this.lvAlleAangemeld.setItems(spelersnamen);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AlleAangemeld.fxml"));
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

}
