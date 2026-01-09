package com.gmail.astroidchannel;

import com.gmail.astroidchannel.membershipFunctions.MembershipFunction;
import com.gmail.astroidchannel.membershipFunctions.Shape;
import com.google.common.collect.Range;

import java.util.Set;

public class FuzzySet implements FuzzySetCharacteristics {
    private double height;
    private Range<Double> carrier;
    private Range<Double> core;
    private Set<Range<Double>> spectrum;
    private Shape shape;
    private MembershipFunction membershipFunction;

    public FuzzySet(double height, Range<Double> carrier, Range<Double> core, Set<Range<Double>> spectrum, Shape shape, MembershipFunction membershipFunction) {
        this.height = height;
        this.carrier = carrier;
        this.core = core;
        this.spectrum = spectrum;
        this.shape = shape;
        this.membershipFunction = membershipFunction;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Range<Double> getCarrier() {
        return carrier;
    }

    public void setCarrier(Range<Double> carrier) {
        this.carrier = carrier;
    }

    public Range<Double> getCore() {
        return core;
    }

    public void setCore(Range<Double> core) {
        this.core = core;
    }

    public Set<Range<Double>> getSpectrum() {
        return spectrum;
    }

    public void setSpectrum(Set<Range<Double>> spectrum) {
        this.spectrum = spectrum;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public MembershipFunction getMembershipFunction() {
        return membershipFunction;
    }

    public void setMembershipFunction(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
