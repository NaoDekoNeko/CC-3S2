import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestClass {
    @Test
    public void Test1(){
        var calc = new Calculadora();
        var resultado = calc.suma(10,15);
        assertThat(resultado).isEqualTo(15);
    }
}
