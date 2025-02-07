package ch.epfl.javions;

//Classe finale non publique permettant de projeter des coordonnées géographiques selon la projection WebMercator
public final class WebMercator {
    private WebMercator(){
    }

    /**
     * Calcule la coordonnée x correspondant à la longitude donnée (en radians) au niveau de zoom donné
     * @param zoomLevel (int) : Le niveau de zoom
     * @param longitude (double) : La longitude en Radians
     * @return la coordonnée x correspondant à la longitude donnée (en radians) au niveau de zoom donné
     */
    static double x(int zoomLevel, double longitude){
        return Math.scalb(1, 8 + zoomLevel)*(Units.convertTo(longitude, Units.Angle.T32) + 0.5);
    }

    /**
     * Calcule la coordonnée y correspondant à la latitude donnée (en radians) au niveau de zoom donné
     * @param zoomLevel (int) : Le niveau de zoom
     * @param latitude (double) : La latitude en Radians
     * @return la coordonnée y correspondant à la latitude donnée (en radians) au niveau de zoom donné
     */
    static double y(int zoomLevel, double latitude){
        return Math.scalb(1, 8 + zoomLevel)*(-1*Units.convertTo(Math2.asinh(Math.tan(latitude)), Units.Angle.T32) + 0.5);

    }
}
