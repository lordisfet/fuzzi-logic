package com.gmail.astroidchannel.membershipFunctions.curvesTypes;

@FunctionalInterface
public interface TransitionCurve {
    double calculate(double t);
}
