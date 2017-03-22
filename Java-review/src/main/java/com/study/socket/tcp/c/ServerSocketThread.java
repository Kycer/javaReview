package com.study.socket.tcp.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class ServerSocketThread extends Thread {

    private Socket socket;

    private InputStream inputStream;

    private InputStreamReader inputStreamReader;

    private BufferedReader bufferedReader;

    public ServerSocketThread(Socket socket) {
        this.socket = socket;
        this.inputStream = null;
        this.inputStreamReader = null;
        this.bufferedReader = null;
    }

    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            System.out.println("当前连接客户端地址："+socket.getInetAddress());
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("我是服务器，客户端说：" + info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(inputStreamReader != null)
                    inputStreamReader.close();
                if(inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
