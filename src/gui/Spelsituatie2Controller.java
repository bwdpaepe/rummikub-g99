package gui;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Spelsituatie2Controller extends BorderPane implements Initializable {
	@FXML
	private Button btnJokerVervangenSpeelBeurt;
	@FXML
	private Button btnSplitsSpeelBeurt;
	@FXML
	private Button btnSteenAanleggenSpeelBeurt;
	@FXML
	private Button btnSteenNaarWerkveldSpeelBeurt;
	@FXML
	private Button btnResetBeurtSpeelBeurt;
	@FXML
	private Button btnBeëindigbeurtSpeelBeurt;
	@FXML
	private Label lblSpelerAanZetSpeelbeurt;
	@FXML
	private GridPane grdPaneGv;
	@FXML
	private ImageView IvImageGV00;
	@FXML
	private ImageView IvImageGV01;
	@FXML
	private ImageView IvImageGV02;
	@FXML
	private ImageView IvImageGV03;
	@FXML
	private ImageView IvImageGV04;
	@FXML
	private ImageView IvImageGV05;
	@FXML
	private ImageView IvImageGV06;
	@FXML
	private ImageView IvImageGV07;
	@FXML
	private ImageView IvImageGV08;
	@FXML
	private ImageView IvImageGV09;
	@FXML
	private ImageView IvImageGV10;
	@FXML
	private ImageView IvImageGV11;
	@FXML
	private ImageView IvImageGV12;
	@FXML
	private ImageView IvImageGV13;
	@FXML
	private ImageView IvImageGV14;
	@FXML
	private ImageView IvImageGV15;
	@FXML
	private ImageView IvImageGV16;
	@FXML
	private ImageView IvImageGV17;
	@FXML
	private ImageView IvImageGV18;
	@FXML
	private ImageView IvImageGV19;
	@FXML
	private ImageView IvImageGV20;
	@FXML
	private ImageView IvImageGV21;
	@FXML
	private ImageView IvImageGV22;
	@FXML
	private ImageView IvImageGV23;
	@FXML
	private ImageView IvImageGV24;
	@FXML
	private ImageView IvImageGV25;
	@FXML
	private ImageView IvImageGV26;
	@FXML
	private ImageView IvImageGV27;
	@FXML
	private ImageView IvImageGV28;
	@FXML
	private ImageView IvImageGV29;
	@FXML
	private ImageView IvImageGV30;
	@FXML
	private ImageView IvImageGV31;
	@FXML
	private ImageView IvImageGV32;
	@FXML
	private ImageView IvImageGV33;
	@FXML
	private ImageView IvImageGV34;
	@FXML
	private ImageView IvImageGV35;
	@FXML
	private ImageView IvImageGV36;
	@FXML
	private ImageView IvImageGV37;
	@FXML
	private ImageView IvImageGV38;
	@FXML
	private ImageView IvImageGV39;
	@FXML
	private ImageView IvImageGV40;
	@FXML
	private ImageView IvImageGV41;
	@FXML
	private ImageView IvImageGV42;
	@FXML
	private ImageView IvImageGV43;
	@FXML
	private ImageView IvImageGV44;
	@FXML
	private ImageView IvImageGV45;
	@FXML
	private ImageView IvImageGV46;
	@FXML
	private ImageView IvImageGV47;
	@FXML
	private ImageView IvImageGV48;
	@FXML
	private ImageView IvImageGV49;
	@FXML
	private ImageView IvImageGV50;
	@FXML
	private ImageView IvImageGV51;
	@FXML
	private ImageView IvImageGV52;
	@FXML
	private ImageView IvImageGV53;
	@FXML
	private ImageView IvImageGV54;
	@FXML
	private ImageView IvImageGV55;
	@FXML
	private ImageView IvImageGV56;
	@FXML
	private ImageView IvImageGV57;
	@FXML
	private ImageView IvImageGV58;
	@FXML
	private ImageView IvImageGV59;
	@FXML
	private ImageView IvImageGV60;
	@FXML
	private ImageView IvImageGV61;
	@FXML
	private ImageView IvImageGV62;
	@FXML
	private ImageView IvImageGV63;
	@FXML
	private ImageView IvImageGV64;
	@FXML
	private ImageView IvImageGV65;
	@FXML
	private ImageView IvImageGV66;
	@FXML
	private ImageView IvImageGV67;
	@FXML
	private ImageView IvImageGV68;
	@FXML
	private ImageView IvImageGV69;
	@FXML
	private ImageView IvImageGV70;
	@FXML
	private ImageView IvImageGV71;
	@FXML
	private ImageView IvImageGV72;
	@FXML
	private ImageView IvImageGV73;
	@FXML
	private ImageView IvImageGV74;
	@FXML
	private ImageView IvImageGV75;
	@FXML
	private ImageView IvImageGV76;
	@FXML
	private ImageView IvImageGV77;
	@FXML
	private ImageView IvImageGV78;
	@FXML
	private ImageView IvImageGV79;
	@FXML
	private ImageView IvImageGV80;
	@FXML
	private ImageView IvImageGV81;
	@FXML
	private ImageView IvImageGV82;
	@FXML
	private ImageView IvImageGV83;
	@FXML
	private ImageView IvImageGV84;
	@FXML
	private ImageView IvImageGV85;
	@FXML
	private ImageView IvImageGV86;
	@FXML
	private ImageView IvImageGV87;
	@FXML
	private ImageView IvImageGV88;
	@FXML
	private ImageView IvImageGV89;
	@FXML
	private ImageView IvImageGV90;
	@FXML
	private ImageView IvImageGV91;
	@FXML
	private ImageView IvImageGV92;
	@FXML
	private ImageView IvImageGV93;
	@FXML
	private ImageView IvImageGV94;
	@FXML
	private ImageView IvImageGV95;
	@FXML
	private ImageView IvImageGV96;
	@FXML
	private ImageView IvImageGV97;
	@FXML
	private ImageView IvImageGV98;
	@FXML
	private ImageView IvImageGV99;
	@FXML
	private ImageView IvImageGV100;
	@FXML
	private ImageView IvImageGV101;
	@FXML
	private ImageView IvImageGV102;
	@FXML
	private ImageView IvImageGV103;
	@FXML
	private ImageView IvImageGV104;
	@FXML
	private ImageView IvImageGV105;
	@FXML
	private ImageView IvImageGV106;
	@FXML
	private ImageView IvImageGV107;
	@FXML
	private ImageView IvImageGV108;
	@FXML
	private ImageView IvImageGV109;
	@FXML
	private ImageView IvImageGV110;
	@FXML
	private ImageView IvImageGV111;
	@FXML
	private ImageView IvImageGV112;
	@FXML
	private ImageView IvImageGV113;
	@FXML
	private ImageView IvImageGV114;
	@FXML
	private ImageView IvImageGV115;
	@FXML
	private ImageView IvImageGV116;
	@FXML
	private ImageView IvImageGV117;
	@FXML
	private ImageView IvImageGV118;
	@FXML
	private ImageView IvImageGV119;
	@FXML
	private ImageView IvImageGV120;
	@FXML
	private ImageView IvImageGV121;
	@FXML
	private ImageView IvImageGV122;
	@FXML
	private ImageView IvImageGV123;
	@FXML
	private ImageView IvImageGV124;
	@FXML
	private ImageView IvImageGV125;
	@FXML
	private ImageView IvImageGV126;
	@FXML
	private ImageView IvImageGV127;
	@FXML
	private ImageView IvImageGV128;
	@FXML
	private ImageView IvImageGV129;
	@FXML
	private ImageView IvImageGV130;
	@FXML
	private ImageView IvImageGV131;
	@FXML
	private ImageView IvImageGV132;
	@FXML
	private ImageView IvImageGV133;
	@FXML
	private ImageView IvImageGV134;
	@FXML
	private ImageView IvImageGV135;
	@FXML
	private ImageView IvImageGV136;
	@FXML
	private ImageView IvImageGV137;
	@FXML
	private ImageView IvImageGV138;
	@FXML
	private ImageView IvImageGV139;
	@FXML
	private ImageView IvImageGV140;
	@FXML
	private ImageView IvImageGV141;
	@FXML
	private ImageView IvImageGV142;
	@FXML
	private ImageView IvImageGV143;
	@FXML
	private ImageView IvImageGV144;
	@FXML
	private ImageView IvImageGV145;
	@FXML
	private ImageView IvImageGV146;
	@FXML
	private ImageView IvImageGV147;
	@FXML
	private ImageView IvImageGV148;
	@FXML
	private ImageView IvImageGV149;
	@FXML
	private ImageView IvImageGV150;
	@FXML
	private ImageView IvImageGV151;
	@FXML
	private ImageView IvImageGV152;
	@FXML
	private ImageView IvImageGV153;
	@FXML
	private ImageView IvImageGV154;
	@FXML
	private ImageView IvImageGV155;
	@FXML
	private ImageView IvImageGV156;
	@FXML
	private ImageView IvImageGV157;
	@FXML
	private ImageView IvImageGV158;
	@FXML
	private ImageView IvImageGV159;
	@FXML
	private ImageView IvImageGV160;
	@FXML
	private ImageView IvImageGV161;
	@FXML
	private ImageView IvImageGV162;
	@FXML
	private ImageView IvImageGV163;
	@FXML
	private ImageView IvImageGV164;
	@FXML
	private ImageView IvImageGV165;
	@FXML
	private ImageView IvImageGV166;
	@FXML
	private ImageView IvImageGV167;
	@FXML
	private ImageView IvImageGV168;
	@FXML
	private ImageView IvImageGV169;
	@FXML
	private ImageView IvImageGV170;
	@FXML
	private ImageView IvImageGV171;
	@FXML
	private ImageView IvImageGV172;
	@FXML
	private ImageView IvImageGV173;
	@FXML
	private ImageView IvImageGV174;
	@FXML
	private ImageView IvImageGV175;
	@FXML
	private ImageView IvImageGV176;
	@FXML
	private ImageView IvImageGV177;
	@FXML
	private ImageView IvImageGV178;
	@FXML
	private ImageView IvImageGV179;
	@FXML
	private ImageView IvImageGV180;
	@FXML
	private ImageView IvImageGV181;
	@FXML
	private ImageView IvImageGV182;
	@FXML
	private ImageView IvImageGV183;
	@FXML
	private ImageView IvImageGV184;
	@FXML
	private ImageView IvImageGV185;
	@FXML
	private ImageView IvImageGV186;
	@FXML
	private ImageView IvImageGV187;
	@FXML
	private ImageView IvImageGV188;
	@FXML
	private ImageView IvImageGV189;
	@FXML
	private ImageView IvImageGV190;
	@FXML
	private ImageView IvImageGV191;
	@FXML
	private ImageView IvImageGV192;
	@FXML
	private ImageView IvImageGV193;
	@FXML
	private ImageView IvImageGV194;
	@FXML
	private ImageView IvImageGV195;
	@FXML
	private ImageView IvImageGV196;
	@FXML
	private ImageView IvImageGV197;
	@FXML
	private ImageView IvImageGV198;
	@FXML
	private ImageView IvImageGV199;
	@FXML
	private ImageView IvImageGV200;
	@FXML
	private ImageView IvImageGV201;
	@FXML
	private ImageView IvImageGV202;
	@FXML
	private ImageView IvImageGV203;
	@FXML
	private ImageView IvImageGV204;
	@FXML
	private ImageView IvImageGV205;
	@FXML
	private ImageView IvImageGV206;
	@FXML
	private ImageView IvImageGV207;
	@FXML
	private ImageView IvImageGV208;
	@FXML
	private ImageView IvImageGV209;
	@FXML
	private Label lblinfoLabelSpelSituatie2;
	@FXML
	private GridPane grdPaneWv;
	@FXML
	private ImageView IvImageWV00;
	@FXML
	private ImageView IvImageWV01;
	@FXML
	private ImageView IvImageWV02;
	@FXML
	private ImageView IvImageWV03;
	@FXML
	private ImageView IvImageWV04;
	@FXML
	private ImageView IvImageWV05;
	@FXML
	private ImageView IvImageWV06;
	@FXML
	private ImageView IvImageWV07;
	@FXML
	private ImageView IvImageWV08;
	@FXML
	private ImageView IvImageWV09;
	@FXML
	private GridPane grdPanePers;
	@FXML
	private ImageView IvImagePers10;
	@FXML
	private ImageView IvImagePers00;
	@FXML
	private ImageView IvImagePers01;
	@FXML
	private ImageView IvImagePers02;
	@FXML
	private ImageView IvImagePers03;
	@FXML
	private ImageView IvImagePers04;
	@FXML
	private ImageView IvImagePers05;
	@FXML
	private ImageView IvImagePers06;
	@FXML
	private ImageView IvImagePers07;
	@FXML
	private ImageView IvImagePers08;
	@FXML
	private ImageView IvImagePers09;
	@FXML
	private ImageView IvImagePers11;
	@FXML
	private ImageView IvImagePers12;
	@FXML
	private ImageView IvImagePers13;
	@FXML
	private ImageView IvImagePers14;
	@FXML
	private ImageView IvImagePers15;
	@FXML
	private ImageView IvImagePers16;
	@FXML
	private ImageView IvImagePers17;
	@FXML
	private ImageView IvImagePers18;
	@FXML
	private ImageView IvImagePers19;
	@FXML
		private ImageView IvImagePers20;
		@FXML
		private ImageView IvImagePers21;
		@FXML
		private ImageView IvImagePers22;
		@FXML
		private ImageView IvImagePers23;
		@FXML
		private ImageView IvImagePers24;
		@FXML
		private ImageView IvImagePers25;
		@FXML
		private ImageView IvImagePers26;
		@FXML
		private ImageView IvImagePers27;
		@FXML
		private ImageView IvImagePers28;
		@FXML
		private ImageView IvImagePers29;
		@FXML
		private Button btnFictiefEinde;
		@FXML
	private Button btnToonScores;
	
	private final int GV_AANTAL_KOLOMMEN = 21;
	private final int GV_AANTAL_RIJEN = 10;
	private final int GV_OFFSET_KOLOMMEN = 1;
	private final int WV_AANTAL_KOLOMMEN = 1;
	private final int WV_AANTAL_RIJEN = 10;
	private final int PS_AANTAL_KOLOMMEN = 3;
	private final int PS_AANTAL_RIJEN = 10;

	private DomeinController dc;
	private String[][][] spelsituatie;
	private List<List<String>> spelsituatieJoost;
	private List<ImageView> imagePersList;
	private int subroutineID;	// 1: joker vervangen
								// 2: serie of rij splitsen
								// 3: steen aanleggen
								// 4: steen naar werkveld
								// 5: beurt beeindigen
								// 6: reset van de beurt
	
	

	private int veldInInput = 999; 	// 0 = PS, 1 = WV, 2 = GV
	private int reeksInInput = 999; // index van de geselecteerde reeks in het GV (dit is gebaseerd op de y-coordinaat van het grid)
	private int positieInInput = 999; // index van de geselecteerde steen in de reeks van het GV (dit is gebaseerd op de x-coordinaat van het grid)
								// index van de geselecteerde steen in PS en WV (dit is gebaseerd op de Y-coordinaat van het grid)
	private int veldInOutput = 999; 	// 0 = PS, 1 = WV, 2 = GV
	private int reeksInOutput = 999; // index van de geselecteerde reeks in het GV (dit is gebaseerd op de y-coordinaat van het grid)
	private int positieInOutput = 999; // index van de geselecteerde plaats in de reeks van het GV (dit is gebaseerd op de x-coordinaat van het grid)
								// index van de geselecteerde plaats in PS en WV (dit is gebaseerd op de Y-coordinaat van het grid)


	public Spelsituatie2Controller(DomeinController dc) {
		super();
		this.dc = dc;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Spelsituatie2.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

	}

	// Event Listener on Button[#btnJokerVervangenSpeelBeurt].onAction
	@FXML
	public void btnJokerVervangenSpeelbeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(String.format(
				"Selecteer een steen in werk- of persoonlijk veld.%nVervolgens een joker gemeenschappelijk veld"));
		this.subroutineID=1;
	}
	// Event Listener on Button[#btnSplitsSpeelBeurt].onAction
	@FXML
	public void btnSplitsSpeelBeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2
		.setText(String.format("Selecteer rechts in de rij/reeks waar je wilt splitsen."));
		this.subroutineID=2;
		// this.lblinfoLabelSpelSituatie2.setStyle("-fx-text-fill: green;");
	}
	// Event Listener on Button[#btnSteenAanleggenSpeelBeurt].onAction
	@FXML
	public void btnSteenAanleggenSpeelBeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(String.format(
				"Selecteer een steen in werk- of persoonlijk veld.%nSelecteer vervolgens een lokatie in gemeenschappelijk veld"));
		
		this.subroutineID=3;
	}
	// Event Listener on Button[#btnSteenNaarWerkveldSpeelBeurt].onAction
	@FXML
	public void btnSteenNaarWerkveldSpeelBeurtOnAction(ActionEvent event) {
		this.lblinfoLabelSpelSituatie2.setText(
				/*joost*/				String.format("Selecteer een steen uit rij.%nOf selecteer een start -of eindsteen uit reeks."));
		this.subroutineID=4;
	}
	// Event Listener on Button[#btnResetBeurtSpeelBeurt].onAction
	@FXML
	public void btnResetBeurtSpeelBeurtOnAction(ActionEvent event) {
		this.dc.resetBeurt();
		this.lblinfoLabelSpelSituatie2.setText(String.format("Beurt werd gereset."));
		this.verwijderSpelSituatieOpHetScherm();
		this.toonSpelSituatieOpHetScherm();
		//tests
		//this.IvImagePers12.setImage(new Image(getClass().getResourceAsStream("/images/B1.png")));

	}
	// Event Listener on Button[#btnBeëindigbeurtSpeelBeurt].onAction
	@FXML
	public void btnBeëindigbeurtSpeelBeurt(ActionEvent event) {
		try {
			this.dc.beeindigBeurt();
			this.lblinfoLabelSpelSituatie2.setText(String.format("Volgende speler is aan zet."));
			this.lblSpelerAanZetSpeelbeurt.setText(String.format("Speler: %s", dc.geefNaamSpelerAanBeurt()));
			this.verwijderSpelSituatieOpHetScherm();
			this.toonSpelSituatieOpHetScherm();
		} catch (Exception e) {
			this.lblinfoLabelSpelSituatie2.setText(e.getMessage());
			this.verwijderSpelSituatieOpHetScherm();
			this.toonSpelSituatieOpHetScherm();
		}
		
		/***	DIT WAS OM TE TESTEN
		dc.testvolgende();
		Scene newScene = new Scene(new Spelsituatie2Controller(this.dc));
		Stage stage = (Stage) this.getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
//		this.lblinfoLabelSpelSituatie2.setText(String.format("Volgende speler is aan zet."));
//		this.lblSpelerAanZetSpeelbeurt.setText(String.format("Speler: %s", dc.geefNaamSpelerAanBeurt()));
//Joost	test
		//this.IvImagePers14.setImage(new Image(getClass().getResourceAsStream("/images/B1.png")));
		 ***/
	}
	// Event Listener on GridPane[#grdPaneGv].onMouseClicked
	@FXML
	public void grdPaneGvOnAction(MouseEvent event) {
		this.veldInOutput = 2;
		// https://stackoverflow.com/questions/28320110/javafx-how-to-get-column-and-row-index-in-gridpane
		for( Node node: this.grdPaneGv.getChildren()) {
			if(node instanceof ImageView) { 
				if(node.getBoundsInParent().contains(event.getX(), event.getY())) {
					int row = GridPane.getRowIndex( node); 
					int column = GridPane.getColumnIndex( node);
					
					// we gaan er voorlopig van uit dat we elke reeks op een afzonderlijke rij tonen
					this.reeksInOutput = row;
					this.positieInOutput = column;
					// 1: joker vervangen
					// 2: serie of rij splitsen
					// 3: steen aanleggen
					// 4: steen naar werkveld
					// 5: beurt beeindigen
					// 6: reset van de beurt
					switch(this.subroutineID) {
					case 1: 
						try {
							this.dc.vervangJoker(this.veldInInput, this.positieInInput, this.reeksInOutput, this.positieInOutput - this.GV_OFFSET_KOLOMMEN);
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						} 
						catch (Exception e) {
							//this.lblinfoLabelSpelSituatie2.setText(String.format("De joker kan niet vervangen worden."));
							lblinfoLabelSpelSituatie2.setText(e.getMessage());
							e.printStackTrace();
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						}
						break;
					case 2: 
						try {
							this.dc.splitsRijOfSerie(this.reeksInOutput, this.positieInOutput - this.GV_OFFSET_KOLOMMEN);
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						} catch (Exception e) {
							this.lblinfoLabelSpelSituatie2.setText(String.format("%s", e.getMessage()));
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						}
						
						break;
					case 3: 
						try {
							this.dc.legSteenAan(this.veldInInput, this.positieInInput, this.reeksInOutput, this.positieInOutput - this.GV_OFFSET_KOLOMMEN);
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						} catch (Exception e) {
							this.lblinfoLabelSpelSituatie2.setText(String.format("De steen kan niet aangelegd worden op deze positie."));
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						}
						break;
					case 4: 
						try {
							this.dc.steenNaarWerkveld(this.reeksInOutput, this.positieInOutput - this.GV_OFFSET_KOLOMMEN);
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						} catch (Exception e) {
							this.lblinfoLabelSpelSituatie2.setText(String.format("Deze steen kan niet naar het werkveld verplaatst worden."));
							this.verwijderSpelSituatieOpHetScherm();
							this.toonSpelSituatieOpHetScherm();
						}
						break;
					case 5: 
						// niet hier maar in de btnBeëindigbeurtSpeelBeurt
						break;
					case 6: 
						// niet hier maar in de btnResetBeurtSpeelBeurtOnAction
						break;
					default:
						this.lblinfoLabelSpelSituatie2.setText(String.format("Er werd een verkeerde actie geregistreerd."));
					}
				}
			}
		}
	}
	// Event Listener on GridPane[#grdPaneWv].onMouseClicked
	@FXML
	public void grdPaneWvOnAction(MouseEvent event) {
		this.veldInInput = 1;
		
		// https://stackoverflow.com/questions/28320110/javafx-how-to-get-column-and-row-index-in-gridpane
		for( Node node: this.grdPaneWv.getChildren()) {
				  
			if(node instanceof ImageView) { 
				if(node.getBoundsInParent().contains(event.getX(), event.getY())) {
					int row = GridPane.getRowIndex( node); 
					int column = GridPane.getColumnIndex( node);
					
					this.positieInInput = row + (10 * column); 	// dus 2de kolom (index 1) start bij 10
				}
			}
		}
	}
	// Event Listener on GridPane[#grdPanePers].onMouseClicked
	@FXML
	public void grdPanePersOnAction(MouseEvent event) {
		this.veldInInput = 0;
		
		// https://stackoverflow.com/questions/28320110/javafx-how-to-get-column-and-row-index-in-gridpane
		for( Node node: this.grdPanePers.getChildren()) {
				  
			if(node instanceof ImageView) { 
				if(node.getBoundsInParent().contains(event.getX(), event.getY())) {
					int row = GridPane.getRowIndex( node); 
					int column = GridPane.getColumnIndex( node);
					
					this.positieInInput = row + (10 * column); 	// dus 2de kolom (index 1) start bij 10
				}
			}
		}
	}
	// Event Listener on Button[#btnFictiefEinde].onAction
		@FXML
		public void btnFictiefEindeOnAction(ActionEvent event) {
			this.dc.fictiefEinde();
			this.lblinfoLabelSpelSituatie2.setText(String.format("Spel is ten einde. Je kan de scores bekijken."));
		}
		// Event Listener on Button[#btnToonScores].onAction
		@FXML
		public void btnToonScoresOnAction(ActionEvent event) {
			Scene newScene = new Scene(new ToonScoreSpelersController(this.dc));
			//Scene newScene = new Scene(new SpelSituatieController(this.dc));
			
			Stage stage = (Stage) this.getScene().getWindow();
	        stage.setScene(newScene);
	        stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// String speler = dc.geefNaamSpelerAanBeurt();
		this.lblSpelerAanZetSpeelbeurt.setText(String.format("Speler: %s", dc.geefNaamSpelerAanBeurt()));
		initializeImagePersList();
//joost nog code Bart toevoegen om met de 3dim array te werken
		spelsituatieJoost = dc.geefSpelsituatieJoost();
		initializePersoonlijkeStenen();
	}
	
//Joost Deze methode is nog eens nazien of ze nodig is in geval van default oplossing geefspelsituatie
	private void initializePersoonlijkeStenen() {
		for (int i = 0; i < spelsituatieJoost.get(0).size(); i++) {
			String tegel = spelsituatieJoost.get(0).get(i);
			imagePersList.get(i).setImage(new Image(getClass().getResourceAsStream(tegel)));
		}
	}
//Joost toegevoegd om sequentieel door de imageviews te loop-en
	private void initializeImagePersList() {
		imagePersList = Arrays.asList(IvImagePers00, IvImagePers01, IvImagePers02, IvImagePers03, IvImagePers04,
				IvImagePers05, IvImagePers06, IvImagePers07, IvImagePers08, IvImagePers09, IvImagePers10, IvImagePers11,
				IvImagePers12, IvImagePers13, IvImagePers14, IvImagePers15, IvImagePers16, IvImagePers17, IvImagePers18,
				IvImagePers19);
	}
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
	    for (Node node : gridPane.getChildren()) {
	        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
	            return node;
	        }
	    }
	    return null;
	}
	
	private void toonSpelSituatieOpHetScherm() {
		// PS
		int counter = 0;
		for(String[] afbeeldingOpNul: this.dc.geefSpelsituatie()[0]) {
			String afbeelding = afbeeldingOpNul[0];
			if(afbeelding!=null) {
			//Alert errorAlert = new Alert(AlertType.ERROR);
			//errorAlert.setHeaderText("Speler bestaat niet!");
			//errorAlert.setContentText(afbeelding);
			//errorAlert.showAndWait();
			ImageView imv = (ImageView) this.grdPanePers.getChildren().get(counter);
			imv.setImage(new Image(getClass().getResourceAsStream(afbeelding)));
			}
			counter++;
		}
		// WV
		counter = 0;
		for(String[] afbeeldingOpNul: this.dc.geefSpelsituatie()[1]) {
			String afbeelding = afbeeldingOpNul[0];
			if(afbeelding!=null) {
			ImageView imv = (ImageView) this.grdPaneWv.getChildren().get(counter);
			imv.setImage(new Image(getClass().getResourceAsStream(afbeelding)));
			}
			counter++;
		}
		// GV
		counter = 0;
		int counter2 = 0;
		for(String[] afbeeldingReeks: this.dc.geefSpelsituatie()[2]) {
			counter2 = 0;
			for(String afbeelding: afbeeldingReeks) {
				if(afbeelding!=null) {
					ImageView imv = (ImageView) this.getNodeFromGridPane(grdPaneGv, counter2 + this.GV_OFFSET_KOLOMMEN, counter);
					imv.setImage(new Image(getClass().getResourceAsStream(afbeelding)));
				}
				counter2++;
			}
			counter++;
		}
	}
	
	private void verwijderSpelSituatieOpHetScherm() {
		//PS
		for(int x = 0; x < this.PS_AANTAL_KOLOMMEN; x++) {
			for(int y = 0; y < this.PS_AANTAL_RIJEN; y++) {
				((ImageView)this.getNodeFromGridPane(this.grdPanePers, x, y)).setImage(null);
			}
		}
		
		//WV
		for(int x = 0; x < this.WV_AANTAL_KOLOMMEN; x++) {
			for(int y = 0; y < this.WV_AANTAL_RIJEN; y++) {
				((ImageView)this.getNodeFromGridPane(this.grdPaneWv, x, y)).setImage(null);
			}
		}
		
		//GV
		for(int x = 0; x < this.GV_AANTAL_KOLOMMEN; x++) {
			for(int y = 0; y < this.GV_AANTAL_RIJEN; y++) {
				((ImageView)this.getNodeFromGridPane(this.grdPaneGv, x, y)).setImage(null);
			}
		}
	}
}
