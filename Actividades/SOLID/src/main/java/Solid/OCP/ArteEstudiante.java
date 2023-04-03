package Solid.OCP;
//Clase hija para los estudiantes de Arte (hereda de la clase abstracta Estudiante)
public class ArteEstudiante extends Estudiante{
    public ArteEstudiante(String name, String regNumber, double score,String dept) {
        super(name, regNumber, score);
        this.department = dept; //asigna departamento
    }

}
