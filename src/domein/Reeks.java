package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import exceptions.SteenIsGeenJokerException;
import exceptions.VeldIsLeegException;

//UC3
public class Reeks {
	private int rijnummer;
	private boolean isNieuw;
	private List<Steen> stenen;
	private Steen joker;

	// UC3
	public Reeks(int rijnummer, List<Steen> stenen, boolean isNieuw) {
		this.setRijnummer(rijnummer);
		this.setIsNieuw(isNieuw);
		this.setStenen(stenen);
	}

	// UC3
	public int getRijnummer() {
		return this.rijnummer;
	}

	// UC3
	public void setRijnummer(int rijnummer) {
		this.rijnummer = rijnummer;
	}

	// UC3
	public boolean getIsNieuw() {
		return this.isNieuw;
	}

	// UC3
	public void setIsNieuw(boolean isNieuw) {
		this.isNieuw = isNieuw;
	}

	// UC3
	public List<Steen> getStenen() {
		return this.stenen;
	}

	// UC3
	public void setStenen(List<Steen> stenen) {
		this.stenen = stenen;
	}

	// UC3
	protected boolean bepaalIsGeldig() {
		// minimaal 3 stenen voor zowel Rij als Serie
		if (this.getStenen().size() < 3) {
			return false;
		}
		return true;
	}

	// UC3
	public void legSteenAan(Steen steen, int positieInReeks) {
		// de reeks wordt 1 index groter
		// omzetten naar array om dan de staart te kopieren
		Steen[] stenenArray = this.getStenen().toArray(new Steen[this.getStenen().size() + 1]);
		// staart kopieren
		Steen[] stenenArrayCopyRange = Arrays.copyOfRange(stenenArray, positieInReeks, stenenArray.length - 1);
		// steen aanleggen
		stenenArray[positieInReeks] = steen;
		// staart terug aan de reeks hangen
		this.setStenen(new ArrayList<>(Arrays.asList(stenenArray)));
		IntStream.range(positieInReeks + 1, this.getStenen().size())
				.forEach(x -> this.getStenen().set(x, stenenArrayCopyRange[x - positieInReeks - 1]));

	}

	// UC3
	public Steen vervangJoker(Steen steen, int positieInReeks) throws SteenIsGeenJokerException, VeldIsLeegException {
		// de reeks blijft even groot
		// pak de joker
		// Steen joker;
		if (positieInReeks < 0 || positieInReeks > stenen.size()-1) {
			throw new VeldIsLeegException();
		}
		this.joker = this.getStenen().get(positieInReeks);
		if (this.joker.getKleur() != Kleur.JOKER) {
			throw new SteenIsGeenJokerException();
		}
		/*
		 * if ((!(this.joker.getKleur()==Kleur.JOKER))) throw new
		 * SteenIsGeenJokerException(); //throw new
		 * SteenIsGeenJokerException("Degeselecteerde steen is geen joker!");
		 */
		// voeg de steen in op die positie
		this.getStenen().set(positieInReeks, steen);
		// retourneer de joker (moet naar het werkveld)
		return this.joker;
	}

	// UC3
	public Steen steenNaarWerkveld(int positieInReeks) {
		// de reeks wordt 1 index kleiner
		return this.getStenen().remove(positieInReeks);
	}

	// UC3
	/** hoeveel stenen bevat een reeks */
	public int hoeveelStenenHeeftDeReeks() {
		return this.getStenen().size();
	}

}
