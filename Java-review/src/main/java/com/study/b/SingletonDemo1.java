package com.study.b;

/**
 *  单例模式 饿汉
 * @author yksoul
 * @date 2017/2/23
 */
public class SingletonDemo1 {

    private SingletonDemo1() {
    }

    private static SingletonDemo1 singletonDemo1 = new SingletonDemo1();

    public static SingletonDemo1 getSingletonDemo1(){
        return singletonDemo1;
    }
}
