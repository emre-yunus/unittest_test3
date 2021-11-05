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
    void simpleCodeParentheses() {
        assertEquals(19, calculator.getResult("(5,4,3,7)"));
    }

    @Test
    void emptyCodeParentheses() {
        assertEquals(0, calculator.getResult("()"));
    }

    @Test
    void basisCodePlus() {
        assertEquals(19, calculator.getResult("&+(5,4,3,7)"));
    }

    @Test
    void basisCodePlusAndEnd() {
        assertEquals(0, calculator.getResult("&+(5,4,3,7) "));
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
        assertEquals(0, calculator.getResult("&-(5,4,3,7) "));
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
        assertEquals(0, calculator.getResult("&*(5,4,3,7) "));
    }

    @Test
    void basisCodeProdAndRandom() {
        assertEquals(0, calculator.getResult("&*(5,4,3,7)aaa5 "));
    }

    @Test
    void basisCodeDiv() {
        assertEquals(0.05952381, calculator.getResult("&/(5,4,3,7)"), 0.001);
    }

    @Test
    void basisCodeDivAndEnd() {
        assertEquals(0, calculator.getResult("&/(5,4,3,7) "));
    }

    @Test
    void basisCodeDivAndRandom() {
        assertEquals(0, calculator.getResult("&/(5,4,3,7)aaa5 "));
    }
}