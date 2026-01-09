package com.gmail.astroidchannel;

import com.google.common.collect.Range;

import java.util.Set;

public interface FuzzySetCharacteristics {
    double findHeight();
    Range<Double> findCarrier();
    Range<Double> findCore();
    Set<Range<Double>> findSpectrum();
    // TODO: isNormal
    // TODO: Normalization
    // TODO: isConvex
}
