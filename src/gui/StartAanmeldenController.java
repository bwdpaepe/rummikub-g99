package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import domein.DomeinController;
import javafx.event.ActionEvent;

import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
	@FXML
    private ResourceBundle bundle ;

	public StartAanmeldenController(DomeinController dc) {
		super();
		this.dc = dc;
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage");
		this.bundle = bundle;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartAanmelden.fxml"), this.bundle);
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
		Locale l = new Locale("nl", "BE");
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l);
		this.bundle = bundle;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartAanmelden.fxml"), this.bundle);
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
	// Event Listener on MenuItem[#mbtnTaalMItemEN].onAction
	@FXML
	public void mbtnTaalMItemENOnAction(ActionEvent event) {
		// TODO Autogenerated
		Locale l = new Locale("en", "US");
		ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage", l);
		this.bundle = bundle;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartAanmelden.fxml"), this.bundle);
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
	// Event Listener on Button[#btnStartAanmelden].onAction
	@FXML
	public void btnStartAanmeldenOnAction(ActionEvent event) {
		// TODO Autogenerated
		Scene newScene = new Scene(new GeefAantalGebruikersController(this.dc, this.bundle.getLocale()));
		Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
	}
}