package com.study.socket.tcp.a.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class TcpSocketServerDemo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(45628);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println(info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
