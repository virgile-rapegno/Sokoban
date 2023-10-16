/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

/*
 * Un joueur est un élément mobile de l'entrepôt.
 * Si plusieurs joueurs sont sur la carte, alors seul le joueur en bas à droite est contrôlable.
 * Les autres auront un fonctionnement similaire à celui des murs.
 */
public class Joueur extends ElementMobile {
	public Joueur(Entrepot entrepot, Position position, CaseEntrepot surCase) {
		super(entrepot, position, surCase);
		typeCase = ContenuCase.JOUEUR;
	}

	@Override
	public boolean estVide(Direction direction) {
		return false;
	}
}
