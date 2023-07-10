package org.IntegrationTests;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntegrationTests{
    /**
     * @ devuelve el contenido del archivo
     */
    public static String load(File file) {
        return null;

    }

    /**
     * @devuelve las palabras en cadenas s, en el orden en que aparecen,
     *  donde una palabra es una secuencia contigua de caracteres que no son
     * espacios en blanco ni signos de puntuación
     */
    public static List<String> extract(String s) {
        return null;

    }

    /**
     * @devuelve un índice que asigna una palabra al conjunto de archivos
     * que contienen esa palabra, para todos los archivos en el conjunto de entrada
     */
    public static Map<String, Set<File>> index(Set<File> files) {
        for (File file : files) {
            String doc = load(file);
            List<String> words = extract(doc);

        }
        return null;

    }
}