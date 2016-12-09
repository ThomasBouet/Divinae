package divinae;

import java.util.*;

public abstract class Joueur {
	private boolean aFiniSonTour;
	private int ListPA[];
	private int ListPAmax[];
	private Divinite diviniteRepresentee;
	private int nbrPrieres;
	private CampDuJoueur campjoueur;
	private MainDuJoueur mainjoueur;
	private Pioche pioche;
	private final boolean humain;
	private static Joueur joueurActif;
	private Centre centre;
	private Scanner sc;
	private boolean canPlay;

	public Joueur(boolean humain, Divinite divinite) {
		this.aFiniSonTour = false;
		// attribution de la divinit�
		this.diviniteRepresentee = divinite;
		// initialisation du nombre de points de pri�res � z�ro.
		this.nbrPrieres = 0;
		// initialisation des PA � z�ro
		this.ListPA = new int[3];
		this.ListPA[0] = 0;
		this.ListPA[1] = 0;
		this.ListPA[2] = 0;
		// on dit que si le joueur est humain ou pas.
		this.humain = humain;
		// Attribution de la divinit�
		// cr�ation de son deck et son camp
		this.mainjoueur = new MainDuJoueur();
		this.campjoueur = new CampDuJoueur();
		this.pioche = Pioche.getInstance();
		this.centre = Centre.getInstance();
		// cr�ation du scanner
		sc = new Scanner(System.in);
		//initialisation de canPlay : attribut permettant ou pas de jouer une carte
		this.canPlay = false;
	}

	public boolean iscanPlay() {
		return canPlay;
	}

	public void setcanPlay(boolean canPlay) {
		this.canPlay = canPlay;
	}

	public void setListPA(int[] listPA) {
		this.ListPA = listPA;
	}

	public void setListPAindex(int index, int valeur){
		for(int i=0; i<valeur; i++){
			this.ListPA[index]++;
			}
		this.ListPAmax[index] = this.ListPA[index];
	}

	public void getListPA() {
		System.out.println("Vous avez :\n");
		System.out.println(this.ListPA[0] + " points Jour\n");
		System.out.println(this.ListPA[1] + " points Nuit\n");
		System.out.println(this.ListPA[2] + " points N�ant\n");
	}

	public void regenererPA() {
		this.setListPA(this.ListPAmax);
	}

	public void ajouterPA(int face) {
		int origine = this.diviniteRepresentee.getOrigine();
		switch (face) {
		case 0:
			if (origine == 1) {
				this.ListPA[0] += 2;
			} else if (origine == 2) {
				this.ListPA[0] += 1;
			}
			break;
		case 1:
			if (origine == 5) {
				this.ListPA[1] += 2;
			} else if (origine == 4) {
				this.ListPA[1] += 1;
			}
			break;
		case 2:
			if ((origine == 2) || (origine == 4)) {
				this.ListPA[2] += 1;
			}
			break;
		}
		this.ListPAmax = this.ListPA;
	}

	public int getNbrPrieres() {
		return nbrPrieres;
	}

	public void setNbrPrieres(int pointsPrieres) {
		this.nbrPrieres = pointsPrieres;
	}

	public CampDuJoueur getCampjoueur() {
		return campjoueur;
	}

	public void setCampjoueur(CampDuJoueur campjoueur) {
		this.campjoueur = campjoueur;
	}

	public MainDuJoueur getMainjoueur() {
		return mainjoueur;
	}

	public void setMainjoueur(MainDuJoueur mainjoueur) {
		this.mainjoueur = mainjoueur;
	}

	public boolean isHuman() {
		return humain;
	}

	/**
	 * Joue le tour d'un Joueur.<br>
	 * Pour un JoueurHumain, cette m�thode affiche les informations n�cessaire �
	 * la prise de d�cision de l'utilisateur, puis elle lui propose de choisir
	 * ce qu'il veut faire.<br>
	 * Pour un JoueurIA, cette m�thode param�tre le ChoixJoueur du JoueurIA.
	 */

	public void jouerTour(int face) {
		this.prendreLaMain();
		this.ajouterPA(face);
		this.prendreLaMain();
		// Affichage de la main du joueur, du centre et de son camp
		this.mainjoueur.afficherMain();
		this.getListPA();
		this.centre.afficherCentre();
		this.campjoueur.afficherCamp();
		// Demande au joueur s'il veut d�fausser ou piocher une carte
		this.defausserCarte();
		this.piocherCarte();
		// Demande au joueur ce qu'il veut faire
		if (this.humain == true) {
			this.reagir();
		} else {
			((IA) this).executerStrategy();
		}
		// Annonce la fin du tour du joueur
		this.finirLeTour();
	}

	public void reagir() {
		while (this.aFiniSonTour == false) {
			System.out.println("Que veux-tu faire ?\n");
			System.out.println("1 : Jouer une carte. ");
			System.out.println("2 : Rattacher un Croyant � un Guide Spirituel.");
			System.out.println("3 : Utiliser la capacit� de sa Divinit�.");
			System.out.println("4 : Ne rien faire.");
			switch (sc.nextInt()) {
			case 1:
				this.mainjoueur.afficherMain();
				this.jouerCarte();
				break;
			case 2:
				if(this.campjoueur.getCamp()!=null){
					this.mainjoueur.afficherMain();
					System.out.println("Donne-moi l'index du Guide Spirituel auquel vous voulez rattacher des cartes :");
					int indexcamp = sc.nextInt();
					this.campjoueur.afficherCamp();
					System.out.println("Donne-moi l'index du Croyant que vous voulez rattacher :");
					int indexcentre = sc.nextInt();
					this.campjoueur.getCamp().get(indexcamp).rattacherCroyants(this.centre.donnerCroyant(indexcentre));
					}
					break;
			case 3:
				System.out.println("Le joueur utilise sa capacit�");
				this.diviniteRepresentee.utiliserCapacite();
				break;
			default:
				System.out.println("Le joueur ne fait rien.");
			}
			System.out.println("As-tu fini ton tour ? O : Oui et N : Non");
			if (sc.next() == "O") {
				aFiniSonTour = true;
			}
		}
	}

	public void defausserCarte() {
		System.out.println("Veux-tu d�fausser une carte ?\nOui\nNon");
		String reponse = sc.next();
		if (reponse.equals("Oui")) { //pour comparer des strings c'est mieux de faire comme �a que des ==
			// V�rification qu'il y a des cartes dans la main, on ne peut pas
			// d�fausser s'il n'y a pas de cartes
			if (this.mainjoueur.getNbCarte() > 0) {
				// Enlever une carte de la main, elle est sp�cifi� par le joueur
				// gr�ce � son index
				this.mainjoueur.afficherMain();
				System.out.println("Donne-moi l'index de cette carte");
				int indexCarte = sc.nextInt();
				this.pioche.recuperer(this.mainjoueur.defausserCarte(indexCarte));
			}
			else{
				System.out.println("Vous n'avez pas de cartes � d�fausser");
			}
		}
	}

	public void piocherCarte() {
		/*
		 * v�rification qu'il n'a pas d�j� 7 cartes en main, le maximum de
		 * cartes autorisee.
		 */
		if (this.mainjoueur.getNbCarte() < 7) {
			System.out.println("Vous avez moins de 7 cartes, nous allons compl�ter votre main jusqu'� 7\n");
			while (this.mainjoueur.getNbCarte() < 7) {
				// Demande � la pioche de donner une carte
				Carte carte = this.pioche.piocher();
				// Ajout � la main de la carte pioch�e
				this.mainjoueur.ajouterCarte(carte);
			}

		}
		this.mainjoueur.afficherMain();
	}

	public void prendreLaMain() {
		System.out.println(this.diviniteRepresentee.getNom()+" prends la main !");
		joueurActif = this;
	}


	public void finirLeTour() {
		System.out.println(this.diviniteRepresentee.getNom()+" a fini de jouer.");
	}

	public void jouerCarte() {
		System.out.println("Donner l'index de la carte � jouer");
		int index = sc.nextInt();
		switch(this.mainjoueur.getMain().get(index).getType()){
		case("Croyants"): 
			this.verifierConsommerPA(index);
		if(this.canPlay==true){
			Croyant croyant = (Croyant) this.mainjoueur.defausserCarte(index);
			this.centre.ajouterCroyant(croyant);
		}else{System.out.println("donc vous ne pouvez toujours pas jouer la carte");}
		this.canPlay = false;
		break;
		case("Guide Spirituel"): 
			this.verifierConsommerPA(index);
		if(this.canPlay == true){
			GuideSpirituel gs = (GuideSpirituel) this.mainjoueur.defausserCarte(index);
			this.campjoueur.ajouterCarte(gs);
		}else{System.out.println("donc vous ne pouvez toujours pas jouer la carte");}
		this.canPlay = false;
		break;
		case("Deus Ex"): 
			this.verifierConsommerPA(index);
		if(this.canPlay==true){
			DeusEx de = (DeusEx) this.mainjoueur.defausserCarte(index);
			de.effet();
		}else{System.out.println("donc vous ne pouvez toujours pas jouer la carte");}
		this.canPlay = false;
		break;
		case("Apocalypse"): 
			this.verifierConsommerPA(index);
		if(this.canPlay == true){
			Apocalypse apo = (Apocalypse) this.mainjoueur.defausserCarte(index);
			apo.effet();
		}else{System.out.println("donc vous ne pouvez toujours pas jouer la carte");}
		this.canPlay = false;
		break;
		}
	}

	public void verifierConsommerPA(int rep) {
			switch (this.mainjoueur.getMain().get(rep).getOrigine()) {
			case (1):
				if (this.ListPA[0] > 0) {
					this.canPlay = true;
					this.ListPA[0]--;
				}
				System.out.println("Vous n'avez pas assez de PA pour jouer la carte");
				break;
			case (3):
				if (this.ListPA[2] > 0) {
					this.canPlay = true;
					this.ListPA[2]--;
				}
			
				if (this.ListPA[0] > 2 || this.ListPA[1] > 2) {
					System.out.println("Choisir quel type de PA � d�penser:\n 1:Jour\n 2:Nuit");
					int i = sc.nextInt();
					switch (i) {
					case (1):
						this.canPlay = true;
						this.ListPA[0] = this.ListPA[0] - 2;
						break;
					case (2):
						this.canPlay = true;
						this.ListPA[1] = this.ListPA[1] - 2;
						break;
					}
				}
				System.out.println("Vous n'avez pas assez de PA pour jouer la carte");
				break;
			case (5):
				if (this.ListPA[1] > 0) {
					this.canPlay = true;
					this.ListPA[1]--;
				}
				System.out.println("Vous n'avez pas assez de PA pour jouer la carte");
				break;
			case(0): break;
			default: System.out.println("Bien essay�");
			}
		}
}