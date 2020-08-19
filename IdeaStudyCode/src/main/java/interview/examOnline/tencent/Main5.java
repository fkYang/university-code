package interview.examOnline.tencent;

import java.util.HashMap;
import java.util.Scanner;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/4/26
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,Long> map = new HashMap<>();
        map.put(1,(long) 1);
        int times = in.nextInt();
        long minleft = 1;
        long maxRight = 1;
        int tempH = 1;
        while(tempH !=60){
            tempH++;
            minleft = minleft*2;
            map.put(tempH,minleft);
        }

        for( int i = 0 ; i < times ; i++){
            long son = in.nextLong();
            int depth = in.nextInt();
            if(depth == 1){
                System.out.println("1");
                continue;
            }

            minleft = 1;
            maxRight = 1;
            if(map.containsKey(depth)){
                minleft = map.get(depth);
                maxRight = minleft*2;
                map.put(depth+1,maxRight);
                maxRight--;
            }
           if( son <= maxRight)
               System.out.println("-1");
           else{
               while( son > maxRight){
                   son = son/2;
               }
               System.out.println(son);
           }

        }
    }
}
