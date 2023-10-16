/*
 * @author Dominique Marcadet
 * modifié par Rapegno Virgile et Blanpain Amaury
 */

package controle;

public enum ContenuCase {
	CAISSE, CAISSE_RANGEE, CASE_VIDE, JOUEUR, MUR, RANGEMENT;

	public static boolean accepteCaisse(ContenuCase typecase) {
		return switch (typecase) {
			case CASE_VIDE, RANGEMENT -> true;
			default -> false;
		};
	}
}
