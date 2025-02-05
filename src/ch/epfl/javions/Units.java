package ch.epfl.javions;

//Classe non instanciable contenant la définition des préfixes SI utiles au projet, des classes imbriquées contenant les définitions des différentes unités et des méthodes de conversion
public final class Units {
    private Units() {
    }

    public static final double CENTI = 1e-2;
    public static final double KILO = 1e3;
    public static final double IN = 2.54;
    public static final double FT = 12;
    public static final double NMI = 1852;

    //Classe imbriquée non instanciable contenant les définitions des unités d'angle
    public static class Angle {
        private Angle() {
        }

        public static final double RADIAN = 1;
        public static final double TURN = 2 * Math.PI * RADIAN;
        public static final double DEGREE = TURN / 360;
        public static final double T32 = Math.scalb(TURN, -32); //TURN / 2^32
    }

    //Classe imbriquée non instanciable contenant les définitions des unités de longueur
    public static class Length {
        private Length() {
        }

        public static final double METER = 1;
        public static final double CENTIMETER = CENTI * METER;
        public static final double KILOMETER = KILO * METER;
        public static final double INCH = IN * CENTIMETER;
        public static final double FOOT = FT * INCH;
        public static final double NAUTICAL_MILE = NMI * METER;
    }

    //TODO Vérifier si il faudrait pas écrire SECOND / 60 plutôt
    //Classe imbriquée non instanciable contenant les définitions des unités de temps
    public static class Time {
        private Time() {
        }

        public static final double SECOND = 1;
        public static final double MINUTE = 60 * SECOND;
        public static final double HOUR = 60 * MINUTE;
    }

    //Classe imbriquée non instanciable contenant les définitions des unités de vitesse
    public static class Speed {
        private Speed() {
        }

        public static final double KNOT = Length.NAUTICAL_MILE / Time.HOUR;
        public static final double KILOMETER_PER_HOUR = Length.KILOMETER / Time.HOUR;
    }

    /**
     * Convertit la valeur, exprimée dans l'unité fromUnit, en l'unité toUnit
     *
     * @param value    (double) : Valeur à convertir
     * @param fromUnit (double) : Unité de départ
     * @param toUnit   (double) : Unité de fin
     * @return la valeur value convertit en l'unité toUnit
     */
    static double convert(double value, double fromUnit, double toUnit) {
        return value * (fromUnit / toUnit);
    }

    /**
     * Equivalent à convert lorsque l'unité d'arrivée est l'unité de base (càd égale à 1)
     *
     * @param value    (double) : Valeur à convertir
     * @param fromUnit (double) : Unité de départ
     * @return la valeur value convertit en l'unité toUnit
     */
    static double convertFrom(double value, double fromUnit) {
        return value * fromUnit;
    }

    /**
     * Equivalent à convert lorsque l'unité de départ est l'unité de base (càd égale à 1)
     *
     * @param value  (double) : Valeur à convertir
     * @param toUnit (double) : Unité de fin
     * @return la valeur value convertit en l'unité toUnit
     */
    static double convertTo(double value, double toUnit) {
        return value / toUnit;
    }
}