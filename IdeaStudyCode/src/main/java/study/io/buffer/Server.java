package study.io.buffer;

import java.io.IOException;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/3
 */
public class Server {
    public static void main(String[] args) {

        try {
            BufferDemo.server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
