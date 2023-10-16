/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

/*
 * Un mur est un élément de terrain immobile sur lequel un element mobile ne peut pas se déplacer.
 */
public class Mur extends CaseEntrepot {
	public Mur(Entrepot entrepot) {
		super(entrepot, ContenuCase.MUR);
	}

	@Override
	public boolean estVide(Direction direction) {
		return false;
	}
}
