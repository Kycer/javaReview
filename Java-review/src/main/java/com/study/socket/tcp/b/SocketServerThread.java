package com.study.socket.tcp.b;

import java.io.*;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class SocketServerThread extends Thread {
    private Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            //3、获取输入流，并读取客户端信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客服端说：" + info);
            }
            System.out.println("当前ip：" + socket.getInetAddress().toString());
            //4、获取输出流，响应客户端的请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("你的ip: " + socket.getInetAddress().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null)
                    pw.close();
                if (os != null)
                    os.close();
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
