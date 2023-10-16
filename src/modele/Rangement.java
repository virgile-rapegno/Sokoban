/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

/*
 * Un rangement est un élément de terrain immobile sur lequel un element mobile peut se déplacer.
 */
public class Rangement extends CaseEntrepot {
	public Rangement(Entrepot entrepot) {
		super(entrepot, ContenuCase.RANGEMENT);
	}

	@Override
	public boolean estVide(Direction direction) {
		return true;
	}
}
