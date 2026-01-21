package com.gmail.astroidchannel.membershipFunctions.curvesTypes;

public class CurveCalculation {
    //        public static final TransitionCurve LINEAR = (t, a, b) -> (t - a) / (b - a);
    public static final TransitionCurve LINEAR = t -> t;
    public static final TransitionCurve COSINE = t -> 1. / 2 + Math.cos(Math.PI * t) / 2;
    public static TransitionCurve getSigmoid(double slope, double inflectionPoint) {
        return t -> 1.0 / (1.0 + Math.exp(-slope * (t - inflectionPoint)));
    }

}
