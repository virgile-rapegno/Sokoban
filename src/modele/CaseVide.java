/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

/*
 * Une case vide est un élément de terrain immobile sur lequel un element mobile pas se déplacer.
 */
public class CaseVide extends CaseEntrepot {
	public CaseVide(Entrepot entrepot) {
		super(entrepot, ContenuCase.CASE_VIDE);
	}

	@Override
	public boolean estVide(Direction direction) {
		return true;
	}
}
