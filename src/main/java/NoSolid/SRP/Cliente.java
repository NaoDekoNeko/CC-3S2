package NoSolid.SRP;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion sin SRP");

        Empleado jessica = new Empleado("Jessica", "Abejita", 7.5);
        showEmpDetail(jessica);

        System.out.println("\n*******\n");

        Empleado chalo  = new Empleado("Chalito", "Smart", 3.2);
        showEmpDetail(chalo );

    }

    private static void showEmpDetail(Empleado emp) {
        emp.displayEmpDetail();
        System.out.println("El ID del empleado es: " + emp.generateEmpId(emp.firstName));
        System.out.println("Este empleado es un" + " empleado " +
                emp.checkSeniority(emp.experienceInYears)
        );
    }
}
/*

Pregunta: Realiza una salida de muestra. Ten en cuenta que la identificación(ID) de un empleado puede variar
en tu caso porque genera un número aleatorio para obtener la identificación (ID) del empleado.

Demostracion sin SRP
Nombre del empleado: Abejita,Jessica
Este empleado tiene 7.5 años de experiencia.
El ID del empleado es: J848
Este empleado es un empleado senior

*******

Nombre del empleado: Smart,Chalito
Este empleado tiene 3.2 años de experiencia.
El ID del empleado es: C771
Este empleado es un empleado junior


Pregunta: ¿Cuál es el problema con este diseño?
El problema es que la clase empleado tiene 3 responsabilidades, estas no están relacionadas una con otra para cumplir
con un objetivo o responsabilidad.
Eg: checkSeniority() y empID(), sus funciones difieren.
Lo que debería suceder es que la clase tenga cohesión, es decir,
que sus métodos estén estrechamente relacionados para cumplir una determinada tarea (responsabilidad).

 */