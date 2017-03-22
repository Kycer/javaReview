package com.study.a;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class StringDemo {

    public static void main(String[] args) {
        String str = "中国，美国，日本";
        System.out.println("str.charAt："+str.charAt(2));
        System.out.println("str.indexOf:" + str.indexOf("美"));
        System.out.println(str.compareTo("中国，美国，日本"));
        System.out.println(str.startsWith("中"));
        System.out.println(str.startsWith("美国", 3));
        String s = "AbCdefghHijk";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(str.replace("，", " - "));
        System.out.println(str.replaceAll("[，]", " + "));
        System.out.println(str.replaceAll("\\，美", " + "));

        String st = "hello";
        String str2 = "he"+new String("llo");
        System.out.println(st.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(st == str2);
        System.out.println((int)'a');  //  97
        System.out.println((int)'z');  //  122
        System.out.println((int)'A'); //  65
        System.out.println((int)'Z'); // 90

        getNum();
    }

    public static void getNum(){
        String str = "HelloWord123abcAAA";
        int l = str.length();
        int big=0;
        int low=0;
        int num=0;
        for (int i = 0; i < l; i++) {
            char c = str.charAt(i);
            if(c > 64 && c < 91){
                big++;
            }else if(c> 96 && c< 123){
                low++;
            }else if(c >= '0' && c <= '9'){
                num++;
            }
        }
        System.out.println("big = " + big + "low = " + low + "num = " + num);
    }
}
