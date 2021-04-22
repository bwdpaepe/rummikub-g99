package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domein.DomeinController;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SpelSituatieController extends BorderPane implements Initializable{
	@FXML
	private Label lblSpelersNaam;
	@FXML
	private Button btnEindeBeurt;

	private DomeinController dc;

	public SpelSituatieController(DomeinController dc) {
		super();
		this.dc = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SpelSituatie.fxml"));
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
	
	// Event Listener on Button[#btnEindeBeurt].onAction
	@FXML
	public void bntEindeBeurtOnAction(ActionEvent event) {
		// terug naar ToonSpelerAanBeurt !?
		Scene newScene = new Scene(new ToonSpelerAanBeurtController(this.dc));
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setScene(newScene);
		stage.show();
				
		//Exception Tijdelijk werkveld moet leeg zijn
		        
		        
		/*Toepassen methodes ?
		 * Methode (SteenKrijgenIndienNietsAfgeled)
		 */
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String spelerAanBeurt = this.dc.geefNaamSpelerAanBeurt(); 
		this.lblSpelersNaam.setText(String.format("%s", spelerAanBeurt));
	}
}
