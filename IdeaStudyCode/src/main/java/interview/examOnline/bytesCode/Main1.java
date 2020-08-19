package interview.examOnline.bytesCode;

import java.util.Scanner;
import java.util.Stack;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/5/11
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> opera = new Stack<>();
        Stack<String> content = new Stack<>();
       StringBuilder s = new StringBuilder();

        for( int i = 0 ; i< n ; i++){
            int step = sc.nextInt();
            switch(step){
                case 1://add
                    String con = sc.nextLine();
                   // con = con.substring(1);
                    con = myTrim(con);
                //    System.out.println( con + con.length());
                    s.append(con);
               //     System.out.println(s.toString()+s.length());
                   // System.out.println(s);
                    opera.push(1);
                    content.push(con);
                    break;
                case 2://delete
                    int k = sc.nextInt();
                    opera.push(2);
                    content.push(s.substring(s.length() -k));
                    s = s.delete(s.length()-k,s.length());
                    break;
                case 3://show
                    int k3 = sc.nextInt();
                    System.out.println(s.charAt( k3-1));
                    break;
                case 4:
                    if( opera.isEmpty())
                        break;
                    int reOperation = opera.pop();
                    String reContent = content.pop();
                    switch(reOperation){
                        case 1:
                            s = s.delete(s.length()-reContent.length(),s.length());
                            break;
                        case 2:
                            s = s.append( reContent);
                            break;
                    }
                    break;
                default:
                    break;
            }
        }

    }
    static String myTrim(String in){

        for( int i = 0 ; i< in.length() ;i++){
            if( in.charAt(i) != ' '){
                in = in.substring(i);
                break;
            }

        }
        return  in;
    }


}
