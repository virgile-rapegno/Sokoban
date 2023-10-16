/*
 * @author Dominique Marcadet
 */

package ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controle.ContenuCase;
import controle.IControleur;

@SuppressWarnings("serial")
public class PanneauSokoban extends JPanel {
	private static EnumMap<ContenuCase, Image> images;
	private static final int TAILLE_IMAGE = FenetreSokoban.TAILLE_IMAGE;
	private IControleur controleur;

	public PanneauSokoban(IControleur controleur) {
		this.controleur = controleur;
		try {
			images = new EnumMap<>(Map.of(ContenuCase.CASE_VIDE,
			        ImageIO.read(new File("img/Vide.jpg")), ContenuCase.MUR,
			        ImageIO.read(new File("img/Mur.jpg")), ContenuCase.CAISSE,
			        ImageIO.read(new File("img/Caisse.jpg")), ContenuCase.CAISSE_RANGEE,
			        ImageIO.read(new File("img/CaisseRangee.jpg")), ContenuCase.RANGEMENT,
			        ImageIO.read(new File("img/Rangement.jpg")), ContenuCase.JOUEUR,
			        ImageIO.read(new File("img/Joueur.jpg"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Le côté métier raisonne en [ligne, colonne]
		// Le côté IHM raisonne en [x, y]
		// Donc x <=> colonne et y <=> ligne
		for (int l = 0; l < controleur.getNbLignes(); ++l)
			for (int c = 0; c < controleur.getNbColonnes(); ++c)
				g.drawImage(images.get(controleur.getContenu(l, c)), c * TAILLE_IMAGE,
				        l * TAILLE_IMAGE, TAILLE_IMAGE, TAILLE_IMAGE, null);
	}
}
