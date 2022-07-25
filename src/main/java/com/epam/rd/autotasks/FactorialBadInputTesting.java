package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialBadInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testNullInput(){
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(null));
    }

    @Test
    void testNegativeInput(){
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("-1"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("-3"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("-5"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("-7"));
    }

    @Test
    void testFractionalInput(){
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("3.14159"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("7.777"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("0.1"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("1.1"));
    }

    @Test
    void testNonDigitalInput(){
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("hello"));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(""));
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial("java"));
    }


}
