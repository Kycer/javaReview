package com.study.a;

import java.time.LocalDate;
import java.util.Random;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class commonClassDemo {
    public static void main(String[] args) {
//        CharacterDemo();
//        MathDemo();
        DateDemo();
    }


    public static void DateDemo(){
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }

    public static void RandomDemo(){
        // 创建对象
        Random r = new Random();
        for (int x = 0; x < 10; x++) {
            // int num = r.nextInt();//返回的是int范围内的随机数
            int num = r.nextInt(100) + 1;//本来返回的是[0,100)范围的内随机数，+1后返回[1,100)
            System.out.println(num);
        }

        //创建对象,给出指定的种子
        Random r2 = new Random(123);
        for (int x = 0; x < 10; x++) {
            int num = r2.nextInt(100) + 1;
            System.out.println(num);//给定种子后，每次得到的随机数是相同的。
        }
    }

    public static void MathDemo(){
        // public static final double PI
        System.out.println("PI:" + Math.PI);//PI:3.141592653589793
        // public static final double E
        System.out.println("E:" + Math.E);//E:2.718281828459045

        // public static int abs(int a)：绝对值
        System.out.println("abs:" + Math.abs(10));
        System.out.println("abs:" + Math.abs(-10));

        // public static double ceil(double a):向上取整
        System.out.println("ceil:" + Math.ceil(12.34));//13.0
        System.out.println("ceil:" + Math.ceil(12.56));//13.0

        // public static double floor(double a):向下取整
        System.out.println("floor:" + Math.floor(12.34));//12.0
        System.out.println("floor:" + Math.floor(12.56));//12.0

        // public static int max(int a,int b):最大值
        System.out.println("max:" + Math.max(12, 23));//23
        // 获取三个数据中的最大值
        // 方法的嵌套调用
        System.out.println("max:" + Math.max(Math.max(12, 23), 18));
        // 获取四个数据中的最大值
        System.out.println("max:"+ Math.max(Math.max(12, 78), Math.max(34, 56)));

        // public static double pow(double a,double b):a的b次幂
        System.out.println("pow:" + Math.pow(2, 3));

        // public static double random():随机数 [0.0,1.0)
        System.out.println("random:" + Math.random());
        // 获取一个1-100之间的随机数
        System.out.println("random:" + ((int) (Math.random() * 100) + 1));

        // public static int round(float a) 四舍五入(参数为double的自学)
        System.out.println("round:" + Math.round(12.34f));//12
        System.out.println("round:" + Math.round(12.56f));//13

        //public static double sqrt(double a):正平方根
        System.out.println("sqrt:"+Math.sqrt(4));
    }

    public static void CharacterDemo(){
        // public static boolean isUpperCase(char ch):判断给定的字符是否是大写字符
        System.out.println("isUpperCase:" + Character.isUpperCase('A'));
        System.out.println("isUpperCase:" + Character.isUpperCase('a'));
        System.out.println("isUpperCase:" + Character.isUpperCase('0'));

        // public static boolean isLowerCase(char ch):判断给定的字符是否是小写字符
        System.out.println("isLowerCase:" + Character.isLowerCase('A'));
        System.out.println("isLowerCase:" + Character.isLowerCase('a'));
        System.out.println("isLowerCase:" + Character.isLowerCase('0'));

        // public static boolean isDigit(char ch):判断给定的字符是否是数字字符
        System.out.println("isDigit:" + Character.isDigit('A'));
        System.out.println("isDigit:" + Character.isDigit('a'));
        System.out.println("isDigit:" + Character.isDigit('0'));

        // public static char toUpperCase(char ch):把给定的字符转换为大写字符
        System.out.println("toUpperCase:" + Character.toUpperCase('A'));
        System.out.println("toUpperCase:" + Character.toUpperCase('a'));

        // public static char toLowerCase(char ch):把给定的字符转换为小写字符
        System.out.println("toLowerCase:" + Character.toLowerCase('A'));
        System.out.println("toLowerCase:" + Character.toLowerCase('a'));
    }
}
