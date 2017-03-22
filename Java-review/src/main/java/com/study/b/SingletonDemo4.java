package com.study.b;

/**
 *  单例模式 最优解决
 * @author yksoul
 * @date 2017/2/23
 */
public class SingletonDemo4 {

    private SingletonDemo4() {
    }

    private static volatile SingletonDemo4 singletonDemo4;

    public static synchronized SingletonDemo4 getSingletonDemo1(){
        // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
        if(singletonDemo4 == null){
            synchronized (SingletonDemo4.class) {
                //未初始化，则初始instance变量
                if (singletonDemo4 == null) {
                    singletonDemo4 = new SingletonDemo4();
                }
            }
        }
        return singletonDemo4;
    }
}
