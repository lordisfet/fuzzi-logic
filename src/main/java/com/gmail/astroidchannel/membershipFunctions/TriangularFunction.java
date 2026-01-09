package com.gmail.astroidchannel.membershipFunctions;

import com.google.common.collect.Range;

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
//    private Shape shape;
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
