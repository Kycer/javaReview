package com.study.a;

import java.util.*;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class ListDemo {
    public static void main(String[] args) {

        ArrayListDemo();
//        setDemo();
    }

    public static void ArrayListDemo(){
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("abc");
        list.add('A');
        list.add('A');
        System.out.println(list.toString());
        System.out.println(list.toArray());
        System.out.println(list.contains('A'));
        list.clear();
        System.out.println(list.toString());
    }

    public static void LinkList(){
        List<Object> link = new LinkedList<>();
    }

    public static void setDemo(){
        Set<Object> set = new HashSet<>();
        set.add('a');
        set.add(1);
        set.add("ABC");
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
