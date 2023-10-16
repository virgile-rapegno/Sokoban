/*
 * @author Dominique Marcadet
 * modifié par Rapegno Virgile et Blanpain Amaury
 */

package ihm;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controle.Direction;
import controle.IControleur;

@SuppressWarnings("serial")
public class FenetreSokoban extends JFrame implements KeyListener {
	static final int TAILLE_IMAGE = 32;
	private static final int HAUTEUR_TITRE_FENETRE = 20;
	private int HAUTEUR_FENETRE;
	private int LARGEUR_FENETRE;
	private IControleur controleur;

	public FenetreSokoban(IControleur controleur) {
		this.controleur = controleur;
		// Adapter la fenêtre à la carte
		HAUTEUR_FENETRE = TAILLE_IMAGE * controleur.getNbLignes();
		LARGEUR_FENETRE = TAILLE_IMAGE * controleur.getNbColonnes();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(LARGEUR_FENETRE, HAUTEUR_FENETRE + HAUTEUR_TITRE_FENETRE));
		setTitle("Sokoban");
		this.add(new PanneauSokoban(controleur));
		addKeyListener(this);
		pack();
		setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Direction direction = switch (e.getKeyCode()) {
			// Jouer avec les flèches.
			case KeyEvent.VK_UP -> Direction.HAUT;
			case KeyEvent.VK_DOWN -> Direction.BAS;
			case KeyEvent.VK_LEFT -> Direction.GAUCHE;
			case KeyEvent.VK_RIGHT -> Direction.DROITE;
			// Jouer avec ZQSD.
			case KeyEvent.VK_Z -> Direction.HAUT;
			case KeyEvent.VK_S -> Direction.BAS;
			case KeyEvent.VK_Q -> Direction.GAUCHE;
			case KeyEvent.VK_D -> Direction.DROITE;
			default -> null;
		};
		if (direction == null)
			return;
		controleur.action(direction);
		repaint();
		if (controleur.jeuTermine()) {
			JOptionPane.showMessageDialog(this, "Vous avez gagné !");
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// nothing
	}
}
