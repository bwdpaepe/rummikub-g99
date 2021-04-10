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
import java.util.List;
import java.util.ResourceBundle;

import domein.DomeinController;
import exceptions.SpelerNietInDBException;
import exceptions.SpelerReedsAangemeldException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ToonScoreSpelersController extends BorderPane implements Initializable {
	@FXML
    private ListView<?> lvEindScores;
	
	private DomeinController dc;

	public ToonScoreSpelersController(DomeinController dc) {
		super();
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ToonScoreSpelers.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try{
			loader.load();
		}
		catch(IOException ex){
			throw new RuntimeException(ex);
		}
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> scoresLijst = FXCollections.observableArrayList(this.dc.geefScores());
		this.lvEindScores.setItems(scoresLijst);
	}
	
}
