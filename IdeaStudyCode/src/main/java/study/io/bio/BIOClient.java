package study.io.bio;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/5/12
 */
public class BIOClient {
    void initBIOClient(String host,int port){
        BufferedReader  reader = null;
        BufferedWriter writer = null;
        Socket socket = null;
        String inputContent;
        int count = 0;
        try{
            reader  = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(host,port);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println(Thread.currentThread().getName()+"   client start :" );
            inputContent = Thread.currentThread().getName();
            writer.write(inputContent);
            writer.flush();
            count++;

            while ((inputContent = reader.readLine()) != null && count < 2 ){
                inputContent = "count:"+inputContent+ "\n";
                writer.write(inputContent);
                writer.flush();
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                socket.close();
                reader.close();
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(30,30,2, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));
        for( int i = 0 ; i < 10 ; i++){
            executor.execute(new MyThread());
        }
        BIOClient client = new BIOClient();
        client.initBIOClient("127.0.0.1" , 9999);
    }
    static class MyThread extends  Thread{
        @Override
        public void run() {
            BIOClient client = new BIOClient();
            client.initBIOClient("127.0.0.1",9999);
        }
    }
}
