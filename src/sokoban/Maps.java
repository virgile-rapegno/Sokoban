package sokoban;

import java.util.HashMap;
import java.util.Map;

/*
 * Cette classe permet de conserver les niveaux et tests
 * disponibles pour lancer une partie.
 */
public class Maps {
	private static Map<String, String> ensembleMap = new HashMap<>();

	private static void makeEnsembleMap() {
		// Test pousser caisses Haut Bas Gauche Droite
		ensembleMap.put("test1", """
		          ###
		          #.#
		        ###$###
		        #.$@$.#
		        ###$###
		          #.#
		          ###
		         """);

		// Test pas de caisse
		ensembleMap.put("test2", """
		          ###
		          # #
		        ### ###
		        #  @  #
		        ### ###
		          # #
		          ###
		         """);

		// Test trop de caisses
		ensembleMap.put("test3", """
		          ###
		          #.#
		        ###$###
		        #. @$.#
		        ###$###
		          #.#
		          ###
		        		         """);

		// Test trop de caisses
		ensembleMap.put("test4", """
		          ###
		          #.#
		        ###$###
		        # $@$.#
		        ###$###
		          #.#
		          ###
		         """);

		// Test trop de caisses dépot rempli
		ensembleMap.put("test5", """
		          ###
		          #.#
		        ###$###
		        #*$@$.#
		        ###$###
		          #.#
		          ###
		         """);

		// Test pas de joueur
		ensembleMap.put("test6", """
		          ###
		          #.#
		        ###$###
		        #.$ $.#
		        ###$###
		          #.#
		          ###
		         """);

		// Test trop de joueurs
		ensembleMap.put("test7", """
		          ###
		          #.#
		        ###$###
		        # @ @ #
		        ###$###
		          #.#
		          ###
		         """);

		// Test personnage sur blocs
		ensembleMap.put("test8", """
		        ######
		        #    #
		        #   @#
		        #   .#
		        #   $#
		        #   *#
		        #@  ##
		        ######
		         """);

		// Test pousser caisses sur blocs
		ensembleMap.put("test9", """
		        ###.###
		        #.....#
		        #######
		        #  $  #
		        #  $ @#
		        #  $ .#
		        #  $ $#
		        #  $ *#
		        #@ $ ##
		        #######
		         """);

		// Niveau 1 Sokoban
		ensembleMap.put("niveau1", """
		            #####
		            #   #
		            #$  #
		          ###  $##
		          #  $ $ #
		        ### # ## #   ######
		        #   # ## #####  ..#
		        # $  $          ..#
		        ##### ### #@##  ..#
		            #     #########
		            #######
		         """);

		// Niveau 2 Sokoban
		ensembleMap.put("niveau2", """
		        ############
		        #..  #     ###
		        #..  # $  $  #
		        #..  #$####  #
		        #..    @ ##  #
		        #..  # #  $ ##
		        ###### ##$ $ #
		          # $  $ $ $ #
		          #    #     #
		          ############
		        		         """);

		// Niveau 3 Sokoban
		ensembleMap.put("niveau3", """
		                ########
		                #     @#
		                # $#$ ##
		                # $  $#
		                ##$ $ #
		        ######### $ # ###
		        #....  ## $  $  #
		        ##...    $  $   #
		        #....  ##########
		        ########
		        		         """);

		// Niveau 4 Sokoban
		ensembleMap.put("niveau4", """
		                   ########
		                   #  ....#
		        ############  ....#
		        #    #  $ $   ....#
		        # $$$#$  $ #  ....#
		        #  $     $ #  ....#
		        # $$ #$ $ $########
		        #  $ #     #
		        ## #########
		        #    #    ##
		        #     $   ##
		        #  $$#$$  @#
		        #    #    ##
		        ###########
		        		         """);

		// Niveau 5 Sokoban
		ensembleMap.put("niveau5", """
		                #####
		                #   #####
		                # #$##  #
		                #     $ #
		        ######### ###   #
		        #....  ## $  $###
		        #....    $ $$ ##
		        #....  ##$  $ @#
		        #########  $  ##
		                # $ $  #
		                ### ## #
		                  #    #
		                  ######
		        		         """);

		// Niveau 6 Sokoban
		ensembleMap.put("niveau6", """
		        ######  ###
		        #..  # ##@##
		        #..  ###   #
		        #..     $$ #
		        #..  # # $ #
		        #..### # $ #
		        #### $ #$  #
		           #  $# $ #
		           # $  $  #
		           #  ##   #
		           #########
		        		         """);

		// Niveau 7 Sokoban
		ensembleMap.put("niveau7", """
		               #####
		         #######   ##
		        ## # @## $$ #
		        #    $      #
		        #  $  ###   #
		        ### #####$###
		        # $  ### ..#
		        # $ $ $ ...#
		        #    ###...#
		        # $$ # #...#
		        #  ### #####
		        ####
		        		         """);

		// Niveau 8 Sokoban
		ensembleMap.put("niveau8", """
		          ####
		          #  ###########
		          #    $   $ $ #
		          # $# $ #  $  #
		          #  $ $  #    #
		        ### $# #  #### #
		        #@#$ $ $  ##   #
		        #    $ #$#   # #
		        #   $    $ $ $ #
		        #####  #########
		          #      #
		          #      #
		          #......#
		          #......#
		          #......#
		          ########

		        		         """);

		// Niveau 9 Sokoban
		ensembleMap.put("niveau9", """
		                  #######
		                  #  ...#
		              #####  ...#
		              #      . .#
		              #  ##  ...#
		              ## ##  ...#
		             ### ########
		             # $$$ ##
		         #####  $ $ #####
		        ##   #$ $   #   #
		        #@ $  $    $  $ #
		        ###### $$ $ #####
		             #      #
		             ########
		        		         """);

		// Niveau 10 Sokoban
		ensembleMap.put("niveau10", """
		         ###  #############
		        ##@####       #   #
		        # $$   $$  $ $ ...#
		        #  $$$#    $  #...#
		        # $   # $$ $$ #...#
		        ###   #  $    #...#
		        #     # $ $ $ #...#
		        #    ###### ###...#
		        ## #  #  $ $  #...#
		        #  ## # $$ $ $##..#
		        # ..# #  $      #.#
		        # ..# # $$$ $$$ #.#
		        ##### #       # #.#
		            # ######### #.#
		            #           #.#
		            ###############
		        		         """);

	}

	public static String getMap(String nomMap) {
		String res;
		makeEnsembleMap();

		res = ensembleMap.get(nomMap);
		if (res == null)
			throw new IllegalArgumentException("Ce nom de map n'est pas disponible");
		return res;
	}

}
