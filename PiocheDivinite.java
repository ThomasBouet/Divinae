package divinae;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class PiocheDivinite extends Pioche {
	private static LinkedList<Divinite> paquet;
	private int nbCarte;

	public PiocheDivinite() /* throws NumberFormatException, IOException */ {
		paquet = new LinkedList<Divinite>();
		try {
			BufferedReader in = null;
			in = new BufferedReader(new FileReader("divinite.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				// Ici on sépare les différentes valeures contenues dans la
				// ligne entre les '*' et on
				// les stocke dans un tableau de String
				String[] decoupee = line.split("\\;");
				Divinite carte = new Divinite(decoupee[0], decoupee[1], decoupee[2], decoupee[3], decoupee[4], decoupee[5],
						decoupee[6]);
				this.paquet.addLast(carte);
			}
			in.close();
		} catch (IOException e) {
			System.err.println("ERREUR : " + e.getMessage());
		}
		this.nbCarte = this.paquet.size();
	}
	
	public void melanger() {
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(this.paquet);
		}
	}
	
	public Divinite piocher() {
		nbCarte = this.paquet.size();
		return this.paquet.pollFirst();
	}

}
