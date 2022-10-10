package no.hiof;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMain {
    //////////////////////////////////////// TEST 1 ////////////////////////////////////////
    // Akseptansekriterier:
    //
    //Et år er et skuddår:
    //
    //Når det er delelig med 4, men ikke 100:
    @Order(1)
    @ParameterizedTest
    @MethodSource("parameters_4_100")
    @DisplayName("Test if year IS a leap year when it is divisible by 4, but not 100")
    public void test_year_dividable_with_4_except_year_100_IS_leap_year(int year1, boolean bool1, int year2, boolean bool2) {
        assertEquals2(bool1, Main.isLeapYear(year1), bool2, Main.isLeapYear(year2));
    }
    private void assertEquals2(boolean bool1, boolean leapYear, boolean bool2, boolean leapYear1) {
    }
    public static Stream parameters_4_100() {
        return Stream.of(
                Arguments.of(4, true, 100, false),
                Arguments.of(8, true, 200, false),
                Arguments.of(12, true, 300, false)
        );
    }
    //////////////////////////////////////// TEST 2 ////////////////////////////////////////
    // Akseptansekriterier:
    //
    //Et år er et skuddår

    //Når det er delelig med 400
    //(For eksempel var år 2000 et skuddår)
    @Order(2)
    @ParameterizedTest
    @MethodSource("parameters_400")
    @DisplayName("Test if year IS a leap year when year is divisible with 400")
    public void test_year_dividable_with_400_IS_leap_year(int year, boolean expected) {
        assertEquals(expected, Main.isLeapYear(year));
    }
    public static Stream parameters_400() {
        return Stream.of(
                Arguments.of(400, true),
                Arguments.of(800, true),
                Arguments.of(1200, true),
                Arguments.of(1600, true),
                Arguments.of(2000, true)
        );
    }
    //////////////////////////////////////// TEST 3 ////////////////////////////////////////
    // Et år er ikke et skuddår
    //
    //Når det ikke er delelig med 4
    @Order(3)
    @ParameterizedTest
    @MethodSource("parameters_not_4")
    @DisplayName("Test if year is NOT a leap year when year is not divisible with 4")
    public void test_year_is_not_dividable_with_4_is_NOT_a_leap_year(int year1, boolean bool1) {
        assertEquals(bool1, Main.isLeapYear(year1));
    }
    public static Stream parameters_not_4() {
        return Stream.of(
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(5, false),
                Arguments.of(7, false),
                Arguments.of(11, false),
                Arguments.of(21, false),
                Arguments.of(79, false),
                Arguments.of(3333, false),
                Arguments.of(99, false),
                Arguments.of(-1, false)
        );
    }
    //////////////////////////////////////// TEST 4 ////////////////////////////////////////
    // Et år er ikke et skuddår
    //
    //Når det er delelig med 100, men ikke 400.
    @Order(4)
    @ParameterizedTest
    @MethodSource("parameters_100_400")
    @DisplayName("Test if year is NOT a leap year when year is divisible with 100, but not 400")
    public void test_year_is_dividable_with_100_but_not_400_is_NOT_a_leap_year(int year1, boolean bool1, int year2, boolean bool2) {
        assertEquals2(bool1, Main.isLeapYear(year1), bool2, Main.isLeapYear(year2));
    }
    public static Stream parameters_100_400() {
        return Stream.of(
                Arguments.of(100, true, 400, false),
                Arguments.of(200, true, 800, false),
                Arguments.of(300, true, 1200, false)
        );
    }
    //////////////////////////////////////// TEST 5 ////////////////////////////////////////
    // Et år er ikke et skuddår
    //
    //(For eksempel var ikke 1700, 1800 og 1900 skuddår, ei heller blir 2100 et)
    @Order(5)
    @ParameterizedTest
    @MethodSource("parameters_1700_1800_1900_2100")
    @DisplayName("Test if year is NOT a leap year when year is 1700, 1800, 1900 or 2100")
    public void test_year_is_1700_1800_1900_2100_NOT_a_leap_year(int year, boolean expected) {
        assertEquals(expected, Main.isLeapYear(year));
    }
    public static Stream parameters_1700_1800_1900_2100() {
        return Stream.of(
                Arguments.of(1700, false),
                Arguments.of(1800, false),
                Arguments.of(1900, false),
                Arguments.of(2100, false)
        );
    }
}




