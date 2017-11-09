package com.study.security.digest.sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * 消息摘要算法 — SHA (sha1 sha224 sha256 sha384 sha512)
 *  jdk没有实现sha-224 bc 实现
 * @author yk
 * @version 1.0 Date: 2017/8/25
 */
public class SHADemo {

    private static final String src = "security SHA test";

    public static void main(String[] args) {
        jdkSHA1();
        bcSHA1();
        bcSHA224();
        ccSHA();
        /*
        JDK sha-1: 8471cea883d73c931ed4a291001a46138f879c15
        bc sha-1: 8471cea883d73c931ed4a291001a46138f879c15
        JDK sha-224: eb678ac9a4d52f3cc20e633ad55701d77070a5ea237546e61c268e55
        CC sha-1: 8471cea883d73c931ed4a291001a46138f879c15
        CC sha-1: 8471cea883d73c931ed4a291001a46138f879c15
        CC sha-512: 47c57423bb66e0b3ca96f9b085f2cdd44c68454f0ee30e9b7ace81a9436ab5376a567f47ce04655ff918b15b59bfd8f15915b6258a52f56f2dd94c58052f2241
        */
    }

    private static void jdkSHA1(){
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA");
            sha.update(src.getBytes());
            System.out.println("JDK sha-1: "+ Hex.encodeHexString(sha.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void bcSHA1(){
        Digest sha1Digest = new SHA1Digest();
        sha1Digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] bytes = new byte[sha1Digest.getDigestSize()];
        sha1Digest.doFinal(bytes, 0);
        System.out.println("bc sha-1: "+ org.bouncycastle.util.encoders.Hex.toHexString(bytes));
    }

    private static void bcSHA224(){
        try {
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest sha = MessageDigest.getInstance("SHA-224");
            sha.update(src.getBytes());
            System.out.println("JDK sha-224: "+ Hex.encodeHexString(sha.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void ccSHA(){
        String sha1Hex = DigestUtils.sha1Hex(src.getBytes());
        System.out.println("CC sha-1: " + sha1Hex);
        String sha1Hex2 = DigestUtils.sha1Hex(src);
        System.out.println("CC sha-1: " + sha1Hex2);

        String sha512Hex = DigestUtils.sha512Hex(src);
        System.out.println("CC sha-512: " + sha512Hex);
    }
}
