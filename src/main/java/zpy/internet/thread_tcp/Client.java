package zpy.internet.thread_tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zpy
 */
public class Client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            while (true) {
                String msg = sc.nextLine();
                if ("exit".equals(msg)) {
                    System.out.println("连接断开");
                    socket.close();
                    ps.close();
                    break;
                }

                ps.println(msg);
                ps.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
