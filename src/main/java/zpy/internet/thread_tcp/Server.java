package zpy.internet.thread_tcp;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author zpy
 */
public class Server {

    private static ExecutorService executorService = new ThreadPoolExecutor(3, 5, 6, TimeUnit.SECONDS
            , new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        try {
            //注册端口
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true) {
                //等待服务端的请求，建立socket连接
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + " 上线了。");
                executorService.execute(new MyServerRunnable(socket));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
