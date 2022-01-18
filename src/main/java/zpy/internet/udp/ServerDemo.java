package zpy.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author zpy
 */
public class ServerDemo {

    public static void main(String[] args) throws Exception {
        //创建接收端对象
        DatagramSocket socket = new DatagramSocket(8888);
        //创建一个数据包对象用于接收数据
        byte[] bytes = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        //等待接收数据
        socket.receive(packet);
        int len = packet.getLength();
        System.out.println(new String(bytes, 0, len));
        System.out.println("发送端Ip：" + packet.getSocketAddress());

        socket.close();
    }
}
