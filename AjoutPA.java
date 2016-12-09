package divinae;

public class AjoutPA implements Sacrifice{
	
	public AjoutPA(){
	}
	
	public void sacrifice(int origine, int nb, int joueur, Jeu jeu){
		for(int i=0; i<nb; i++){	
			jeu.ListJoueur.get(joueur).setListPAindex(origine, nb);
		}

	}
	public void sacrifice(){
		System.out.println("mauvaise méthode");
	}

}
