package com.study.Class;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class Student {
    private int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void say() {
        System.out.println("Hello World!");
    }

    private void say2() {
        System.out.println("Hello private World");
    }

    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b){
        System.out.println(a.toUpperCase() + "," +b.toLowerCase());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
