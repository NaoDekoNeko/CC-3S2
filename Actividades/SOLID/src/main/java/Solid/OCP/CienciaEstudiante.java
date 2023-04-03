package Solid.OCP;
//Clase hija para los estudiantes de Ciencias (hereda de la clase abstracta Estudiante)
public class CienciaEstudiante extends Estudiante{
    public CienciaEstudiante(String name, String regNumber, double score,String dept) {
        super(name, regNumber, score);
        this.department = dept; //asigna departamento
    }
}
