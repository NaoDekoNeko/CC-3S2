package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserGreetingTest {
    /*
    //el primer test
    @Test
    void formatsGreetingWithName() {
        String actual = "";
        assertThat(actual)
                .isEqualTo("Hola y bienvenido, Kapumota");
    }
     */

    private static final UserId USER_ID
            = new UserId("1234");
    @Mock
    private UserProfiles profiles;
    /*
    @Test
    void formatsGreetingWithName() {
        //esta implementación presenta olor a código de prueba pues se ha configurado
        //el doble de prueba tanto como Stub como Mock
        //cuando se haga la llamada a ese método, entonces regresa lo que quiero
        when(profiles.fetchNicknameFor(USER_ID))
                .thenReturn("Kapumota");
        var greeting = new UserGreeting(profiles);
        String actual =
                greeting.formatGreeting(USER_ID);
        assertThat(actual)
                .isEqualTo("Hola y bienvenido, Kapumota");


    }
    */
    /*
    //al reemplazar este código se elimina el SUT
    @Test
    void formatsGreetingWithName() {
        String actual = "";
        assertThat(actual)
                .isEqualTo("Hola y bienvenido, Kapumota");
    }
     */
    @Test
    void formatGreetingWithName(){
        when(profiles.fetchNicknameFor(any()))
                .thenReturn("Kapumota");
        var greeting = new UserGreeting(profiles);
        String actual =
                greeting.formatGreeting(new UserId(""));
        assertThat(actual)
                .isEqualTo("Hola y bienvenido, Kapumota");
    }
}