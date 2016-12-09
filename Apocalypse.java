package divinae;

public class Apocalypse extends Carte{
	private ApoEffect apocalypse;
	
	public Apocalypse(String type,String nom,String dogme1,String dogme2,String dogme3,String origine,String p){
		super( type, nom, dogme1, dogme2, dogme3, origine, p);
	}
	
	public void effet(){
		this.apocalypse = new ApoEffect();
		this.apocalypse.sacrifice(Jeu.getInstance());
	}
	
}
