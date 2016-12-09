package divinae;

public class StratRandom implements Strategy {
	
	public String deciderString() {
		int i = (int) Math.random();
		if (i==0) {
			return "Non";
		}
		else {
			return "Oui";
		}
	}

	@Override
	public int deciderChoix() {
		return (int) (4*Math.random());
	}

	@Override
	public int deciderCarte(int nbCartes) {
		return (int) (nbCartes*Math.random());
	}

}
