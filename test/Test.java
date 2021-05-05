import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    //------------------------------------------------
    // méthode pour assister les tests.

    private < E extends Comparable< E > > ListeMilieu< E >
    construire( E ... valeurs ) {
        ListeMilieu< E > resultat = new ListeMilieu<>();

        for( E v : valeurs ) {
            resultat.inserer( v );
        }

        return resultat;
    }

    //------------------------------------------------
    // Test pour la construction

    @org.junit.jupiter.api.Test
    void construire_taille_0() {
        ListeMilieu< Integer > a = construire();

        assertEquals( 0, a.taille() );
    }

    //------------------------------------------------
    // Tests pour l'insertion

    // une valeur
    @org.junit.jupiter.api.Test
    void inserer_uneValeur_taille() {
        ListeMilieu< Integer > a = construire( 4 );

        assertEquals( 1, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_uneValeur_milieu() {
        ListeMilieu< Integer > a = construire( 4 );

        assertEquals( 4, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_uneValeur_minima() {
        ListeMilieu< Integer > a = construire( 4 );

        assertEquals( 4, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_uneValeur_maxima() {
        ListeMilieu< Integer > a = construire( 4 );

        assertEquals( 4, a.maxima() );
    }

    // deux valeurs
    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_ordre_taille() {
        ListeMilieu< Integer > a = construire( 4, 8 );

        assertEquals( 2, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_ordre_milieu() {
        ListeMilieu< Integer > a = construire( 4, 8 );

        assertEquals( 4, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_ordre_minima() {
        ListeMilieu< Integer > a = construire( 4, 8 );

        assertEquals( 4, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_ordre_maxima() {
        ListeMilieu< Integer > a = construire( 4, 8 );

        assertEquals( 8, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_desordre_taille() {
        ListeMilieu< Integer > a = construire( 8, 4 );

        assertEquals( 2, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_desordre_milieu() {
        ListeMilieu< Integer > a = construire( 8, 4 );

        assertEquals( 4, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_desordre_minima() {
        ListeMilieu< Integer > a = construire( 8, 4 );

        assertEquals( 4, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_desordre_maxima() {
        ListeMilieu< Integer > a = construire( 8, 4 );

        assertEquals( 8, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_double_taille() {
        ListeMilieu< Integer > a = construire( 4, 4 );

        assertEquals( 1, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_double_milieu() {
        ListeMilieu< Integer > a = construire( 8, 8 );

        assertEquals( 8, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_double_minima() {
        ListeMilieu< Integer > a = construire( 8, 8 );

        assertEquals( 8, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_deuxValeurs_double_maxima() {
        ListeMilieu< Integer > a = construire( 4, 4 );

        assertEquals( 4, a.maxima() );
    }

    // trois valeurs
    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_ordre_taille() {
        ListeMilieu< Integer > a = construire( -4, 0, 12 );

        assertEquals( 3, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_ordre_milieu() {
        ListeMilieu< Integer > a = construire( -4, 0, 12 );

        assertEquals( 0, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_ordre_minima() {
        ListeMilieu< Integer > a = construire( -4, 0, 12 );

        assertEquals( -4, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_ordre_maxima() {
        ListeMilieu< Integer > a = construire( -4, 0, 12 );

        assertEquals( 12, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iii_taille() {
        ListeMilieu< Integer > a = construire( 12, 5, 2 );

        assertEquals( 3, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iii_milieu() {
        ListeMilieu< Integer > a = construire( 12, 5, 2 );

        assertEquals( 5, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iii_minima() {
        ListeMilieu< Integer > a = construire( 12, 5, 2 );

        assertEquals( 2, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iii_maxima() {
        ListeMilieu< Integer > a = construire( 12, 5, 2 );

        assertEquals( 12, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iis_taille() {
        ListeMilieu< Integer > a = construire( 0, -9, 12 );

        assertEquals( 3, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iis_milieu() {
        ListeMilieu< Integer > a = construire( 0, -9, 12 );

        assertEquals( 0, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iis_minima() {
        ListeMilieu< Integer > a = construire( 0, -9, 12 );

        assertEquals( -9, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iis_maxima() {
        ListeMilieu< Integer > a = construire( 0, -9, 12 );

        assertEquals( 12, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iss_taille() {
        ListeMilieu< Integer > a = construire( 0, 9, 12 );

        assertEquals( 3, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iss_milieu() {
        ListeMilieu< Integer > a = construire( 0, 9, 12 );

        assertEquals( 9, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iss_minima() {
        ListeMilieu< Integer > a = construire( 0, 9, 12 );

        assertEquals( 0, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_troisValeurs_iss_maxima() {
        ListeMilieu< Integer > a = construire( 0, 9, 12 );

        assertEquals( 12, a.maxima() );
    }

    // dix valeurs
    @org.junit.jupiter.api.Test
    void inserer_dixValeurs_taille() {
        ListeMilieu< Integer > a = construire( 1, 4, 7, 2, 5, 8, 3, 6, 9, 0 );

        assertEquals( 10, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_dixValeurs_milieu() {
        ListeMilieu< Integer > a = construire( 1, 4, 7, 2, 5, 8, 3, 6, 9, 0 );

        assertEquals( 4, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_dixValeurs_minima() {
        ListeMilieu< Integer > a = construire( 1, 4, 7, 2, 5, 8, 3, 6, 9, 0 );

        assertEquals( 0, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_dixValeurs_maxima() {
        ListeMilieu< Integer > a = construire( 1, 4, 7, 2, 5, 8, 3, 6, 9, 0 );

        assertEquals( 9, a.maxima() );
    }

    // onze valeurs
    @org.junit.jupiter.api.Test
    void inserer_onzeValeurs_taille() {
        ListeMilieu< Integer > a = construire( -1, -4, -7, -2, -5, -8, -3, -6, -9, -10, -11 );

        assertEquals( 11, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void inserer_onzeValeurs_milieu() {
        ListeMilieu< Integer > a = construire( -1, -4, -7, -2, -5, -8, -3, -6, -9, -10, -11 );

        assertEquals( -6, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void inserer_onzeValeurs_minima() {
        ListeMilieu< Integer > a = construire( -1, -4, -7, -2, -5, -8, -3, -6, -9, -10, -11 );

        assertEquals( -11, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void inserer_onzeValeurs_maxima() {
        ListeMilieu< Integer > a = construire( -1, -4, -7, -2, -5, -8, -3, -6, -9, -10, -11 );

        assertEquals( -1, a.maxima() );
    }

    //------------------------------------------------
    // Tests pour la suppression

    // 2 valeurs

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_deuxValeurs_taille() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( 8 );

        assertEquals( 1, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_deuxValeurs_milieu() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( 8 );

        assertEquals( -1, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_deuxValeurs_minima() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( 8 );

        assertEquals( -1, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_deuxValeurs_maxima() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( 8 );

        assertEquals( -1, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_deuxValeurs_taille() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( -1 );

        assertEquals( 1, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_deuxValeurs_milieu() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( -1 );

        assertEquals( 8, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_deuxValeurs_minima() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( -1 );

        assertEquals( 8, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_deuxValeurs_maxima() {
        ListeMilieu< Integer > a = construire( -1, 8 );

        a.supprimer( -1 );

        assertEquals( 8, a.maxima() );
    }

    // trois valeurs

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_troisValeurs_taille() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( -1 );

        assertEquals( 2, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_troisValeurs_milieu() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( -1 );

        assertEquals( 8, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_troisValeurs_minima() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( -1 );

        assertEquals( 8, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_minima_de_troisValeurs_maxima() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( -1 );

        assertEquals( 12, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_troisValeurs_taille() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 12 );

        assertEquals( 2, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_troisValeurs_milieu() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 12 );

        assertEquals( -1, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_troisValeurs_minima() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 12 );

        assertEquals( -1, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_maxima_de_troisValeurs_maxima() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 12 );

        assertEquals( 8, a.maxima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_milieu_de_troisValeurs_taille() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 8 );

        assertEquals( 2, a.taille() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_milieu_de_troisValeurs_milieu() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 8 );

        assertEquals( -1, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_milieu_de_troisValeurs_minima() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 8 );

        assertEquals( -1, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_milieu_de_troisValeurs_maxima() {
        ListeMilieu< Integer > a = construire( 12, -1, 8 );

        a.supprimer( 8 );

        assertEquals( 12, a.maxima() );
    }

    // 10 valeurs

    @org.junit.jupiter.api.Test
    void supprimer_inferieur_de_dixValeurs_milieu() {
        ListeMilieu< Integer > a = construire( 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 );

        a.supprimer( 5 );

        assertEquals( 11, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_inferieur_de_dixValeurs_minima() {
        ListeMilieu< Integer > a = construire( 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 );

        a.supprimer( 5 );

        assertEquals( 1, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_inferieur_de_dixValeurs_maxima() {
        ListeMilieu< Integer > a = construire( 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 );

        a.supprimer( 5 );

        assertEquals( 19, a.maxima() );
    }

    // 11 valeurs

    @org.junit.jupiter.api.Test
    void supprimer_superieur_de_onzeValeurs_milieu() {
        ListeMilieu< Integer > a = construire( 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 );

        a.supprimer( 17 );

        assertEquals( 9, a.milieu() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_superieur_de_onzeValeurs_minima() {
        ListeMilieu< Integer > a = construire( 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 );

        a.supprimer( 17 );

        assertEquals( 1, a.minima() );
    }

    @org.junit.jupiter.api.Test
    void supprimer_superieur_de_onzeValeurs_maxima() {
        ListeMilieu< Integer > a = construire( 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 );

        a.supprimer( 17 );

        assertEquals( 21, a.maxima() );
    }
}
