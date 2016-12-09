package divinae;

import java.util.LinkedList;
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Pioche {
	private LinkedList<Carte> paquet;
	private int nbCarte;
	private static Pioche instance = null;

	public LinkedList<Carte> getPaquet() {
		return paquet;
	}

	public void setPaquet(LinkedList<Carte> paquet) {
		this.paquet = paquet;
	}

	public int getNbCarte() {
		return nbCarte;
	}

	public void setNbCarte(int nbCarte) {
		this.nbCarte = nbCarte;
	}

	/**
	 * C'est le design pattern singleton. Il s'assure de n'avoir qu'une instance de Pioche
	 * 
	 * @return une Pioche.
	 */
	public static Pioche getInstance() {
		if (instance == null) {
			instance = new Pioche();
		}
		return instance;
	}

	public Pioche() /* throws NumberFormatException, IOException */ {
		paquet = new LinkedList<Carte>();
		try {
			BufferedReader in = null;
			in = new BufferedReader(new FileReader("cartedivinae.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				// Ici on sépare les différentes valeures contenues dans la
				// ligne entre les '*' et on
				// les stocke dans un tableau de String
				String[] decoupee = line.split("\\;");
				/*Carte carte = new Carte(decoupee[0], decoupee[1], decoupee[2], decoupee[3], decoupee[4], decoupee[5],
						decoupee[6]);
				this.paquet.addLast(carte);*/
				switch(decoupee[0]){
				case("Croyants"):Croyant croyant = new Croyant(decoupee[0], decoupee[1], decoupee[2], decoupee[3], decoupee[4],decoupee[5], decoupee[6]);
				this.paquet.addLast(croyant);
				break;
				case("Guide Spirituel"):GuideSpirituel GS = new GuideSpirituel(decoupee[0], decoupee[1], decoupee[2], decoupee[3],decoupee[4], decoupee[5], decoupee[6]);
				this.paquet.addLast(GS);
				break;
				case("Apocalypse"):Apocalypse apo = new Apocalypse(decoupee[0], decoupee[1], decoupee[2], decoupee[3],decoupee[4], decoupee[5], decoupee[6]);
				this.paquet.addLast(apo);
				break;
				case("Deus Ex"):DeusEx DE = new DeusEx(decoupee[0], decoupee[1], decoupee[2], decoupee[3],decoupee[4], decoupee[5], decoupee[6]);
				this.paquet.addLast(DE);
				break;
				default:System.err.println("pioche vide");
				}
				
				
			}
			in.close();
			this.nbCarte = this.paquet.size();
		} catch (IOException e) {
			System.err.println("ERREUR : " + e.getMessage());
		}
	}

	public void afficherPioche() {
		for (int i = 0; i < nbCarte; i++) {
			this.paquet.get(i).afficherCarte();
		}
	}

	public void melanger() {
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(this.paquet);
		}
	}

	public Carte piocher() {
		nbCarte = this.paquet.size();
		return this.paquet.remove();
	}

	public void recuperer(Carte carte) {
		this.paquet.addLast(carte);
		nbCarte = this.paquet.size();
	}

}
