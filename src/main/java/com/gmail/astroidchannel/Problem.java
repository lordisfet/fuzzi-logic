package com.gmail.astroidchannel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Problem {
    private Map<String, FuzzySet> sets = new HashMap<>();

    public Problem(Map<String, FuzzySet> sets) {
        this.sets = sets;
    }

    public Problem(Problem other) {
        this.sets = new HashMap<>(other.sets);
    }

    public Map<String, FuzzySet> getSets() {
        return sets;
    }

    public void setSets(Map<String, FuzzySet> sets) {
        this.sets = sets;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Objects.equals(sets, problem.sets);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sets);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "sets=" + sets +
                '}';
    }
}
