package com.study.socket.tcp.c;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class CleintSocketReview {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 5555);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.print("我是客户端我来连接你了！");
            writer.flush();

            writer.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
