package com.gmail.astroidchannel;


public final class FuzzyMath {
    public final static double EPS = 0.00001;

    public static double linearThroughDots(double x, double min, double max, boolean isRising) {

        if (min == max) {
            throw new IllegalArgumentException("min cant be equal max for linear function");
        }

        if (isRising) {
            return (x - min) / (max - min);
        } else
            return (max - x) / (max - min);
    }

    public static double cosine(double x, double min, double max, double phi) {
        return phi + (1 / phi) * Math.cos(Math.PI * (x - min) / (max - min));
    }
}
