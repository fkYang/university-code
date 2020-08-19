package study.net;

import sun.reflect.generics.tree.VoidDescriptor;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/3
 */
public class DNS {
    public static void main(String[] args) {

        getByNameString();
        getByNameIP();
    }

    static void getByNameString(){
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(address);
    }
    static void getByNameIP(){
        try {
            InetAddress address = InetAddress.getByName("61.135.169.121");
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
