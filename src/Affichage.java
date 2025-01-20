import java.util.ArrayList;
import java.util.Scanner;

public class Affichage {

    public static Scanner scanner = new Scanner(System.in);

    public static final String RESET = "\033[0m";
    public static final String GRAS = "\033[1m";
    public static final String ROUGE = "\033[0;31m";
    public static final String VERT = "\033[0;32m";
    public static final String JAUNE = "\033[0;33m";
    public static final String BLEU = "\033[0;34m";
    public static final String MAGENTA = "\033[0;35m";
    public static final String NOIR = "\033[0;30m";
    public static final String NOIR_GRAS = "\033[1;30m";

    public static final String[] TABLEAU_COULEURS_JOUEURS = { VERT, JAUNE, ROUGE, BLEU, MAGENTA };

    public static String[] titres = {
            "    ▄   ████▄ █▄▄▄▄ ██   ▄█▄    ▄█    ▄   ▄███▄     ▄▄▄▄▄\n" +
            "     █  █   █ █  ▄▀ █ █  █▀ ▀▄  ██     █  █▀   ▀   █     ▀▄\n" +
            "█     █ █   █ █▀▀▌  █▄▄█ █   ▀  ██ ██   █ ██▄▄   ▄  ▀▀▀▀▄\n" +
            " █    █ ▀████ █  █  █  █ █▄  ▄▀ ▐█ █ █  █ █▄   ▄▀ ▀▄▄▄▄▀\n" +
            "  █  █          █      █ ▀███▀   ▐ █  █ █ ▀███▀\n" +
            "   █▐          ▀      █            █   ██\n" +
            "   ▐                 ▀",

            " ▄▀▀▄ ▄▀▀▄  ▄▀▀▀▀▄   ▄▀▀▄▀▀▀▄  ▄▀▀█▄   ▄▀▄▄▄▄   ▄▀▀█▀▄    ▄▀▀▄ ▀▄  ▄▀▀█▄▄▄▄  ▄▀▀▀▀▄\n" +
            "█   █    █ █      █ █   █   █ ▐ ▄▀ ▀▄ █ █    ▌ █   █  █  █  █ █ █ ▐  ▄▀   ▐ █ █   ▐\n" +
            "▐  █    █  █      █ ▐  █▀▀█▀    █▄▄▄█ ▐ █      ▐   █  ▐  ▐  █  ▀█   █▄▄▄▄▄     ▀▄\n" +
            "   █   ▄▀  ▀▄    ▄▀  ▄▀    █   ▄▀   █   █          █       █   █    █    ▌  ▀▄   █\n" +
            "    ▀▄▀      ▀▀▀▀   █     █   █   ▄▀   ▄▀▄▄▄▄▀  ▄▀▀▀▀▀▄  ▄▀   █    ▄▀▄▄▄▄    █▀▀▀\n" +
            "                    ▐     ▐   ▐   ▐   █     ▐  █       █ █    ▐    █    ▐    ▐\n" +
            "                                      ▐        ▐       ▐ ▐         ▐\n",

            " ▌ ▐·      ▄▄▄   ▄▄▄·  ▄▄· ▪   ▐ ▄ ▄▄▄ ..▄▄ ·\n" +
            "▪█·█▌▪     ▀▄ █·▐█ ▀█ ▐█ ▌▪██ •█▌▐█▀▄.▀·▐█ ▀.\n" +
            "▐█▐█• ▄█▀▄ ▐▀▀▄ ▄█▀▀█ ██ ▄▄▐█·▐█▐▐▌▐▀▀▪▄▄▀▀▀█▄\n" +
            " ███ ▐█▌.▐▌▐█•█▌▐█ ▪▐▌▐███▌▐█▌██▐█▌▐█▄▄▌▐█▄▪▐█\n" +
            ". ▀   ▀█▄▀▪.▀  ▀ ▀  ▀ ·▀▀▀ ▀▀▀▀▀ █▪ ▀▀▀  ▀▀▀▀",

            " ██▒   █▓ ▒█████   ██▀███   ▄▄▄       ▄████▄   ██▓ ███▄    █ ▓█████   ██████\n" +
            "▓██░   █▒▒██▒  ██▒▓██ ▒ ██▒▒████▄    ▒██▀ ▀█  ▓██▒ ██ ▀█   █ ▓█   ▀ ▒██    ▒\n" +
            " ▓██  █▒░▒██░  ██▒▓██ ░▄█ ▒▒██  ▀█▄  ▒▓█    ▄ ▒██▒▓██  ▀█ ██▒▒███   ░ ▓██▄\n" +
            "  ▒██ █░░▒██   ██░▒██▀▀█▄  ░██▄▄▄▄██ ▒▓▓▄ ▄██▒░██░▓██▒  ▐▌██▒▒▓█  ▄   ▒   ██▒\n" +
            "   ▒▀█░  ░ ████▓▒░░██▓ ▒██▒ ▓█   ▓██▒▒ ▓███▀ ░░██░▒██░   ▓██░░▒████▒▒██████▒▒\n" +
            "   ░ ▐░  ░ ▒░▒░▒░ ░ ▒▓ ░▒▓░ ▒▒   ▓▒█░░ ░▒ ▒  ░░▓  ░ ▒░   ▒ ▒ ░░ ▒░ ░▒ ▒▓▒ ▒ ░\n" +
            "   ░ ░░    ░ ▒ ▒░   ░▒ ░ ▒░  ▒   ▒▒ ░  ░  ▒    ▒ ░░ ░░   ░ ▒░ ░ ░  ░░ ░▒  ░ ░\n" +
            "     ░░  ░ ░ ░ ▒    ░░   ░   ░   ▒   ░         ▒ ░   ░   ░ ░    ░   ░  ░  ░\n" +
            "      ░      ░ ░     ░           ░  ░░ ░       ░           ░    ░  ░      ░\n" +
            "     ░                               ░"
    };

    public static final String[] cartesPropagation = {
            "  ________\n" +
            " / __←    \\\n" +
            "/1    \\→__ \\\n" +
            "\\     /   1/\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/2   \\→__  \\\n" +
            "\\ __←/    2/\n" +
            " \\________/",

            "  ________\n" +
            " /    ↗   \\\n" +
            "/3    \\    \\\n" +
            "\\  __←/   3/\n" +
            " \\________/",

            "  ________\n" +
            " /  __←   \\\n" +
            "/4    \\    \\\n" +
            "\\     /   4/\n" +
            " \\____↘___/",

            "  ________\n" +
            " /     ↗  \\\n" +
            "/5     \\   \\\n" +
            "\\      /  5/\n" +
            " \\_____↘__/",

            "  ________\n" +
            " /   →__  \\\n" +
            "/6  /      \\\n" +
            "\\   \\→__  6/\n" +
            " \\________/",

            "  ________\n" +
            " / ___    \\\n" +
            "/7    \\→__ \\\n" +
            "\\     ↗   7/\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/8    ↖→__ \\\n" +
            "\\  ___/   8/\n" +
            " \\________/",

            "  ________\n" +
            " /  __←/  \\\n" +
            "/9     \\   \\\n" +
            "\\      ↙  9/\n" +
            " \\________/",

            "  ________\n" +
            " /   \\→__ \\\n" +
            "/10  /     \\\n" +
            "\\    ↘   10/\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/11 \\→__   \\\n" +
            "\\   /   ↘11/\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/12 \\→__↗  \\\n" +
            "\\   /    12/\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/13___   13\\\n" +
            "\\ /   ↘→__ /\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/14    →__ \\\n" +
            "\\ \\___↗  14/\n" +
            " \\________/",

            "  ________\n" +
            " /___     \\\n" +
            "/15  \\→__15\\\n" +
            "\\        ↘ /\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/16   →__↗ \\\n" +
            "\\ ___/   16/\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/ ___    17\\\n" +
            "\\17  \\→__↗ /\n" +
            " \\________/",

            "  ________\n" +
            " /        \\\n" +
            "/18   →__18\\\n" +
            "\\ ___/   ↘ /\n" +
            " \\________/",

            "  ________\n" +
            " /  ___   \\\n" +
            "/19    \\   \\\n" +
            "\\   __←↙ 19/\n" +
            " \\________/",

            "  ________\n" +
            " /  __←   \\\n" +
            "/20    ↖   \\\n" +
            "\\   ___/ 20/\n" +
            " \\________/"
    };

    /*public static String[] listeCommandes = {
            "q", // Lance un vote pour quitter la partie
    };*/


    /**
     * Choisi aléatoirement l'un des titres en ASCII Art.
     */
    public static void titreMenuPrincipalAleatoire(int vAlea){
        System.out.println(titres[vAlea]);
    }
    
    
    /**
     * Retourne la saisie d'un nombre entier de la part de l'utilisateur après avoir afficher un message.
     *
     * @param msg
     * @return
     */
    // Le code de retour -1 signifie qu'il y a eu une erreur de saisie
    public static Integer saisirEntier(String msg) {
        String saisie;
        System.out.print(msg);
        saisie = scanner.nextLine();
        try {
            return Integer.parseInt(saisie);
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    /**
     * Retourne la saisie de l'utilsateur après avoir afficher un message.
     *
     * @param msg
     * @return
     */
    public static String saisirChaine(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    /**
     * Affiche les mentions légales liés au jeu.
     */
    public static void afficherMentionsLegales() {
        System.out.println(JAUNE + "⚠ AVERTISSEMENT DE PROPRIÉTÉ INTELLECTUELLE ⚠" + RESET);
        System.out.println(ROUGE + "Ce contenu est protégé par les lois sur la propriété intellectuelle.");
        System.out.println("Toute reproduction, distribution ou utilisation non autorisée est interdite." + RESET);
        System.out.println("© 2024 Voracines. Tous droits réservés.\n");
    }


    /**
     * Saute de nbSauts lignes.
     */
    public static void nettoyerConsole(int nbSauts) {
        for (int i = 0; i < nbSauts; i++) {
            System.out.println();
        }
    }


    /**
     * Affiche le plateau en prenant en compte les informations du tableau à 3 dimension.
     *
     * @param plateau
     */
    public static void afficherPlateau(int[][][] plateau) {
        System.out.print("      ");
        for (int i = 0; i < plateau.length / 2 + 1; i++) {
            System.out.print((i + 1) + "   ");
        }
        System.out.println();

        System.out.println("                 " + couleurCorrespondante(plateau, 0, 7) + "___" + RESET);
        System.out.println("A            " + couleurCorrespondante(plateau, 1, 5) + "___" + couleurCorrespondante(plateau, 1, 6) + "/" + couleurCorrespondante(plateau, 1, 7) + caractereCorrespondant(plateau, 1, 7) + couleurCorrespondante(plateau, 1, 8) + "\\" + couleurCorrespondante(plateau, 1, 9) + "___" + RESET);
        System.out.println("B        " + couleurCorrespondante(plateau, 2, 3) + "___" + couleurCorrespondante(plateau, 2, 4) + "/" + couleurCorrespondante(plateau, 2, 5) + caractereCorrespondant(plateau, 2, 5) + couleurCorrespondante(plateau, 2, 6) + "\\" + couleurCorrespondante(plateau, 2, 7) + "___" + couleurCorrespondante(plateau, 2, 8) + "/" + couleurCorrespondante(plateau, 2, 9) + caractereCorrespondant(plateau, 2, 9) + couleurCorrespondante(plateau, 2, 10) + "\\" + couleurCorrespondante(plateau, 2, 11) + "___" + RESET);
        System.out.println("C    " + couleurCorrespondante(plateau, 3, 1) + "___" + couleurCorrespondante(plateau, 3, 2) + "/" + couleurCorrespondante(plateau, 3, 3) + caractereCorrespondant(plateau, 3, 3) + couleurCorrespondante(plateau, 3, 4) + "\\" + couleurCorrespondante(plateau, 3, 5) + "___" + couleurCorrespondante(plateau, 3, 6) + "/" + couleurCorrespondante(plateau, 3, 7) + caractereCorrespondant(plateau, 3, 7) + couleurCorrespondante(plateau, 3, 8) + "\\" + couleurCorrespondante(plateau, 3, 9) + "___" + couleurCorrespondante(plateau, 3, 10) + "/" + couleurCorrespondante(plateau, 3, 11) + caractereCorrespondant(plateau, 3, 11) + couleurCorrespondante(plateau, 3, 12) + "\\" + couleurCorrespondante(plateau, 3, 13) + "___" + RESET);
        System.out.println("D   " + couleurCorrespondante(plateau, 4, 0) + "/" + couleurCorrespondante(plateau, 4, 1) + caractereCorrespondant(plateau, 4, 1) + couleurCorrespondante(plateau, 4, 2) + "\\" + couleurCorrespondante(plateau, 4, 3) + "___" + couleurCorrespondante(plateau, 4, 4) + "/" + couleurCorrespondante(plateau, 4, 5) + caractereCorrespondant(plateau, 4, 5) + couleurCorrespondante(plateau, 4, 6) + "\\" + couleurCorrespondante(plateau, 4, 7) + "___" + couleurCorrespondante(plateau, 4, 8) + "/" + couleurCorrespondante(plateau, 4, 9) + caractereCorrespondant(plateau, 4, 9) + couleurCorrespondante(plateau, 4, 10) + "\\" + couleurCorrespondante(plateau, 4, 11) + "___" + couleurCorrespondante(plateau, 4, 12) + "/" + couleurCorrespondante(plateau, 4, 13) + caractereCorrespondant(plateau, 4, 13) + couleurCorrespondante(plateau, 4, 14) + "\\" + RESET);
        System.out.println("E   " + couleurCorrespondante(plateau, 5, 0) + "\\" + couleurCorrespondante(plateau, 5, 1) + "___" + couleurCorrespondante(plateau, 5, 2) + "/" + couleurCorrespondante(plateau, 5, 3) + caractereCorrespondant(plateau, 5, 3) + couleurCorrespondante(plateau, 5, 4) + "\\" + couleurCorrespondante(plateau, 5, 5) + "___" + couleurCorrespondante(plateau, 5, 6) + "/" + couleurCorrespondante(plateau, 5, 7) + caractereCorrespondant(plateau, 5, 7) + couleurCorrespondante(plateau, 5, 8) + "\\" + couleurCorrespondante(plateau, 5, 9) + "___" + couleurCorrespondante(plateau, 5, 10) + "/" + couleurCorrespondante(plateau, 5, 11) + caractereCorrespondant(plateau, 5, 11) + /*Le probleme est la dans cette instruction qui suit*/ couleurCorrespondante(plateau, 5, 12) + "\\" + couleurCorrespondante(plateau, 5, 13) + "___" + couleurCorrespondante(plateau, 5, 14) + "/" + RESET);
        System.out.println("F   " + couleurCorrespondante(plateau, 6, 0) + "/" + couleurCorrespondante(plateau, 6, 1) + caractereCorrespondant(plateau, 6, 1) + couleurCorrespondante(plateau, 6, 2) + "\\" + couleurCorrespondante(plateau, 6, 3) + "___" + couleurCorrespondante(plateau, 6, 4) + "/" + couleurCorrespondante(plateau, 6, 5) + caractereCorrespondant(plateau, 6, 5) + couleurCorrespondante(plateau, 6, 6) + "\\" + couleurCorrespondante(plateau, 6, 7) + "___" + couleurCorrespondante(plateau, 6, 8) + "/" + couleurCorrespondante(plateau, 6, 9) + caractereCorrespondant(plateau, 6, 9) + couleurCorrespondante(plateau, 6, 10) + "\\" + couleurCorrespondante(plateau, 6, 11) + "___" + couleurCorrespondante(plateau, 6, 12) + "/" + couleurCorrespondante(plateau, 6, 13) + caractereCorrespondant(plateau, 6, 13) + couleurCorrespondante(plateau, 6, 14) + "\\" + RESET);
        System.out.println("G   " + couleurCorrespondante(plateau, 7, 0) + "\\" + couleurCorrespondante(plateau, 7, 1) + "___" + couleurCorrespondante(plateau, 7, 2) + "/" + couleurCorrespondante(plateau, 7, 3) + caractereCorrespondant(plateau, 7, 3) + couleurCorrespondante(plateau, 7, 4) + "\\" + couleurCorrespondante(plateau, 7, 5) + "___" + couleurCorrespondante(plateau, 7, 6) + "/" + couleurCorrespondante(plateau, 7, 7) + caractereCorrespondant(plateau, 7, 7) + couleurCorrespondante(plateau, 7, 8) + "\\" + couleurCorrespondante(plateau, 7, 9) + "___" + couleurCorrespondante(plateau, 7, 10) + "/" + couleurCorrespondante(plateau, 7, 11) + caractereCorrespondant(plateau, 7, 11) + couleurCorrespondante(plateau, 7, 12) + "\\" + couleurCorrespondante(plateau, 7, 13) + "___" + couleurCorrespondante(plateau, 7, 14) + "/" + RESET);
        System.out.println("H   " + couleurCorrespondante(plateau, 8, 0) + "/" + couleurCorrespondante(plateau, 8, 1) + caractereCorrespondant(plateau, 8, 1) + couleurCorrespondante(plateau, 8, 2) + "\\" + couleurCorrespondante(plateau, 8, 3) + "___" + couleurCorrespondante(plateau, 8, 4) + "/" + couleurCorrespondante(plateau, 8, 5) + caractereCorrespondant(plateau, 8, 5) + couleurCorrespondante(plateau, 8, 6) + "\\" + couleurCorrespondante(plateau, 8, 7) + "___" + couleurCorrespondante(plateau, 8, 8) + "/" + couleurCorrespondante(plateau, 8, 9) + caractereCorrespondant(plateau, 8, 9) + couleurCorrespondante(plateau, 8, 10) + "\\" + couleurCorrespondante(plateau, 8, 11) + "___" + couleurCorrespondante(plateau, 8, 12) + "/" + couleurCorrespondante(plateau, 8, 13) + caractereCorrespondant(plateau, 8, 13) + couleurCorrespondante(plateau, 8, 14) + "\\" + RESET);
        System.out.println("I   " + couleurCorrespondante(plateau, 9, 0) + "\\" + couleurCorrespondante(plateau, 9, 1) + "___" + couleurCorrespondante(plateau, 9, 2) + "/" + couleurCorrespondante(plateau, 9, 3) + caractereCorrespondant(plateau, 9, 3) + couleurCorrespondante(plateau, 9, 4) + "\\" + couleurCorrespondante(plateau, 9, 5) + "___" + couleurCorrespondante(plateau, 9, 6) + "/" + couleurCorrespondante(plateau, 9, 7) + caractereCorrespondant(plateau, 9, 7) + couleurCorrespondante(plateau, 9, 8) + "\\" + couleurCorrespondante(plateau, 9, 9) + "___" + couleurCorrespondante(plateau, 9, 10) + "/" + couleurCorrespondante(plateau, 9, 11) + caractereCorrespondant(plateau, 9, 11) + couleurCorrespondante(plateau, 9, 12) + "\\" + couleurCorrespondante(plateau, 9, 13) + "___" + couleurCorrespondante(plateau, 9, 14) + "/" + RESET);
        System.out.println("J       " + couleurCorrespondante(plateau, 10, 2) + "\\" + couleurCorrespondante(plateau, 10, 3) + "___" + couleurCorrespondante(plateau, 10, 4) + "/" + couleurCorrespondante(plateau, 10, 5) + caractereCorrespondant(plateau, 10, 5) + couleurCorrespondante(plateau, 10, 6) + "\\" + couleurCorrespondante(plateau, 10, 7) + "___" + couleurCorrespondante(plateau, 10, 8) + "/" + couleurCorrespondante(plateau, 10, 9) + caractereCorrespondant(plateau, 10, 9) + couleurCorrespondante(plateau, 10, 10) + "\\" + couleurCorrespondante(plateau, 10, 11) + "___" + couleurCorrespondante(plateau, 10, 12) + "/" + RESET);
        System.out.println("K           " + couleurCorrespondante(plateau, 11, 4) + "\\" + couleurCorrespondante(plateau, 11, 5) + "___" + couleurCorrespondante(plateau, 11, 6) + "/" + couleurCorrespondante(plateau, 11, 7) + caractereCorrespondant(plateau, 11, 7) + couleurCorrespondante(plateau, 11, 8) + "\\" + couleurCorrespondante(plateau, 11, 9) + "___" + couleurCorrespondante(plateau, 11, 10) + "/" + RESET);
        System.out.println("                " + couleurCorrespondante(plateau, 12, 6) + "\\" + couleurCorrespondante(plateau, 12, 7) + "___" + couleurCorrespondante(plateau, 12, 8) + "/" + RESET);
    }


    /**
     * Détermine la couleur à afficher pour une case sur le plateau en surbrillance,
     * en fonction des données issues du plateau et des informations de la carte.
     *
     * @param plateau        Le tableau 3D représentant l'état du plateau de jeu.
     * @param donneesCarte   Les informations associées à la carte en cours (tableau 2D).
     * @param lignePlateau   La ligne sur le plateau à analyser.
     * @param colonnePlateau La colonne sur le plateau à analyser.
     * @param ligneCarte     La ligne de la carte associée à analyser.
     * @param colonneCarte   La colonne de la carte associée à analyser.
     * @return               Une chaîne correspondant au code couleur :
     *                       - RESET si la case est une "source" ou une "flèche".
     *                       - Une couleur spécifique avec `couleurCorrespondante()` si pertinent.
     *                       - NOIR sinon.
     */
    public static String definirCouleurEnSurbrillance(int[][][] plateau, int[][] donneesCarte, int lignePlateau, int colonnePlateau, int ligneCarte, int colonneCarte) {
        if (donneesCarte[ligneCarte][colonneCarte] >= 4) {
            // Une fleche
            return RESET;
        } else if (plateau[lignePlateau][colonnePlateau][1] != 0) {
            return couleurCorrespondante(plateau, lignePlateau, colonnePlateau);
        } else if (donneesCarte[ligneCarte][colonneCarte] >= 1) {
            // Une source
            return RESET; // + GRAS ?
        } else {
            return NOIR;
        }
    }


    /**
     * Affiche une section du plateau de jeu. Les cases visibles et leurs adjacentes
     * sont affichées avec des couleurs ou des caractères spécifiques, en fonction
     * de leur état et de leurs informations associées.
     *
     * @param plateau     Le tableau 3D contenant les informations de toutes les cases du plateau.
     * @param ligne       La ligne sur le plateau de la case à afficher.
     * @param colonne     La colonne sur le plateau de la case à afficher.
     * @param donneesCarte Un tableau 2D représentant des données associées à une carte.
     * @param donneesCase  Un tableau 2D non utilisé ici directement, mais représentant des informations
     *                     spécifiques à une case du plateau.
     */
    public static void afficherCase(int[][][] plateau, int ligne, int colonne, int[][] donneesCarte, int[][] donneesCase) {
        if (colonne == 1) { // Extremité gauche
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne - 1, 0, 1) + caractereCorrespondant(plateau, ligne, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne, 0, 2) + caractereCorrespondant(plateau, ligne, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne + 1, 0, 3) + caractereCorrespondant(plateau, ligne, colonne + 1) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne - 1, 1, 1) + caractereCorrespondant(plateau, ligne + 1, colonne - 1) + couleurCorrespondante(plateau, ligne + 1, colonne) + caractereCorrespondant(plateau, ligne + 1, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne + 1, 1, 3) + caractereCorrespondant(plateau, ligne + 1, colonne + 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne + 2, 1, 4) + caractereCorrespondant(plateau, ligne + 1, colonne + 2) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne - 1, 2, 1) + caractereCorrespondant(plateau, ligne + 2, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne, 2, 2) + caractereCorrespondant(plateau, ligne + 2, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne + 1, 2, 3) + caractereCorrespondant(plateau, ligne + 2, colonne + 1) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 3, colonne - 1, 3, 1) + caractereCorrespondant(plateau, ligne + 3, colonne - 1) + RESET + "   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 3, colonne + 1, 3, 3) + caractereCorrespondant(plateau, ligne + 3, colonne + 1) + RESET);
        } else if (colonne == 13) { // Extremité droite
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne - 1, 0, 1) + caractereCorrespondant(plateau, ligne, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne, 0, 2) + caractereCorrespondant(plateau, ligne, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne + 1, 0, 3) + caractereCorrespondant(plateau, ligne, colonne + 1) + RESET);
            System.out.println(definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne - 2, 1, 0) + caractereCorrespondant(plateau, ligne + 1, colonne - 2) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne - 1, 1, 1) + caractereCorrespondant(plateau, ligne + 1, colonne - 1) + couleurCorrespondante(plateau, ligne + 1, colonne) + caractereCorrespondant(plateau, ligne + 1, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne + 1, 1, 3) + caractereCorrespondant(plateau, ligne + 1, colonne + 1) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne - 1, 2, 1) + caractereCorrespondant(plateau, ligne + 2, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne, 2, 2) + caractereCorrespondant(plateau, ligne + 2, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne + 1, 2, 3) + caractereCorrespondant(plateau, ligne + 2, colonne + 1) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 3, colonne - 1, 3, 1) + caractereCorrespondant(plateau, ligne + 3, colonne - 1) + RESET + "   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 3, colonne + 1, 3, 3) + caractereCorrespondant(plateau, ligne + 3, colonne + 1) + RESET);
        } else if (ligne == 10) { // Extremité en bas
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne - 1, 0, 1) + caractereCorrespondant(plateau, ligne, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne, 0, 2) + caractereCorrespondant(plateau, ligne, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne + 1, 0, 3) + caractereCorrespondant(plateau, ligne, colonne + 1) + RESET);
            System.out.println(definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne - 2, 1, 0) + caractereCorrespondant(plateau, ligne + 1, colonne - 2) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne - 1, 1, 1) + caractereCorrespondant(plateau, ligne + 1, colonne - 1) + couleurCorrespondante(plateau, ligne + 1, colonne) + caractereCorrespondant(plateau, ligne + 1, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne + 1, 1, 3) + caractereCorrespondant(plateau, ligne + 1, colonne + 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne + 2, 1, 4) + caractereCorrespondant(plateau, ligne + 1, colonne + 2) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne - 1, 2, 1) + caractereCorrespondant(plateau, ligne + 2, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne, 2, 2) + caractereCorrespondant(plateau, ligne + 2, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne + 1, 2, 3) + caractereCorrespondant(plateau, ligne + 2, colonne + 1) + RESET);
        } else { // Tout le reste du plateau
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne - 1, 0, 1) + caractereCorrespondant(plateau, ligne, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne, 0, 2) + caractereCorrespondant(plateau, ligne, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne, colonne + 1, 0, 3) + caractereCorrespondant(plateau, ligne, colonne + 1) + RESET);
            System.out.println(definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne - 2, 1, 0) + caractereCorrespondant(plateau, ligne + 1, colonne - 2) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne - 1, 1, 1) + caractereCorrespondant(plateau, ligne + 1, colonne - 1) + couleurCorrespondante(plateau, ligne + 1, colonne) + caractereCorrespondant(plateau, ligne + 1, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne + 1, 1, 3) + caractereCorrespondant(plateau, ligne + 1, colonne + 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 1, colonne + 2, 1, 4) + caractereCorrespondant(plateau, ligne + 1, colonne + 2) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne - 1, 2, 1) + caractereCorrespondant(plateau, ligne + 2, colonne - 1) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne, 2, 2) + caractereCorrespondant(plateau, ligne + 2, colonne) + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 2, colonne + 1, 2, 3) + caractereCorrespondant(plateau, ligne + 2, colonne + 1) + RESET);
            System.out.println("   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 3, colonne - 1, 3, 1) + caractereCorrespondant(plateau, ligne + 3, colonne - 1) + RESET + "   " + definirCouleurEnSurbrillance(plateau, donneesCarte, ligne + 3, colonne + 1, 3, 3) + caractereCorrespondant(plateau, ligne + 3, colonne + 1) + RESET);
        }
    }


    /**
     * Retourne le caractère correspondant de l'élément aux indices [ligne][colonne][1] du plateau.
     *
     * @param plateau
     * @param ligne
     * @param colonne
     * @return
     */
    public static String caractereCorrespondant(int[][][] plateau, int ligne, int colonne) {
        /*
        1 : 1 chaumiere
        2 : 2 chaumieres
        3 : 3 chaumieres
        4 : engrais
        5 : transmutation
         */
        String[] caracteres = {" ⌂ ", "⌂ ⌂", "⌂⌂⌂", " ⇑ ", " ⌽ ", "/", "\\", "___"};
        String res = " ";
        if (plateau[ligne][colonne][0] == 2) { // Il s'agit d'une chaumiere
            res = caracteres[plateau[ligne][colonne][1] - 1];
        } else if (plateau[ligne][colonne][0] == 1) { // Il s'agit d'un chemin
            if (plateau[ligne][colonne][2] == 0 || plateau[ligne][colonne][2] == 3) { // 0, 3 : '/'
                res = caracteres[5];
            } else if (plateau[ligne][colonne][2] == 1 || plateau[ligne][colonne][2] == 4) { // 1, 4 : '\'
                res = caracteres[6];
            } else if (plateau[ligne][colonne][2] == 2 || plateau[ligne][colonne][2] == 5) { // 2, 5 : '___'
                res = caracteres[7];
            }
            /*
            0 : /
            1 : \
            2 : ___
            3 : /
            4 : \
            5 : ___
             */
        }
        return res;
    }


    /**
     * Retourne la couleur correspondante de l'élément aux indices [ligne][colonne][1] ou [ligne][colonne][2] du plateau.
     *
     * @param plateau
     * @param ligne
     * @param colonne
     * @return
     */
    public static String couleurCorrespondante(int[][][] plateau, int ligne, int colonne) {
        String res = RESET;
        if (plateau[ligne][colonne][0] == 1) { // Il s'agit d'un chemin
            if (plateau[ligne][colonne][1] == 0) { // Il n'y a aucune couleur assignée
                if (plateau[ligne][colonne][2] >= 0 && plateau[ligne][colonne][2] <= 2) { // Chemin de lisiere
                    res = RESET + GRAS;
                } else if (plateau[ligne][colonne][2] >= 3 && plateau[ligne][colonne][2] <= 4) { // Chemin du village
                    res = RESET;
                }
            } else { // Il y a une couleur assignée
                if (plateau[ligne][colonne][2] >= 0 && plateau[ligne][colonne][2] <= 2) { // Chemin de lisiere
                    res = TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, Jeu.couleursJoueurs[plateau[ligne][colonne][1] - 1])] + GRAS;
                } else if (plateau[ligne][colonne][2] >= 3 && plateau[ligne][colonne][2] <= 5) { // Chemin du village
                    res = TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, Jeu.couleursJoueurs[plateau[ligne][colonne][1] - 1])];
                }
            }
        } else if (plateau[ligne][colonne][0] == 2) { // Il s'agit d'une chaumiere
            if (plateau[ligne][colonne][2] == 0) { // Si elle est victime
                res = ROUGE;
            } else { // Si elle n'est pas victime
                res = VERT;
            }
        }
        return res;
    }

    public static void afficherMessageErreur(String messageErreur) {
        afficherTexteEnAnimation(ROUGE + messageErreur + RESET, false);
        Logique.attendre(1500);
    }

    public static void afficherTexteEnAnimation(String texte, boolean retourLigne) {
        System.out.print("\033[F\033[K");
        for (int i = 0; i < texte.length(); i++) {
            System.out.print(texte.charAt(i));
            Logique.attendre(25);
        }
        if (retourLigne) {
            System.out.println();
        }
        Logique.viderBuffer();
    }

    // A afficher juste au dessus de l'affichage du plateau a chaque fois
    public static void afficherScores(int[] victimesJoueurs, String[] pseudosJoueurs, String[] couleursJoueurs) {
        System.out.println("Score des joueurs :");
        for (int i = 0; i < victimesJoueurs.length; i++) {
            System.out.println(TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[i])] + GRAS + pseudosJoueurs[i] + RESET + " : " + victimesJoueurs[i]);
        }
    }

    public static void afficherFileJoueur(ArrayList<Integer> fileJoueur) {
        // Affiche chaque carte de la file du joueur iJoueur
        for (int iCarte = 0; iCarte < fileJoueur.size(); iCarte++) {
            System.out.println(Affichage.cartesPropagation[fileJoueur.get(iCarte) - 1]);
            System.out.println();
        }
    }
}

/*
    _______________
   /               \
  /        ^        \
 /       /___\       \
/       /     \       \
\      |   ↑   | ጰ    /
 \    ጰ \     /   ጰ  /
  \    ጰ/_/ \_\ጰ    /
   \_______________/
        Engrais
    _______________
   /               \
  /  ///////////\   \
 /  ///////////__\   \
/   |    _    |  |    \
\ ጰ |[] | | []|[]|    /
 \  |ጰ__| |___|ጰ_| ጰ /
  \       ጰ         /
   \_______________/
      1 chaumière
    _______________
   /      /////////\
  /  ///////////\/__\
 /  ///////////__\  |\
/   |    _    |  |[]|ጰ\
\ ጰ |[] | | []|[]|ጰ_ጰ /
 \ጰ |ጰ__| |_ጰ_|ጰ_|ጰጰ /
  \   ጰ   ጰ     ጰ  ጰ/
   \_______________/
      2 chaumières
    _______________
   ////////////////\
  /  ///////////\/__\
 /|[///////////__\  |\
/ጰ|_|    _    |  |[]|ጰ\
\ ጰ |[] | | []|[]|ጰ_ጰ /
 \ጰ |ጰ__| |_ጰ_|ጰ_|ጰጰ /
  \  ጰጰ   ጰ ጰጰ  ጰ  ጰ/
   \_______________/
      3 chaumières
    _______________
   /       n       \
  /      _( )__      \
 /      / / \ \      \
/       _______       \
\      |   _   |      /
 \     |_ጰ| |__|  ጰ  /
  \   ጰ  ጰ    ጰ     /
   \_______________/
     Transmutation
 */