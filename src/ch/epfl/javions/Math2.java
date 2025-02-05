package ch.epfl.javions;

//Classe non instanciable permettant d'effectuer des calculs mathématiques, similaire à la classe Math de Java
public final class Math2 {
    private Math2(){
    }

    /**
     * Limite la valeur de v entre min et max, lève IllegalArgumentException si min est (strictement) supérieur à max
     * @param min (int) : Borne inférieure
     * @param v (int) : Valeur à encadrer
     * @param max (int) : Borne supérieure
     * @return la valeur encadrée dans l'intervalle [min, max]
     */
    static int clamp(int min, int v, int max){
        Preconditions.checkArgument(min <= max);
        return v < max ? (v > min ? v : min) : max;
        //return Math.clamp(v, min, max)
    }

    /**
     * Calcule le sinus hyperbolique réciproque de son argument x
     * @param x (double) : Valeur donnée pour calculer arsinh(x)
     * @return le résultat de arsinh(x)
     */
    static double asinh(double x){
        return Math.log(x + Math.sqrt(1 + x*x));
    }
}
