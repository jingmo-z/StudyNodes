package zpy.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author zpy
 */
public class ClientDemo {

    public static void main(String[] args) throws Exception {
        //创建发送端对象
        DatagramSocket socket = new DatagramSocket();
        //创建一个数据包对象封装数据

        byte[] bytes = "这是一个数据包。".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);
        //发送数据
        socket.send(packet);

        socket.close();

    }
}
