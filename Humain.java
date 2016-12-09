package divinae;

public class Humain extends Joueur {
	private static Humain instance = null;

	public Humain(Divinite divinite) {
		super(true, divinite);
	}
	
	public static Humain getInstance(Divinite divinite) {
		if (instance == null) {
			instance = new Humain(divinite);
		}
		return instance;
	}
}