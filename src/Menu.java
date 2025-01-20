/**
 * La classe Menu gère l'affichage et la navigation entre les différents menus d'une application ou d'un jeu.
 * Elle comprend les menus principaux, les menus pour les paramètres, les règles, les modes de jeu, etc.
 * Des interactions utilisateur sont proposées via des choix et des sons sont joués pour donner un retour.
 *
 * Cette classe est interactive et dépend de plusieurs autres classes/utilitaires comme `Audio`, `Affichage` et `Jeu`.
 */
public class Menu {
    /**
     * Affiche le menu principal et gère la navigation vers d'autres menus en fonction du choix de l'utilisateur.
     * Propose les options suivantes :
     * - Jouer
     * - Consulter les règles
     * - Modifier les paramètres
     * - Quitter
     * Joue des effets sonores basés sur les choix.
     */
    public static void afficherMenu1() {
        int choix;

        if (Audio.clipEnCours == null && Parametres.musique) {
            Audio.clipEnCours = Audio.jouerAudio("assets/audio/tmp.wav", 70, true, Parametres.musique);
        }
        int vAlea = (int)(Math.random() * Affichage.titres.length - 1) + 1;

        do {
            Affichage.nettoyerConsole(200);
            Affichage.titreMenuPrincipalAleatoire(vAlea);
            System.out.println();
            Affichage.afficherMentionsLegales();
            System.out.println();
            System.out.println(Affichage.GRAS + "Pour une meilleure experience de jeu, veuillez utiliser un terminal avec un fond noir et qui supporte la palette de couleur ANSI" + Affichage.RESET);
            System.out.println();
            System.out.println("1. JOUER - Plongez dans une aventure envoûtante");
            System.out.println("2. RÈGLES - Apprenez à jouer");
            System.out.println("3. PARAMÈTRES - Personnalisez votre jeu");
            System.out.println("4. QUITTER - Laissez les mystères pour une autre fois");

            choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);
            switch (choix) {
                case 1, 2, 3 -> Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
                case 4 -> Audio.jouerAudio("assets/audio/validation.wav", 70, false, Parametres.effetsSonores);
                default -> Audio.jouerAudio("assets/audio/error.wav", 80, false, Parametres.effetsSonores);
            }
        } while (choix < 1 || choix > 4);

        System.out.println();

        switch (choix) {
            case 1 -> afficherMenuReseau();
            case 2 -> afficherRegles();
            case 3 -> afficherParametres();
            case 4 -> {
                Audio.stopAudio(Audio.clipEnCours, true);
                Audio.jouerAudio("assets/audio/bye.wav", 80, false, Parametres.effetsSonores);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Lanceur.quitter = true;
            }
        }
    }

    /**
     * Affiche les options du menu de réseau :
     * - Jouer sur cette machine.
     * - Jouer en réseau local.
     * - Jouer en ligne.
     * - Retour au menu principal.
     * Réagit aux choix via des sons et déplace l'utilisateur vers les menus correspondants.
     */
    public static void afficherMenuReseau() {
        int choix;

        do {
            Affichage.nettoyerConsole(200);
            System.out.println("=== SELECTION CONNEXION ===");
            System.out.println("1. Sur cette machine");
            System.out.println("2. Réseau local");
            System.out.println("3. En ligne");
            System.out.println("4. Retour");

            choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);
            Audio.jouerSonSaisie(choix < 1 || choix > 4, "error", "click");
        } while (choix < 1 || choix > 4);

        switch (choix) {
            case 1 -> afficherMenuModeJeu();
            //case 2 -> // TODO
            //case 3 -> afficherMenuEnLigne();
        }
    }

    /**
     * Affiche le menu permettant de choisir un mode de jeu :
     * - Joueur contre joueur (JcJ).
     * - Joueur contre l'ordinateur (JcE).
     * - Ordinateurs entre eux (EcE).
     * - Retour au menu réseau.
     *
     * Envoie l'utilisateur vers les menus appropriés selon le mode de jeu choisi.
     */
    public static void afficherMenuModeJeu() {
        int choix;

        do {
            Affichage.nettoyerConsole(200);
            System.out.println("======= 🎮 MODE DE JEU 🎮 =======");
            System.out.println("1. JcJ");
            System.out.println("2. Prochainement - JcE ");
            System.out.println("3. Prochainement - EcE");
            System.out.println("4. Retour");
            System.out.println("================================");

            choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);
            Audio.jouerSonSaisie(choix < 1 || choix > 4, "error", "click");
        } while (choix < 1 || choix > 4);

        System.out.println();

        switch (choix) {
            case 1 -> afficherMenuJcJ();
            //case 2 -> afficherMenuJcE();
            //case 3 -> afficherMenuEcE();
            case 4 -> afficherMenuReseau();
        }
    }


    /**
     * Affiche le menu permettant de choisir le nombre de joueurs pour un mode JcJ (Joueur contre Joueur).
     * - 3 joueurs : objectif 60 victimes.
     * - 4 joueurs : objectif 50 ou 100 (mode 2v2).
     * - 5 joueurs : objectif 40 victimes.
     * - Retour vers le menu précédent.
     *
     * Gère également les aspects spécifiques comme le choix du mode 2v2 dans le cas de 4 joueurs.
     */
    public static void afficherMenuJcJ(){
        int choix;

        do {
            Affichage.nettoyerConsole(200);
            System.out.println("=== \uD83D\uDC64 NOMBRE DE JOUEURS \uD83D\uDC64 ===");
            System.out.println("1. 3 joueurs [objectif : 60 victimes]\t- Un combat chacun pour soi !");
            System.out.println("2. 4 joueurs [objectif : 50 ou 100 victimes]\t- 4 forces ; un seul objectif !");
            System.out.println("3. 5 joueurs [objectif : 40 victimes]\t- La mêlée royale ultime !");
            System.out.println("4. Retour");
            System.out.println("================================");

            choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);

            switch (choix) {
                case 1, 3 -> {
                    Audio.jouerAudio("assets/audio/validation.wav", 70, false, Parametres.effetsSonores);
                    Audio.stopAudio(Audio.clipEnCours, true);
                    Logique.attendre(2500);
                    Audio.clipEnCours = Audio.jouerAudio("assets/audio/m2.wav", 70, true, Parametres.musique);
                }
                case 2, 4 -> Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
                default -> Audio.jouerAudio("assets/audio/error.wav", 80, false, Parametres.effetsSonores);
            }
        } while (choix < 1 || choix > 4);

        System.out.println();

        switch (choix) {
            case 1 -> Jeu.lancerPartie(3);
            case 2 -> afficherMenu4J();
            case 3 -> Jeu.lancerPartie(5);
            case 4 -> afficherMenuModeJeu();
        }
    }

    /**
     * Affiche le menu permettant de choisir un mode spécial pour **4 joueurs** :
     * - Chacun pour soi.
     * - Modèle 2 contre 2 (2v2).
     * - Retour au menu précédent.
     *
     * Ajuste la logique du jeu en fonction du mode choisi.
     */
    public static void afficherMenu4J() {
        int choix;
        System.out.println("======= 🎮 CHOIX DU MODE 🎮 =======");
        System.out.println("1. Chacun pour soi\t- Le chaos absolu !");
        System.out.println("2. 2c2\t- Travaillez en équipe !");
        System.out.println("3. Retour");
        System.out.println("================================");

        do {
            choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);
            switch (choix) {
                case 1, 2 -> {
                    Audio.jouerAudio("assets/audio/validation.wav", 70, false, Parametres.effetsSonores);
                    Audio.stopAudio(Audio.clipEnCours, true);
                    try {
                        Thread.sleep(2500);
                        Affichage.nettoyerConsole(200);
                        Audio.clipEnCours = Audio.jouerAudio("assets/audio/m2.wav", 70, true, Parametres.musique);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Affichage.nettoyerConsole(200);
                }
                case 3 -> Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
                default -> Audio.jouerAudio("assets/audio/error.wav", 80, false, Parametres.effetsSonores);
            }
        } while (choix < 1 || choix > 3);

        switch (choix) {
            case 1 -> Jeu.lancerPartie(4);
            case 2 -> Jeu.lancerPartie(4, true);
            case 3 -> afficherMenuJcJ();
        }
    }

    /**
     * Affiche le menu pour faire jouer des joueurs humains contre des ordinateurs (JcE).
     * L'utilisateur peut définir :
     * - Le nombre de joueurs humains (entre 0 et 5).
     * - Le nombre d'ordinateurs pour compléter les places restantes.
     *
     * Si aucun joueur n'est sélectionné, le jeu peut proposer un passage automatique au mode EcE.
     */
    public static void afficherMenuJcE() {
        /*int nbJoueurs;
        int nbOrdinateurs;
        String choix;
        System.out.println("=== \uD83D\uDC64 NOMBRE DE JOUEURS \uD83D\uDC64 ===");

        do {
            nbJoueurs = Affichage.saisirEntier(Affichage.VERT + "Saisissez le nombre de joueurs : " + Affichage.RESET);
            Audio.jouerSonSaisie(nbJoueurs < 0 || nbJoueurs > 5, "error", "click");
        } while (nbJoueurs < 0 || nbJoueurs > 5);

        if (nbJoueurs == 0) {
            //System.out.println("Il n'y a aucun joueur, vous avez été placé automatiquement en mode EcE");
            System.out.println("Il n'y a aucun joueur.");
            do {
                choix = Affichage.saisirChaine(Affichage.VERT + "Voulez vous passer en mode EcE ? (o/n) : " + Affichage.RESET);
            } while (!choix.equalsIgnoreCase("o") && !choix.equalsIgnoreCase("n"));
            if (choix.equalsIgnoreCase("o")) {
                afficherMenuJcE();
            } else {
                // Recommencer ici ?
            }
        } else if (nbJoueurs == 5) {
            System.out.println("Il n'y a plus assez de place pour accueillir un Ordinateur, vous avez été placé automatiquement en mode JcJ 5 joueurs");
        } else {
            do {
                nbOrdinateurs = Affichage.saisirEntier(Affichage.VERT + "Saisissez le nombre d'Ordinateurs : " + Affichage.RESET);
            } while (nbOrdinateurs < 5 - nbJoueurs);
        }

        System.out.println();

        switch (nbJoueurs) {
            case 3, 5 -> Jeu.lancerPartie(nbJoueurs);
            //case 4 -> Jeu.lancerPartie(nbJoueurs, jouerEn2c2());
        }*/
    }

    /**
     * Affiche le menu pour le mode où les ordinateurs jouent uniquement entre eux (EcE).
     * Actuellement non implémenté.
     */
    public static void afficherMenuEcE() {

    }


    /**
     * Affiche les règles du jeu en plusieurs sections :
     * - Description générale du jeu et des objectifs de victoire.
     * - Mise en place du plateau et des decks.
     * - Déroulement des phases de jeu (planification, propagation).
     * - Comment capturer des tuiles et gagner des points.
     * - Règles spéciales et bonne chance !
     *
     * Affiche également des visuels ASCII pour illustrer les plateaux et cartes.
     */
    public static void afficherRegles() {
        Affichage.nettoyerConsole(200);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println(Affichage.GRAS + "         BIENVENUE DANS VORACINES     " + Affichage.RESET);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println();
        System.out.println("DESCRIPTION DU JEU :");
        System.out.println("Dans Voracines, vous incarnez des arbres maléfiques dotés de pouvoirs");
        System.out.println("surnaturels. Votre mission : capturer des villageois pour vous nourrir");
        System.out.println("de leur force vitale. Vous rivalisez contre d'autres arbres en");
        System.out.println("propageant vos racines à travers un village. Chaque joueur devra");
        System.out.println("stratégiser, anticiper les mouvements adverses et exploiter les tuiles");
        System.out.println("spéciales pour triompher.");
        System.out.println();
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println(Affichage.GRAS + "             BUT DU JEU               " + Affichage.RESET);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println("Votre objectif est de capturer un nombre prédéterminé de victimes en");
        System.out.println("encerclant les tuiles village avec vos racines. Voici les conditions");
        System.out.println("de victoire selon le mode de jeu :");
        System.out.println("   - 3 joueurs : 60 victimes.");
        System.out.println("   - 4 joueurs : 50 victimes.");
        System.out.println("   - 5 joueurs : 45 victimes.");
        System.out.println("   - Mode équipe (2v2) : 100 victimes par équipe.");
        System.out.println("Dès qu'un joueur ou une équipe atteint cet objectif, la partie se");
        System.out.println("termine immédiatement.");
        System.out.println();
        Affichage.saisirChaine(Affichage.VERT + "Appuyer sur entrée pour lire la suite" + Affichage.RESET);
        Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
        System.out.println();
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println(Affichage.GRAS + "          MISE EN PLACE               " + Affichage.RESET);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println("1. Préparez le plateau de jeu en disposant les tuiles village :");
        System.out.println("   - Placez les tuiles \"3 chaumières\" au centre du plateau.");
        System.out.println("   - Disposez les tuiles \"2 chaumières\" et \"Transmutation\" autour.");
        System.out.println("   - Placez les tuiles \"1 chaumière\" et \"Engrais\" sur les bords.");
        System.out.println("2. Mélangez les cartes de propagation et formez une pile face cachée.");
        System.out.println("3. Chaque joueur choisit une couleur et prend un sac contenant 50 jetons racines.");
        System.out.println("4. Déterminez aléatoirement le premier joueur.");
        System.out.println(" (Prenez en compte que tout ceci est un jeu de société réel : tous ces processus sont donc automatisés.) ");
        System.out.println();
        Affichage.saisirChaine(Affichage.VERT + "Appuyer sur entrée pour lire la suite" + Affichage.RESET);
        Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
        System.out.println();
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println(Affichage.GRAS + "      DÉROULEMENT D'UN TOUR           " + Affichage.RESET);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println("Un tour se divise en deux phases principales :");
        System.out.println();
        System.out.println("PHASE 1 : PLANIFICATION");
        System.out.println("   - Chaque joueur pioche 4 cartes de propagation.");
        System.out.println("   - Ils choisissent 3 cartes parmi ces 4 et les organisent dans un ordre");
        System.out.println("     secret (en les empilant). La 4ème carte est défaussée.");
        System.out.println("   - Une fois les cartes choisies, les joueurs ne peuvent plus changer");
        System.out.println("     leur ordre. Les cartes seront révélées et jouées dans cet ordre.");
        System.out.println();
        System.out.println();
        System.out.println("Voici à quoi ressemble une carte de propagation :");
        System.out.println();
        System.out.println(
                "  ________\n" +
                " / __←    \\\n" +
                "/1    \\→__ \\\n" +
                "\\     /   1/\n" +
                " \\________/");
        System.out.println();
        System.out.println("Les flèches indiquent où la propagation mènera, tandis que les traits sans flèches indique la source qui est nécessaire pour la propagation.");
        System.out.println("Si lorsque vous jouez, les sources ne sont pas présente sur l'endroit où vous décidez de jouer, la propagation ne fonctionnera pas.");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Voici à quoi peut ressembler le plateau de jeu :");
        System.out.println(
                "             ___\n" +
                "         ___/ ⌂ \\___\n" +
                "     ___/ ⇑ \\___/ ⌂ \\___\n" +
                " ___/ ⇑ \\___/ ⌽ \\___/ ⌂ \\___\n" +
                "/ ⇑ \\___/ ⌽ \\___/ ⌽ \\___/ ⌂ \\\n" +
                "\\___/ ⌽ \\___/⌂⌂⌂\\___/⌂ ⌂\\___/\n" +
                "/ ⇑ \\___/⌂⌂⌂\\___/⌂⌂⌂\\___/ ⌂ \\\n" +
                "\\___/⌂ ⌂\\___/⌂⌂⌂\\___/⌂ ⌂\\___/\n" +
                "/ ⇑ \\___/⌂ ⌂\\___/⌂ ⌂\\___/ ⇑ \\\n" +
                "\\___/ ⌂ \\___/⌂ ⌂\\___/ ⌂ \\___/\n" +
                "    \\___/ ⌂ \\___/ ⌂ \\___/\n" +
                "        \\___/ ⌂ \\___/\n" +
                "            \\___/");
        System.out.println();
        System.out.println("Le plateau ici présent est composé d'héxagones. Chaque héxagone a des points qui seront attribué, lors de leurs captures, aux joueurs.");
        System.out.println("PHASE 2 : PROPAGATION");
        System.out.println("   - Les joueurs révèlent leur première carte en même temps.");
        System.out.println("   - Celui ayant la carte avec le plus petit numéro joue en premier.");
        System.out.println("   - Chaque joueur place ses jetons racines sur le plateau en suivant");
        System.out.println("     les flèches indiquées sur sa carte.");
        System.out.println("   - Répétez l’opération pour les 2ème et 3ème cartes de chaque joueur.");
        System.out.println();
        Affichage.saisirChaine(Affichage.VERT + "Appuyer sur entrée pour lire la suite" + Affichage.RESET);
        Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
        System.out.println();
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println(Affichage.GRAS + "         CAPTURE DES TUILES           " + Affichage.RESET);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println("Pour capturer une tuile village, placez la 6ème racine autour de cette");
        System.out.println("tuile. Une fois capturée, la tuile est retirée du plateau et ajoutée");
        System.out.println("aux points de victime du joueur.");
        System.out.println();
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println(Affichage.GRAS + "        RÈGLES SPÉCIALES              " + Affichage.RESET);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println("- Une racine adverse ne peut pas être utilisée comme source.");
        System.out.println("- Vous pouvez utiliser un chemin inoccupé comme source.");
        System.out.println();
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        System.out.println(Affichage.GRAS + "            BONNE CHANCE !            " + Affichage.RESET);
        System.out.println(Affichage.VERT + "======================================" + Affichage.RESET);
        Affichage.saisirChaine(Affichage.VERT + "Appuyez sur entrée pour revenir au menu" + Affichage.RESET);
        Audio.jouerAudio("assets/audio/click.wav", 70, false, Parametres.effetsSonores);
    }

    /**
     * Affiche le menu des paramètres utilisateur et permet la modification :
     * - Activer/désactiver la musique.
     * - Retourner au menu principal.
     * Modifie le comportement du jeu selon la configuration choisie.
     */
    public static void afficherParametres() {
        int choix;

        do {
            do {
                Affichage.nettoyerConsole(200);
                System.out.println("=== PARAMÈTRES ===");
                if (Parametres.musique) {
                    System.out.println("1. Musique ☑");
                } else {
                    System.out.println("1. Musique ☐");
                }
                if (Parametres.effetsSonores) {
                    System.out.println("2. Effets sonores ☑");
                } else {
                    System.out.println("2. Effets sonores ☐");
                }
                System.out.println("3. Retour");

                choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez le numéro du paramètre à modifier : " + Affichage.RESET);
                if (choix == 1 && Parametres.musique) {
                    Parametres.musique = false;
                    Audio.stopAudio(Audio.clipEnCours, false);
                } else if (choix == 1 && !Parametres.musique) {
                    Parametres.musique = true;
                    Audio.clipEnCours = Audio.jouerAudio("assets/audio/tmp.wav", 70, true, Parametres.musique);
                } else if (choix == 2) {
                    Parametres.effetsSonores = !Parametres.effetsSonores;
                }
                Audio.jouerSonSaisie(choix < 1 || choix > 3, "error", "click");
            } while (choix != 3 && !(choix < 1 || choix > 2));
        } while (choix != 3);
    }

    /**
     * Affiche le menu pour jouer en ligne.
     * - Vérifie d'abord la connexion avec le serveur avant d'afficher le menu.
     * - Options disponibles :
     *   - Créer un salon (démarrer le serveur).
     *   - Rejoindre un salon (se connecter à un serveur existant).
     *   - Retour au menu précédent.
     *
     * Si la connexion au serveur échoue, retourne directement au menu principal.
     */
    public static void afficherMenuEnLigne() {
        int choix;

        // TODO Verifier si il y a la connexion
        //if (Version.verifierConnexion()) {
            Affichage.nettoyerConsole(200);
            System.out.println("=== ONLINE ===");
            System.out.println("1. Créer un salon");
            System.out.println("2. Rejoindre un salon");
            System.out.println("3. Retour");

            do {
                choix = Affichage.saisirEntier(Affichage.VERT + "Saisissez votre choix : " + Affichage.RESET);
                Audio.jouerSonSaisie(choix < 1 || choix > 3, "error", "click");
            } while (choix < 1 || choix > 3);

            switch (choix) {
                case 1 -> {
                    Affichage.nettoyerConsole(200);
                    Serveur.demarrerServeur();
                }
                case 2 -> {
                    Affichage.nettoyerConsole(200);
                    Client.connectionAuServeur();
                }
            }
        //} else {
        //    System.out.println("Echec de la connexion, retour au menu principal");
        //}
    }
}