package com.study.annotation.a;

import java.lang.annotation.*;

/**
 * @author yksoul
 * @date 2017/2/23
 */
/*
* @Target(ElementType.TYPE)   //接口、类、枚举、注解
* @Target(ElementType.FIELD) //字段、枚举的常量
* @Target(ElementType.METHOD) //方法
* @Target(ElementType.PARAMETER) //方法参数
* @Target(ElementType.CONSTRUCTOR)  //构造函数
* @Target(ElementType.LOCAL_VARIABLE)//局部变量
* @Target(ElementType.ANNOTATION_TYPE)//注解
* @Target(ElementType.PACKAGE) ///包
* */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
/*
* SOURCE: 注解仅存在于源码中，在class字节码文件中不包含
* CLASS: 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获
* RUNTIME: 注解会在class字节码文件中存在，在运行时可以通过反射获取到
* */
@Retention(RetentionPolicy.RUNTIME)
// 允许子类继承
@Inherited
// 表明这个注解应该被 javadoc工具记录
@Documented
public @interface TestAnn {
    String value();
}
