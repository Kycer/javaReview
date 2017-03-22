package com.study.a;

/**
 * @author yksoul
 * @date 2017/2/23
 */

class Fu{
    String a = "A";
    static {
        System.out.println("父类static块");
    }
    public Fu() {
        System.out.println("这是父类的构造方法");
    }
}
public class extendsDemo extends Fu{
    String a = "B";
    static{
        System.out.println("子类static块");
    }
    public extendsDemo() {
        super();
        System.out.println("这是子类的构造方法");
    }

    public static void main(String[] args) {
        extendsDemo demo = new extendsDemo();
        System.out.println("a = " + demo.a);
    }
}


