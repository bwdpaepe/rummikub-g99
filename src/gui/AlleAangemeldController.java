package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import domein.DomeinController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AlleAangemeldController extends BorderPane implements Initializable {
	@FXML
	private ListView<String> lvAlleAangemeld;
	@FXML
	private Button btnAlleAangemeldSpeel;
	@FXML
	private Button btnAlleAangemeldOverzicht;

	private DomeinController dc;

	public AlleAangemeldController(DomeinController dc) {
		super();
		this.dc = dc;
		
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
	
	@FXML
	public void btnAlleAangemeldSpeelOnAction(ActionEvent event) {
		// TODO Autogenerated
		Scene newScene = new Scene(new ToonSpelerAanBeurtController(this.dc));
		Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
	}
	
	//UC 4
	/*@FXML
	public void btnAlleAangemeldOverzichtOnAction(ActionEvent event) {
		// TODO Autogenerated
		Scene newScene = new Scene(new ??Controller(this.dc));
		Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
	}*/
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> spelersnamen = FXCollections.observableArrayList(this.dc.geefSpelersnamen());
		this.lvAlleAangemeld.setItems(spelersnamen);	
	}

}
