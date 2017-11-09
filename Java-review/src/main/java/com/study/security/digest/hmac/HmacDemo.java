package com.study.security.digest.hmac;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author yk
 * @version 1.0 Date: 2017/8/29
 */
public class HmacDemo {

    private static final String src = "security HMAC test";

    public static void main(String[] args) {
        jdkHmacMD5();
        bcHacMD5();
    }

    private static void jdkHmacMD5(){
        try {
            // 初始化KeyGenerator
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            // 产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 获得密钥
//            byte[] encoded = secretKey.getEncoded();
            byte[] encoded = Hex.decodeHex(new char[] {'a','a','a','a','a','a','a','a','a','a'});

            // 还原密钥
            SecretKey secretKeySpec = new SecretKeySpec(encoded, "HmacMD5");
            //  实例化MAC
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            // 初始化mac
            mac.init(secretKeySpec);
            byte[] bytes = mac.doFinal(src.getBytes());
            System.out.println("JDK hmacMD5:" + Hex.encodeHexString(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }

    private static void bcHacMD5(){
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
        hMac.update(src.getBytes(), 0, src.getBytes().length);
        byte[] bytes = new byte[hMac.getMacSize()];
        hMac.doFinal(bytes, 0);
        System.out.println("bc hmacMD5:" + org.bouncycastle.util.encoders.Hex.toHexString(bytes));
    }
}
