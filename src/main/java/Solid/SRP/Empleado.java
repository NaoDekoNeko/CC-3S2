package Solid.SRP;

public class Empleado {
    public String firstName, lastName, empId;
    public double experienceInYears;
    public Empleado(String firstName, String lastName, double experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceInYears = experience;
    }
    public void displayEmpDetail(){
        System.out.println("Nombre del empleado: "+lastName+","+firstName);
        System.out.println("Este empleado tiene "+ experienceInYears+" años de experiencia.");
    }
}


/*
Dentro de la clase Empleado, el metodo displayEmpDetail() tiene la tarea de mostrar los datos
del objeto empleado pertinentes a la misma.
En la clase GeneradorIDEmpleado, el método que comparte nombre con la clase, se encarga de generar el ID del empleado.
Por último, la clase SeniorityChecker, contiene un método que se encarga de comprobar la permanencia de un empleado en la empresa.

 Y como cada una de estas clases se enfoca en una unica responsabilidad en particular.
 Dividirlo de esa manera cumple con el uso del Principio de Responsabilidad
 Unica. (SRP)
 */