package study.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/3
 */
public class NetworkInterfaceDemo {
    public static void main(String[] args) {
   //     getName();
        getNames();
    }

    static void getName(){
        try {
            InetAddress address = InetAddress.getByName("127.0.0.1");
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
            System.out.println(networkInterface);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    static  void getNames(){
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements()){
                NetworkInterface nextElement = interfaces.nextElement();
                System.out.println(nextElement + " --" + nextElement.getDisplayName());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
