package checkSommes.modele;

import checkSommes.utils.Couleur;


public class Case {

    private int valeur;
    private int couleur;
    private boolean estSolution;
    private boolean choisie;

    /**
     * Constructeur de la classe Case.
     *
     * @param valeur La valeur numérique de la case.
     */
    public Case(int valeur) {
        this.valeur      = valeur;
        this.couleur     = Couleur.VERT.getNumero();
        this.estSolution = false;
        this.choisie     = false;
    }

    /**
     * Retourne la valeur de la case.
     *
     * @return La valeur de la case.
     */
    public int getValeur() {
        return this.valeur;
    }

    /**
     * Retourne la couleur de la case.
     *
     * @return La couleur de la case.
     */
    public int getCouleur() {
        return this.couleur;
    }

    /**
     * Vérifie si la case est choisie.
     *
     * @return true si la case est choisie, false sinon.
     */
    public boolean estChoisie() {
        return this.choisie;
    }

    /**
     * Vérifie si la case est une solution.
     *
     * @return true si la case est une solution, false sinon.
     */
    public boolean estSolution() {
        return this.estSolution;
    }

    /**
     * Définit la case comme faisant partie de la solution.
     */
    public void setEstSolution() {
        this.estSolution = true;
    }

    /**
     * Choisit la case.
     */
    public void choisir() {
        this.choisie = true;
        this.setCouleur(this.estSolution() ? Couleur.CORAIL.getNumero() : Couleur.GRIS.getNumero());
    }

    /**
     * Choisit la couleur de la case.
     */
    public void setCouleur(int couleur) {
        assert (couleur >= 0 && couleur <= 2) : "La couleur de la case est invalide";

        this.couleur = couleur;
    }

    /**
     * Initialise la case.
     */
    public void initialiser() {
        this.choisie = false;
        this.couleur = Couleur.VERT.getNumero();
    }

}
