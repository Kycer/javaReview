package com.yksoul.wx.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.Buffer;
import java.util.Arrays;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/18
 */
public class CheackUtil {
    private static final String token = "yksoul";
    public static boolean checkSignature(String signature, String timestamp, String nonce){
        String[] arr = {token, timestamp, nonce};
        //1 排序
        Arrays.sort(arr);
        //2 生成字符串
        StringBuffer buffer = new StringBuffer();
        for (String s : arr) {
            buffer.append(s);
        }
        //  sha1 加密
        String sha1Hex = DigestUtils.sha1Hex(buffer.toString());
        // 返回比较结果
        return sha1Hex.equals(signature);
    }
}
