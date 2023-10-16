/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

/*
 * Les éléments mobiles partagent un grand nombre de méthodes qui ne sont pas nécessaires
 * pour les autres cases, ainsi les caisses et le joueur héritent de cette classe.
 * En particulier, il faut mémoriser si l'élément est sur un rangement.
 */
abstract class ElementMobile extends CaseEntrepot {
	protected CaseEntrepot surCase;
	protected Position position;

	protected ElementMobile(Entrepot entrepot, Position position, CaseEntrepot surCase) {
		super(entrepot);
		this.position = position;
		this.surCase = surCase;
	}

	public boolean isSurRangement() {
		return surCase.getTypeCase() == ContenuCase.RANGEMENT;
	}

	/*
	 * En reprenant les règles de la composition de map, il n'est pas nécessaire de
	 * vérifier que l'on regarde en dehors de la matrice de l'entrepôt car il y aura
	 * au moins un mur avant le bord de la map.
	 */
	public Position positionRegardee(Direction direction) {
		int x = position.getColonne();
		int y = position.getLigne();

		return switch (direction) {
			case DROITE -> new Position(x + 1, y);
			case GAUCHE -> new Position(x - 1, y);
			case HAUT -> new Position(x, y - 1);
			case BAS -> new Position(x, y + 1);
		};
	}

	/*
	 * L'élément se déplace et met à jour sa position, mais il faut aussi mettre à
	 * jour l'entrepôt.
	 */
	public void seDeplacer(Position position) {
		entrepot.changerPosition(this.position, position, this);
		this.position = position;
	}

	public void setSurCase(CaseEntrepot surCase) {
		this.surCase = surCase;
	}

	public CaseEntrepot getSurCase() {
		return surCase;
	}
}