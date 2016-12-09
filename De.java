package divinae;

public class De {
	private int face;
	private static De instance = null;

	public De() {
		this.face = 0;
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	/**
	 * C'est le design pattern singleton. Il s'assure de n'avoir qu'une instance
	 * de Dé
	 * 
	 * @return un Dé.
	 */
	public static De getInstance() {
		if (instance == null) {
			instance = new De();
		}
		return instance;
	}

	public void lancerDe() {
		this.face = (int) (3 * Math.random());
		if (face == 0) {
			System.out.println("Le dé tombe sur Jour");
		} else if (face == 1) {
			System.out.println("Le dé tombe sur Nuit");
		} else {
			System.out.println("Le dé tombe sur Néant");
		}
	}

}
