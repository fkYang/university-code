package interview.examOnline.beike;

import java.util.Scanner;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/11
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] arr = new int[t][2];
        for( int i = 0; i < t ; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        in.close();
        int[] kinds = kinds(arr, t);
        for( int i = 0 ; i < t ; i++){
            System.out.println(kinds[i]);
        }

    }

    static int[] kinds(int[][] arr , int t){
        int [] result = new int[t];
        for( int i = 0 ; i < t ; i++){
            if( arr[i][0] == 1 && arr[i][1] == 1)//1各格子
                result[i] = 1;
            else if (arr[i][0] == 1 || arr[i][1] == 1)//一列
                result[i] = 2;
            else{
                int min = Math.min(arr[i][0],arr[i][1]);//多行多列
                for( int j  = 2 ; j <= min ; j++ ){
                    if( arr[i][0] % j == 0 || arr[i][1] %j ==0){
                        result[i] = j;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
