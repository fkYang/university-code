package interview.examOnline.kedaxunfei;

import java.util.Scanner;

/**
 * ÀàÃèÊö
 *
 * @author yfk
 * @date 2020/8/15
 */
//×Ö·û´®×óÒÆn
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String goal = in.nextLine();
        int n = in.nextInt();
        in.close();

        System.out.println(leftMove(goal, n));

    }

    static String leftMove(String goal ,int n){
        StringBuilder builder = new StringBuilder();
        builder.append(goal.substring(n));
        builder.append(goal.substring(0, n));
        return  builder.toString();
    //    for(int i = n ; i < goal.length();)
//        for(int i = n-1 ; i >= 0 ; i--){
//            builder.append(String)
//        }
    }
}
