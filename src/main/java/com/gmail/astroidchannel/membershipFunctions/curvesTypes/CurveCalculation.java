package com.gmail.astroidchannel.membershipFunctions.curvesTypes;

public class CurveCalculation {
    // public static final TransitionCurve LINEAR = (t, a, b) -> (t - a) / (b - a);
    // public static final TransitionCurve LINEAR = t -> t;
    // public static final TransitionCurve COSINE = t -> 1. / 2 + Math.cos(Math.PI * t) / 2;
    public static final TransitionCurve getLinear(double a, double b) {
        return t -> (t - a) / (b - a);
    }
    public static final TransitionCurve getCosine(double a, double b) {
        return t -> 1.0 / 2.0 + Math.cos(Math.PI * (t - a) / (b - a)) / 2.0;
    }
    public static TransitionCurve getSigmoid(double slope, double inflectionPoint) {
        return t -> 1.0 / (1.0 + Math.exp(-slope * (t - inflectionPoint)));
    }
    public static final TransitionCurve getBell(double a, double b, double c) {
        return t -> 1.0 / (1.0 + Math.pow(Math.abs((t - c) / a), 2 * b));
    }

}
