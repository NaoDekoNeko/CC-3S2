package PruebasEspecificaciones;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    private static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * Busca un String para subcadenas delimitadas por una etiqueta start y end,
     * y devuelve todas las subcadenas coincidentes en un arreglo.
     *
     * @param str   el String que contiene las subcadenas, null devuelve null, empty devuelve empty
     * @param open  el String identifica el inicio de la subcadena, empty retorna null
     * @param close the String identifica el fin de la subcadena, empty retorna null
     * @return un arreglo String de subcadenas o {@code null} si no empareja
     */
    public static String[] substringsBetween(final String str, final String open, final String close) {
        // Completa
        if (str == null | isEmpty(open) || isEmpty(close)) {
            return null;
        }
        int strLen = str.length();
        if(strLen == 0) {
            return EMPTY_STRING_ARRAY;
        }
        //almacenan la longitud de las cadenas
        int closeLen = close.length();
        int openLen = open.length();
        List<String> list = new ArrayList<>();
        int pos = 0; //indica la posicion de la cadena
        while(pos<strLen-closeLen){
            int start = str.indexOf(open,pos); //busca la próxima aparición de la etiqueta open
            if(start<0){
                break; //rompemos el bucle si la etiqueta open no vuelve a aparecer en la cadena
            }
            start += openLen;
            int end = str.indexOf(close, start);
            if(end<0){
                break; //si la etiqueta close no vuelve a aparecer
            }
            list.add(str.substring(start,end));
            pos = end + closeLen;   //nos da la posición final
        }
        if(list.isEmpty()){
            return null; //si no encuentra subcadenas, retorna null
        }
        //no encongtró subcadenas, por lo que retorna un String
        //retorna un string array nulo
        return list.toArray(EMPTY_STRING_ARRAY);
    }
}


