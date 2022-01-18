package zpy.internet.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zpy
 */
public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);

            while (true) {
                String msg = sc.nextLine();
                System.out.println(msg);
                if ("exit".equals(msg)) {
                    System.out.println("连接断开");
                    socket.close();
                    os.close();
                    ps.close();
                    break;
                }

                ps.println(msg);
                ps.flush();

                //从socket管道获取输入流
                InputStream is = socket.getInputStream();
                //把字节输入路包装成缓冲字符输入流进行消息的接收
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String res;
                if ((res = reader.readLine()) != null) {
                    System.out.println(socket.getRemoteSocketAddress() + ":" + res);
                    ps.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
