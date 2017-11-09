package com.study.security.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * 应用场景 ： e-mail、 密钥、 证书文件
 *
 * @author yk
 * @version 1.0 Date: 2017/8/25
 */
public class Base64Demo {

    private static final String src = "security base64 test";

    public static void main(String[] args) {
//        jdkBase64();
//        commonsCodesBase64();
//        bouncyCastleBase64();
        jdk8UtilBase64();
    }

    private static void jdkBase64() {
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(src.getBytes());
            System.out.println("encode: " + encode); // c2VjdXJpdHkgYmFzZTY0IHRlc3Q=

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(encode);
            System.out.println("decode: " + new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void commonsCodesBase64() {
        byte[] bytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encode: " + new String(bytes)); //c2VjdXJpdHkgYmFzZTY0IHRlc3Q=

        byte[] decodeBase64 = Base64.decodeBase64(bytes);
        System.out.println("decode: " + new String(decodeBase64));
    }

    private static void bouncyCastleBase64() {
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode: " + new String(encode));// c2VjdXJpdHkgYmFzZTY0IHRlc3Q=

        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("decode: " + new String(decode));
    }

    /*
    *  有测试说 性能好
    * */
    private static void  jdk8UtilBase64(){
        byte[] encode = java.util.Base64.getEncoder().encode(src.getBytes());
        System.out.println("encode: " + new String(encode)); // c2VjdXJpdHkgYmFzZTY0IHRlc3Q=

        byte[] decode = java.util.Base64.getDecoder().decode(encode);
        System.out.println("decode: " + new String(decode));
    }
}
