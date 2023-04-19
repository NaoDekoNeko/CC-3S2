import Calculator.Calculadora;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private static Calculadora calculadora;
    @BeforeAll
    public static void init(){
        calculadora = new Calculadora();
    }
    //Requisito 1:
    // El estado de la calculadora es verdadero cuando se inicializa correctamente.
    @Test
    public void whenCalculatorInitializedThenReturnTrue() {
        assertTrue(calculadora.getStatus());
    }
    //Requisito 2:
    // La calculadora debe tener funciones de suma y resta.
    @Test
    public void whenAdditionTwoNumberThenCorrectAnswer() {
        assertEquals(5, calculadora.addition(2,3));
    }
    //Requisito 3:
    // La calculadora debe tener función de división.
    @Test
    public void whenDivisionThenReturnCorrectAnswer(){
        assertEquals(2,calculadora.division(8,4));
    }
    //Excepcion cuando alguien divide por cero
    @Test
    public void whenDivisionByZeroThenThrowException(){
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            calculadora.division(5,0);
        });
        assertEquals("No se puede dividir por cero",exception.getMessage());
    }
    //Requisito 4:
    //Dividir dos numeros
    // y que el resultado coincida con 4 decimales
    //con el resultado correcto
    @Test
    public void whenDividingTwoNumbersThenResultWith4Decimals() {
        assertEquals(1.4,calculadora.division(7,5),0.0001);
    }
    //Requisito 5:
    //Sacar raíz cuadrada a un numero
    //y que el resultado coincida en 4 decimales
    //con el resultado correcto
    @Test
    public void whenSquareRootANumberThenResultWith4Decimals(){
        assertEquals(1.4142,calculadora.raizCuadrada(2),0.0001);
    }
    //Excepcion cuando alguien saca raíz cuadrada a un numero negativo
    @Test
    public void whenSquareRootANegativeNumberThenThrowException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, ()->{
            calculadora.raizCuadrada(-23.4);
        });
        assertEquals("No se puede sacar raíz cuadrada " +
                        "Real a un numero negativo",
                exception.getMessage());
    }
    //Requisito 6:
    //Elevar un numero a la potencia de otro
    //Y el resultado coincide en 4 decimales con el resultado correcto
    @Test
    public void whenANumberIsPoweredByAnotherThenReturnCorrectResultWith4Decimals(){
        assertEquals(243,calculadora.potencia(3,5),0.0001);
    }
}
