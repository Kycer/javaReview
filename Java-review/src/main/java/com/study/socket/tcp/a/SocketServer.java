package com.study.socket.tcp.a;

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
            ServerSocket socket = new ServerSocket(10086);
            //2、调用accept()方法开始监听，等待客户端的连接
            Socket accept = socket.accept();
            //3、获取输入流，并读取客户端信息
            InputStream is = accept.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info=br.readLine()) != null){
                System.out.println("我是服务器，客服端说："+ info);
            }
            accept.shutdownInput();
            //4、获取输出流，响应客户端的请求
            OutputStream os = accept.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("Hello World！");
            pw.flush();


            //5、关闭资源
            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            accept.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
