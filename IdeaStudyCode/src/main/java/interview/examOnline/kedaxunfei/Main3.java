package interview.examOnline.kedaxunfei;

import java.util.Scanner;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/15
 */
//无符号三位整数，二进制，1的个数
public class Main3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        System.out.println(nums(n));
        System.out.println(rightMove(n));
    }

    static int rightMove(int n){
        int index = 0;
        int num = 0;
        while(index < 32){
            if( (n&1) == 1)
                num++;
            n = (n >>> 1);
            index++;
        }
        return num;
    }
    static int nums(int n ){
        if(n == 0)
            return 0;
        int index = 0;
        int num = 0;
        while(index < 32){
            int temp = (1 << index);
            if( (n & temp) != 0){
                num++;
            }
            index++;
        }
        return  num;
    }
}
