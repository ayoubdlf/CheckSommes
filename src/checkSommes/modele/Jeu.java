package checkSommes.modele;

import checkSommes.exceptions.ErreurFichier;
import checkSommes.fabrique.FabriquePlateau;
import checkSommes.ig.Observateur;
import java.io.*;
import java.util.*;


public class Jeu implements Iterable<Coup>{

    private ArrayList<Observateur> observateurs; // Liste des observateurs qui seront notifiés des changements
    private ArrayList<Coup> coups;
    private boolean mode;                        // Indique le mode actuel du jeu : true = oui, false = non
    private int nbVies;                          // Indique le nombre de vies restantes
    private Case[][] cases;


    /**
     * Constructeur de la classe Jeu.
     */
    public Jeu() {
        this.observateurs = new ArrayList<>(3);
        this.coups        = new ArrayList<>();
        this.mode         = false;
        this.nbVies       = 5;
        this.cases        = FabriquePlateau.FabriquePlateau5x5();
    }

    /**
     * Réinitialise le plateau de jeu.
     */
    public void reinitialiserPlateau() {
        this.coups.clear();
        this.mode   = false;
        this.nbVies = 5;

        for (int ligne = 0; ligne < this.getNbLignes(); ligne++) {
            for (int colonne = 0; colonne < this.getNbColonnes(); colonne++) {
                this.cases[ligne][colonne].initialiser();
            }
        }

        this.notifierObservateurs();
    }

    /**
     * Ajoute un observateur à la liste des observateurs.
     *
     * @param observateur L'observateur à ajouter. Ne doit pas être nul.
     * @throws AssertionError si l'observateur est nul.
     */
    public void ajouterObservateur(Observateur observateur) {
        assert (observateur != null) : "L'observateur ne doit pas etre nul";

        this.observateurs.add(observateur);
    }

    /**
     * Notifie tous les observateurs en appelant leur méthode 'reagir'.
     */
    public void notifierObservateurs() {
        for(Observateur observateur : this.observateurs) {
            observateur.reagir();
        }
    }

    /**
     * Change le mode du jeu (inverse le mode actuel).
     * Notifie tous les observateurs du changement de mode.
     */
    public void switchMode() {
        this.mode = !this.mode;

        this.notifierObservateurs();
    }

    /**
     * Vérifie si le mode actuel est 'oui'.
     * 
     * @return true si le mode est 'oui', false sinon.
     */
    public boolean enModeOui() {
        return this.mode;
    }

    /**
     * Vérifie si le mode actuel est 'non'.
     * 
     * @return true si le mode est 'non', false sinon.
     */
    public boolean enModeNon() {
        return !this.mode;
    }

    /**
     * Retourne le nombre de vies restantes dans le jeu.
     * 
     * @return Le nombre de vies restantes.
     */
    public int getNbVies() {
        return this.nbVies;
    }

    /**
     * Retourne la valeur de la case à la position spécifiée.
     *
     * @param ligne   La ligne de la case.
     * @param colonne La colonne de la case.
     * @return La valeur de la case.
     */
    public int getValeur(int ligne, int colonne) {
        assert (ligne   >= 0 && ligne   < this.getNbLignes())   : "La nombre de la ligne est incorrect";
        assert (colonne >= 0 && colonne < this.getNbColonnes()) : "La nombre de la colonne est incorrect";

        return this.cases[ligne][colonne].getValeur();
    }

    /**
     * Retourne la couleur de la case à la position spécifiée.
     *
     * @param ligne   La ligne de la case.
     * @param colonne La colonne de la case.
     * @return La couleur de la case.
     */
    public int getCouleur(int ligne, int colonne) {
        assert (ligne   >= 0 && ligne   < this.getNbLignes())   : "La nombre de la ligne est incorrect";
        assert (colonne >= 0 && colonne < this.getNbColonnes()) : "La nombre de la colonne est incorrect";

        return this.cases[ligne][colonne].getCouleur();
    }

    /**
     * Retourne le nombre de lignes du plateau de jeu.
     *
     * @return Le nombre de lignes.
     */
    public int getNbLignes() {
        return this.cases.length;
    }

    /**
     * Retourne le nombre de colonnes du plateau de jeu.
     *
     * @return Le nombre de colonnes.
     */
    public int getNbColonnes() {
        return this.cases[0].length;
    }

    /**
     * Calcule la somme des valeurs des cases de la ligne spécifiée
     * qui font partie de la solution.
     *
     * @param ligne La ligne dont on veut calculer la somme.
     * @return La somme des valeurs des cases de la ligne.
     */
    public int sommeLigne(int ligne) {
        assert (ligne >= 0 && ligne < this.getNbLignes()) : "La nombre de la ligne est incorrect";

        int somme = 0;

        for (int colonne = 0; colonne < this.getNbColonnes() ; colonne++) {
            Case c = this.cases[ligne][colonne];

            somme += c.estSolution() ? c.getValeur() : 0;
        }

        return somme;
    }

    /**
     * Calcule la somme des valeurs des cases de la colonne spécifiée
     * qui font partie de la solution.
     *
     * @param colonne La colonne dont on veut calculer la somme.
     * @return La somme des valeurs des cases de la colonne.
     */
    public int sommeColonne(int colonne) {
        assert (colonne >= 0 && colonne < this.getNbColonnes()) : "La nombre de la colonne est incorrect";

        int somme = 0;

        for (int ligne = 0; ligne < this.getNbLignes() ; ligne++) {
            Case c = this.cases[ligne][colonne];

            somme += c.estSolution() ? c.getValeur() : 0;
        }

        return somme;
    }

    /**
     * Vérifie si la case à la position spécifiée fait partie de la solution.
     *
     * @param ligne   La ligne de la case.
     * @param colonne La colonne de la case.
     * @return true si la case fait partie de la solution, false sinon.
     */
    public boolean estSolution(int ligne, int colonne) {
        assert (ligne   >= 0 && ligne   < this.getNbLignes())   : "La nombre de la ligne est incorrect";
        assert (colonne >= 0 && colonne < this.getNbColonnes()) : "La nombre de la colonne est incorrect";

        return this.cases[ligne][colonne].estSolution();
    }

    /**
     * Enlève un nombre de vies du jeu.
     *
     * @param nbVies Le nombre de vies à enlever.
     */
    private void enleverVie(int nbVies) {
        assert (nbVies > 0 && nbVies < this.getNbVies()) : "La nombre de la vie est incorrect";

        this.nbVies = Math.max(0, this.nbVies - nbVies); // on evite d'avoir des vies negatives

        // this.notifierObservateurs(); // Si on enleve ce commentaire ca vas causer des erreurs et afficher le dernier coup dans le nouveau game
    }

    /**
     * Choisi une case du plateau de jeu.
     *
     * @param ligne   La ligne de la case à choisir.
     * @param colonne La colonne de la case à choisir.
     */
    public void choisirCase(int ligne, int colonne) {
        assert (ligne   >= 0 && ligne   < this.getNbLignes())   : "La nombre de la ligne est incorrect";
        assert (colonne >= 0 && colonne < this.getNbColonnes()) : "La nombre de la colonne est incorrect";
        
        this.choisirCase(ligne, colonne, false);
    }

    /**
     * Choisi une case du plateau de jeu.
     *
     * @param ligne   La ligne de la case à choisir.
     * @param colonne La colonne de la case à choisir.
     * @param avecAide Indique si une aide est utilisée.
     */
    public void choisirCase(int ligne, int colonne, boolean avecAide) {
        assert (ligne   >= 0 && ligne   < this.getNbLignes())   : "La nombre de la ligne est incorrect";
        assert (colonne >= 0 && colonne < this.getNbColonnes()) : "La nombre de la colonne est incorrect";

        Case caseChoisie = this.cases[ligne][colonne];
        if(caseChoisie.estChoisie()) { return; } // Ne rien faire si la case est déjà choisie

        caseChoisie.choisir();

        if(avecAide) {
            this.enleverVie(2);
        } else if ((this.enModeOui() && !caseChoisie.estSolution()) || (this.enModeNon() && caseChoisie.estSolution())) {
            this.enleverVie(1);
        }

        Coup coup = new Coup(ligne, colonne, this.sommeLigne(ligne), this.sommeColonne(colonne));
        coup.setEstAvecAide(avecAide);
        coup.setEstSolution(caseChoisie.estSolution());

        this.coups.add(coup); // Ajouter le coup

        this.notifierObservateurs();
    }

    /**
     * Vérifie si le jeu est terminé.
     *
     * @return true si le jeu est terminé, false sinon.
     */
    public boolean jeuTermine() {
        return (this.nbVies == 0) || (this.getNbSolutions() == this.getNbSolutionsTrouves());
    }

    /**
     * Utilise une aide pour choisir une case du plateau de jeu.
     */
    public void aider() {
        Integer[] caseAleatoireNonChoisie = this.getCaseAleatoireNonChoisie();

        this.choisirCase(caseAleatoireNonChoisie[0], caseAleatoireNonChoisie[1], true);
    }

    /**
     * Ouvre un fichier et initialise le plateau de jeu.
     *
     * @param fichier Le fichier à ouvrir.
     * @throws ErreurFichier Si le fichier est incorrect.
     */
    public void ouvrir(File fichier) throws ErreurFichier {
        assert (fichier != null) : "Le fichier est incorrect";

        try {
            BufferedReader bufferReader = new BufferedReader(new FileReader(fichier));

            String line;
            int ligne = 0;
            this.cases = null;

            while ((line = bufferReader.readLine()) != null) {
                if (ligne == 0) {
                    String[] size  = line.trim().split("\\s+");

                    int nbLignes   = Integer.parseInt(size[0]);
                    int nbColonnes = Integer.parseInt(size[1]);

                    this.cases = new Case[nbLignes][nbColonnes];
                } else {
                    String[] casesStr = line.trim().split("\\s+");

                    for (int colonne = 0; colonne < casesStr.length; colonne++) {
                        Case c;

                        if (casesStr[colonne].charAt(0) == '*') {
                            // gerer les solutions
                            c = new Case(Integer.parseInt(casesStr[colonne].substring(1)));
                            c.setEstSolution();
                        } else {
                            c = new Case(Integer.parseInt(casesStr[colonne]));
                        }

                        this.cases[ligne-1][colonne] = c;
                    }
                }

                ligne++;

            }

            this.reinitialiserPlateau();
        } catch (IOException e) {
            throw new ErreurFichier(e.toString());
        }
    }

    /**
     * Retourne une case aléatoire non choisie du plateau de jeu.
     *
     * @return La case aléatoire non choisie.
     */
    private Integer[] getCaseAleatoireNonChoisie() {
        ArrayList<Integer[]> casesAleatoire = this.getCasesNonChoisies();
        Collections.shuffle(casesAleatoire);

        return casesAleatoire.getFirst();
    }

    /**
     * Retourne une liste de cases non choisies du plateau de jeu.
     *
     * @return La liste des cases non choisies.
     */
    private ArrayList<Integer[]> getCasesNonChoisies() {
        ArrayList<Integer[]> casesNonChoisies = new ArrayList<>();

        for (int ligne = 0; ligne < this.getNbLignes(); ligne++) {
            for (int colonne = 0; colonne < this.getNbColonnes(); colonne++) {
                if(!this.cases[ligne][colonne].estChoisie()) {
                    casesNonChoisies.add(new Integer[]{ ligne, colonne });
                }
            }
        }

        return casesNonChoisies;
    }

    /**
     * Retourne le nombre de solutions du plateau de jeu.
     *
     * @return Le nombre de solutions.
     */
    private int getNbSolutions() {
        int nbSolutions = 0;

        for (int ligne = 0; ligne < this.getNbLignes(); ligne++) {
            for (int colonne = 0; colonne < this.getNbColonnes(); colonne++) {
                nbSolutions += this.cases[ligne][colonne].estSolution() ? 1 : 0;
            }
        }

        return nbSolutions;
    }

    /**
     * Retourne le nombre de solutions trouvées du plateau de jeu.
     *
     * @return Le nombre de solutions trouvées.
     */
    private int getNbSolutionsTrouves() {
        int nbSolutions = 0;

        for(Coup coup : this.coups) {
            nbSolutions += coup.estSolution() ? 1 : 0;
        }

        return nbSolutions;
    }

    /**
     * Retourne un itérateur sur les coups du plateau de jeu.
     *
     * @return L'itérateur sur les coups.
     */
    @Override
    public Iterator<Coup> iterator() {
        return this.coups.iterator();
    }
}
