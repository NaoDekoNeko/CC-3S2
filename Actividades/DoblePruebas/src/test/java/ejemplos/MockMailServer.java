package ejemplos;

import ejemplos.MailServer;

public class MockMailServer implements MailServer {
     boolean fueLlamado;
     String actualRecipiente = "test@example.com";
     String actualTema = "Bienvenido!";
    String actualTexto = "Bienvenido a tu cuenta";
    @Override
    public void sendEmail(String recipiente, String tema,
                      	String texto) {
        fueLlamado= true;
        actualRecipiente = recipiente;
        actualTema = tema;
        actualTexto = texto;
	}
}

