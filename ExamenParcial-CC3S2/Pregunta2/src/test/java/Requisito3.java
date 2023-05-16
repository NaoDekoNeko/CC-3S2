import TicTacToe.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Requisito3 {
    private TicTacToe game;
    @BeforeEach
    public void setUp(){
        game = new TicTacToe();
    }
    @Test
    public void NoWinner(){
        assertThat(game.hayGanador()).isFalse();
    }
    @Test
    public void WinningCond1(){
        game.jugar(3,3);
        game.jugar(1,2);
        game.jugar(1,3);
        game.jugar(1,1);
        game.jugar(2,3);
        //gana X en la fila 3
        assertThat(game.hayGanador()).isTrue();
    }
    @Test
    public void WinningCond2(){
        game.jugar(1,1);
        game.jugar(2,1);
        game.jugar(1,3);
        game.jugar(2,3);
        game.jugar(3,3);
        game.jugar(2,2);
        //gana O en la columna 2
        assertThat(game.hayGanador()).isTrue();
    }
    @Test
    public void WinningCond3(){
        game.jugar(2,1);
        game.jugar(3,3);
        game.jugar(1,2);
        game.jugar(2,2);
        game.jugar(3,1);
        game.jugar(1,1);
        //gana O por la diagonal izq
        assertThat(game.hayGanador()).isTrue();
    }
    @Test void WinningCond4(){
        game.jugar(3,1);
        game.jugar(1,1);
        game.jugar(2,2);
        game.jugar(3,3);
        game.jugar(1,3);
        //gana X por la diagonal derecha
        assertThat(game.hayGanador()).isTrue();
    }
}
