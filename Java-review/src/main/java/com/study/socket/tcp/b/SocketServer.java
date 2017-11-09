package com.study.socket.tcp.b;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket socketServer = new ServerSocket(10086);
            //2、调用accept()方法开始监听，等待客户端的连接
            Socket socket = null;

            while (true){
                socket = socketServer.accept();
                SocketServerThread thread = new SocketServerThread(socket);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
