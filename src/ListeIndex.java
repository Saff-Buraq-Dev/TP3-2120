
/**
 *
 * @nom: Safouene Gharbi
 * @code_permanent: GHAS03089005
 *
 * Cette classe représente une structure qui va gérer l'accès à une suite de {@ListeMilieu}.
 * avec leur index. Cet accès grâce à l'index va nous permettre d'accèder aux valeurs d'une façon plus rapide.
 */
public class ListeIndex<E extends Comparable< E > > {

    /**
     * Classe privée qui représente un chainon de {@ListeMilieu}.
     * Un chainon, est l'unité de base d'une liste chainée. Constitué de la valeur même de l'objet,
     * et d'une référence vers l'objet suivant. La fin d'une liste est caractérisée par la valeur null.
     */
    private class Chainon<ListeMilieu>{
        public Chainon<ListeMilieu> suivant;
        public ListeMilieu liste;

        public Chainon () {}

    }

    // variables d'instance
    private Chainon<ListeMilieu> teteIndex;
    private int nbrListe;

    /**
     * Constructeur sans paramètre de ListeIndex. Construit une {@ListeIndex} vide.
     */
    public ListeIndex( ) {
        teteIndex = null;
        nbrListe = 0;
    }

    /**
     * Permet de savoir si la {@ListeIndex} contient une valeur donnée dans une des {@ListeMilieu}
     * qu'elle contient. Cette méthode utilise les méthodes d'instance {@rechercheBinaireInferieure} et
     * {@rechercheBinaireSuperieure} sur la {@ListeMilieu} susceptible de contenir la valeur cherchée.
     * @param valeur de type générique implémentant {@Comparable}.
     * @return {@boolean} true si la {@ListeIndex} contient la valuer, false sinon.
     */
    public boolean contient( E valeur ) {
        boolean contient= false;
        if ( null != teteIndex ) {
            Chainon<ListeMilieu> actuel = teteIndex;
            while (null != actuel.suivant && valeur.compareTo((E) actuel.liste.maxima()) > 0) {
                actuel = actuel.suivant;
            }
            if (valeur.compareTo((E) actuel.liste.milieu()) <= 0) {
                int position = actuel.liste.rechercheBinaireInferieure(valeur);
                contient = position != -1;
            } else {
                int position = actuel.liste.rechercheBinaireSuperieure(valeur);
                contient = position != -1;
            }
        }
        return contient;
    }

    /**
     * Permet d'accéder à une {@ListeMilieu} contenue dans la {@ListeIndex} à l'aide de son index.
     *
     * @param i l'index de la {@ListeMilieu} recherchée
     * @return {@ListeMilieu<E>} la {@ListeMilieu} à l'index voulu.
     * @throws IndexOutOfBoundsException si l'index est négatif ou supérieur à la taille de la {@ListeIndex}
     */
    public ListeMilieu<E> get( int i ) {
        if ( i < 0 || i >= nbrListe ) {
            throw new IndexOutOfBoundsException();
        }
        Chainon<ListeMilieu> actuel = teteIndex;
        for (int j = 0; j < i; j++) {
            actuel = actuel.suivant;
        }
        return actuel.liste;
    }
    /**
     * Permet d'insérer une valeur dans la {@ListeMilieu} adéquate, dans la structure de {@ListeIndex}.
     * Insérer les valeurs à travers {@ListeIndex} se fait en O(sqrt(n)).
     *
     * @param valeur de type générique implémentant {@Comparable}
     */
    public void inserer( E valeur ) {
        if ( null == teteIndex ) {
            // Premiere valeur.
            teteIndex = new Chainon<>();
            ListeMilieu<E> lm = new ListeMilieu();
            lm.inserer( valeur );
            teteIndex.liste = lm;
            nbrListe ++;
        } else {
            Chainon<ListeMilieu> actuel = teteIndex;
            // Parcourir la liste jusqu'à arriver à la liste adéquate.
            // Soit la valeur est plus petite que le maxima soit, c'est la dernière liste.
            while ( null != actuel.suivant && valeur.compareTo( (E) actuel.liste.maxima()) >= 0 ) {
                actuel = actuel.suivant;
            }
            actuel.liste.inserer( valeur );

            // Respecter l'invariant: Le nombre de valeurs dans chaque ListeMilieu est plus petit ou égal au double du nombre
            //de ListeMilieu dans l’index.
            if ( actuel.liste.taille() > 2 * nbrListe ) {
                Chainon<ListeMilieu> nouveau = new Chainon<>();
                nouveau.liste = actuel.liste.diviser();
                nouveau.suivant = actuel.suivant;
                actuel.suivant = nouveau;
                nbrListe ++;
            }
        }
    }

    /**
     * Permet de connaitre le nombre de {@ListeMilieu} contenues dans la structure de {@ListeIndex}.
     *
     * @return {@int} le nombre de {@ListeMilieu} contenues dans une structure de {@ListeIndex}
     */
    public int nbrListe() {
        return nbrListe;
    }

    /**
     * Permet de supprimer une valeur dans la {@ListeMilieu} adéquate, dans la structure de {@ListeIndex}.
     * Une fois la {@ListeMilieu} susceptible de contenir la valeur à supprimer repérée, c'est la {@ListeMilieu}
     * qui s'occupe de supprimer la valeur.
     *
     * @param valeur de type générique implémentant {@Comparable}
     */
    public void supprimer( E valeur ) {
        Chainon<ListeMilieu> actuel = teteIndex;
        while ( null != actuel.suivant && valeur.compareTo( (E) actuel.liste.maxima()) > 0 ) {
            actuel = actuel.suivant;
        }
        actuel.liste.supprimer(valeur);
    }

    /**
     * Permet de connaitre le nombre de valeurs contenues dans la {@ListeIndex}. Il s'agit de la somme du nombre
     * de valeurs dans chaque {@ListeMilieu} contenue dans la structure de {@ListeIndex}
     *
     * @return {@int} la taille de la structure {@ListeIndex}: Le nombre de {@ListeMilieu} contenues dans la structure.
     */
    public int taille() {
        int i;
        int somme = 0;
        for (i = 0; i < nbrListe; i++) {
            somme += get( i ).taille();
        }
        return somme;
    }

}