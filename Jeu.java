package divinae;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Jeu {
	/**
	 * Elle n'est instanciable qu'une fois, grâce au patter singleton.<br>
	 * Elle possède les attributs suivants:<br>
	 * <code>private final Scanner sc</code> pour la gestion des entrées
	 * claviers<br>
	 * <code>private static Jeu instance</code> pour garantir l'unicité du Jeu.
	 */

	private final Scanner sc;
	private int nbTour;
	private static Jeu instance = null;
	private Pioche paquet;
	private De de;
	protected ArrayList<Joueur> ListJoueur;
	protected int nbJoueur;
	private PiocheDivinite piocheD;
	protected int joueurMaxPP;
	protected int joueurMinPP;
	

	/**
	 * C'est le design pattern singleton. Il s'assure de n'avoir qu'une instance
	 * de Console.
	 * 
	 * @return une Console.
	 */

	public static Jeu getInstance() {
		if (instance == null) {
			instance = new Jeu();
		}
		return instance;
	}

	public static void setInstance(Jeu instance) {
		Jeu.instance = instance;
	}

	public Jeu() {
		this.sc = new Scanner(System.in);
		this.ListJoueur = new ArrayList<Joueur>();
		this.nbJoueur = this.ListJoueur.size();
		this.paquet = Pioche.getInstance();
		this.piocheD = new PiocheDivinite();
		this.piocheD.melanger();
		this.paquet.melanger();
		// test : paquet.afficherPioche();
		this.de = De.getInstance();
		// test : de.lancerDe();
		this.joueurMaxPP=0;
		this.joueurMinPP=0;
		this.nbTour = 1;
		System.out.println("Nouveau jeu!\n");

	}

	 /* Créer la partie : générer la pioche, le centre, les mains des joueurs,
	 * le dé, les joueurs
	 */

	public void choisirJoueurs() {
		// choix des joueurs, du nombre, de leur type, etc.
		Joueur humain = Humain.getInstance(this.piocheD.piocher());			//t'avais mis == mais du coup ça marchait pas
		this.ListJoueur.add(humain);							//j'ai mis < et ça marche
		System.out.println("Combien y-a-t-il de joueurs IA ?");
		int nbrJoueurIA = sc.nextInt();
		for (int i = 0; i < nbrJoueurIA; i++) {
			Joueur ia = new IA(this.piocheD.piocher(), null);
			this.ListJoueur.add(ia);
		}
		this.nbJoueur = this.ListJoueur.size();
	}
	
	public void afficherListJoueur(){
		System.out.println(this.nbJoueur);
		for(int i=0; i<this.nbJoueur; i++){
			System.out.println("Joueur "+(i+1));
			this.ListJoueur.get(i).toString();
		}
		
	}
	public int getnbJoueur(){
		return this.nbJoueur;
	}

	public void jouerPartie() {
		while (this.nbJoueur != 1) {
			System.out.println("Tour n°"+this.nbTour);
			Iterator<Joueur> ListJoueur = this.ListJoueur.iterator();
			this.de.lancerDe();
			while (ListJoueur.hasNext()) {
				ListJoueur.next().ajouterPA(this.de.getFace());
				ListJoueur.next().jouerTour(this.de.getFace());
				ListJoueur.next().regenererPA();
			}
			this.nbTour++;
		}
		this.arreterJeu();
	}
	
	public int getJoueurMaxPP(){
		int val=0;
		int index=0;
		for(int i=0; i<this.nbJoueur; i++){
			if(this.ListJoueur.get(i).getNbrPrieres() > val){
				val = this.ListJoueur.get(i).getNbrPrieres();
				index = i;
			}
		}
		return index;
	}
	
	public int getJoueurMinPP(){
		int val=getJoueurMaxPP();
		int index=0;
		for(int i=0; i<this.nbJoueur; i++){
			if(this.ListJoueur.get(i).getNbrPrieres() < val){
				val = this.ListJoueur.get(i).getNbrPrieres();
				index = i;
			}
		}
		return index;
	}
	
	public void arreterJeu(){
		System.out.println("La partie est fini.");
		Jeu.setInstance(null);
	}
}

