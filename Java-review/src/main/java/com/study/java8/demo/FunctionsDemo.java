package com.study.java8.demo;

import java.util.function.Function;

/**
 * Function接口接收一个参数，并返回单一的结果。默认方法可以将多个函数串在一起（compse, andThen）
 *
 * @author yk
 * @version 1.0 Date: 2017-12-19
 */
public class FunctionsDemo {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        Integer apply = toInteger.apply("123");
        String apply1 = backToString.apply("123");
        System.out.println(apply);     // 123
        System.out.println(apply1);     // "123"

    }
}
