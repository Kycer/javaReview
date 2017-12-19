package com.study.java8.demo.functional;

/**
 * @author yk
 * @version 1.0 Date: 2017-12-19
 */
@FunctionalInterface
public interface a<F, T> {
    T convert(F from);
}
