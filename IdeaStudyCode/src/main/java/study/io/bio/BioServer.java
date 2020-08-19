package study.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/5/12
 */
public class BioServer {
    public void initBIOServer(int port) {
        ServerSocket serverSocket = null;//服务端 Socket
        Socket socket = null;//客户端 socket
        BufferedReader reader = null;
        String inputContent;
        int count = 0;
        try {
            serverSocket = new ServerSocket(port,10);
            System.out.println("serversocket start");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("id:" + socket.hashCode() + "client connect");
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while ((inputContent = reader.readLine()) != null) {
                    System.out.println("get id：" + socket.hashCode() + " " + inputContent);
                    count++;
                }
                System.out.println("end: id:" + socket.hashCode() + "over");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        BioServer server = new BioServer();
        server.initBIOServer(9999);
    }
}
