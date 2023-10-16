/*
 * Chaque case de l'entrepot a besoin d'un ensemble d'atributs et de méthodes.
 * Il faut définir l'agrégation avec l'entrepôt, mais aussi une position et le type de case pour l'affichage.
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

public class Caisse extends ElementMobile {
	public Caisse(Entrepot entrepot, Position position, CaseEntrepot surCase) {
		super(entrepot, position, surCase);
		typeCase = isSurRangement() ? ContenuCase.CAISSE_RANGEE : ContenuCase.CAISSE;
	}

	/*
	 * La caisse pour indiquer si la place est libre essaye d'abord de se déplacer
	 * dans la même direction que le joueur. Si le déplacement est possible, elle le
	 * fait et indique que son ancienne place est libre.
	 */
	@Override
	public boolean estVide(Direction direction) {
		Position nouvellePosition = positionRegardee(direction);
		int nouveauX = nouvellePosition.getColonne();
		int nouveauY = nouvellePosition.getLigne();

		if (ContenuCase.accepteCaisse(entrepot.getContenu(nouveauY, nouveauX))) {
			this.seDeplacer(nouvellePosition);
			return true;
		}
		return false;
	}

	/*
	 * Il faut mettre à jour le type de caisse lors du déplacement avec un
	 * rangement.
	 */
	@Override
	public void setSurCase(CaseEntrepot surCase) {
		super.setSurCase(surCase);
		typeCase = isSurRangement() ? ContenuCase.CAISSE_RANGEE : ContenuCase.CAISSE;
	}
}
