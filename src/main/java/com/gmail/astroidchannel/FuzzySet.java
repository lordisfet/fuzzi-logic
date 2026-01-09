package com.gmail.astroidchannel;

import com.gmail.astroidchannel.membershipFunctions.MembershipFunction;
import com.gmail.astroidchannel.membershipFunctions.Shape;
import com.google.common.collect.Range;

import java.util.Set;

public class FuzzySet {
    private double height;
    private Range<Double> carrier;
    private Range<Double> core;
    private Set<Range<Double>> spectrum;
    private Shape shape;
    private MembershipFunction membershipFunction;
}
