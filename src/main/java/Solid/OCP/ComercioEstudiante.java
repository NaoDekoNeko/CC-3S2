package Solid.OCP;

public class ComercioEstudiante extends Estudiante {
    ComercioEstudiante(String name, String regNumber, double score,String dept){
        super(name, regNumber, score);
        this.department = dept; //asigna departamento
    }
}
