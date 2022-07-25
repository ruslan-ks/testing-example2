package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Factorial {
    public String factorial(String n) {
        if(n == null) {
            throw new IllegalArgumentException();
        }
        // Since NumberFormatException extends IllegalArgumentException, parseInt exception handling can be omitted.
        final int value = Integer.parseInt(n);
        if(value < 0) {
            throw new IllegalArgumentException();
        }
        return String.valueOf(recursiveFactorialImpl(value));
    }

    private BigInteger recursiveFactorialImpl(int n) {
        if(n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(recursiveFactorialImpl(n - 1));
    }
}
