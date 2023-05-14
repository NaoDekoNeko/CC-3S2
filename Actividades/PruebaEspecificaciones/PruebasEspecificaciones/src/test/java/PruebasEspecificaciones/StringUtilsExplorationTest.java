package PruebasEspecificaciones;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * These are the tests we made in the exploration phase (step 2)
 */
public class StringUtilsExplorationTest {

    @Test
    void simpleCase() {
        assertThat (StringUtils.substringsBetween("abcd","a","d"))
                .isEqualTo(new String[]{"bc"});
    }

    @Test
    void manySubstrings() {
        // completa
    }

    @Test
    void openAndCloseTagsThatAreLongerThan1Char() {
       // completa
    }

}
