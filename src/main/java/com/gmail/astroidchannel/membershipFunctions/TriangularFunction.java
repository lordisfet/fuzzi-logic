package com.gmail.astroidchannel.membershipFunctions;

import com.google.common.collect.Range;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class TriangularFunction implements MembershipFunction {
    private double a;
    private double b;
    private double c;
//    private double height;
//    private Range<Double> carrier;
//    private Range<Double> core;
//    private Set<Range<Double>> spectrum;
//    private Shape shape; // Опуклість
//    private MembershipFunction membershipFunction;

    public TriangularFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TriangularFunction(TriangularFunction other) {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
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

    @Override
    public double calculate(double x) {
        if (Double.compare(x, a) <= 0) {
            return 0;
        }
        if (Double.compare(x, c) >= 0) {
            return 0;
        }
        if (Double.compare(x, a) > 0 && Double.compare(x, b) <= 0) {
            return (x - a) / (b - a);
        }
        if (Double.compare(x, b) > 0 && Double.compare(x, c) <= 0) {
            return (c - x) / (c - b);
        }

        throw new IllegalArgumentException("x = " + x + " is not in conditions");
    }

    @Override
    public double findHeight() {
        return calculate(b);
    }

    @Override
    public Range<Double> findCarrier() {
        return Range.open(a, c);
    }

    @Override
    public Range<Double> findCore() {
        return Range.closed(b, b);
    }

    @Override
    public Set<Range<Double>> findSpectrum() {
        Set<Range<Double>> boundaries = new LinkedHashSet<>();
        boundaries.add(Range.open(a,b));
        boundaries.add(Range.open(b,c));

        return boundaries;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TriangularFunction that = (TriangularFunction) o;
        return Double.compare(a, that.a) == 0 && Double.compare(b, that.b) == 0 && Double.compare(c, that.c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "TriangularFunction{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
