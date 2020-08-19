package interview.examOnline.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/4/26
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        in.nextLine();
        Stack<Long> first = new Stack<>();
        Stack<Long> second  = new Stack<>();
        for( int i = 0 ; i < times ; i++){
            String op = in.next();
            switch(op){
                case "add":
                    long num = in.nextLong();
                    first.add(num);
                    break;
                case "peek":
                    if( second.isEmpty() ){
                        while( !first.isEmpty()){
                            second.add(first.pop());
                        }
                    }
        //            if(second.isEmpty()){
         //               System.out.println();
         //           }else
                        {
                        System.out.println(second.peek());
                    }
                    break;
                case "poll":
                    if( second.isEmpty() ) {
                        while (!first.isEmpty()) {
                            second.add(first.pop());
                        }
                    }
                //    if(!second.isEmpty())
                    {
                        second.pop();
                    }
                    break;
            }
        }
    }
}
