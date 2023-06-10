package ejemplos;

public class UserNotifications{

    private final MailServer mailServer;

    public UserNotifications(MailServer mailServer) {
        this.mailServer = mailServer;
    }
    /*
    public void welcomeNewUser(String mail) {
    }
     */
    public void welcomeNewUser(String email) {
        try {
            mailServer.sendEmail(email, "Bienvenido!", "Bienvenido a tu cuenta");
        } catch (IllegalArgumentException e) {
            throw new NotificationFailureException("not-an-email-address");
        }
    }

}
