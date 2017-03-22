package com.study.b;

/**
 *  单例模式 饱汉 线程安全
 * @author yksoul
 * @date 2017/2/23
 */
public class SingletonDemo3 {

    private SingletonDemo3() {
    }

    private static SingletonDemo3 singletonDemo3;

    public static synchronized SingletonDemo3 getSingletonDemo1(){
        if(singletonDemo3 == null){
            singletonDemo3 = new SingletonDemo3();
        }
        return singletonDemo3;
    }
}
