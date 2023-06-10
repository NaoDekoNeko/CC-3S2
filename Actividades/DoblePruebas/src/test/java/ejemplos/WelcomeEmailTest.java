package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class) //Con esto se inicializa mockito
public class WelcomeEmailTest {
    @Mock
    private MailServer mailServer;

    @Test
    public void sendsWelcomeEmail(){
        var notifications
                = new UserNotifications(mailServer);
        notifications.welcomeNewUser("test@example.com");
        verify(mailServer).sendEmail("test@example.com",
                "Bienvenido!",
                "Bienvenido a tu cuenta");
    }
    @Test
    public void rejectsInvalidEmailRecipient(){
        doThrow(new IllegalArgumentException())
                .when(mailServer).sendEmail(any(),any(),any());
        var notifications = new UserNotifications(mailServer);
        assertThatExceptionOfType(NotificationFailureException.class)
                .isThrownBy(()->notifications.welcomeNewUser("not-an-email-address"));
    }
}
