package divinae;

public class Carte {
	private String type;
	private String nom;
	private int cara;
	private String[] dogme;
	private int origine;
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String[] getDogme() {
		return dogme;
	}

	public void setDogme(String[] dogme) {
		this.dogme = dogme;
	}

	public int getOrigine() {
		return origine;
	}

	public void setOrigine(int origine) {
		this.origine = origine;
	}

	public Carte(String type,String nom,String dogme1,String dogme2,String dogme3,String origine,String p){
		try {
			this.dogme = new String[3];
			this.type=type;
			this.nom=nom;
			this.dogme[0]=dogme1;
			this.dogme[1]=dogme2;
			this.dogme[2]=dogme3;
			this.origine= Integer.parseInt(origine);
			this.cara=Integer.parseInt(p);
		} catch (NumberFormatException e) {
			System.err.println("Erreur :" +e.getMessage());
		}
		
	}
	
	public void afficherCarte(){
		System.out.println(type+" "+nom+" ");
		for(int i=0; i< dogme.length; i++){
			switch(dogme[i]){
				case("A"): System.out.print("Nature "); break;
		  		case("B"): System.out.print("Humain "); break;
		  		case("C"): System.out.print("Symboles "); break;
		  		case("D"): System.out.print("Mystique "); break;
		  		case("E"): System.out.print("Chaos "); break;
		  		case("0"):System.out.print(" "); break;
				}
		}
		System.out.println();
		switch(origine){
		case(1):System.out.print("Jour "); break;
		case(2):System.out.print("Aube "); break;
		case(3):System.out.print("Néant "); break;
		case(4):System.out.print("Crépuscule "); break;
		case(5):System.out.print("Nuit "); break;
		case(0):System.out.print(" "); break;
		}
		System.out.println();
		System.out.println(cara);
		System.out.println();
	}
	
	public void sacrifice(){
		
	}

}
