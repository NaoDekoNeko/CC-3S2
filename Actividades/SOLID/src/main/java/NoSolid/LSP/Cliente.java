package NoSolid.LSP;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Demostracion sin LSP\n");
        PaymentHelper helper = new PaymentHelper();

        // Instanciando dos usuarios registrados
        RegisteredUserPayment pagoAbejita = new RegisteredUserPayment("Abejita");
        RegisteredUserPayment pagoChalito = new RegisteredUserPayment("Chalito");

        // Agregando los usuarios a los helper
        helper.addUser(pagoAbejita);
        helper.addUser(pagoChalito);
/*
        GuestUserPayment guestUser = new GuestUserPayment();
        helper.addUser(guestUser);
*/
        // Procesando el pago usando la clase helper
        // Encuentras algun problema?
        helper.showPreviousPayments();
        helper.processNewPayments();

    }
}

/*
Pregunta: Realiza una salida de muestra y describe la excepción
resultante. ¿Cuál es el problema?.

Salida :
Exception in thread "main" java.lang.UnsupportedOperationException
	at NoSolid.LSP.GuestUserPayment.previousPaymentInfo(GuestUserPayment.java:10)
	at NoSolid.LSP.PaymentHelper.showPreviousPayments(PaymentHelper.java:14)
	at NoSolid.LSP.Cliente.main(Cliente.java:21)

La excepción lanzada hace referencia a una operación no soportada, y hace que
se rompa el ciclo, haciendo que no avance al nuevo pago.
El problema es que el usuario invitado no posee un registro de sus pagos
anteriores, pero al implementar la misma interfaz que un usuario registrado,
que sí posee dicha información, se lanza la excepción.




 */

