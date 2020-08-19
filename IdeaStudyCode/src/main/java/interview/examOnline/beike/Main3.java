package interview.examOnline.beike;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/11
 */
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }
        in.close();

        System.out.println(minLength(arr));

    }
//当前
    static int minLength(int[] arr){
        int max = 0;
        int minLength = arr.length;
        for( int i = 0 ; i <arr.length ; i++){
            max = max | arr[i];
        }
        for( int i = 0 ; i < arr.length ; i++){
            int temp = 0;
            int j = 0;
            for( j = i ; j <arr.length ; j++){
                temp = temp | arr[j];
                if( temp == max){
                    minLength = Math.min(minLength, j-i+1);
                    break;
                }
            }
            if(j == arr.length)
                break;
        }
        return  minLength;

//        int max = 0;
//        int minLength = 1;
//        int [][][] demo = new int[arr.length][arr.length][2];
//        //[][][0] : max
//        //[][][1]: minLength
//        for(int i = 0 ; i <arr.length ; i++){
//            demo[i][i][0] = i;
//            demo[i][i][1] = 1;
//        }
//
//        for(int i = 0 ; i < arr.length ; i++){
//            for( int j = i+1 ; j < arr.length ; j++){
//                int preMax = demo[i][j-1][0];
//                if( (demo[i][j-1][0] | arr[j] ) == arr[j]){
//                    demo[i][j][0] = arr[j];
//                    demo[i][j][1] = 1;
//
//                }else{
//                    demo[i][j][0] = demo[i][j-1][0] | arr[j];
//                    demo[i][j][1] = demo[i][j-1][1] + 1;
//                }
//            }
//        }
//
//        for(int i = 0 ; i < arr.length ; i++){
//            for( int j = i+1 ; j < arr.length ; j++){
//                if(demo[i][j][0] >= max){
//                    max = demo[i][j][0];
//                    minLength = Math.min(demo[i][j][0],minLength);
//                }
//            }
//        }
//
//
//        return minLength;
    }
}
