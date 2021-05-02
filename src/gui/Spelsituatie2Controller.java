package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Spelsituatie2Controller extends BorderPane implements Initializable{
	@FXML
	private Button btnJokerVervangenSpeelBeurt;
	@FXML
	private Button btnSplitsSpeelBeurt;
	@FXML
	private Button btnSteenAanleggenSpeelBeurt;
	@FXML
	private Button btnSteenNaarWerkveldSpeelBeurt;
	@FXML
	private Button btnResetBeurtSpeelBeurt;
	@FXML
	private Button btnBeëindigbeurtSpeelBeurt;
	@FXML
	private Label lblinfoLabelSpelSituatie2;
	@FXML
	private Label lblSpelerAanZetSpeelbeurt;
	private DomeinController dc;

	public Spelsituatie2Controller(DomeinController dc) {
		super();
		this.dc = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Spelsituatie2.fxml"));
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

	
	
	// Event Listener on Button[#btnJokerVervangenSpeelBeurt].onAction
	@FXML
	public void btnJokerVervangenSpeelbeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(String.format("Selecteer een steen in werk- of persoonlijk veld.%nVervolgens een joker gemeenschappelijk veld"));
	}
	// Event Listener on Button[#btnSplitsSpeelBeurt].onAction
	@FXML
	public void btnSplitsSpeelBeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(String.format("Selecteer rechts in de rij/reeks waar je wilt splitsen."));
		//this.lblinfoLabelSpelSituatie2.setStyle("-fx-text-fill: green;");
		
	}
	// Event Listener on Button[#btnSteenAanleggenSpeelBeurt].onAction
	@FXML
	public void btnSteenAanleggenSpeelBeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(String.format("Selecteer een steen in werk- of persoonlijk veld.%nSelecteer vervolgens een lokatie in gemeenschappelijk veld"));
	}
	// Event Listener on Button[#btnSteenNaarWerkveldSpeelBeurt].onAction
	@FXML
	public void btnSteenNaarWerkveldSpeelBeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(String.format("Selecteer een steen uit rij.%nOf selecteer een start -of eindsteen uit reeks."));
	}
	// Event Listener on Button[#btnResetBeurtSpeelBeurt].onAction
	@FXML
	public void btnResetBeurtSpeelBeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(String.format("Beurt werd gereset."));
	}
	// Event Listener on Button[#btnBeëindigbeurtSpeelBeurt].onAction
	@FXML
	public void btnBeëindigbeurtSpeelBeurt(ActionEvent event) {
		dc.testvolgende();
		this.lblinfoLabelSpelSituatie2.setText(String.format("Volgende speler is aan zet."));
		this.lblSpelerAanZetSpeelbeurt.setText(String.format("Speler: %s",dc.geefNaamSpelerAanBeurt()));
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//String speler = dc.geefNaamSpelerAanBeurt();
		this.lblSpelerAanZetSpeelbeurt.setText(String.format("Speler: %s",dc.geefNaamSpelerAanBeurt()));
	}

	
}
