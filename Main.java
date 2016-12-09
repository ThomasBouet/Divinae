package divinae;

public class Main {
 
	public Main() {
	}

	public static void main(String[] args) {
		// création d'une partie
		Jeu partie = Jeu.getInstance();
		// Choix des joueurs
		partie.choisirJoueurs();
		partie.jouerPartie();
		//partie.afficherListJoueur();
		// Déroulement de la partie tant qu'il n'y a pas de gagnant
		/* AjoutPA apa = new AjoutPA();
		apa.sacrifice(1, 3, 0);
		partie.afficherListJoueur();
		partie.ListJoueur.get(0).getListPA();
		partie.ListJoueur.get(0).piocherCarte();
		}*/
		// Fin de la partie
	
	}
}
