package domein;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;

//UC2
public class Steen {
	private int waarde;
	private Kleur kleur;
	//UC3
	//ArrayList<Image> images = new ArrayList<>();
	private String afbeelding;

	//UC2
	/** Constructor van Steen: argumenten waarde, kleur en reeksnummer */
	public Steen(int waarde, Kleur kleur, String afbeelding) {
		this.setWaarde(waarde);
		this.setKleur(kleur);
		//this.setImages(images);
		this.setAfbeelding(afbeelding);
		
	}

	//UC2
	public int getWaarde() {
		return waarde;
	}

	//UC2
	private void setWaarde(int waarde) {
		this.waarde = waarde;
	}

	//UC2
	public Kleur getKleur() {
		return kleur;
	}

	//UC2
	private void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}

	public String getAfbeelding() {
		return afbeelding;
	}

	private void setAfbeelding(String afbeelding) {
		this.afbeelding = afbeelding;
	}
	
	
	
	//UC3
	/*public ArrayList<Image> getImages() {
		return images;
	}*/
	//UC3
	/*public void setImages(ArrayList<Image> images) {
		this.images = images;
	}*/
	
}
