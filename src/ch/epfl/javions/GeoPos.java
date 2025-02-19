package ch.epfl.javions;

public record GeoPos(int longitudeT32, int latitudeT32) {
    public GeoPos {
        if (!isValidLatitudeT32(latitudeT32))
            throw new IllegalArgumentException();
    }

    public static boolean isValidLatitudeT32(int latitudeT32){
        return latitudeT32 <= Math.scalb(1,30)  && latitudeT32 >= Math.scalb(-1, 30);
    }

    public double longitude(){
        return Units.convertFrom(longitudeT32, Units.Angle.T32);
    }

    public double latitude(){
        return Units.convertFrom(latitudeT32, Units.Angle.T32);
    }

    @Override
    public String toString() {
        return "("+longitude()+"°, "+latitude()+"°)";
    }
}