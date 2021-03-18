package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import domein.DomeinController;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GeefAantalGebruikersController extends BorderPane {
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
		if(txfAantalSpelers.getText().matches("\\d")) {
			int aantalSpelers = Integer.parseInt(txfAantalSpelers.getText());
			dc.initialiseerSpel(aantalSpelers);
			
			Scene newScene = new Scene(new MeldAanController(this.dc));
			Stage stage = (Stage) this.getScene().getWindow();
	        stage.setScene(newScene);
	        stage.show();
		}
		// TODO else throw error
	}
}
