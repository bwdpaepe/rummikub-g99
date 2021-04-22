module rummikub_g99 {
	exports persistentie;
	exports cui;
	exports talen;
	exports gui;
	exports main;
	exports domein;
	exports testen;
	exports exceptions;

	requires java.sql;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	
	opens main to javafx.graphics,javafx.fxml;
	opens gui to javafx.graphics,javafx.fxml;
}