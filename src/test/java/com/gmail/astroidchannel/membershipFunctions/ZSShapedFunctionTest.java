package com.gmail.astroidchannel.membershipFunctions;

import com.gmail.astroidchannel.membershipFunctions.curvesTypes.CurveCalculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZSShapedFunctionTest {

    @Test
    void calculate() {
        double a = 3, b = 6, eps = 0.00001;
        MembershipFunction function1 = new ZSShapedFunction(a, b, ZSShapedFunction.Shape.Z, CurveCalculation.COSINE);

        assertEquals(1, function1.calculate(a-1), eps);
        assertEquals(1, function1.calculate(a), eps);
        assertEquals(1. / 2, function1.calculate((a + b) / 2), eps);
        assertEquals(0.20611, function1.calculate(0.85 * b), eps);
        assertEquals(0, function1.calculate(b), eps);
        assertEquals(0, function1.calculate(b + 1), eps);

        MembershipFunction function2 = new ZSShapedFunction(a, b, ZSShapedFunction.Shape.S, CurveCalculation.COSINE);

        assertEquals(0, function2.calculate(a-1), eps);
        assertEquals(0, function2.calculate(a), eps);
        assertEquals(1. / 2, function2.calculate((a + b) / 2), eps);
        assertEquals(1 - 0.20611, function2.calculate(0.85 * b), eps);
        assertEquals(1, function2.calculate(b), eps);
        assertEquals(1, function2.calculate(b + 1), eps);
    }
}