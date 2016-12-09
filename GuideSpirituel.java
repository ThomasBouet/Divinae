package divinae;
import java.util.ArrayList;

public class GuideSpirituel extends Carte{
	private int nbCroyantsRattachables;
	private ArrayList<Croyant> croyantsRattaches;
	
	public GuideSpirituel(String type,String nom,String dogme1,String dogme2,String dogme3,String origine,String p){
		super(type, nom, dogme1, dogme2, dogme3, origine, p);
		this.nbCroyantsRattachables = Integer.parseInt(p);
		this.croyantsRattaches = new ArrayList<Croyant>();
	}
	
	public void afficherGS(){
		super.afficherCarte();
	}
	
	public void sacrifice(){}
	
	public void rattacherCroyants(Croyant croyant){
		if(croyantsRattaches.size() < nbCroyantsRattachables){
			this.croyantsRattaches.add(croyant);
		}
	}
	
	public void afficherCroyants(){
		if(!this.croyantsRattaches.isEmpty()){
			System.out.println("Les croyants rattachés de ce guide spirituel sont :");
			for(int i =0; i<croyantsRattaches.size(); i++){
				this.croyantsRattaches.get(i).afficherCarte();
			}
		}
	}

}
