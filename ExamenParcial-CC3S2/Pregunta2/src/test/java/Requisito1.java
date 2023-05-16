import TicTacToe.TicTacToe;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class Requisito1 {
    @Test
    public void OutOfGridXAxis(){
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                ()->new TicTacToe().jugar(5,2));
    }
    @Test
    public void OutOfGridYAxis(){
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(
                ()->new TicTacToe().jugar(1,7));
    }
    @Test
    public void AlreadyOccupied()
    {
        var ticTacToe = new TicTacToe();
        ticTacToe.jugar(3,3);
        ticTacToe.jugar(3,3);
        //se va a comprobar que el movimiento de O no se haya hecho y solo se haya realizado el movimiento X
        assertThat(ticTacToe.getCell(3,3)).isEqualTo(TicTacToe.Cell.CROSS);
    }
}
