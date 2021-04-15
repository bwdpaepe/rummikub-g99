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
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	
	opens main to javafx.graphics,javafx.fxml;
	opens gui to javafx.graphics,javafx.fxml;
}