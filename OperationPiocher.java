package divinae;

public class OperationPiocher implements Strategy {

	@Override
	public void faire(Jeu jeu, Joueur joueur) {
		if (joueur.getMainjoueur().getNbCarte() < 7) {
			System.out.println("L'IA pioche une carte.");
			joueur.piocherCarte();
		}
	}

}
