package com.study.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一ajax请求返回数据工具类
 * @author yk
 * @version 1.0 Date: 2017/6/8
 */
public class ResultUtils {

    public static Map<String, Object> success(Object o) {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("message", "请求成功");
        map.put("data", o);
        return map;
    }

    public static Map<String, Object> success() {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("message", "请求成功");
        return map;
    }

    public static Map<String, Object> error(Integer code, String msg){
        Map map = new HashMap();
        map.put("code", code);
        map.put("message", msg);
        return map;
    }

    public static Map<String, Object> error(Integer code, String msg, StringBuffer url){
        Map map = new HashMap();
        map.put("code", code);
        map.put("message", msg);
        map.put("url", url);
        return map;
    }
}
