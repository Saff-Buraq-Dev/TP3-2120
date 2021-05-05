/**
 *
 * @nom: Safouene Gharbi
 * @code_permanent: GHAS03089005
 *
 * Cette classe représente un type de données abstrait. Une {@ListeMilieu} est constituée de deux listes chainées.
 * Une inférieure triée dans un ordre décroissant. Une supérieure, dont la plus petite valeur doit être plus grande
 * que la plus grande valeur de la liste inférieure et qui est triée dans l'ordre croissant. La taille de la liste
 * inférieure doit être égal ou au plus supérieur de 1 par rapport à la liste supérieure. Ces conditions doivent
 * demeurer vraie à tout moment.
 *
 */
public class ListeMilieu< E extends Comparable< E > > {

    /**
     * Classe privée qui représente un chainon de valeur de type générique.
     * Un chainon, est l'unité de base d'une liste chainée. Constitué de la valeur même de l'objet,
     * et d'une référence vers l'objet suivant. La fin d'une liste est caractérisée par la valeur null.
     */
    private class Chainon<E>{
        public Chainon<E> suivant;
        public E valeur;

        public Chainon () {}

        public Chainon ( E valeur ) {
            this.valeur = valeur;
            this.suivant = null;
        }

        public Chainon ( E valeur, Chainon<E> suivant ) {
            this.valeur = valeur;
            this.suivant = suivant;
        }
    }

    // variables d'instance. On garde le minima et le maxima pour la performance.
    public int tailleInf;
    public int tailleSup;
    private E minima;
    private E maxima;
    private Chainon<E> teteInf;
    private Chainon<E> teteSup;

    /**
     * Constructeur sans paramètre de ListeIndex. Construit une {@ListeMilieu} vide.
     */
    public ListeMilieu() {
        teteInf = null;
        teteSup = null;
        tailleInf = 0;
        tailleSup = 0;
    }

    /**
     * Permet de diviser la {@ListeMilieu} en deux et retourner la liste supérieure sous forme de {@ListeMilieu}.
     * La {@ListeMilieu} sur laquelle on appelle cette méthode, garde seulement les éléments de la liste inférieure
     * redistribué sous la forme d'une {@ListeMilieu} en respectant les invariants.
     * 
     * @return {@ListeMilieu<E>} contenant les valeurs de la liste supérieure de la {@ListeMilieu} initiale. Tous les 
     * invariants restent respectés dans la liste initiale et dans la liste retournée.
     */
    public ListeMilieu<E> diviser() {
        ListeMilieu<E> lm = new ListeMilieu<>();
        Chainon<E> actuel = teteSup;
        while ( null != actuel.suivant ) {
            lm.inserer(actuel.valeur);
            supprimer(actuel.valeur);
            actuel = actuel.suivant;
        }
        lm.inserer(actuel.valeur);
        supprimer(actuel.valeur);
        return lm;
    }

    /**
     * Permet d'insérer une valeur dans une {@ListeMilieu}. L'insertion se fait directement à la bonne place.
     * Ce qui permet aux listes supérieure et inférieure de la {@ListeMilieu} de rester triées en tout temps.
     * Après avoir inséré une nouvelle valeur on s'assure de garder la taille de la liste inférieure au maximum,
     * plus grande d'une valeur que la liste supérieure.
     *
     * @param valeur de type générique implémentant {@Comparable}
     */
    public void inserer( E valeur ) {
        Chainon<E> nouveau = new Chainon( valeur );
        if ( null == teteInf ) {
            // Première valeur
            teteInf = nouveau;
            minima = teteInf.valeur;
            tailleInf ++;
        } else if ( valeur.compareTo( teteInf.valeur ) <= 0 ) {
            // La valeur doit être insérée dans la liste inférieure
            insererValeurInferieure( nouveau );
            ajusterInferieure();
        } else if ( null == teteSup ) {
            // Première valeur dans la liste supérieure
            teteSup = nouveau;
            maxima = valeur;
            tailleSup ++;

        } else if ( valeur.compareTo( teteSup.valeur ) < 0 && valeur.compareTo( teteInf.valeur ) > 0 ) {
            // Si la valeur est entre la valeur de teteInf et teteSup, on l'insère dans teteInf
            nouveau.suivant = teteInf;
            teteInf = nouveau;
            tailleInf ++;
            ajusterInferieure();
            
        } else if ( valeur.compareTo( teteSup.valeur ) > 0 ) {
            // La valeur doit être insérée dans la liste supérieure
            insererValeurSuperieure( nouveau );
            ajusterSuperieure();
        }
    }

    /**
     * Permet d'insérer une valeur dans la liste supérieure d'une {@ListeMilieu}.
     * L'insertion se fait directement à la bonne place ce qui permet à la liste supérieure de rester triée en tout temps.
     *
     * @param nouveau le chainon qui contient la valeur à ajouter
     */
    private void insererValeurSuperieure( Chainon<E> nouveau ) {
        Chainon<E> actuel = teteSup;
        while ( null != actuel.suivant && nouveau.valeur.compareTo( actuel.suivant.valeur ) > 0 ) {
            actuel = actuel.suivant;
        }
        if ( null == actuel.suivant && nouveau.valeur.compareTo( actuel.valeur ) != 0 ) {
            actuel.suivant = nouveau;
            maxima = nouveau.valeur;
            tailleSup ++;
        } else if ( null != actuel.suivant && nouveau.valeur.compareTo( actuel.valeur ) != 0 ){
            nouveau.suivant = actuel.suivant;
            actuel.suivant = nouveau;
            tailleSup ++;
        }
    }

    /**
     * Permet d'insérer une valeur dans la liste inférieure d'une {@ListeMilieu}.
     * L'insertion se fait directement à la bonne place ce qui permet à la liste inférieure de rester triée en tout temps.
     *
     * @param nouveau le chainon qui contient la valeur à ajouter
     */
    private void insererValeurInferieure( Chainon<E> nouveau ) {
        Chainon<E> actuel = teteInf;
        while ( null != actuel.suivant && nouveau.valeur.compareTo( actuel.suivant.valeur) < 0 ) {
            actuel = actuel.suivant;
        }
        if ( null == actuel.suivant && nouveau.valeur.compareTo( actuel.valeur ) != 0 ) {
            actuel.suivant = nouveau;
            minima = nouveau.valeur;
            tailleInf ++;
        } else if ( null != actuel.suivant && nouveau.valeur.compareTo( actuel.valeur ) != 0 ){
            nouveau.suivant = actuel.suivant;
            actuel.suivant = nouveau;
            tailleInf ++;
        }
    }

    /**
     * Permet d'accéder au premier élément de la liste inférieure d'une {@ListeMilieu} et obtenir sa valeur.
     *
     */
    public E milieu() {
        E milieu = null;
        if( teteInf != null ){
            milieu = teteInf.valeur;
        }
        return milieu;
    }

    /**
     * Permet d'accéder au dernier élément de la liste inférieure d'une {@ListeMilieu} et obtenir sa valeur.
     * Il s'agit de l'élément le plus petit de toute la liste.
     */
    public E minima() {
        return minima;
    }

    /**
     * Permet d'accéder au dernier élément de la liste supérieure d'une {@ListeMilieu} et obtenir sa valeur.
     * Il s'agit de l'élément le plus grand de toute la liste. Si cet élément est nul, la méthode retourne le {@minima}.
     */
    public E maxima() {
        E maxima = ( null != this.maxima ) ? this.maxima : this.minima;
        return  maxima;
    }

    /**
     * Permet de supprimer une valeur d'une {@ListeMilieu} si cette valeur existe.
     * Les invariants demeurent vérifiés en tout temps, en ajustant les listes supérieure et inférieure après
     * chaque suppression
     *
     * @param valeur de type générique implémentant {@Comparable}
     */
    public void supprimer( E valeur ) {
        if ( valeur.compareTo( teteInf.valeur ) <= 0 ) {
            supprimerDansInferieure( valeur );
            ajusterSuperieure();
        } else if ( valeur.compareTo( teteSup.valeur ) >= 0 ) {
            supprimerDansSuperieure(valeur);
            ajusterInferieure();
        }
    }

    /**
     * Permet de retrouver une valeur et la supprimer dans la liste supérieure d'une {@ListeMilieu}.
     *
     * @param valeur de type générique implémentant {@Comparable}
     */
    private void supprimerDansSuperieure(E valeur) {
        // On utilise deux pointeurs qui se suivent pour repérer l'élément à supprimer et le précédent.
        Chainon<E> actuel = teteSup;
        Chainon<E> deuxiemePointeur = ( null != teteSup.suivant ) ? teteSup.suivant : teteSup;
        while ( null != deuxiemePointeur.suivant && valeur.compareTo( deuxiemePointeur.valeur ) != 0 ) {
            actuel = actuel.suivant;
            deuxiemePointeur = deuxiemePointeur.suivant;
        }
        if ( valeur.compareTo( teteSup.valeur ) == 0 ) {
            // Si la valeur correspond au premier élément de la liste supérieure.
            teteSup = teteSup.suivant;
            tailleSup --;
            maxima = ( tailleSup == 0 ) ? null : maxima;
        } else if ( null == deuxiemePointeur.suivant && valeur.compareTo( deuxiemePointeur.valeur ) ==0 ) {
            // Si la valeur correspond au dernier élément de la liste supérieure.
            actuel.suivant = null;
            maxima = actuel.valeur;
            tailleSup --;
        } else if ( null != deuxiemePointeur.suivant && valeur.compareTo( deuxiemePointeur.valeur ) == 0 ) {
            // Si la valeur correspond à un élément au milieu de la liste supérieure.
            actuel.suivant = deuxiemePointeur.suivant;
            tailleSup --;
        }
    }

    /**
     * Permet de retrouver une valeur et la supprimer dans la liste inférieure d'une {@ListeMilieu}.
     *
     * @param valeur de type générique implémentant {@Comparable}
     */
    private void supprimerDansInferieure( E valeur ) {
        // On utilise deux pointeurs qui se suivent pour repérer l'élément à supprimer et le précédent.
        Chainon<E> actuel = teteInf;
        Chainon<E> deuxiemePointeur = ( null != teteInf.suivant ) ? teteInf.suivant : teteInf;
        while ( null != deuxiemePointeur.suivant && valeur.compareTo( deuxiemePointeur.valeur ) != 0 ) {
            actuel = actuel.suivant;
            deuxiemePointeur = deuxiemePointeur.suivant;
        }
        if ( valeur.compareTo( teteInf.valeur ) == 0 ) {
            // Si la valeur correspond au premier élément de la liste inférieure.
            teteInf = teteInf.suivant;
            tailleInf --;
            minima = ( tailleInf == 0 ) ? null : minima;
        } else if ( null == deuxiemePointeur.suivant && valeur.compareTo( deuxiemePointeur.valeur ) ==0 ) {
            // Si la valeur correspond au dernier élément de la liste inférieure.
            actuel.suivant = null;
            minima = actuel.valeur;
            tailleInf --;
        } else if ( null != deuxiemePointeur.suivant && valeur.compareTo( deuxiemePointeur.valeur ) == 0 ) {
            // Si la valeur correspond à un élément au milieu de la liste inférieure.
            actuel.suivant = deuxiemePointeur.suivant;
            tailleInf --;
        }
    }

    /**
     * Retourne la taille d'une {@ListeMilieu}.
     */
    public int taille() {
        return tailleInf + tailleSup;
    }

    /**
     * Permet de chercher un élément dans la liste inférieure d'une {@ListeMilieu}. Cette méthode utilise l'algorithme
     * de recherche binaire pour avoir un temps de recherche en 𝑂(log 𝑛).
     *
     * @param cible de type générique implémentant {@Comparable}
     * @return {@int} la position de l'élément, -1 si introuvable.
     */
    public int rechercheBinaireInferieure( E cible ) {
        int debut = 0;
        int fin = tailleInf - 1;
        while( debut < fin ) {
            int milieu = ( debut + fin ) / 2;
            if( cible.compareTo( getElementInferieure( milieu ).valeur ) >= 0 ) {
                fin = milieu;
            } else {
                debut = milieu + 1;
            }
        }
        if( getElementInferieure( debut ).valeur.compareTo( cible ) != 0 ) {
            debut = -1;
        }
        return debut;
    }

    /**
     * Permet de chercher un élément dans la liste supérieure d'une {@ListeMilieu}. Cette méthode utilise l'algorithme
     * de recherche binaire pour avoir un temps de recherche en 𝑂(log 𝑛).
     *
     * @param cible de type générique implémentant {@Comparable}
     * @return {@int} la position de l'élément, -1 si introuvable.
     */
    public int rechercheBinaireSuperieure( E cible ) {
        int debut = 0;
        int fin = tailleSup - 1;
        while( debut < fin ) {
            int milieu = ( debut + fin ) / 2;
            if( null != teteSup && cible.compareTo( getElementSuperieure( milieu ).valeur ) >= 0 ) {
                fin = milieu;
            } else {
                debut = milieu + 1;
            }
        }
        if( null == teteSup || getElementSuperieure( debut ).valeur.compareTo( cible ) != 0 ) {
            debut = -1;
        }
        return debut;
    }

    /**
     * Permet de rééquilibrer les listes inférieure et supérieure pour que la condition: La taille de la liste
     * inférieure doit être égal ou au plus supérieur de 1 par rapport à la liste supérieure soit vraie en tout temps.
     */
    private void ajusterSuperieure() {
        if( tailleSup > tailleInf ){
            Chainon<E> temp = ( null != teteSup.suivant ) ? teteSup.suivant : null;
            teteSup.suivant = teteInf;
            teteInf = teteSup;
            teteSup = temp;
            tailleSup --;
            tailleInf ++;
        }
        minima = ( tailleInf == 1 ) ? teteInf.valeur : minima;
    }

    /**
     * Permet de rééquilibrer les listes inférieure et supérieure pour que la condition: La taille de la liste
     * inférieure doit être égal ou au plus supérieur de 1 par rapport à la liste supérieure soit vraie en tout temps.
     */
    private void ajusterInferieure() {
        if ( tailleInf - tailleSup > 1 ) {
            Chainon<E> temp = new Chainon<>( teteInf.suivant.valeur, teteInf.suivant.suivant );
            teteInf.suivant = teteSup;
            teteSup = teteInf;
            teteInf = temp;
            tailleInf--;
            tailleSup++;
            maxima = ( tailleSup == 1 ) ? teteSup.valeur : maxima;
        }
    }

    /**
     * Permet de parcourir la liste inférieure d'une {@ListeMilieu} et d'obtenir un élément de la liste grâce à son indice.
     *
     * @param index position de l'élément recherché dans la liste.
     * @return {@Chainon<E>} le chainon à la position recherchée.
     * @throws IndexOutOfBoundsException si l'index est négatif ou supérieur à la taille de la liste.
     */
    private Chainon<E> getElementInferieure( int index ) {
        if ( index >= tailleInf || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Chainon<E> actuel = teteInf;
        if ( index != 0 ) {
            for (int i = 0; i < index; i++) {
                actuel = actuel.suivant;
            }
        }
        return actuel;
    }

    /**
     * Permet de parcourir la liste supérieure d'une {@ListeMilieu} et d'obtenir un élément de la liste grâce à son indice.
     *
     * @param index position de l'élément recherché dans la liste.
     * @return {@Chainon<E>} le chainon à la position recherchée.
     * @throws IndexOutOfBoundsException si l'index est négatif ou supérieur à la taille de la liste.
     */
    private Chainon<E> getElementSuperieure( int index ) {
        if ( index >= tailleSup || index < 0 ){
            throw new IndexOutOfBoundsException();
        }
        Chainon<E> actuel = teteSup;
        if ( index != 0 ) {
            for ( int i = 0; i < index; i++ ) {
                actuel = actuel.suivant;
            }
        }
        return actuel;
    }

}