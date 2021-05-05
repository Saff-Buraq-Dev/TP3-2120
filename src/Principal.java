public class Principal {
    public static void main(String[] args) {
        ListeIndex a = construireIndex( -10, 0, 10, 20, 30, 40, 50 );
        ListeMilieu b = construireMilieu(1, 10, 15, 6, 4, -4);
        a.supprimer(30);

    }

    private static < E extends Comparable< E > > ListeIndex< E > construireIndex(E ... valeurs ) {
        ListeIndex< E > resultat = new ListeIndex<>();

        for( E v : valeurs ) {
            resultat.inserer( v );
        }

        return resultat;
    }

    private static < E extends Comparable< E > > ListeMilieu< E > construireMilieu( E ... valeurs ) {
        ListeMilieu< E > resultat = new ListeMilieu<>();

        for( E v : valeurs ) {
            resultat.inserer( v );
        }

        return resultat;
    }
}
