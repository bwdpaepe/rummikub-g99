package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import domein.DomeinController;
import javafx.event.ActionEvent;

import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import talen.Language;
import javafx.scene.control.MenuButton;

public class StartAanmeldenController extends BorderPane {
	@FXML
	private MenuButton mbtnTaal;
	@FXML
	private MenuItem mbtnTaalMItemNL;
	@FXML
	private MenuItem mbtnTaalMItemEN;
	@FXML
	private Button btnStartAanmelden;
	
	private DomeinController dc;
	private Language language = Language.getInstance();

	public StartAanmeldenController(DomeinController dc) {
		super();
		this.dc = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartAanmelden.fxml"));
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

	// Event Listener on MenuItem[#mbtnTaalMItemNL].onAction
	@FXML
	public void mbtnTaalMItemNLOnAction(ActionEvent event) {
		// TODO Autogenerated
		language.stelTaalIn("nl", "BE");
	}
	// Event Listener on MenuItem[#mbtnTaalMItemEN].onAction
	@FXML
	public void mbtnTaalMItemENOnAction(ActionEvent event) {
		// TODO Autogenerated
		language.stelTaalIn("en", "US");
	}
	// Event Listener on Button[#btnStartAanmelden].onAction
	@FXML
	public void btnStartAanmeldenOnAction(ActionEvent event) {
		// TODO Autogenerated
		Scene newScene = new Scene(new GeefAantalGebruikersController(this.dc));
		Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
	}
	
	
}
