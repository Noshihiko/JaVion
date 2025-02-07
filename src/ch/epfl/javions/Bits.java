package ch.epfl.javions;

import java.util.Objects;

//Classe non instanciable permettant d'extraire un sous-ensemble des 64 bits d'une valeur de type long
public class Bits {
    private Bits(){
    }

    /**
     * Extrait du vecteur de 64 bits value la plage de size bits commençant au bit d'index start, qu'elle interprète comme une valeur non signée
     * Lève IllegalArgumentException si la taille n'est pas strictement supérieure à 0 et strictement inférieure à 32,
     * ou IndexOutOfBoundsException si la plage décrite par start et size n'est pas totalement comprise entre 0 (inclus) et 64 (exclu).
     * @param value (long) : Vecteur de 64 bits
     * @param start (int) : Index de début
     * @param size (int) : Plage de bits à extraire
     * @return la valeur non signée de la plage de size bits à partir de start
     */
    public static int extractUInt(long value, int start, int size){
        Preconditions.checkArgument(size > 0 && size < Integer.SIZE);
        Objects.checkFromIndexSize(start, size, Long.SIZE);

        long shifted = value >>> start;
        long mask = (1L << size) - 1;
        return (int) (shifted & mask);
    }

    /**
     * Retourne vrai ssi le bit de value d'index donné vaut 1.
     * Lève IndexOutOfBoundsException s'il n'est pas compris entre 0 (inclus) et 64 (exclu).
     * @param value (long) : Vecteur de 64 bits
     * @param index (int) : Index du bit à extraire
     * @return vrai ssi le bit de value d'index donné vaut 1, sinon faux.
     */
    public static boolean testBit(long value, int index){
        Objects.checkIndex(index, Long.SIZE);
        //return ((value >>> index) & 1) == 1;
        return extractUInt(value, index, 1) == 1;
    }
}