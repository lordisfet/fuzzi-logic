package com.gmail.astroidchannel.membershipFunctions;

import com.google.common.collect.Range;
import java.util.Set;

public interface MembershipFunction {
    double calculate(double x);
    double findHeight();
    Range<Double> findCarrier();
    Range<Double> findCore();
    Set<Range<Double>> findSpectrum();
    // TODO: isNormal
    // TODO: Normalization
    // TODO: isConvex
}
