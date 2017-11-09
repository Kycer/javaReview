package com.study.socket.tcp.d;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author yksoul
 * @date 2017/2/23
 */
public class FileUploadClient {
    public static void main(String[] args) {
        try {
            while (true){
                Scanner sc = new Scanner(System.in);
                System.out.println("请输入文件全路径：");
                String path = sc.next();
                File file = new File(path);
                if(!file.exists() || !file.isFile()){
                    System.out.println("文件路径错误或传入的不是正确文件！");
                    continue;
                }else {
                    Socket socket = new Socket("127.0.0.1",6666);
                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(outputStream);

                    FileInputStream fis = new FileInputStream(file);

                    dos.writeUTF(file.getName());
                    dos.flush();
                    System.out.println("开始传输文件。。。");

                    byte[] bytes = new byte[1024];
                    int length = 0;
                    long progress = 0;
                    while((length = fis.read(bytes, 0, bytes.length)) != -1) {
                        dos.write(bytes, 0, length);
                        dos.flush();
                        progress += length;
                        System.out.print("- " + (100*progress/file.length()) + "% -");
                    }
                    System.out.println();
                    System.out.println("文件传输成功。");

                    dos.flush();
                    dos.close();
                    fis.close();
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
