import TicTacToe.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Requisito2 {
    private TicTacToe game;
    @BeforeEach
    public void setUp(){
        game = new TicTacToe();
    }
    @Test
    public void XPlaysFirst(){
        assertThat(game.getTurno()).isEqualTo('X');
    }
    @Test
    public void OplaysAfterX(){
        game.jugar(1,1);
        assertThat(game.getTurno()).isEqualTo('O');
    }
}
