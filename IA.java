package divinae;

public class IA extends Joueur {
	private Strategy strategy;

	public IA(Divinite divinite, Strategy str) {
		super(false, divinite);
		this.strategy = str;
		// TODO Auto-generated constructor stub
	}

	public void executerStrategy() {
		this.strategy = new OperationPiocher();
		strategy.faire(Jeu.getInstance(), this); // PAS ENCORE FINI
	/*case 1:
		this.mainjoueur.afficherMain();
		this.jouerCarte();
		break;
	case 2:
		this.mainjoueur.afficherMain();
		System.out.println("Donne-moi l'index du Guide Spirituel auquel vous voulez rattacher des cartes :");
		int indexcamp = sc.nextInt();
		System.out.println("Donne-moi l'index du Croyant que vous voulez rattacher :");
		int indexcentre = sc.nextInt();
		this.campjoueur.getCamp().get(indexcamp).rattacherCroyants(this.centre.donnerCroyant(indexcentre));
		break;
	case 3:
		System.out.println("Le joueur utilise sa capacité");
		this.diviniteRepresentee.utiliserCapacite();
		break;
	default:
		System.out.println("Le joueur ne fait rien.");
		aFiniSonTour = true;
	}

			case "Jouer une carte":
				this.strategy = new OperationPoserCarte();
				strategy.faire(Jeu.getInstance(), this);	
		*/
		
	}
}