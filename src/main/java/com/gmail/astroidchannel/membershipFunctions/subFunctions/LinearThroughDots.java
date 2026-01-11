package com.gmail.astroidchannel.membershipFunctions.subFunctions;

import java.util.Objects;


/**
 * x1 cant be equal x2, throw exception
 * if x1 < x2 value increases from 0 to 1,
 * if x1 > x2 value decreases from 1 to 0,
 **/
public class LinearThroughDots implements SubFunction {
    private double x1;
    private double x2;
    private Direction direction;

    public enum Direction {
        UP,
        DOWN
    }

    public LinearThroughDots() {
    }

    public LinearThroughDots(double x1, double x2, Direction direction) {
        this.x1 = x1;
        this.x2 = x2;
        this.direction = direction;
    }

    public LinearThroughDots(LinearThroughDots other) {
        this.x1 = other.x1;
        this.x2 = other.x2;
        this.direction = other.direction;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public double calculate(double x) {
        if (x1 == x2) {
            throw new IllegalArgumentException("x1 cant be equal x2 for linear function");
        }

        if (direction == Direction.UP) {
            return (x - x1) / (x2 - x1);
        }
        if (direction == Direction.DOWN) {
            return (x2 - x) / (x2 - x1);
        }

        throw new IllegalArgumentException("Unexpected direction: " + direction);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LinearThroughDots that = (LinearThroughDots) o;
        return Double.compare(x1, that.x1) == 0 && Double.compare(x2, that.x2) == 0 && direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, direction);
    }

    @Override
    public String toString() {
        return "LinearThroughDots{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", direction=" + direction +
                '}';
    }
}
