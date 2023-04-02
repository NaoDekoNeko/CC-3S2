package Solid.DIP;

public class PSQLDatabase implements BaseDatos{
    @Override
    public void saveEmpIdInDatabase(String empId) {
        System.out.println("El id : " + empId + " es guardado en la base de datos Postgres");
    }
}
