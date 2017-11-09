package com.study.Class;

import java.lang.reflect.Method;

/**
 * Class.forName 动态加载类  运行时加载
 *
 * @author yksoul
 * @date 2017/2/23
 */
public class TestMain2 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.study.Class.Student");

            System.out.println("类的名称"+c.getName());
             /*
             * getMethods() 获取所有public 的方法，包括父类继承来的
             * getDeclaredMethods 该类所有自己申明的方法，不问访问权限
             *
             * */
            Method[] methods = c.getMethods();
            Method[] declaredMethods = c.getDeclaredMethods();
            for (Method method : methods) {
                // 返回值类型
                Class<?> type = method.getReturnType();
                System.out.print(type.getName()+ "  ");
                // 得到方法的名字
                System.out.print(method.getName() + "(");
                // 获取参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.print(parameterType.getName() + ",");
                }
                System.out.println(")");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
