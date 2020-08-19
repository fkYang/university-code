package study.io.buffer;

import sun.java2d.pipe.BufferedTextPipe;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/3
 */
public class BufferDemo {
    static String path = "D:\\31577\\桌面\\hrllo.txt";
    public static void main(String[] args) throws IOException {

       client();

    }


    static void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket accept = serverSocket.accept();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
        byte[] bytes = new byte[1024];
        int i = 0;
        while (i !=10){
            bufferedInputStream.read(bytes);

            System.out.println(Arrays.toString(bytes));
            i++;
        }


        bufferedInputStream.close();
        serverSocket.close();


    }
    static void client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
        BufferedReader  reader = new BufferedReader(new InputStreamReader(System.in));

        String inputContent ;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        while ((inputContent = reader.readLine()) != null ){
            inputContent = "count:"+inputContent+ "\n";
            writer.write(inputContent);
            writer.flush();
        }

    }
}
