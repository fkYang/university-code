package study.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ������
 *
 * @author yfk
 * @date 2020/5/12
 */
public class BIOServerNoBlocking {
    public static void main(String[] args) {
        BIOServerNoBlocking server = new BIOServerNoBlocking();
        server.initBIOServer(9999);
    }
    public void initBIOServer(int port) {
        ServerSocket serverSocket = null;//�����Socket
        Socket socket = null;//�ͻ���socket
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ClientSocketThread thread = null;
        try {
            serverSocket = new ServerSocket(port,10);
            serverSocket.setSoTimeout(10);
            System.out.println(stringNowTime() + ": serverSocket started");
            while (true) {
                try {
                    socket = serverSocket.accept();
                } catch (SocketTimeoutException e) {
                    //���е������ʾ����accept��û���յ��κ����ݵģ�����˵����߳������������һЩ��������
    //                System.out.println("now time is: " + stringNowTime());
                    continue;
                }
                System.out.println(stringNowTime() + ": idΪ" + socket.hashCode() + "��Clientsocket connected");
                thread = new ClientSocketThread(socket);
                threadPool.execute(thread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String stringNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return format.format(new Date());
    }



    class ClientSocketThread extends Thread {
        public Socket socket;

        public ClientSocketThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            String inputContent;
            int count = 0;
            try {
                socket.setSoTimeout(1000);
            } catch (SocketException e1) {
                e1.printStackTrace();
            }
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //reader�ĳ�ʱ�����socket��AbstractPlainSocketImpl������Ƶ�
                while (true) {
                    try {
                        while ((inputContent = reader.readLine()) != null) {
                            System.out.println("�յ�idΪ" + socket.hashCode() + "  " + inputContent);
                            count++;
                        }
                    } catch (Exception e) {
                        //ִ�е������ʾread����û�л�ȡ���κ����ݣ��߳̿���ִ��һЩ�����Ĳ���
 //                       System.out.println("Not read data: " + stringNowTime());
                        continue;
                    }
                    //ִ�е������ʾ��ȡ�������ݣ����ǿ�����������лظ��ͻ��˵Ĺ���
                    System.out.println("idΪ" + socket.hashCode() + "��Clientsocket " + stringNowTime() + "��ȡ����");
                    sleep(1000);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
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
    }
}


