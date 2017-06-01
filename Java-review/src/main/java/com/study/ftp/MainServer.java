package com.study.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/31
 */
public class MainServer {

    private FTPClient ftp;

    /**
     * @param path     上传到ftp服务器哪个路径下
     * @param addr     地址
     * @param port     端口号
     * @param username 用户名
     * @param password 密码
     * @return res
     * @throws Exception
     */
    private boolean connect(String path, String addr, int port, String username, String password) throws Exception {
        boolean result = false;
        ftp = new FTPClient();
        int reply;
        ftp.connect(addr, port);
        ftp.login(username, password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            return result;
        }
        ftp.changeWorkingDirectory(path);
        result = true;
        return result;
    }

    private void upload(File file, String path) throws Exception {

        System.out.println(" file.isDirectory() : " + file.isDirectory());

        if (file.isDirectory()) {
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + "\\" + files[i]);
                if (file1.isDirectory()) {
                    upload(file1, path);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + "\\" + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            File file2 = new File(file.getPath());

            System.out.println(" file.getPath() : " + file.getPath() + " | file2.getName() : " + file2.getName());

            InputStream input = new FileInputStream(file2);

            ftp.changeWorkingDirectory(path);
            ftp.storeFile(file2.getName(), input);

            input.close();  //关闭输入流
            ftp.logout();  //退出连接
        }
    }

    public static void main(String[] args) throws Exception {

        MainServer mainServer = new MainServer();
        String ip = args[0];
        String user = args[1];
        String password = args[2];
        String filePath = args[3];
        String uploadPath = args[4];
        boolean res = mainServer.connect("", ip, 21, user, password);
        System.out.println("连接 ：" + (res ? "成功" : "失败"));
        //上传
        File file = new File(filePath);
        mainServer.upload(file, uploadPath);
    }
}
