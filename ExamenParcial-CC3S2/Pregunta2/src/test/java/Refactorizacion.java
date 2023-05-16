import TicTacToe.TicTacToe;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Refactorizacion {
    @Test
    public void Winner(){
        TicTacToe game = new TicTacToe();
        game.jugar(3,1);
        game.jugar(1,1);
        game.jugar(2,2);
        game.jugar(3,3);
        game.jugar(1,3);
        assertThat(game.esGanador('X',1,3)).isTrue();
    }
}
