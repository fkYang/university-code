package study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/3
 */
public class OutputsStreamDemo {
    public static void main(String[] args) throws Exception {

        OutputStream outputStream = new FileOutputStream("D:\\31577\\桌面\\hrllo.txt");
        outputStream.write(88);
        outputStream.flush();
        outputStream.close();
    }
}
