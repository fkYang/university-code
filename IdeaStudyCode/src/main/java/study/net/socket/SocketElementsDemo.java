package study.net.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类描述
 *      默认socket 超时时长 0
 *
 * @author yfk
 * @date 2020/8/3
 */
public class SocketElementsDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        Socket socket = new Socket("127.0.0.1", 8000);
        int timeout = socket.getSoTimeout();
        System.out.println(timeout);
    }
}
