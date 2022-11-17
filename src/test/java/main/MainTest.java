package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("checkOperationNum -> 0")
    public void checkOperationNumTest1() {
        assertTrue(Main.checkOperationNum(0));
    }

    @Test
    @DisplayName("checkOperationNum -> 6")
    public void checkOperationNumTest2() {
        assertTrue(Main.checkOperationNum(6));
    }

    @Test
    @DisplayName("checkOperationNum -> 2")
    public void checkOperationNumTest3() {
        assertFalse(Main.checkOperationNum(2));
    }

    @Test
    @DisplayName("checkOperationNum -> 4")
    public void checkOperationNumTest4() {
        assertFalse(Main.checkOperationNum(4));
    }

    @Test
    @DisplayName("readOperationNum -> 1")
    public void readOperationNum() {
        assertEquals(1, Main.readOperationNum(new Scanner("1")));
    }

    @Test
    @DisplayName("7 + 11 = 18")
    public void additionTest1() {
        assertEquals(18, Main.addition(new int[]{7, 11}));
    }

    @Test
    @DisplayName("-7 + 11 = 18")
    public void additionTest2() {
        assertEquals(4, Main.addition(new int[]{-7, 11}));
    }

    @Test
    @DisplayName("7 - 11 = -4")
    public void subtractionTest1() {
        assertEquals(-4, Main.subtraction(new int[]{7, 11}));
    }

    @Test
    @DisplayName("-7 - 11 = -18")
    public void subtractionTest2() {
        assertEquals(-18, Main.subtraction(new int[]{-7, 11}));
    }

    @Test
    @DisplayName("7 * 11 = 77")
    public void multiplicationTest1() {
        assertEquals(77, Main.multiplication(new int[]{7, 11}));
    }

    @Test
    @DisplayName("-7 * 11 = -77")
    public void multiplicationTest2() {
        assertEquals(-77, Main.multiplication(new int[]{-7, 11}));
    }

    @Test
    @DisplayName("7 / 11 = 0")
    public void divisionTest1() {
        assertEquals(0, Main.division(new int[]{7, 11}));
    }

    @Test
    @DisplayName("11 / 7 = 1")
    public void divisionTest2() {
        assertEquals(1, Main.division(new int[]{11, 7}));
    }

    @Test
    @DisplayName("0 / 7 = 0")
    public void divisionTest3() {
        assertEquals(0, Main.division(new int[]{0, 7}));
    }

//  Baszakodás
//    @Test
//    @DisplayName("readSecondNumberTest1")
//    public void readSecondNumberTest1() {
////        int secondNum = 1;
//        new Scanner("1");
//        assertEquals("", byteArrayOutputStream.toString().trim());
//    }
//
//    @Test
//    @DisplayName("readSecondNumberTest2")
//    public void readSecondNumberTest2() {
//        assertEquals(0, new Scanner(1));
//    }

}