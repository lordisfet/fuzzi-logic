package com.gmail.astroidchannel.membershipFunctions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class zShapedTest {

    @Test
    void testZShapedCalculate() {
        double a = 3, b = 6, coefficient = 1. / 2;
        MembershipFunction function = new TriangularFunction(a, b, coefficient);

    }
}