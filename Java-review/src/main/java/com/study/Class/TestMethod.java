package com.study.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class TestMethod {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.study.Class.Student");
            Student stu = (Student) c.newInstance();

            Method m = c.getMethod("print", new Class[]{int.class, int.class});
//            Method m = c.getMethod("print", int.class, int.class);
            Object invoke = m.invoke(stu, new Object[]{new Integer(20), new Integer(20)});
            m.invoke(stu, 20, 10);

            System.out.println("===============================");

            Constructor constructor = c.getConstructor(int.class, String.class);
            Student st = (Student) constructor.newInstance(20, "小明");
            System.out.println(st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
