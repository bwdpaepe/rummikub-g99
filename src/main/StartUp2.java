package main;
	
	import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import domein.DomeinController;
import domein.Kleur;
import domein.Spel;
import domein.Speler;
import domein.Steen;
import gui.Spelsituatie2Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistentie.SpelerMapper;
import talen.Language;
	
	public class StartUp2 extends Application{
		// om meertaligheid te kunnen toepassen
		private ResourceBundle bundle;
		private Language language = Language.getInstance();
	
		//snelle login + zelf gekozen startsituatie
		@Override
		public void start(Stage primaryStage) throws Exception 
		{
			ResourceBundle bundle = ResourceBundle.getBundle("talen.ApplicationMessage");
			this.bundle = bundle;
			Locale l = new Locale("en","US");
			Spel spel = new Spel(3);
			SpelerMapper mapper = new SpelerMapper();
			Speler speler1 = mapper.zoekSpeler("joost", "wachtwoordjoost");
			Speler speler2 = mapper.zoekSpeler("bart", "wachtwoordbart");
			Speler speler3 = mapper.zoekSpeler("lynn", "wachtwoordlynn");
			spel.voegSpelerToe(speler1);
			spel.voegSpelerToe(speler2);
			spel.voegSpelerToe(speler3);
			DomeinController dc = new DomeinController(spel);
			
			List<Steen> startStenen1 = new ArrayList<Steen>();
			List<Steen> startStenen2 = new ArrayList<Steen>();
			List<Steen> startStenen3 = new ArrayList<Steen>();
			List<Steen> extraStenen1 = new ArrayList<Steen>();
			List<Steen> extraStenen2 = new ArrayList<Steen>();
			List<Steen> extraStenen3 = new ArrayList<Steen>();
			
			
			//voeg stenen toe als je de startstenen zelf wilt bepalen voor speler1
			startStenen1.addAll(Arrays.asList(
					new Steen(1, Kleur.BLAUW, "/images/B1.png"),
					new Steen(13, Kleur.BLAUW, "/images/B13.png"),
					new Steen(10, Kleur.BLAUW, "/images/B10.png"),
					new Steen(12, Kleur.BLAUW, "/images/B11.png"),
					new Steen(12, Kleur.BLAUW, "/images/B12.png"),
					new Steen(12, Kleur.GEEL, "/images/G12.png"),
					new Steen(12, Kleur.ROOD, "/images/R12.png")
					));
			
			//voeg stenen toe als je de speler1 extra stenen wilt geven aan het begin
			extraStenen1.addAll(Arrays.asList());
			
			
			//voeg stenen toe als je de startstenen zelf wilt bepalen voor speler2
			startStenen2.addAll(Arrays.asList());
			//voeg stenen toe als je de speler1 extra stenen wilt geven aan het begin
			extraStenen2.addAll(Arrays.asList(
					new Steen(0, Kleur.JOKER, "/images/J0.png")));
			
			
			//voeg stenen toe als je de startstenen zelf wilt bepalen voor speler3
			startStenen3.addAll(Arrays.asList());
			//voeg stenen toe als je de speler1 extra stenen wilt geven aan het begin
			extraStenen3.addAll(Arrays.asList(
					new Steen(13, Kleur.BLAUW, "/images/B13.png"),
					new Steen(10, Kleur.BLAUW, "/images/B10.png"),
					new Steen(11, Kleur.BLAUW, "/images/B11.png"),
					new Steen(12, Kleur.BLAUW, "/images/B12.png"),
					new Steen(0, Kleur.JOKER, "/images/J0.png")));
			
			
			if(!startStenen1.isEmpty()) {
				speler1.verwijderAllePersoonlijkeStenen();
				for(Steen s:startStenen1) {
					speler1.voegSteenToe(s);
				}
			} else {
				spel.normaleStenen(speler1);
			}
			for(Steen s:extraStenen1) {
				speler1.voegSteenToe(s);
			}
			if(!startStenen2.isEmpty()) {
				speler2.verwijderAllePersoonlijkeStenen();
				for(Steen s:startStenen2) {
					speler2.voegSteenToe(s);
				}
			} else {
				spel.normaleStenen(speler2);
			}
			for(Steen s:extraStenen2) {
				speler2.voegSteenToe(s);
			}
			if(!startStenen3.isEmpty()) {
				speler3.verwijderAllePersoonlijkeStenen();
				for(Steen s:startStenen3) {
					speler3.voegSteenToe(s);
				}
			} else {
				spel.normaleStenen(speler3);
			}
			for(Steen s:extraStenen3) {
				speler3.voegSteenToe(s);
			}
			dc.startSpel2();
			Scene scene = new Scene(new Spelsituatie2Controller(dc, l));
			primaryStage.setScene(scene);
			primaryStage.setTitle("Test Scenario");
	        primaryStage.show();
		}
		
		public static void main(String[] args) {
			
			launch(args);
		}

		
	
	}