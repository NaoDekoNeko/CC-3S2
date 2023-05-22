package PruebasEspecificaciones;

import org.junit.jupiter.api.Test;
import static PruebasEspecificaciones.StringUtils.substringsBetween;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test void strIsNullOrEmpty() {
        assertThat(StringUtils.substringsBetween(null,"a","b"))
                .isNull();  //T1 -> str = null
        assertThat(substringsBetween("","a","b"))
                .isEqualTo(new String[]{ }); //T2 -> str = ""
    }

    @Test
    void openIsNullOrEmpty() {
        assertThat(substringsBetween("abc",null,"c"))
                .isEqualTo(null); //T1
        assertThat(substringsBetween("abc","","c"))
                .isEqualTo(null);
    }

    @Test
    void closeIsNullOrEmpty() {
            assertThat(substringsBetween("abc", "a", null))
                    .isEqualTo(null);
            assertThat(substringsBetween("abc", "a", ""))
                    .isEqualTo(null);
    }

    @Test
    void strOfLength1() {
        assertThat(substringsBetween("a", "a", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "a")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "a", "a")).isEqualTo(null);
    }

    @Test
    void openAndCloseOfLength1() {
        assertThat(substringsBetween("abc", "x", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "x", "c")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "c")).isEqualTo(new String[] { "b"});
    }

    @Test
    void openAndCloseTagsOfDifferentSizes() {
        assertThat(substringsBetween("aabcc", "xx", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "aa", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "xx", "cc")).isEqualTo(null);
        assertThat(substringsBetween("aabbcc", "aa", "cc"))
                .isEqualTo(new String[] {"bb"});
        assertThat(substringsBetween("aabbccaaeecc", "aa", "cc"))
                .isEqualTo(new String[] {"bb", "ee"});
    }

    @Test
    void noSubstringBetweenOpenAndCloseTags() {
        // T21: str no contiene caracteres entre la etiqueta open y close
        assertThat(substringsBetween("aabb", "aa", "bb"))
                .isEqualTo(new String[] { ""});
    }

    @Test
    void closeTagAppearingMultipleTimes() {
        // T22: len(str) >1, len(open) >1, len(close) >= 1, etiquetas open y close se repiten varias veces
        assertThat(substringsBetween("a abb ddc ca abbcc", "a a", "c c"))
                . isEqualTo(new String[ ]      {"bb dd"});
        // T23: entre las etiquetas open y close solo hay una subcadena de longitud >1
        assertThat(substringsBetween("aabbccaa", "aa", "cc"))
                . isEqualTo(new String[ ]      {"bb"});
        //T24: entre las etiquetas open y close existe un substring vacio y no vacio
        assertThat(substringsBetween("aabbccaacc", "aa", "cc"))
                . isEqualTo(new String[ ]      {"bb", ""});
        assertThat(substringsBetween("aabaabbccaacc", "aa", "cc"))
                . isEqualTo(new String[ ]      {"baabb", ""});
    }

}
