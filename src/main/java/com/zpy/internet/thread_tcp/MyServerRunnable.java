package com.zpy.internet.thread_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author zpy
 */
public class MyServerRunnable implements Runnable {

    private Socket socket;

    public MyServerRunnable() {
    }

    public MyServerRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //从socket管道获取输入流
            InputStream is = socket.getInputStream();
            //把字节输入路包装成缓冲字符输入流进行消息的接收
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = reader.readLine()) != null) {
                System.out.println(socket.getRemoteSocketAddress() + ":" + msg);
            }

        } catch (IOException e) {
            System.out.println(socket.getRemoteSocketAddress() + " 下线了。");
        }
    }
}
