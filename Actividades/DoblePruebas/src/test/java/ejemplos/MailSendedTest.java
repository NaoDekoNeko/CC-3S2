package ejemplos;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MailSendedTest {
    @Test
    public void sendsWelcomeTest() {
        var mailServer = new MockMailServer();
        var notifications = new UserNotifications(mailServer);
        notifications.welcomeNewUser();
        assertThat(mailServer.fueLlamado).isTrue();
        assertThat(mailServer.actualRecipiente)
                .isEqualTo("test@example.com");
        assertThat(mailServer.actualTema)
                .isEqualTo("Bienvenido!");
        assertThat(mailServer.actualTexto)
                .contains("Bienvenido a tu cuenta");
    }
}
