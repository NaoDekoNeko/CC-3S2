package Solid.OCP;
//Decide si hay distinción de artes para el estudiante
public class ArtsDistinctionDecider implements DistinctionDecider{
    public void evaluateDistinction(Estudiante estudiante){
        if(estudiante.score >70){   //corrobora que se cumpla con el puntaje mínimo
            System.out.println(estudiante.regNumber + " ha recibido una distincion en artes.");
        }
    }
}
