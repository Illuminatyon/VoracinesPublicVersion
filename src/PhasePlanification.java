import java.util.ArrayList;

public class PhasePlanification {

    // Déclaration de la pile utilisée dans la phase de propagation
    //public static ArrayList<Integer> pilePropagation;


    public static int demanderDefausseJoueur(ArrayList<Integer> fileJoueur) {
        int choix;

        Affichage.afficherFileJoueur(fileJoueur);
        Logique.viderBuffer();
        choix = Affichage.saisirEntier("Saisissez le numéro de la carte à défausser : ");
        if (!(fileJoueur.contains(choix))) {
            Audio.jouerAudio("assets/audio/error.wav", 80, false, Parametres.effetsSonores);
        }

        return choix;
    }
}
