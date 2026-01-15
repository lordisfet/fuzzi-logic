package com.gmail.astroidchannel.membershipFunctions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangularFunctionTest {

    @Test
    void testTriangularCalculation() {
        double a = 2, b = 4, c = 7;
        MembershipFunction function = new TriangularFunction(a, b, c);

        assertEquals(0, function.calculate(1));
        assertEquals(0, function.calculate(a));
        assertEquals(0.5, function.calculate(3));
        assertEquals(1, function.calculate(b));
        assertEquals(1./3, function.calculate(6));
        assertEquals(0, function.calculate(c));
        assertEquals(0, function.calculate(8));
    }


}