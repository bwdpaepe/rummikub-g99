package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import talen.Language;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import domein.DomeinController;
import domein.Spel;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

public class GeefAantalKnoppenController extends BorderPane implements Initializable{
	@FXML
	private Label lblAantalSpelers;
	@FXML
	private RadioButton rbtn2Spelers;
	@FXML
	private ToggleGroup aantal;
	@FXML
	private RadioButton rbtn3Spelers;
	@FXML
	private RadioButton rbtn4Spelers;
	@FXML
	private Button btnAantalSpelers;
	
	private ResourceBundle bundle ;
	private DomeinController dc;
	private Language language = Language.getInstance();
	int aantalSpelers;
	
	public GeefAantalKnoppenController(DomeinController dc, Locale l) {
		super();
		this.dc = dc;
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l);
		this.bundle = bundle;
		language.stelTaalIn(l.getLanguage(), l.getCountry());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GeefAantalKnoppen.fxml"), this.bundle);
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
		dc.initialiseerSpel(this.radioButtonKeuze());
		
		Scene newScene = new Scene(new MeldAanController(this.dc, this.bundle.getLocale()));
		Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
	}
	
	public int radioButtonKeuze() {
		if(this.aantal.getSelectedToggle().equals(rbtn2Spelers))
			aantalSpelers = 2;
		if(this.aantal.getSelectedToggle().equals(rbtn3Spelers))
			aantalSpelers = 3;
		if(this.aantal.getSelectedToggle().equals(rbtn4Spelers))
			aantalSpelers = 4;
		return aantalSpelers;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.lblAantalSpelers.setText(String.format(language.getString("hoeveelSpelers") + "\n(min=%d, max=%d)",Spel.MINIMUM_SPELERS, Spel.MAXIMUM_SPELERS));
		
	}
}
