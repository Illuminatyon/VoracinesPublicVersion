import java.util.ArrayList;

public class JcJ {
    public static void afficherModificationOrdreCartes(int nbJoueurs, String messageChoixConfirmation, String[] couleursJoueurs, String[] pseudosJoueurs, ArrayList<Integer>[] filesJoueurs, int iJoueur) {
        Affichage.nettoyerConsole(200);
        System.out.println("Modification de l'ordre des cartes");
        System.out.println();
        System.out.println("Seul(e) " + Affichage.TABLEAU_COULEURS_JOUEURS[Logique.trouverIndiceCouleur(GestionJoueur.couleurs, couleursJoueurs[iJoueur])] + Affichage.GRAS + pseudosJoueurs[iJoueur] + Affichage.RESET + " peut regarder l'écran !");
        System.out.println();
        System.out.println("Ordre de vos cartes :");
        Affichage.afficherFileJoueur(filesJoueurs[iJoueur]);
    }
}
