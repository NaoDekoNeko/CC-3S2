package Solid.OCP;

public class CommerceDistinctionDecider implements DistinctionDecider{
    public void evaluateDistinction(Estudiante estudiante){
        if(estudiante.score >95){   //corrobora que se cumpla con el puntaje mínimo
            System.out.println(estudiante.regNumber + " ha recibido una distincion en comercio.");
        }
    }
}
