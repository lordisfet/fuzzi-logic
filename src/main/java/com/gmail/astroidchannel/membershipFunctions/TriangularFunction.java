package com.gmail.astroidchannel.membershipFunctions;

import java.util.Objects;

public class TriangularFunction implements MembershipFunction {
    private double a;
    private double b;
    private double c;

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
        return 0;
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
