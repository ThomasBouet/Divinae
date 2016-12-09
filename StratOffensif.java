package divinae;

public class StratOffensif implements Strategy {

	@Override
	public String deciderPioche(Joueur joueur) {
		if (joueur.mainjoueur.getNbCarte() < 7) {
			return "Oui";
		}
		else {
			return "Non";
		}
	}
	
	public String deciderDefausser() {
		return "Non";
	}

	@Override
	public int deciderChoix(Joueur joueur) {
		if (joueur.getListPA() != {0,0,0}) {
			return (int) (3*Math.random());
		}
		else {
			return 4;
		}
	}

	@Override
	public int deciderCarte(Jeu jeu, Joueur joueur) {
		if (jeu.getJoueurMaxPP() == joueur.getNbrPrieres()) {
			return (int);
		} else {
			return (int) (joueur.mainjoueur.getNbCarte()*Math.random());
		}
	}

}
