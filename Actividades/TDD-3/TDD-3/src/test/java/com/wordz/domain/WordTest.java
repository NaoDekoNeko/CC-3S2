package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void oneIncorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertScoreForLetter(score,0,Letter.CORRECT);
    }
    private void assertScoreForLetter(Score score,
        int position,Letter expected  ){
        assertThat(score.letter(position)).
                isEqualTo(expected);
    }
    //@Test
    void secondLetterWrongPosition()
    {
        var word = new Word("AR");
        var score = word.guess("ZA");
        assertScoreForLetter(score,1, PART_CORRECT);
    }
}
