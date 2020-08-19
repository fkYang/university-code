package study.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Socket;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/3
 */
public class FileInputDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("D:\\31577\\桌面\\hrllo.txt");
        int i = inputStream.read();
        i = inputStream.read();
        i = inputStream.read();
        inputStream.close();

    }
}
