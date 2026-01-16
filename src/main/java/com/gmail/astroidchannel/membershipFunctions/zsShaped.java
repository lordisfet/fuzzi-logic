package com.gmail.astroidchannel.membershipFunctions;

import com.gmail.astroidchannel.FuzzyMath;
import com.google.common.collect.Range;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class ZSShaped implements MembershipFunction {
    private static final double phi = 1./2;
    private static final double beta = 1./2;
    private double a;
    private double b;
    private boolean isZShaped;

    public ZSShaped(double a, double b, boolean isZShaped) {
        this.a = a;
        this.b = b;
        this.isZShaped = isZShaped;
    }

    public ZSShaped(ZSShaped other) {
        this.a = other.a;
        this.b = other.b;
        this.isZShaped = other.isZShaped;
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

    public boolean isZShaped() {
        return isZShaped;
    }

    public void setZShaped(boolean ZShaped) {
        isZShaped = ZShaped;
    }

    @Override
    public double calculate(double x) {
        if (Double.compare(x, a) <= 0) {
            return isZShaped ? 1 : 0;
        }
        if (Double.compare(x, b) >= 0) {
            return isZShaped ? 0 : 1;
        }
        if (Double.compare(x, a) > 0 && Double.compare(x, b) < 0) {
            return FuzzyMath.cosine(x, a, b, phi, beta);
        }

        throw new IllegalArgumentException("x = " + x + " is not in conditions");
    }

    @Override
    public double findHeight() {
        return 1;
    }

    @Override
    public Range<Double> findCarrier() {
        return isZShaped ? Range.open(Double.MIN_VALUE, b) : Range.open(a, Double.MAX_VALUE);
    }

    @Override
    public Range<Double> findCore() {
        return isZShaped ? Range.closed(Double.MIN_VALUE, a) : Range.closed(b, Double.MAX_VALUE);
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
        ZSShaped zsShaped = (ZSShaped) o;
        return Double.compare(a, zsShaped.a) == 0 && Double.compare(b, zsShaped.b) == 0 && isZShaped == zsShaped.isZShaped;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, isZShaped);
    }

    @Override
    public String toString() {
        return "ZSShaped{" +
                "a=" + a +
                ", b=" + b +
                ", isZShaped=" + isZShaped +
                '}';
    }
}
