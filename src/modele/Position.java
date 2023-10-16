/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

/*
 * Position est implémenté de façon naïve afin d'éviter de parcourir l'entrepôt pour retrouver
 * les coordonnées d'un élément.
 */
public class Position {
	private int colonne;
	private int ligne;

	public Position(int i, int j) {
		colonne = i;
		ligne = j;
	}

	int getColonne() {
		return colonne;
	}

	int getLigne() {
		return ligne;
	}
}
