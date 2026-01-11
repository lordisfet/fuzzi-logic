package com.gmail.astroidchannel.membershipFunctions;

import com.google.common.collect.Range;

import java.util.Set;

public class zShaped implements MembershipFunction {


    @Override
    public double calculate(double x) {
        return 0;
    }

    @Override
    public double findHeight() {
        return 0;
    }

    @Override
    public Range<Double> findCarrier() {
        return null;
    }

    @Override
    public Range<Double> findCore() {
        return null;
    }

    @Override
    public Set<Range<Double>> findSpectrum() {
        return Set.of();
    }
}
