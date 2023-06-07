package ejemplos;

public class UserNotifications{
    private final MailServer mailServer;
    String actualRecipiente = "test@example.com";
    String actualTema = "Bienvenido!";
    String actualTexto = "Bienvenido a tu cuenta";
    public UserNotifications(MailServer mailServer) {
        this.mailServer = mailServer;
    }

    public void welcomeNewUser() {
        mailServer.sendEmail(actualRecipiente,actualTema,actualTexto);
    }
}
