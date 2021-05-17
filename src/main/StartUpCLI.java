package main;

import cui.Application;
import domein.DomeinController;

public class StartUpCLI {

	public static void main(String[] args) {
		
		DomeinController dc = new DomeinController(); 
		Application app = new Application(dc);
		app.start();
	}

}
