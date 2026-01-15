package com.gmail.astroidchannel.membershipFunctions;

import com.gmail.astroidchannel.FuzzyMath;
import com.google.common.collect.Range;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class zShaped implements MembershipFunction {
    private double coefficient;
    private double a;
    private double b;

    public zShaped(double coefficient, double a, double b) {
        this.coefficient = coefficient;
        this.a = a;
        this.b = b;
    }

    public zShaped(zShaped other) {
        this.coefficient = other.coefficient;
        this.a = other.a;
        this.b = other.b;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
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
        return Double.compare(coefficient, zShaped.coefficient) == 0 && Double.compare(a, zShaped.a) == 0 && Double.compare(b, zShaped.b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient, a, b);
    }

    @Override
    public String toString() {
        return "zShaped{" +
                "coefficient=" + coefficient +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
