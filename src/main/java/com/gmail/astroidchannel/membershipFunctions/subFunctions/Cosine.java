package com.gmail.astroidchannel.membershipFunctions.subFunctions;

import java.util.Objects;

public class Cosine implements SubFunction {
    private double phi;
    private double coefficient;
    private double x1;
    private double x2;

    public Cosine(double phi, double coefficient, double x1, double x2) {
        this.phi = phi;
        this.coefficient = coefficient;
        this.x1 = x1;
        this.x2 = x2;
    }

    public Cosine(Cosine other) {
        this.phi = other.phi;
        this.coefficient = other.coefficient;
        this.x1 = other.x1;
        this.x2 = other.x2;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    @Override
    public double calculate(double x) {
        return phi + coefficient * Math.cos(Math.PI * (x - x1) / (x2 - x1));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cosine cosine = (Cosine) o;
        return Double.compare(phi, cosine.phi) == 0 && Double.compare(coefficient, cosine.coefficient) == 0 && Double.compare(x1, cosine.x1) == 0 && Double.compare(x2, cosine.x2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phi, coefficient, x1, x2);
    }

    @Override
    public String toString() {
        return "Cosine{" +
                "phi=" + phi +
                ", coefficient=" + coefficient +
                ", a=" + x1 +
                ", b=" + x2 +
                '}';
    }
}
