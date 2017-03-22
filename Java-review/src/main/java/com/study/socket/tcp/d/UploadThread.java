package com.study.socket.tcp.d;

import java.io.*;
import java.net.Socket;

/**
 * @author yksoul
 * @date 2017/2/23
 */
@SuppressWarnings("Duplicates")
public class UploadThread implements Runnable{

    private Socket socket;

    private InputStream inputStream;

    private DataInputStream dataInputStream;

    private FileOutputStream fileOutputStream;


    public UploadThread(Socket socket) {
        this.socket = socket;
        this.inputStream = null;
        this.dataInputStream = null;
        this.fileOutputStream = null;
    }

    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String fileName = dataInputStream.readUTF();
            File filePath = new File("E:\\Test\\upload");
            if(!filePath.exists()){
                filePath.mkdirs();
            }

            File file = new File(filePath.getAbsolutePath() + File.separatorChar + fileName);
            fileOutputStream = new FileOutputStream(file);

            byte[] bytes = new byte[1024];
            int length = 0;
            while((length = dataInputStream.read(bytes, 0, bytes.length)) != -1){
                fileOutputStream.write(bytes, 0, length);
            }
            System.out.println("文件"+fileName+"写入成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null)
                    fileOutputStream.close();
                if(dataInputStream != null)
                    dataInputStream.close();
                if(inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
