package com.gmail.astroidchannel.membershipFunctions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SigmoidFunctionTest {

    @Test
    void calculate() {
        double a = 3, b = 6, eps = 0.00001;
        MembershipFunction function = new SigmoidFunction(3, 6);

        assertEquals(0.000123394575986, function.calculate(a), eps);
        assertEquals(0.0109869426306, function.calculate((a + b) / 2), eps);
        assertEquals(0.973403006423, function.calculate(1.2 * b), eps);
        assertEquals(1. / 2, function.calculate(b), eps);
    }
}