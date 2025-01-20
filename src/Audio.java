import javax.sound.sampled.*;
import java.io.File;

/**
 * Classe utilitaire pour gérer la lecture des fichiers audio.
 * Utilise l'API Java Sound pour lire, contrôler le volume et arrêter des fichiers audio.
 */
public class Audio {
    public static Clip clipEnCours;
    /**
     * Lit un fichier audio au chemin spécifié avec le volume et l'option de boucle.
     *
     * @param cheminFichier    Le chemin vers le fichier audio à lire.
     * @param pourcentageVolume Le volume de lecture en pourcentage (entre 0 et 100).
     * @param boucle           Indique si le fichier doit être lu en boucle infinie.
     * @return                 Un objet {@link Clip} représentant l'audio en cours de lecture, ou null si une erreur survient.
     */
    public static Clip jouerAudio(String cheminFichier, int pourcentageVolume, boolean boucle, boolean estParametreActif) {
        if (!estParametreActif) {
            return null;
        }
        try {
            File fichierAudio = new File(cheminFichier);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(fichierAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Gérer le volume
            FloatControl controleVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = pourcentageVolumeEnDecibels(pourcentageVolume, controleVolume);
            controleVolume.setValue(volume);

            if (boucle) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }

            // Libérer les ressources automatiquement à la fin de la lecture
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

            return clip; // Retourne le clip pour contrôle ultérieur
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Arrête un fichier audio en cours de lecture avec ou sans fondu.
     *
     * @param clip   L'objet {@link Clip} en cours de lecture.
     * @param fondu  Indique si l'arrêt doit inclure un effet de "fade out" (diminution progressive du volume).
     */
    public static void stopAudio(Clip clip, boolean fondu) {
        if (clip != null && clip.isRunning()) {
            if (fondu) {
                // Appliquer le fade out
                FloatControl controleVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                new Thread(() -> {
                    try {
                        for (float volume = controleVolume.getValue(); volume > controleVolume.getMinimum(); volume -= 0.25f) {
                            controleVolume.setValue(volume);
                            Thread.sleep(15); // Attente pour rendre la transition progressive
                        }
                        clip.stop();
                        clip.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                // Arrêt immédiat
                clip.stop();
                clip.close();
            }
        }
    }

    /**
     * Convertit un pourcentage de volume en valeurs décibels compatibles avec le contrôle de volume.
     *
     * @param volumePercentage Le pourcentage de volume (entre 0 et 100).
     * @param volumeControl    L'objet {@link FloatControl} utilisé pour contrôler le volume.
     * @return                 La valeur du volume en décibels.
     */
    private static float pourcentageVolumeEnDecibels(int volumePercentage, FloatControl volumeControl) {
        float min = volumeControl.getMinimum();
        float max = volumeControl.getMaximum();
        return (float) (min + (volumePercentage / 100.0) * (max - min));
    }

    /**
     * Joue un son spécifique en fonction d'une condition donnée.
     *
     * @param conditionErreur  La condition à vérifier (true = erreur, false = valide).
     * @param sonErreur        Le nom du fichier son à jouer en cas d'erreur (sans extension).
     * @param sonValide        Le nom du fichier son à jouer en cas de succès (sans extension).
     */
    public static void jouerSonSaisie(boolean conditionErreur, String sonErreur, String sonValide) {
        if (conditionErreur) {
            jouerAudio("assets/audio/" + sonErreur + ".wav", 80, false, Parametres.effetsSonores);
        } else {
            jouerAudio("assets/audio/" + sonValide + ".wav", 70, false, Parametres.effetsSonores);
        }
    }
}