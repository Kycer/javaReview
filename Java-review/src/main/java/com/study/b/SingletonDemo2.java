package com.study.b;

/**
 *  单例模式 懒汉
 * @author yksoul
 * @date 2017/2/23
 */
public class SingletonDemo2 {

    private SingletonDemo2() {
    }

    private static SingletonDemo2 singletonDemo2 = null;

    public static SingletonDemo2 getSingletonDemo1(){
        if(singletonDemo2 == null){
            singletonDemo2 = new SingletonDemo2();
        }
        return singletonDemo2;
    }
}
