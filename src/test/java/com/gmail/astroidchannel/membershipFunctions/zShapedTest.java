package com.gmail.astroidchannel.membershipFunctions;

import com.gmail.astroidchannel.FuzzyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class zShapedTest {

    @Test
    void testZShapedCalculate() {
        double a = 3, b = 6, coefficient = 1. / 2;
        MembershipFunction function = new zsShaped(a, b, coefficient, false);

        assertEquals(1, function.calculate(0), FuzzyMath.EPS);
        assertEquals(1, function.calculate(2), FuzzyMath.EPS);
        assertEquals(1, function.calculate(a), FuzzyMath.EPS);
        assertEquals(1./2, function.calculate(4.5), FuzzyMath.EPS);
        assertEquals(1./4, function.calculate(5), FuzzyMath.EPS);
        assertEquals(0, function.calculate(b), FuzzyMath.EPS);
        assertEquals(0, function.calculate(7), FuzzyMath.EPS);
    }
}