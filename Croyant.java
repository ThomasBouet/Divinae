package divinae;

public class Croyant extends Carte{
	private int pointPriere;
	
	public Croyant(String type,String nom,String dogme1,String dogme2,String dogme3,String origine,String p){
			super( type, nom, dogme1, dogme2, dogme3, origine, p);
			this.pointPriere = Integer.parseInt(p);
	}
	
	public void afficherCroyant(){
		super.afficherCarte();
	}
	
	public void sacrifice(){}
}
