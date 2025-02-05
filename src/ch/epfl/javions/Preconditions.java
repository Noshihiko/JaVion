package ch.epfl.javions;

//CLasse non instantiable vérifiant si une méthode tierse ne renverra pas d'erreur
public final class Preconditions {
    private Preconditions() {
    }

    /**
     * Lève l'exception IllegalArgumentException si son argument est faux, ne fait rien sinon
     *
     * @param shouldBeTrue (boolean) : Argument testé
     */
    static void checkArgument(boolean shouldBeTrue) {
        if (!shouldBeTrue) {
            throw new IllegalArgumentException();
        }
    }
}