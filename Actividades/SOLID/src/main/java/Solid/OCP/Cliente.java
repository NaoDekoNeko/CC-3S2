package Solid.OCP;

import java.util.ArrayList;
import java.util.List;
public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion OCP");
        List<Estudiante> CienciasEstudiantes = enrollScienceStudents();
        List<Estudiante> ArtesEstudiantes = enrollArtsStudents();
        List<Estudiante> ComercioEstudiantes = enrollCommerceStudents();


        // Muestra todos los resultados.
        System.out.println("Resultados:");

        for (Estudiante estudiante : CienciasEstudiantes) {
            System.out.println(estudiante);
        }
        for (Estudiante estudiante : ArtesEstudiantes) {
            System.out.println(estudiante);
        }
        for (Estudiante estudiante : ComercioEstudiantes) {
            System.out.println(estudiante);
        }

        // Evalua las distinciones

        DistinctionDecider scienceDistinctionDecider = new ScienceDistinctionDecider();
        DistinctionDecider artsDistinctionDecider = new ArtsDistinctionDecider();
        DistinctionDecider commerceDistinctionDecider = new CommerceDistinctionDecider();
        System.out.println("Distinciones:");
        for (Estudiante estudiante : CienciasEstudiantes) {
            scienceDistinctionDecider.evaluateDistinction(estudiante);
        }
        for (Estudiante estudiante : ArtesEstudiantes) {
            artsDistinctionDecider.evaluateDistinction(estudiante);
        }

        for(Estudiante estudiante : ComercioEstudiantes){
             commerceDistinctionDecider.evaluateDistinction(estudiante);
        }

    }

    private static List<Estudiante> enrollScienceStudents() {
        Estudiante Irene = new CienciaEstudiante("Irene", "R1", 81.5,"Ciencia de la computacion.");
        Estudiante jessica = new CienciaEstudiante("Jessica", "R2", 72,"Fisica");
        List<Estudiante> CienciasEstudiantes = new ArrayList<Estudiante>();
        CienciasEstudiantes.add(Irene);
        CienciasEstudiantes.add(jessica);
        return CienciasEstudiantes;
    }

    private static List<Estudiante> enrollArtsStudents() {
        Estudiante chalo = new ArteEstudiante("Chalo", "R3", 71,"Historia");
        Estudiante claudio = new ArteEstudiante("Claudio", "R4", 66.5,"Literatura");
        List<Estudiante> ArtesEstudiantes = new ArrayList<Estudiante>();
        ArtesEstudiantes.add(chalo);
        ArtesEstudiantes.add(claudio);
        return ArtesEstudiantes;
    }
    private static List<Estudiante> enrollCommerceStudents(){
        Estudiante gabriel = new ComercioEstudiante("Gabriel","R5",100,"Comercio");
        Estudiante ademar = new ComercioEstudiante("Ademar","R6",97,"Comercio");
        List<Estudiante>  ComercioEstudiantes = new ArrayList<Estudiante>();
        ComercioEstudiantes.add(gabriel);
        ComercioEstudiantes.add(ademar);
        return ComercioEstudiantes;
    }

}

/*
Pregunta: Realiza una salida de muestra de tu respuesta. Explica los cambios realizados
El programa es flexible porque a partir de la clase estudiante se extienden nuevas subclases
para el departamento especifico al que pertence el estudiante, y a su vez estas subclases
implementan la interfaz DistinctionDecider.
 Esto genera que no tengamos que modificar la funcion evaluatedistinction para un conjunto
 determinado de clases. Sino que se crean dos nuevos metodos en las subclases  para
 calcular la distincion  en funcion de las puntuaciones de cada departamento.

Pregunta: ¿Cuáles son las principales ventajas ahora?
Se puede agregar nuevas funcionalidades sin tener que modificar el codigo existente.
En este caso se pueden crear nuevas subclases para los departamentos que se quieran añadir,
o también eliminar departamentos sin afectar a la clase principal.
 */
