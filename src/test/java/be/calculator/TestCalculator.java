package be.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {
    private final CodeCalculator calculator = new CodeCalculator();

    @Test
    void emptyCode() {
        assertEquals(0, calculator.getResult(""));
    }

    @Test
    void randomCode() {
        assertEquals(0, calculator.getResult(" hhj s"));
    }

    @Test
    void nullCode() {
        assertEquals(0, calculator.getResult(null));
    }

    @Test
    void simpleCode() {
        assertEquals(19, calculator.getResult("5,4,3,7"));
    }

    @Test
    void simpleCodeWithSpaces() {
        assertEquals(24, calculator.getResult("   5,   4,8, 7 "));
    }

    @Test
    void simpleCodeWithOther() {
        assertEquals(0, calculator.getResult(" aav 15,4,3, 7 "));
    }

    @Test
    void simpleCodeParentheses() {
        assertEquals(29, calculator.getResult("(15,4,3,7)"));
    }

    @Test
    void simpleCodeParenthesesAndSpaces() {
        assertEquals(25, calculator.getResult("(  5, 4,9, 07 )"));
    }

    @Test
    void simpleCodeParenthesesAndOther() {
        assertEquals(0, calculator.getResult("( aaab 5, 4,30, 7 )"));
    }

    @Test
    void emptyCodeParentheses() {
        assertEquals(0, calculator.getResult("()"));
    }

    @Test
    void basisCodePlus() {
        assertEquals(21, calculator.getResult("&+(5,4,3,9)"));
    }

    @Test
    void basisCodePlusAndEmptyStart() {
        assertEquals(32, calculator.getResult("   &+(5,4,13,3,7)"));
    }

    @Test
    void basisCodePlusAndOtherStart() {
        assertEquals(0, calculator.getResult("ahhd   &+(5,4,13,3,7)"));
    }

    @Test
    void basisCodePlusAndEnd() {
        assertEquals(26, calculator.getResult("&+(5,4,3,7,4,3) "));
    }

    @Test
    void basisCodeOther() {
        assertEquals(0, calculator.getResult("&!(5,4,3,7,4,3)"));
    }

    @Test
    void basisCodeEmpty() {
        assertEquals(26, calculator.getResult("&(5,4,3,7,4,3) "));
    }

    @Test
    void basisCodePlusAndRandom() {
        assertEquals(0, calculator.getResult("&+(5,4,3,7)aaa5 "));
    }

    @Test
    void basisCodeMin() {
        assertEquals(-9, calculator.getResult("&-(5,4,3,7)"));
    }

    @Test
    void basisCodeMinAndEnd() {
        assertEquals(-9, calculator.getResult("&-(5,4,3,7) "));
    }

    @Test
    void basisCodeMinAndRandom() {
        assertEquals(0, calculator.getResult("&-(5,4,3,7)aaa5 "));
    }

    @Test
    void basisCodeProdMin() {
        assertEquals(420, calculator.getResult("&*(5,4,3,7)"));
    }

    @Test
    void basisCodeProdAndEnd() {
        assertEquals(420, calculator.getResult("&*(5,4,3,7) "));
    }

    @Test
    void basisCodeProdAndRandom() {
        assertEquals(0, calculator.getResult("&*(5,4,3,7)aaa5 "));
    }

    @Test
    void basisCodeDiv() {
        assertEquals(0.05952381, calculator.getResult("&/(5,4,3,7)"), 0.0001);
    }

    @Test
    void basisCodeDivAndEnd() {
        assertEquals(0.05952381, calculator.getResult("&/(5,4,3,7) "), 0.0001);
    }

    @Test
    void basisCodeDivAndRandom() {
        assertEquals(0, calculator.getResult("&/(5,4,3,7)aaa5 "));
    }

    @Test
    void simpleCodeWithNumbersContaining0() {
        assertEquals(128, calculator.getResult("100,20,8"));
    }

    @Test
    void simpleCodeWith0() {
        assertEquals(5, calculator.getResult("&/(0,20,4,0)"));
    }

    @Test
    void simpleCodeWithAll0() {
        assertEquals(0, calculator.getResult("&/(0,0,0,0)"));
    }
}