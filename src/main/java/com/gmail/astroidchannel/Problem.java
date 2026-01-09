package com.gmail.astroidchannel;

import com.gmail.astroidchannel.membershipFunctions.MembershipFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Problem {
    private double leftBorder;
    private double rightBorder;
    private Map<String, MembershipFunction> sets = new HashMap<>();

    public Problem(double leftBorder, double rightBorder, Map<String, MembershipFunction> sets) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
        this.sets = new HashMap<>(sets);
    }

    public Problem(Problem other) {
        this.leftBorder = other.leftBorder;
        this.rightBorder = other.rightBorder;
        this.sets = new HashMap<>(other.sets);
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    public Map<String, MembershipFunction> getSets() {
        return sets;
    }

    public void setSets(Map<String, MembershipFunction> sets) {
        this.sets = sets;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Double.compare(leftBorder, problem.leftBorder) == 0 && Double.compare(rightBorder, problem.rightBorder) == 0 && Objects.equals(sets, problem.sets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftBorder, rightBorder, sets);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "leftBorder=" + leftBorder +
                ", rightBorder=" + rightBorder +
                ", sets=" + sets +
                '}';
    }
}
