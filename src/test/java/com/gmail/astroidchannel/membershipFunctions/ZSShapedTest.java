package com.gmail.astroidchannel.membershipFunctions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZSShapedTest {

    @Test
    void testZSShapedCalculation() {
        double a = 3, b = 6, eps = 0.00001;
        MembershipFunction function = new ZSShaped(a, b, true);

        assertEquals(1, function.calculate(a), eps);
        assertEquals(1. / 2, function.calculate((a + b) / 2), eps);
        assertEquals(0.20611, function.calculate(0.85 * b), eps);
        assertEquals(0, function.calculate(b), eps);
    }
}