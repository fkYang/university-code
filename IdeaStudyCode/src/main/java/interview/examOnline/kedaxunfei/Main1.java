package interview.examOnline.kedaxunfei;

import java.util.Scanner;

/**
 * ÀàÃèÊö
 *
 * @author yfk
 * @date 2020/8/15
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for( int i = 0 ; i < n ; i++){
            for( int j = 0 ; j < m ; j++){
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        System.out.println(max(arr));
    }

    static int max(int [][] arr){
        int max = 0;
        int n = arr.length;
        int m = arr[0].length;
        for( int i = 0 ; i < n ; i++){
            for( int j = 0 ; j < m ; j++){

                for( int l = 0 ; l < n ; l++){
                    for( int k = 0 ; k < m ; k++){
                        if( l == i || k == j)
                            continue;

                        int temp = arr[i][j]*arr[l][k];

                        max = Math.max(max,temp);
                    }
                }
            }
        }
        return max;
    }
}
