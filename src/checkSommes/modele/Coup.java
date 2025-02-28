package checkSommes.modele;


public class Coup {

    private int     ligne;
    private int     colonne;
    private int     sommeLigne;
    private int     sommeColonne;
    private boolean aide;
    private boolean estSolution;

    /**
     * Constructeur de la classe Coup.
     *
     * @param ligne Le numero de la ligne.
     * @param colonne Le numero de la colonne.
     * @param sommeLigne La somme de la ligne.
     * @param sommeColonne La somme de la colonne.
     */
    public Coup(int ligne, int colonne, int sommeLigne, int sommeColonne) {
        this.ligne        = ligne;
        this.colonne      = colonne;
        this.sommeLigne   = sommeLigne;
        this.sommeColonne = sommeColonne;
        this.aide         = false;
        this.estSolution  = false;
    }

    /**
     * Retourne la valeur de la ligne.
     *
     * @return La valeur de la ligne.
     */
    public int getLigne() {
        return this.ligne;
    }

    /**
     * Retourne la valeur de la colonne.
     *
     * @return La valeur de la colonne.
     */
    public int getColonne() {
        return this.colonne;
    }

    /**
     * Retourne la valeur de la somme de la ligne.
     *
     * @return La valeur de la somme de la ligne.
     */
    public int getSommeLigne() {
        return this.sommeLigne;
    }

    /**
     * Retourne la valeur de la somme de la colonne.
     *
     * @return La valeur de la somme de la colonne.
     */
    public int getSommeColonne() {
        return this.sommeColonne;
    }

    /**
     * Retourne la valeur de l'aide.
     *
     * @return La valeur de l'aide.
     */
    public boolean estAvecAide() {
        return this.aide;
    }

    /**
     * Retourne si le coup fait partie des solutions.
     *
     * @return True si le coup fait partie des solutions, false sinon.
     */
    public boolean estSolution() {
        return this.estSolution;
    }

    /**
     * Définit si le coup fait partie des solutions.
     *
     * @param estSolution True si le coup fait partie des solutions, false sinon.
     */
    public void setEstSolution(boolean estSolution) {
        this.estSolution = estSolution;
    }

    public void setEstAvecAide(boolean aide) {
        this.aide = aide;
    }

    @Override
    public String toString() {
        return String.format("<L%d, C%d> / <%d %d>", this.getLigne()+1, this.getColonne()+1, this.getSommeLigne(), this.getSommeColonne());
    }
}
