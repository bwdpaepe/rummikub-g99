package main;
	
	import java.util.ResourceBundle;

import domein.DomeinController;
import gui.StartAanmeldenController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import talen.Language;
	
	public class StartUp extends Application{
			
		@Override
		public void start(Stage primaryStage) throws Exception 
		{
			DomeinController dc = new DomeinController();
			
			Scene scene = new Scene(new StartAanmeldenController(dc));
			primaryStage.setScene(scene);
			primaryStage.setTitle("Start aanmelden");
			primaryStage.show();
		}
		
		public static void main(String[] args) {
			
			launch(args);
		}
	
	}