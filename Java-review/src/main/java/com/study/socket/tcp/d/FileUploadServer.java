package com.study.socket.tcp.d;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class FileUploadServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);

            while (true){
                Socket socket = serverSocket.accept();
                UploadThread thread = new UploadThread(socket);
                new Thread(thread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
