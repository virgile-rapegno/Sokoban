/*
 * @author Dominique Marcadet
 * modifié par Rapegno Virgile et Blanpain Amaury
 */

package sokoban;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import controle.Controleur;
import ihm.FenetreSokoban;
import modele.Entrepot;

/*
 * JouerSokoban est la classe principale pour lancer une partie de Sokoban.
 * Il est nécessaire de modifier map en attendant l'implémentation d'une lecture de fichier.
 * 
 * map doit respecter les règles du site :
 * http://www.sokobano.de/wiki/index.php?title=Level_format
 * 
 * En particulier le programme assume que le joueur est dans une salle fermée par des murs.
 */
public class JouerSokoban implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new JouerSokoban());
	}

	@Override
	public void run() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choisir la map entre test1 - test8 et niveau1 - niveau10 : ");
		String nomMap = scanner.next();

		String map = Maps.getMap(nomMap);
		Entrepot entrepot = new Entrepot(map);
		Controleur controleur = new Controleur(entrepot);

		new FenetreSokoban(controleur);
	}
}
