package divinae;

public class OperationPoserCarte implements Strategy {

	public void faire(Jeu jeu, Joueur joueur) {
		if (joueur.getNbrPrieres() == jeu.getJoueurMaxPP()) {
			joueur.jouerCarte();
			if (joueur.getMainjoueur().getMain().get((int)(7*Math.random())).getType() == "Apocalypse") {
				Apocalypse apo = (Apocalypse) joueur.getMainjoueur().defausserCarte(index);
				apo.sacrifice(Jeu.getInstance());
			}
		}
		
	}
}
