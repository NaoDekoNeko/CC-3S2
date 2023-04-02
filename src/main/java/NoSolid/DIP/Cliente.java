package NoSolid.DIP;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("***A demo without DIP.***");
        InterfazUsuario usuario = new InterfazUsuario();
        usuario.saveEmployeeId("E001");

    }
}
/*
    Pregunta: Realiza una salida de muestra.
    ¿Cuáles son los problemas que adolece el código?

    La clase InterfazUsuario está fuertemente acoplada a
    la clase OracleDatabase, ya que crea una instancia directamente
    en el constructor. Esto significa que si queremos cambiar
    la base de datos a la que se guarda la identificación del empleado,
    necesitamos cambiar el código en InterfazUsuario.

    La clase InterfazUsuario viola el principio de inversión de
    dependencia (DIP), ya que depende
    de una clase concreta (OracleDatabase) en lugar de una abstracción
    como podría ser una clase BaseDeDatos.





 */