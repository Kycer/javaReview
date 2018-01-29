package com.study.java8.demo;

import java.util.Optional;

/**
 * @author yk
 * @version 1.0 Date: 2017-12-19
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> str = Optional.of("");
        Optional<Integer> i = Optional.ofNullable(null);
        System.out.println(i);
        System.out.println(str);
    }
}
