package com.gmail.astroidchannel.membershipFunctions;

public interface XNormalization {
    default double normalization(double x, double min, double max) {
        return (x - min) / (max - min);
    }
}
