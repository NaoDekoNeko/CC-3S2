package NoSolid.OCP;
import java.util.Arrays;
import java.util.List;

public class DistinctionDecider {
    List<String> science= Arrays.asList("Ciencia de la Computacion.","Fisica");
    List<String> arts= Arrays.asList("Historia","Literatura");
    List<String> commerce = Arrays.asList("Comecio");
    public void evaluateDistinction(Estudiante estudiante) {

        if (science.contains(estudiante.department)) {
            if (estudiante.score > 80) {
                System.out.println(estudiante.regNumber+" ha recibido una distincion en ciencias.");
            }
        }

        if (arts.contains(estudiante.department)) {
            if (estudiante.score > 70) {
                System.out.println(estudiante.regNumber + " ha recibido una distincion en artes.");
            }
        }
        if(commerce.contains(estudiante.department)) {
            if(estudiante.score>75)
            {
                System.out.println(estudiante.regNumber+ " ha recibido una distincion en comercio.");

            }
        }
    }

}
/*
    Pregunta:¿Está bien modificar el método evaluateDistinction()de esta manera?.
    No, no está bien modificar el método evaluateDistinction() de esta manera
    ya que va en contra del Principio Abierto/Cerrado (OCP).
    En lugar de modificar directamente el método existente, se debe crear una
    nueva clase que extienda la clase DistinctionDecider y sobrescribir el
    método evaluateDistinction() en esa nueva clase para agregar la lógica
    adicional para los estudiantes de comercio. De esta manera, el código
    existente no se modifica y se sigue cumpliendo el principio OCP.


 */