package interview.examOnline.tencent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/4/26
 */
public class MyQueue {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int group = in.nextInt();
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second  = new Stack<>();
        Queue<Integer> result = new LinkedList<>();
        for( int k = 0 ; k < group ; k++){
            //2.每组数据长度
            int times = in.nextInt();

            in.nextLine();

        for( int i = 0 ; i < times ; i++){
            String op = in.next();
            switch(op){
                case "PUSH":
                    int num = in.nextInt();
                    first.add(num);
                    break;
                case "TOP":
                    if( second.isEmpty() ){
                        while( !first.isEmpty()){
                            second.add(first.pop());
                        }
                    }
                    if( second.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(second.peek());
                    }
                    break;
                case "POP":
                    if( second.isEmpty() ) {
                        while (!first.isEmpty()) {
                            second.add(first.pop());
                        }
                    }
                    if(second.isEmpty()){
                        System.out.println("-1");
                    }else{
                        second.pop();
                    }

                    break;
                case "SIZE":
                    System.out.println(first.size()+second.size());
                    break;
                case "CLEAR":
                    first.clear();
                    second.clear();
                    break;
            }
        }
    }}
}
