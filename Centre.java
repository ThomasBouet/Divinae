package divinae;

import java.util.ArrayList;

public class Centre {
	private ArrayList<Croyant> centre;
	private int nbCarte;
	private static Centre instance = null;

	public ArrayList<Croyant> getCentre() {
		return centre;
	}

	public void setCentre(ArrayList<Croyant> centre) {
		this.centre = centre;
	}

	public int getNbCarte() {
		return nbCarte;
	}

	public void setNbCarte(int nbCarte) {
		this.nbCarte = nbCarte;
	}

	/**
	 * C'est le design pattern singleton. Il s'assure de n'avoir qu'une instance
	 * de Centre.
	 * 
	 * @return un Centre.
	 */

	public static Centre getInstance() {
		if (instance == null) {
			instance = new Centre();
		}
		return instance;
	}

	public Centre() {
		this.centre = new ArrayList<Croyant>();
		this.nbCarte = this.centre.size();
	}

	public Croyant donnerCroyant(int i) {
		return this.centre.remove(i);
	}
	
	public void afficherCentre(){
		System.out.println("Composiion du centre :\n");
		for(int i=0; i<this.nbCarte; i++){
			System.out.println("Carte n°"+i+" :");
			this.centre.get(i).afficherCarte();
		}
	}
	
	public void ajouterCroyant(Croyant croyant){
		this.centre.add(croyant);
		this.nbCarte = this.centre.size();
		
	}

}
