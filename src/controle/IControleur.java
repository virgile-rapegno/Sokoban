/*
 * @author Dominique Marcadet
 */

package controle;

public interface IControleur {
	void action(Direction direction);

	ContenuCase getContenu(int ligne, int colonne);

	int getNbColonnes();

	int getNbLignes();

	boolean jeuTermine();
}
