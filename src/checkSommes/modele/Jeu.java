package checkSommes.modele;

import checkSommes.fabrique.FabriquePlateau;
import checkSommes.ig.Observateur;
import checkSommes.utils.Couleur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


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

    private void enleverVie(int nbVies) {
        assert (nbVies > 0 && nbVies < this.getNbVies()) : "La nombre de la vie est incorrect";

        this.nbVies -= nbVies;

        this.notifierObservateurs();
    }

    public void choisirCase(int ligne, int colonne) {
        this.choisirCase(ligne, colonne, false);
    }

    public void choisirCase(int ligne, int colonne, boolean aide) {
        assert (ligne   >= 0 && ligne   < this.getNbLignes())   : "La nombre de la ligne est incorrect";
        assert (colonne >= 0 && colonne < this.getNbColonnes()) : "La nombre de la colonne est incorrect";

        Case c = this.cases[ligne][colonne];
        if(c.estChoisie() || this.jeuTermine()) { return; } // Si la case est deja choisie, ou le jeu est terminé, alors ne rien faire

        c.choisir();

        int couleur = c.estSolution() ? Couleur.CORAIL.getNumero() : Couleur.GRIS.getNumero();
        c.setCouleur(couleur);

        if(aide) {
            this.enleverVie(2);
        }

        if (!aide && ((this.enModeOui() && !c.estSolution()) || (this.enModeNon() && c.estSolution()))) {
            this.enleverVie(1);
        }

        Coup coup = new Coup(ligne, colonne, this.sommeLigne(ligne), this.sommeColonne(colonne), aide);
        coup.setEstSolution(c.estSolution());


        this.coups.add(coup);

        this.notifierObservateurs();
    }

    public boolean jeuTermine() {
        return (this.nbVies <= 0) || (this.getNbSolutions() == this.getNbSolutionsTrouves());
    }

    public void aider() {
        Integer[] caseAleatoireNonChoisie = this.getCaseAleatoireNonChoisie();

        this.choisirCase(caseAleatoireNonChoisie[0], caseAleatoireNonChoisie[1], true);
    }


    private Integer[] getCaseAleatoireNonChoisie() {
        ArrayList<Integer[]> casesAleatoire = this.getCasesNonChoisies();
        Collections.shuffle(casesAleatoire);

        return casesAleatoire.getFirst();
    }

    private ArrayList<Integer[]> getCasesNonChoisies() {
        ArrayList<Integer[]> casesNonChoisies = new ArrayList<>();

        for (int ligne = 0; ligne < this.getNbLignes(); ligne++) {
            for (int colonne = 0; colonne < this.getNbColonnes(); colonne++) {
                if(!this.cases[ligne][colonne].estChoisie()) {
                    // casesNonChoisies.add(this.cases[ligne][colonne]);
                    casesNonChoisies.add(new Integer[]{ ligne, colonne });
                }
            }
        }

        return casesNonChoisies;
    }

    private int getNbSolutions() {
        int nbSolutions = 0;

        for (int ligne = 0; ligne < this.getNbLignes(); ligne++) {
            for (int colonne = 0; colonne < this.getNbColonnes(); colonne++) {
                nbSolutions += this.cases[ligne][colonne].estSolution() ? 1 : 0;
            }
        }

        return nbSolutions;
    }

    private int getNbSolutionsTrouves() {
        int nbSolutions = 0;

        for(Coup coup : this.coups) {
            nbSolutions += coup.estSolution() ? 1 : 0;
        }

        return nbSolutions;
    }

    @Override
    public Iterator<Coup> iterator() {
        return this.coups.iterator();
    }
}
