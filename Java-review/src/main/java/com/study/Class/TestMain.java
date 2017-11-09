package com.study.Class;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class TestMain {
    public static void main(String[] args) {
        try {

            Student student = new Student();

            Class c0 = Student.class;

            Class c1 = student.getClass();

            Class c2 = Class.forName("com.study.Class.Student");

            // 通过无参数构造方法 创建实例
            Student instance = (Student)c2.newInstance();
            instance.say();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
