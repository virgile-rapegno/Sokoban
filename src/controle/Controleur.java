/*
 * @author Rapegno Virgile et Blanpain Amaury
 */
package controle;

import modele.Entrepot;
import modele.Joueur;
import modele.Position;

/*
 * Le controleur reprend un grand nombre de méthodes fournies par l'entrepôt car ses deux
 * seules vraies fonctionnalités sont de déterminer si une partie est finie et de réclamer
 * une éventuelle action au joueur.
 * On laisse par la suite les objets métier interagir entre eux.
 */
public class Controleur implements IControleur {
	private Entrepot entrepot;
	private Joueur joueur;

	public Controleur(Entrepot entrepot) {
		this.entrepot = entrepot;
		joueur = entrepot.getJoueur();
	}

	/*
	 * De l'IHM on sait où l'on souhaite déplacer le personnage, si le déplacement
	 * est possible on lui demande de le réaliser.
	 */
	@Override
	public void action(Direction direction) {
		Position nouvellePosition = joueur.positionRegardee(direction);

		if (entrepot.estLibre(nouvellePosition, direction))
			joueur.seDeplacer(nouvellePosition);
	}

	@Override
	public ContenuCase getContenu(int l, int c) {
		return entrepot.getContenu(l, c);
	}

	@Override
	public int getNbColonnes() {
		return entrepot.getNombreColonnes();
	}

	@Override
	public int getNbLignes() {
		return entrepot.getNombreLignes();
	}

	@Override
	public boolean jeuTermine() {
		return entrepot.getNombreCaisse() == entrepot.getNombreCaisseRangee();
	}
}
