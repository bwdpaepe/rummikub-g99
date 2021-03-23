package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import domein.DomeinController;
import domein.Spel;
import exceptions.BuitenBereikAantalSpelersException;
import exceptions.SpelerNietInDBException;
import exceptions.SpelerReedsAangemeldException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GeefAantalGebruikersController extends BorderPane implements Initializable {
	@FXML
	private Label lblAantalSpelers;
	@FXML
	private TextField txfAantalSpelers;
	@FXML
	private Button btnAantalSpelers;

	private DomeinController dc;

	public GeefAantalGebruikersController(DomeinController dc) {
		super();
		this.dc = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GeefAantalGebruikers.fxml"));
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

	// Event Listener on Button[#btnAantalSpelers].onAction
	@FXML
	public void btnAantalSpelersOnAction(ActionEvent event) {
		// TODO Autogenerated
		try {
			int aantalSpelers = Integer.parseInt(txfAantalSpelers.getText());
			dc.initialiseerSpel(aantalSpelers);
			
			Scene newScene = new Scene(new MeldAanController(this.dc));
			Stage stage = (Stage) this.getScene().getWindow();
	        stage.setScene(newScene);
	        stage.show();
	        
		} catch (BuitenBereikAantalSpelersException e){ 
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Ingevoerd aantal ongeldig!");
			errorAlert.setContentText(e.getMessage());
			errorAlert.showAndWait();
			
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Formaat invoer ongeldig!");
			errorAlert.setContentText(e.getMessage());
			errorAlert.showAndWait();
		}
		
		
		/*if(txfAantalSpelers.getText().matches("\\d")) {
			int aantalSpelers = Integer.parseInt(txfAantalSpelers.getText());
			dc.initialiseerSpel(aantalSpelers);
			
			Scene newScene = new Scene(new MeldAanController(this.dc));
			Stage stage = (Stage) this.getScene().getWindow();
	        stage.setScene(newScene);
	        stage.show();
		}*/
		// TODO else throw error
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.lblAantalSpelers.setText(String.format("Hoeveel spelers wenst u aan te melden?\n(min=%d, max=%d)",Spel.minimumSpelers, Spel.maximumSpelers));
		
	}
	
}
