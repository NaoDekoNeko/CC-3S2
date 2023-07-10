package org.BlackBoxWhiteBox;

import java.util.List;

public class BlackBoxWhiteBox {
    /**
     * Ordena una lista de enteros en orden nodecreciente Modifica la lista tal que
     * valores.get(i) <= valores.get(i+1) para todo 0<=i<valores.size()-1
     */
    public static void sort(List<Integer> valores) {
        // escoge un buen algoritmo para el tamano de la lista
        if (valores.size() < 10) {
            radixSort(valores);
        } else if (valores.size() < 1000*1000*1000) {
            quickSort(valores);
        } else {
            mergeSort(valores);
        }
    }

    private static void mergeSort(List<Integer> valores) {

    }

    private static void quickSort(List<Integer> valores) {

    }

    private static void radixSort(List<Integer> valores) {

    }
}