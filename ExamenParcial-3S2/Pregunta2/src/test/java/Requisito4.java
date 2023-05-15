import TicTacToe.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Requisito4 {
    private TicTacToe game;
    @BeforeEach
    public void setUp(){
        game = new TicTacToe();
    }
    @Test
    public void GameIsDraw(){
        game.jugar(1,1);
        //X| |
        // | |
        // | |
        game.jugar(1,2);
        //X|O|
        // | |
        // | |
        game.jugar(1,3);
        //X|O|X
        // | |
        // | |
        game.jugar(3,1);
        //X|O|X
        // | |
        //O| |
        game.jugar(3,2);
        //X|O|X
        // | |
        //O|X|
        game.jugar(3,3);
        //X|O|X
        // | |
        //O|X|O
        game.jugar(2,2);
        //X|O|X
        // |X|
        //O|X|O
        game.jugar(2,3);
        //X|O|X
        // |X|O
        //O|X|O
        game.jugar(2,1);
        //X|O|X
        //X|X|O
        //O|X|O
        assertThat(game.tableroLleno()).isTrue();
    }
}
