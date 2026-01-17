package com.gmail.astroidchannel.membershipFunctions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrapezoidalFunctionTest {

    @Test
    void calculate() {
        double a = 1, b = 3, c = 5, d = 8;
        MembershipFunction function = new TrapezoidalFunction(a, b, c, d);

        assertEquals(0, function.calculate(-10));
        assertEquals(0, function.calculate(0));
        assertEquals(0, function.calculate(a));
        assertEquals(1. / 2, function.calculate(2));
        assertEquals(1, function.calculate(b));
        assertEquals(1, function.calculate(4));
        assertEquals(1, function.calculate(c));
        assertEquals(2. / 3, function.calculate(6));
        assertEquals(0, function.calculate(d));
    }
}