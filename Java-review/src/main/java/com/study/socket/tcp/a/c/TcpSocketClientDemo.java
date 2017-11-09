package com.study.socket.tcp.a.c;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class TcpSocketClientDemo {
    public static void main (String [] args){
        try {
            Socket socket = new Socket("127.0.0.1", 45628);
            OutputStream outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
