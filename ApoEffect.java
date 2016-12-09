package divinae;

public class ApoEffect implements Sacrifice{
	
	public ApoEffect(){
	}
	
	public void sacrifice(Jeu jeu){
		if(jeu.getnbJoueur()<4){
			System.out.println(jeu.ListJoueur.get(jeu.getJoueurMaxPP())+"Le joueur "+(jeu.getJoueurMaxPP()+1)+" a gagné !");
			jeu.arreterJeu();
		}
		else{
			System.out.println(jeu.ListJoueur.get(jeu.getJoueurMinPP())+"Le joueur "+(jeu.getJoueurMaxPP()+1)+" est éliminé !");
			jeu.ListJoueur.remove(jeu.getJoueurMinPP());
		}
	}

	@Override
	public void sacrifice(int origine, int nb, int joueur, Jeu jeu) {
		// TODO Auto-generated method stub
		
	}
}
