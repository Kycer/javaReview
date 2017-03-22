package com.study.a;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(1);
        buffer.append('a');
        buffer.append("ABC");
        buffer.append(1.2);
        System.out.println(buffer.toString());
    }
}
