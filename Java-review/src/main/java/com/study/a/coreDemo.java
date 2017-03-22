package com.study.a;


import java.util.Scanner;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class coreDemo {

    public static void main(String[] args) {
        byte a = 1;
        short b = 1;
        int c = 1;
        long d = 1;
        float e = 1.123f;
        double f = 3.1415;
        char g = 'A';
        boolean h = true;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        hexDemo();
        System.out.println("--------------------------------------");
        yunSuan();

//        suShu();
//        suShu2();
//        chengfabiao();
//        sanjiao();
//        daosanjiao();
//        shuxianhua();
    }

    public static void shuxianhua(){

        while (true){
            System.out.print("请输入一个三位数：");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if(Integer.toString(input).length() != 3){
                System.out.println("输入的数字错误");
                continue;
            }
            int g = input%10;
            int s = input/10%10;
            int b = input/100;
            if(g*g*g + s*s*s + b*b*b == input){
                System.out.println(input + "是水仙花数！");
                return ;
            }else{
                System.out.println(input + "不是水仙花数！");
            }

        }
    }

    public static void sanjiao(){
        for (int i = 1; i <= 5; i++){
            for (int k = 0; k < 5 - i; k++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void daosanjiao(){
        for (int i = 5; i>=1; i --){
            for (int k = 5-i; k>0; k --){
                System.out.print(" ");
            }
            for (int j=i; j>=1; j--){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void hexDemo() {
        System.out.println(0b100);
        System.out.println(0100);
        System.out.println(100);
        System.out.println(0x100);
    }

    public static void yunSuan() {
        System.out.println(5 >> 2);
        System.out.println(7 << 3);
        System.out.println(5 >>> 2);
        String s = Integer.toBinaryString(3);
        String s1 = Integer.toBinaryString(4);
        System.out.print(s + " & " + s1);
        System.out.println(3&4);
        System.out.println("Integer.toHexString(3)=   "+Integer.toHexString(3));
        System.out.println("Integer.toOctalString(3)=   "+Integer.toOctalString(3));
        System.out.println("Integer.toUnsignedString(3)=   "+Integer.toUnsignedString(3));
        System.out.println(3|4);
        System.out.println(4^3);
        System.out.println(~6);
    }

    public static void suShu(){
        boolean isprime = true;
        int count = 0;
        for (int i =2; i <= 100000; i++){
           for (int j = 2; j < i; j++){
               if((i % j) == 0){
                   isprime = false;
                   break;
               }
           }
           if(isprime){
               count ++;
               System.out.print(i + "   ");
               if(count % 10 == 0){
                   System.out.println();
               }
           }
            isprime = true;
        }
    }

    public static void suShu2(){
        int count = 0;
        for (int i = 2; i <= 100000; i++){
            int temp = (int) Math.sqrt(i);

            if(i <= 3){
                count ++;
                System.out.print(i + "  ");
            }else{
                for (int j=2; j<= temp; j++){
                    if(i % j == 0){
                        break;
                    }

                    if(j >= temp){
                        count ++;
                        System.out.print(i + "  ");
                        if(count % 10 == 0){
                            System.out.println();
                        }
                    }
                }
            }
        }

    }

    public static void chengfabiao(){
        for (int i =1; i<=9; i++){
            for (int j = 1; j<=i; j++){
                System.out.print(j + " * " + i + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }
}
