package be.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculatorAsString {
    private final CodeCalculator calculator = new CodeCalculator();

    @Test
    void emptyCode() {
        assertEquals("empty code = 0", calculator.getResultAsString(""));
    }

    @Test
    void randomCode() {
        assertEquals("invalid code = 0", calculator.getResultAsString(" hhj s"));
    }

    @Test
    void nullCode() {
        assertEquals("null code = 0", calculator.getResultAsString(null));
    }

    @Test
    void simpleCode() {
        assertEquals("5 + 4 + 3 + 7 = 19", calculator.getResultAsString("5,4,3,7"));
    }

    @Test
    void simpleCodeWithSpaces() {
        assertEquals("5 + 4 + 3 + 7 = 19", calculator.getResultAsString("   5,   4,3, 7 "));
    }

    @Test
    void simpleCodeWithOther() {
        assertEquals("invalid code = 0", calculator.getResultAsString(" aav 5,4,3, 7 "));
    }

    @Test
    void simpleCodeParentheses() {
        assertEquals("5 + 4 + 3 + 7 = 19", calculator.getResultAsString("(5,4,3,7)"));
    }

    @Test
    void simpleCodeParenthesesAndSpaces() {
        assertEquals("5 + 4 + 3 + 7 = 19", calculator.getResultAsString("(  5, 4,3, 7 )"));
    }

    @Test
    void simpleCodeParenthesesAndOther() {
        assertEquals("invalid code = 0", calculator.getResultAsString("( aaab 5, 4,3, 7 )"));
    }

    @Test
    void emptyCodeParentheses() {
        assertEquals("empty code = 0", calculator.getResultAsString("()"));
    }

    @Test
    void basisCodePlus() {
        assertEquals("5 + 4 + 3 + 7 = 19", calculator.getResultAsString("&+(5,4,3,7)"));
    }

    @Test
    void basisCodePlusAndEmptyStart() {
        assertEquals("5 + 4 + 3 + 7 = 19", calculator.getResultAsString("   &+(5,4,3,7)"));
    }

    @Test
    void basisCodePlusAndOtherStart() {
        assertEquals("invalid code = 0", calculator.getResultAsString("ahhd   &+(5,4,3,7)"));
    }

    @Test
    void basisCodePlusAndEnd() {
        assertEquals("5 + 4 + 3 + 7 = 19", calculator.getResultAsString("&+(5,4,3,7) "));
    }

    @Test
    void basisCodePlusAndRandom() {
        assertEquals("invalid code = 0", calculator.getResultAsString("&+(5,4,3,7)aaa5 "));
    }

    @Test
    void basisCodeMin() {
        assertEquals("5 - 4 - 3 - 7 = -9", calculator.getResultAsString("&-(5,4,3,7)"));
    }

    @Test
    void basisCodeMinAndEnd() {
        assertEquals("5 - 4 - 3 - 7 = -9", calculator.getResultAsString("&-(5,4,3,7) "));
    }

    @Test
    void basisCodeMinAndRandom() {
        assertEquals("invalid code = 0", calculator.getResultAsString("&-(5,4,3,7)aaa5 "));
    }

    @Test
    void basisCodeProdMin() {
        assertEquals("5 * 4 * 3 * 7 = 420", calculator.getResultAsString("&*(5,4,3,7)"));
    }

    @Test
    void basisCodeProdAndEnd() {
        assertEquals("5 * 4 * 3 * 7 = 420", calculator.getResultAsString("&*(5,4,3,7) "));
    }

    @Test
    void basisCodeProdAndRandom() {
        assertEquals("invalid code = 0", calculator.getResultAsString("&*(5,4,3,7)aaa5 "));
    }

    @Test
    void basisCodeDiv() {
        assertEquals("5 / 4 / 3 / 7 = 0.0595", calculator.getResultAsString("&/(5,4,3,7)"));
    }

    @Test
    void basisCodeDivAndEnd() {
        assertEquals("5 / 4 / 3 / 7 = 0.0595", calculator.getResultAsString("&/(5,4,3,7) "));
    }

    @Test
    void basisCodeDivAndRandom() {
        assertEquals("invalid code = 0", calculator.getResultAsString("&/(5,4,3,7)aaa5 "));
    }
}