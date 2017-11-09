package com.study.a;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author yksoul
 * @date 2017/2/23
 */
interface Fan<T>{
    void show(T t);
}
public class fanXing implements Fan<String>{
    @Override
    public void show(String s) {

    }
}

class fanXing2<T> implements Fan<T>{

    @Override
    public void show(T t) {
        new HashSet<>();
        new HashMap<>();
    }
}