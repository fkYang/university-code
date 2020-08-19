package study.basic;

import java.util.Arrays;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/4
 */
public class LongDemo {
    public static void main(String[] args) {

        long v = 7;
        byte[] writeBuffer = new byte[8];
        writeBuffer[0] = (byte)(v >>> 56);
        writeBuffer[1] = (byte)(v >>> 48);
        writeBuffer[2] = (byte)(v >>> 40);
        writeBuffer[3] = (byte)(v >>> 32);
        writeBuffer[4] = (byte)(v >>> 24);
        writeBuffer[5] = (byte)(v >>> 16);
        writeBuffer[6] = (byte)(v >>>  8);
        writeBuffer[7] = (byte)(v >>>  0);


        System.out.println(Arrays.toString(writeBuffer));

    }
}
