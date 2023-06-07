package ejemplos;
import java.util.random.RandomGenerator;
public class LanzamientoDados {
    private final int NUMERO_LADOS = 6;

    //reemplazamos el objeto RandomGenerator por una interfaz NumerosAleatorios
    private final NumerosAleatorios rnd;

    // Completa
    //constructor de clase
    public LanzamientoDados(NumerosAleatorios r){
        this.rnd = r;
    }
    public String asText() {
        int lanzado = rnd.nextInt(NUMERO_LADOS) + 1;

        return String.format("Sacaste un %d", lanzado);
    }
}
