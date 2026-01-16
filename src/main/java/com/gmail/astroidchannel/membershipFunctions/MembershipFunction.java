package com.gmail.astroidchannel.membershipFunctions;

import com.google.common.collect.Range;

import java.util.Set;

public interface MembershipFunction {
    double calculate(double x);

    double findHeight();

    Range<Double> findCarrier();

    Range<Double> findCore();

    //TODO: Maybe i can tree use a simple analise with searching max/min value of function in exchange for the override methods
    Set<Range<Double>> findSpectrum();
    // TODO: isNormal
    // TODO: Normalization
    // TODO: isConvex
    // TODO: findAlphaLevelSet
}
