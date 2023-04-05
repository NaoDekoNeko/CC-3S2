package Solid.LSP;

public class Cliente {
    public static void main(String[] args) {

        System.out.println("Demostracion LSP.***\n");
        PaymentHelper helper = new PaymentHelper();

        // Instanciando dos usuarios registrados
        RegisteredUserPayment irene = new RegisteredUserPayment("Irene");
        RegisteredUserPayment claudio = new RegisteredUserPayment("Claudio");
        // Instanciando el pago de un usuario invitado
        GuestUserPayment guestUser1 = new GuestUserPayment();

        // Consolidando la informacion del pago anterior al helper
        helper.addPreviousPayment(irene);
        helper.addPreviousPayment(claudio);

        // Consolidando nuevas solicitudes de pago al helper
        helper.addNewPayment(irene);
        helper.addNewPayment(claudio);
        helper.addNewPayment(guestUser1);

        // Recupera todos los pagos anteriores de los usuarios registrados
        helper.showPreviousPayments();

        // Procesa todas las solicitudes de pago nuevos de todos los usuarios
        helper.processNewPayments();


    }
}



/*
    Problema: ¿cuáles son los cambios clave?. Explica tus resultados.
    Un cambio clave ha sido la liberación del metodo previousPayments de los objetos de la clase
    guestUser, pues no solo no tienen registro de pagos anteriores, sino que no pueden tenerlos,
    su clase no contempla la creación de dicho registro.
    Estos cambios permiten una mejor separación de responsabilidades y una mayor cohesión en el código.
    Ahora, cada interfaz se encarga de una tarea específica y las clases implementan solo las interfaces
    necesarias para su funcionalidad.
 */