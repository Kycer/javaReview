package com.study.java8.demo.functional;

/**
 * @author yk
 * @version 1.0 Date: 2017-12-19
 */
public class test {
    public static void main(String[] args) {
        a<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        a<String, Integer> a = Integer::valueOf;
        Integer b = a.convert("123");
        System.out.println(b);   // 123
    }
}
