package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import domein.DomeinController;
import exceptions.SpelerNietInDBException;
import exceptions.SpelerReedsAangemeldException;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class MeldAanController extends BorderPane implements Initializable {
	@FXML
	private Label lblMeldAan;
	@FXML
	private Button btnMeldAan;
	@FXML
	private TextField txfMeldAanSpelersnaam;
	@FXML
	private TextField txfMeldAanWachtwoord;

	private DomeinController dc;

	public MeldAanController(DomeinController dc) {
		super();
		this.dc = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MeldAan.fxml"));
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

	// Event Listener on Button[#btnMeldAan].onAction
	@FXML
	public void btnMeldAanOnAction(ActionEvent event) {
		// TODO Autogenerated
		
		String spelersnaam = txfMeldAanSpelersnaam.getText();
		String wachtwoord = txfMeldAanWachtwoord.getText();
		
		try {
			if(spelersnaam == null || spelersnaam.isBlank() || wachtwoord == null || wachtwoord.isBlank()) 
			{
				throw new InputMismatchException("Spelersnaam en wachtwoord mogen niet leeg zijn!");
			}
			
			dc.meldAan(spelersnaam,wachtwoord);
			
			if(!dc.bepaalAlleSpelersAangemeld()) {
				txfMeldAanSpelersnaam.clear();
				txfMeldAanWachtwoord.clear();
			}
			else {
				Scene newScene = new Scene(new AlleAangemeldController(this.dc));
				Stage stage = (Stage) this.getScene().getWindow();
			       stage.setScene(newScene);
			       stage.show();
			}
		} catch (SpelerNietInDBException e) {
			// TODO Auto-generated catch block
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Speler bestaat niet!");
			errorAlert.setContentText(e.getMessage());
			errorAlert.showAndWait();
		} catch (SpelerReedsAangemeldException e) {
			// TODO Auto-generated catch block
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Speler is reeds aangemeld!");
			errorAlert.setContentText(e.getMessage());
			errorAlert.showAndWait();
		} catch (InputMismatchException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Invoer ongeldig!");
			errorAlert.setContentText(e.getMessage());
			errorAlert.showAndWait();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.lblMeldAan.setText(String.format("Geef spelersnaam en wachtwoord van speler %d:", 2));
		
	}
	
	
}
