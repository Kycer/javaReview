package com.study.security.digest.md;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 *  消息摘要算法 — MD
 *  jdk 没有提供md4 md4 由BC提供
 *
 * @author yk
 * @version 1.0 Date: 2017/8/25
 */
public class MDDemo {

    private static final String src = "security MD test";

    public static void main(String[] args) {
        jdkMD();
        bcMD4();
        bcMD5();
        ccMD();

        /*
        * JDK MD5: d6eca220395eac95d44dba915fe14392
        * JDK MD2: 6af21bf68a16105220912236331ebc07
        * BC MD4: 596eb115154aceb42b755683b4a59891
        * BC MD5: d6eca220395eac95d44dba915fe14392
        * CC MD5: d6eca220395eac95d44dba915fe14392
        * CC MD2: 6af21bf68a16105220912236331ebc07
        * */
    }

    private static void jdkMD(){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(src.getBytes());
            System.out.println("JDK MD5: " + Hex.encodeHexString(digest));
//            d6eca220395eac95d44dba915fe14392

            MessageDigest md2 = MessageDigest.getInstance("MD2");
            byte[] digest2 = md2.digest(src.getBytes());
            System.out.println("JDK MD2: " + Hex.encodeHexString(digest2));
//            6af21bf68a16105220912236331ebc07

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void bcMD4(){
//        Digest md4Digest = new MD4Digest();
//        md4Digest.update(src.getBytes(), 0, src.getBytes().length);
//        byte[] bytes = new byte[md4Digest.getDigestSize()];
//        md4Digest.doFinal(bytes, 0);
//        System.out.println("BC MD4: " + org.bouncycastle.util.encoders.Hex.toHexString(bytes));

        try {
            // 动态给jdk 添加一个Provider 也可以 通过修改配置文件
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest md4 = MessageDigest.getInstance("MD4");
            byte[] digest = md4.digest(src.getBytes());
            System.out.println("BC MD4: " + Hex.encodeHexString(digest));
//            596eb115154aceb42b755683b4a59891
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    private static void bcMD5(){
        Digest md5Digest = new MD5Digest();
        md5Digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] bytes = new byte[md5Digest.getDigestSize()];
        md5Digest.doFinal(bytes, 0);
        System.out.println("BC MD5: " + org.bouncycastle.util.encoders.Hex.toHexString(bytes));
//        d6eca220395eac95d44dba915fe14392
    }

    public static void ccMD(){
        String md5Hex = DigestUtils.md5Hex(src.getBytes());
        System.out.println("CC MD5: "+ md5Hex);

        String md2Hex = DigestUtils.md2Hex(src.getBytes());
        System.out.println("CC MD2: "+ md2Hex);
    }
}
