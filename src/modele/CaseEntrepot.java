/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

/*
 * Chaque case de l'entrepot a besoin d'un ensemble d'atributs et de méthodes.
 * Il faut définir l'agrégation avec l'entrepôt, mais aussi une position et le type de case pour l'affichage.
 */
abstract class CaseEntrepot {
	protected Entrepot entrepot;
	protected ContenuCase typeCase;

	/*
	 * Constructeur pour les éléments mobiles
	 */
	protected CaseEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}

	/*
	 * Constructeur pour les éléments fixes
	 */
	protected CaseEntrepot(Entrepot entrepot, ContenuCase typeCase) {
		this.entrepot = entrepot;
		this.typeCase = typeCase;
	}

	public abstract boolean estVide(Direction direction);

	public ContenuCase getTypeCase() {
		return typeCase;
	}
}
