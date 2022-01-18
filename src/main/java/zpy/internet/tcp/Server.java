package zpy.internet.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zpy
 */
public class Server {

    public static void main(String[] args) {

        try {
            //注册端口
            ServerSocket serverSocket = new ServerSocket(8888);
            //等待服务端的请求，建立socket连接
            Socket socket = serverSocket.accept();
            //从socket管道获取输入流
            InputStream is = socket.getInputStream();
            //把字节输入路包装成缓冲字符输入流进行消息的接收
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = reader.readLine()) != null) {
                System.out.println(socket.getRemoteSocketAddress() + ":" + msg);
                OutputStream os = socket.getOutputStream();
                PrintStream ps = new PrintStream(os);
                ps.println("收到，over");
                ps.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
