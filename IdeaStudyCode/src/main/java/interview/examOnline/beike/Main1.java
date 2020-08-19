package interview.examOnline.beike;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/8/11
 */
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String string = in.next();
        //System.out.println(n == string.length());
        int change = change(string);
        System.out.println(change);
        in.close();

    }

    static int change(String s){
        int changes = 0;
        int left = 0 , right = s.length() -1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                changes++;
            }
            left++;
            right--;
        }
        return changes;
    }
}
