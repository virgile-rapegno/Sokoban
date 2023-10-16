/*
 * @author Rapegno Virgile et Blanpain Amaury
 */

package modele;

import controle.ContenuCase;
import controle.Direction;

public class Entrepot {
	private Joueur joueur;
	private CaseEntrepot[][] matriceEntrepot;
	private int nombreCaisses = 0;
	private int nombreCaissesRangees = 0;
	private int nombreColonnes = 0;
	private int nombreLignes = 0;

	public Entrepot(String map) {
		/*
		 * Décomposition de la map et recherche des dimensions de la map.
		 */
		char[] mapDecomposee = map.toCharArray();

		int maxColonnes = 0;
		for (char symbole : mapDecomposee)
			if (symbole == '\n') {
				if (nombreColonnes > maxColonnes)
					maxColonnes = nombreColonnes;
				nombreColonnes = 0;
				nombreLignes++;
			} else
				nombreColonnes++;

		nombreColonnes = maxColonnes;
		matriceEntrepot = new CaseEntrepot[nombreLignes][nombreColonnes];

		/*
		 * Remplissage de la matrice en lisant la map.
		 * 
		 * On remplit ligne par ligne, en comblant avec des cases vide si le retour à la
		 * ligne se fait plutôt (cas des maps non rectangulaires).
		 * 
		 * On respecte comme indiqué dans la classe JouerSokoban les règles du site :
		 * http://www.sokobano.de/wiki/index.php?title=Level_format
		 */
		int nombreRangements = 0;
		boolean finCaractereLigne = false;
		int lecture = 0;
		for (int l = 0; l < nombreLignes; l++) {
			int c = 0;
			// On lit les caractères imposé par la map.
			while (!finCaractereLigne) {
				switch (mapDecomposee[lecture]) {
					case ' ': // CaseVide
						matriceEntrepot[l][c] = new CaseVide(this);
						break;
					case '#': // Mur
						matriceEntrepot[l][c] = new Mur(this);
						break;
					case '.': // Rangement
						matriceEntrepot[l][c] = new Rangement(this);
						nombreRangements++;
						break;
					case '$': // Caisse
						nombreCaisses++;
						matriceEntrepot[l][c] = new Caisse(this, new Position(c, l),
						        new CaseVide(this));
						break;
					case '*': // Caisse Rangée
						nombreCaisses++;
						nombreCaissesRangees++;
						nombreRangements++;
						matriceEntrepot[l][c] = new Caisse(this, new Position(c, l),
						        new Rangement(this));
						break;
					case '@': // Joueur
						joueur = new Joueur(this, new Position(c, l), new CaseVide(this));
						matriceEntrepot[l][c] = joueur;
						break;
					case '+': // Joueur sur rangement
						joueur = new Joueur(this, new Position(c, l), new Rangement(this));
						matriceEntrepot[l][c] = joueur;
						break;
					case '\n': // fin de la ligne de caratère
						finCaractereLigne = true;
						c--;
						break;
					default: // On est en dehors des règles imposées pour la map.
						throw new IllegalArgumentException("Caractère non autorisé");
				}
				c++;
				lecture++;
			}

			// Il faut finir de remplir la ligne de la matrice avec des cases vides.
			while (c < nombreColonnes) {
				matriceEntrepot[l][c] = new CaseVide(this);
				c++;
			}
			finCaractereLigne = false;
		}

		// Cas évidents de maps impossibles.
		if (joueur == null)
			throw new IllegalArgumentException("Il n'y a pas de joueur sur la carte");
		if (nombreRangements == 0)
			throw new IllegalArgumentException("Il n'y a pas de rangement");
		if (nombreCaisses > nombreRangements)
			throw new IllegalArgumentException("Il y a des caisses sans rangement");
	}

	/*
	 * Un élément mobile demande à l'entrepôt de le déplacer dans la matrice. On
	 * fait attention à laisser derrière l'élément la case qu'il porte, et de
	 * mémoriser la case sur lequel il avance.
	 */
	public void changerPosition(Position anciennePosition, Position nouvellePosition,
	        ElementMobile elementMobile) {

		int ancienX = anciennePosition.getColonne();
		int ancienY = anciennePosition.getLigne();
		int nouveauX = nouvellePosition.getColonne();
		int nouveauY = nouvellePosition.getLigne();

		CaseEntrepot caseAPoser = elementMobile.getSurCase();
		matriceEntrepot[ancienY][ancienX] = caseAPoser;
		elementMobile.setSurCase(matriceEntrepot[nouveauY][nouveauX]);
		matriceEntrepot[nouveauY][nouveauX] = elementMobile;

		if (elementMobile.getClass() == Caisse.class) {
			if (caseAPoser.getTypeCase() == ContenuCase.RANGEMENT)
				nombreCaissesRangees--;
			if (elementMobile.isSurRangement())
				nombreCaissesRangees++;
		}
	}

	/*
	 * L'entrepôt étant l'agrégation des cases, il peut demander à une case si elle
	 * est libre.
	 */
	public boolean estLibre(Position position, Direction direction) {
		int x = position.getColonne();
		int y = position.getLigne();
		return matriceEntrepot[y][x].estVide(direction);
	}

	/*
	 * Ensemble des getter afin de protéger les attributs.
	 */
	public ContenuCase getContenu(int l, int c) {
		return matriceEntrepot[l][c].getTypeCase();
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public int getNombreCaisse() {
		return nombreCaisses;
	}

	public int getNombreCaisseRangee() {
		return nombreCaissesRangees;
	}

	public int getNombreColonnes() {
		return nombreColonnes;
	}

	public int getNombreLignes() {
		return nombreLignes;
	}
}