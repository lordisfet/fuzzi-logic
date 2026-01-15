package com.gmail.astroidchannel;


public final class FuzzyMath {
    public final static double EPS = 0.00001;

    public static double linearThroughDots(double x, double min, double max, boolean isRising) {

        if (min == max) {
            throw new IllegalArgumentException("min cant be equal max for linear function");
        }

        double result = isRising ? (x - min) / (max - min) : (max - x) / (max - min);

        if (Double.compare(result, 0) < 0) {
            return 0;
        }
        if (Double.compare(result, 1) > 0) {
            return 1;
        }
        return result;
    }

    public static double cosine(double x, double min, double max, double phi) {
//        return phi + (1 / phi) * Math.cos(Math.PI * (x - min) / (max - min));
        return phi + (phi * Math.cos(Math.PI * (x - min) / (max - min)));
    }
}
