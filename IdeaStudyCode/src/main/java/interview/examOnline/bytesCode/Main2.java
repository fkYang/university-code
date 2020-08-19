package interview.examOnline.bytesCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/5/11
 */
public class Main2 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String article = in.nextLine();
        int nums = in.nextInt();
        List<String> words = new ArrayList<>(nums);
        in.nextLine();
        for( int i = 0 ; i < nums ; i++){
            String word= in.nextLine();
            words.add(word);
        }
        caculate(article,words,0);
        System.out.println(ans);

    }
    static void caculate(String article,List<String> words,int index){
        if( index >= article.length()){
            ans++;
            return;
        }
        for( int i = 0 ; i < words.size() ;i++){
            String temp = words.get(i);
            if( index+temp.length() > article.length())
                continue;
            if( article.substring(index,index+temp.length()) .equals(temp)){
                index = index + temp.length();
                caculate(article,words,index);
                index = index -temp.length();
            }
        }


    }

}
