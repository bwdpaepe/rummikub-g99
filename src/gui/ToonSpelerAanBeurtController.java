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

public class ToonSpelerAanBeurtController extends BorderPane implements Initializable {
	@FXML
	private Label lblSpelerAanZet;
	@FXML
	private Button btnSpeelBeurt;

	private DomeinController dc;
	
	public ToonSpelerAanBeurtController(DomeinController dc) {
		super();
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ToonSpelerAanBeurt.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try{
			loader.load();
		}
		catch(IOException ex){
			throw new RuntimeException(ex);
		}
	}
	
	@FXML
	public void btnSpeelBeurtOnAction(ActionEvent event) {
		//Doorgaan naar volgend scherm 
		Scene newScene = new Scene(new SpelSituatieController(this.dc));
		Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
        // opvangen exeptions uit domein ?  
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String spelerAanBeurt = this.dc.geefNaamSpelerAanBeurt(); 
		this.lblSpelerAanZet.setText(String.format("Speler aan zet: %s", spelerAanBeurt));
	}
}
