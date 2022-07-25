package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("invalidStringCases")
    public void testInvalidStringCases(String input) {
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(input));
    }

    private static Stream<String> invalidStringCases() {
        return Stream.of("java", "-", "hello5", "3!", "5G", "@");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:2", "3:6", "4:24", "5:120", "10:3628800", "13:6227020800"}, delimiter = ':')
    public void testRegularIntegerCases(String input, String expected) {
        assertEquals(expected, factorial.factorial(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/negativeCases.csv")
    public void testNegativeCases(String input) {
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(input));
    }
}
