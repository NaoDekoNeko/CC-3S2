package PruebasEstructurales;

public class LeftPadUtils { //esto sale en rojo porque no se puede instanciar el constructor
    private static final String SPACE = " ";

    private static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     *
     * @param str       cadena para completar, puede ser null
     * @param size      'longitud' a copletar
     * @param padStr    la cadena con la que completar. Null o vacio se
     *                  trata como un solo espacio
     * @return left     devuelve una cadena con un desplazamiento left, codena original
     *  {@code null}    si se entrega una cadena null
     *  Ejemplo: str:"abc",padStr:"-", size = 5
     */

    public static String leftPad(final String str, final int size, String padStr) {
        if (str == null) { //1
            return null;
        }
        if (isEmpty(padStr)) { //2
            padStr = SPACE;
        }
        final int padLen = padStr.length();
        final int strLen = str.length();
        final int pads = size - strLen;
        if (pads <= 0) {//3
            return str; //no completamos
        }

        if (pads == padLen) { //4
            return padStr.concat(str);
        } else if (pads < padLen) {//5
            return padStr.substring(0, pads).concat(str); //solo la parte que encaja
        } else {//6
            final char[] padding = new char[pads];
            final char[] padChars = padStr.toCharArray();
            //se completa tantas veces como sea necesario para llegar al padding
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }
}
