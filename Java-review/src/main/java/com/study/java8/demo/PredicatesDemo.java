package com.study.java8.demo;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Predicate是一个布尔类型的函数，该函数只有一个输入参数。
 * Predicate接口包含了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）
 *
 * @author yk
 * @version 1.0 Date: 2017-12-19
 */
public class PredicatesDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));
        System.out.println(predicate.negate().test("foo"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println(isEmpty.test("1"));
        System.out.println(isNotEmpty.test("1"));
    }
}
