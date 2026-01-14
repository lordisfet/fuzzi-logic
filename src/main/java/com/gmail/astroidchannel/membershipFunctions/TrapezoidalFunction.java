package com.gmail.astroidchannel.membershipFunctions;

import com.gmail.astroidchannel.FuzzyMath;
import com.google.common.collect.Range;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class TrapezoidalFunction implements MembershipFunction {
    private double a;
    private double b;
    private double c;
    private double d;

    public TrapezoidalFunction(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public TrapezoidalFunction(TrapezoidalFunction other) {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
        this.d = other.d;
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public double calculate(double x) {
        if (Double.compare(x, a) <= 0) {
            return 0;
        }
        if (Double.compare(x, d) >= 0) {
            return 0;
        }
        if (Double.compare(x, b) >= 0 && Double.compare(x,c) <= 0) {
            return 1;
        }
        if (Double.compare(x, a) > 0 && Double.compare(x, b) <= 0) {
            return FuzzyMath.linearThroughDots(x, a, b, true);
        }
        if (Double.compare(x, c) > 0 && Double.compare(x, d) <= 0) {
            return FuzzyMath.linearThroughDots(x, c, d, false);
        }

        throw new IllegalArgumentException("x = " + x + " is not in conditions");
    }

    @Override
    public double findHeight() {
        return calculate(b);
    }

    @Override
    public Range<Double> findCarrier() {
        return Range.open(a, d);
    }

    @Override
    public Range<Double> findCore() {
        return Range.closed(b, c);
    }

    @Override
    public Set<Range<Double>> findSpectrum() {
        Set<Range<Double>> boundaries = new LinkedHashSet<>();
        boundaries.add(Range.open(a,b));
        boundaries.add(Range.open(b,d));

        return boundaries;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrapezoidalFunction that = (TrapezoidalFunction) o;
        return Double.compare(a, that.a) == 0 && Double.compare(b, that.b) == 0 && Double.compare(c, that.c) == 0 && Double.compare(d, that.d) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public String toString() {
        return "TrapezoidalFunction{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
