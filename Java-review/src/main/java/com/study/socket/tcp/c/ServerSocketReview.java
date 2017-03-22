package com.study.socket.tcp.c;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class ServerSocketReview {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                ServerSocketThread thread = new ServerSocketThread(socket);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
