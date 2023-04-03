package Solid.DIP;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion con DIP");

        // Usando Oracle
        BaseDatos basedatos = new OracleDatabase();
        InterfazUsuario usuario = new InterfazUsuario(basedatos);
        usuario.saveEmployeeId("E002");

        // completa

        basedatos = new MySQLDatabase();
        //usuario.setDatabase(basedatos);
        usuario = new InterfazUsuario(basedatos);
        usuario.saveEmployeeId("E002");


        basedatos = new PSQLDatabase();
        usuario.setDatabase(basedatos);
        //usuario = new InterfazUsuario(basedatos);
        usuario.saveEmployeeId("E002");

    }
}

/*
Pregunta: Realiza una salida de muestra.
¿Esto resuelve todos los problemas que adolece el código?.

Si porque ahora se puede hacer el guardado de datos del usuario
en la base de datos que se elija, agregando más bases de datos.

Pregunta: ¿Cuál es el beneficio de hacer esto?.
El beneficio de hacer esto es que ahora podemos agregar el usuario
a otra base de datos.InterfazUsuario es ahora independiente de la
implementación concreta de BaseDatos y puede trabajar con cualquier
objeto que implemente la interfaz BaseDatos. Esto hace que el código
sea más flexible y fácil de mantener.

Pregunta: Verifica tus resultados.
    Demostracion con DIP
    El id : E002 es guardado en la base de datos Oracle
    El id: E002 es guardado en la base de datos MySQL
    El id : E002 es guardado en la base de datos Postgres

 */