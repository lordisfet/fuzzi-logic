package com.gmail.astroidchannel.membershipFunctions;

import com.gmail.astroidchannel.FuzzyMath;
import com.google.common.collect.Range;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class zShaped implements MembershipFunction {
    private double a;
    private double b;
    private double coefficient;

    public zShaped(double a, double b, double coefficient) {
        this.a = a;
        this.b = b;
        this.coefficient = coefficient;
    }

    public zShaped(zShaped other) {
        this.a = other.a;
        this.b = other.b;
        this.coefficient = other.coefficient;
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

    @Override
    public double calculate(double x) {
        if (Double.compare(x, a) <= 0) {
            return 1;
        }
        if (Double.compare(x, b) >= 0) {
            return 0;
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
        return Range.open(0., b);
    }

    @Override
    public Range<Double> findCore() {
        return Range.closed(0., a);
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
        zShaped zShaped = (zShaped) o;
        return Double.compare(a, zShaped.a) == 0 && Double.compare(b, zShaped.b) == 0 && Double.compare(coefficient, zShaped.coefficient) == 0;
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
