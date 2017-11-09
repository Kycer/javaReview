package com.study.a;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class diGui {
    public static void main(String[] args) {
        System.out.println(jieCheng(5));
    }

    public static int jieCheng(int n){
        if(n==1){
            return 1;
        }else {
            System.out.println(n);
            return n*jieCheng(n-1);
        }
    }
}
