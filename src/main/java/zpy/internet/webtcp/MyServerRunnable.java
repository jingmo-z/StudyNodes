package zpy.internet.webtcp;

import java.io.IOException;
import java.io.PrintStream;
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
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("Http/1.1 200 OK");
            ps.println("Content-type:text/html;charset=utf-8");

            ps.println();

            ps.println("<h1>TCP协议</h1>");
            ps.flush();
            ps.close();

        } catch (IOException e) {
            System.out.println(socket.getRemoteSocketAddress() + " 下线了。");
        }
    }
}
