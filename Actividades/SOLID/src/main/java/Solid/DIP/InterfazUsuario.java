package Solid.DIP;

class InterfazUsuario{
    BaseDatos basedatos;
    public InterfazUsuario(BaseDatos basedatos){
        this.basedatos = basedatos;
    }
    public void saveEmployeeId(String empId) {basedatos.saveEmpIdInDatabase(empId);}

    public void setDatabase(BaseDatos basedatos) {
        this.basedatos = basedatos; //gracias a esto, podemos copiar un mismo usuario
                                    //en diferentes bases de datos
    }

}

