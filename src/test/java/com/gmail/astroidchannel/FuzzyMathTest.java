package com.gmail.astroidchannel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuzzyMathTest {

    @Test
    void testLinearFalling() {
        double lower = 4.0;
        double upper = 7.0;
        boolean isRising = false;

        // 1. Проверяем граничное значение (Начало) -> Должно быть 1.0 (так как Falling)
        assertEquals(1.0, FuzzyMath.linearThroughDots(4.0, lower, upper, isRising), FuzzyMath.EPS, "В точке start должно быть 1.0");

        // 2. Проверяем граничное значение (Конец) -> Должно быть 0.0
        assertEquals(0.0, FuzzyMath.linearThroughDots(7.0, lower, upper, isRising), FuzzyMath.EPS, "В точке end должно быть 0.0");

        // 3. Проверяем середину -> Должно быть 0.5
        assertEquals(0.5, FuzzyMath.linearThroughDots(5.5, lower, upper, isRising), FuzzyMath.EPS, "В середине должно быть 0.5");

        // 4. Проверяем выход за границы (необязательно, но полезно)
        assertEquals(1, FuzzyMath.linearThroughDots(3.0, lower, upper, isRising), FuzzyMath.EPS, "Слева от отрезка должно быть 1.0");
        assertEquals(0, FuzzyMath.linearThroughDots(8.0, lower, upper, isRising), FuzzyMath.EPS, "Справа от отрезка должно быть 0.0");
    }
}