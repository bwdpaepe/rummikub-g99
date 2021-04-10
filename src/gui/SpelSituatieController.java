package gui;

import java.io.IOException;
import java.net.URL;

import domein.DomeinController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import talen.Language;
import java.util.ResourceBundle;

public class SpelSituatieController extends BorderPane{
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
	
	public void btnSpeelBeurtOnAction(ActionEvent event) {
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
	
	

}
