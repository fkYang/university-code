package study.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/6
 */
public class SocketDemo {
    public static void main(String[] args) {

        getTime();
    }

    /**
     * 从 time.nist.gov 获取时间，利用socket
     * */
    static void getTime(){
        try ( Socket socket = new Socket("time.nist.gov",13)){
            socket.setSoTimeout(10000);
      //      InputStream inputStream = socket.getInputStream();
            StringBuilder builder = new StringBuilder();
            Reader reader = new InputStreamReader(socket.getInputStream(), "ASCII");
            int i = 0;
            while((i = reader.read())!= -1){
                builder.append((char)i);
            }
            System.out.println(builder.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
