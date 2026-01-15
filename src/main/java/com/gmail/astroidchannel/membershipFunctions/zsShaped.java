package com.gmail.astroidchannel.membershipFunctions;

import com.gmail.astroidchannel.FuzzyMath;
import com.google.common.collect.Range;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class zsShaped implements MembershipFunction {
    private double a;
    private double b;
    private double coefficient;
    private boolean isRising;

    public zsShaped(double a, double b, double coefficient, boolean isRising) {
        this.a = a;
        this.b = b;
        this.coefficient = coefficient;
        this.isRising = isRising;
    }

    public zsShaped(zsShaped other) {
        this.a = other.a;
        this.b = other.b;
        this.coefficient = other.coefficient;
        this.isRising = other.isRising;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public boolean isRising() {
        return isRising;
    }

    public void setRising(boolean rising) {
        isRising = rising;
    }

    @Override
    public double calculate(double x) {
        if (Double.compare(x, a) <= 0) {
            return isRising ? 0 : 1;
        }
        if (Double.compare(x, b) >= 0) {
            return isRising ? 1 : 0;
        }
        if (Double.compare(x, a) > 0 && Double.compare(x, b) < 0) {
            return FuzzyMath.cosine(x, a, b, coefficient);
        }

        throw new IllegalArgumentException("x = " + x + " is not in conditions");
    }

    @Override
    public double findHeight() {
        return 1;
    }

    @Override
    public Range<Double> findCarrier() {
        return isRising ? Range.open(a, Double.MAX_VALUE) : Range.open(Double.MIN_VALUE, b);
    }

    @Override
    public Range<Double> findCore() {
        return isRising ? Range.closed(b, Double.MAX_VALUE) : Range.closed(Double.MIN_VALUE, a);
    }

    @Override
    public Set<Range<Double>> findSpectrum() {
        Set<Range<Double>> result = new LinkedHashSet<>();
        result.add((Range.open(a, b)));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        zsShaped zsShaped = (zsShaped) o;
        return Double.compare(a, zsShaped.a) == 0 && Double.compare(b, zsShaped.b) == 0 && Double.compare(coefficient, zsShaped.coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, coefficient);
    }

    @Override
    public String toString() {
        return "zShaped{" +
                "a=" + a +
                ", b=" + b +
                ", coefficient=" + coefficient +
                '}';
    }
}
