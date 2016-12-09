package divinae;

import java.util.ArrayList;

public class MainDuJoueur {
	private ArrayList<Carte> main;
	private int nbCarte;
	
	public ArrayList<Carte> getMain() {
		return main;
	}

	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}

	public int getNbCarte() {
		return nbCarte;
	}

	public void setNbCarte(int nbCarte) {
		this.nbCarte = nbCarte;
	}

	public MainDuJoueur() {
		this.main = new ArrayList<Carte>();
		this.nbCarte = main.size();
	}

	public void ajouterCarte(Carte carte) {
		this.main.add(carte);
		this.nbCarte = this.main.size();
	}

	public Carte defausserCarte(int i) {
		Carte c = this.main.remove(i);
		this.nbCarte = this.main.size();
		return c;
	}

	public void afficherMain() {
		System.out.println("Composition de la main :\n");
		for (int i = 0; i < this.nbCarte; i++) {
			System.out.println("Carte n°"+i+" :");
			this.main.get(i).afficherCarte();
		}
	}

}
