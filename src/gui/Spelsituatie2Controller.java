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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Spelsituatie2Controller extends BorderPane implements Initializable {
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
	private Label lblSpelerAanZetSpeelbeurt;
	@FXML
	private GridPane grdPaneGv;
	@FXML
	private Label lblinfoLabelSpelSituatie2;
	@FXML
	private GridPane grdPaneWv;
	@FXML
	private GridPane grdPanePers;
	@FXML
	private ImageView IvImagePers10;
	@FXML
	private ImageView IvImagePers00;
	@FXML
	private ImageView IvImagePers02;
	@FXML
	private ImageView IvImagePers03;
	@FXML
	private ImageView IvImagePers01;
	@FXML
	private ImageView IvImagePers11;
	@FXML
	private ImageView IvImagePers12;
	@FXML
	private ImageView IvImagePers13;
	@FXML
	private ImageView IvImagePers04;
	@FXML
	private ImageView IvImagePers14;
	@FXML
	private ImageView IvImagePers05;
	@FXML
	private ImageView IvImagePers15;
	@FXML
	private ImageView IvImagePers06;
	@FXML
	private ImageView IvImagePers16;
	@FXML
	private ImageView IvImagePers07;
	@FXML
	private ImageView IvImagePers17;
	@FXML
	private ImageView IvImagePers08;
	@FXML
	private ImageView IvImagePers18;
	@FXML
	private ImageView IvImagePers09;
	@FXML
	private ImageView IvImagePers19;
	
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
		this.lblinfoLabelSpelSituatie2.setText(String.format
				("Selecteer een steen in werk- of persoonlijk veld.%nSelecteer vervolgens een lokatie in gemeenschappelijk veld"));
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
		this.IvImagePers12.setImage(new Image(getClass().getResourceAsStream("/images/B1.png")));


	}
	// Event Listener on Button[#btnBeëindigbeurtSpeelBeurt].onAction
	@FXML
	public void btnBeëindigbeurtSpeelBeurt(ActionEvent event) {
		dc.testvolgende();
		this.lblinfoLabelSpelSituatie2.setText(String.format("Volgende speler is aan zet."));
		this.lblSpelerAanZetSpeelbeurt.setText(String.format("Speler: %s",dc.geefNaamSpelerAanBeurt()));
		this.IvImagePers14.setImage(new Image(getClass().getResourceAsStream("/images/B1.png")));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//String speler = dc.geefNaamSpelerAanBeurt();
		this.lblSpelerAanZetSpeelbeurt.setText(String.format("Speler: %s",dc.geefNaamSpelerAanBeurt()));
	}

	
}
