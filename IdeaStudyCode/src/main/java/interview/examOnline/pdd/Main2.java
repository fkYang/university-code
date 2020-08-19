package interview.examOnline.pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() , m = in.nextInt() , t = in.nextInt();
        int[][] mid = new int[n][2];
        int[][] evening = new int[m][2];
        for( int i = 0 ; i < n ; i++){
            mid[i][0] = in.nextInt();
            mid[i][1] = in.nextInt();
        }
        for( int i = 0 ; i < m ; i++){
            evening[i][0] = in.nextInt();
            evening[i][1] = in.nextInt();
        }
        in.close();
        if( t == 0){
            System.out.println("0");
        }
        else {
            sort(mid);
            sort(evening);
            int min = getMin(mid, evening, t, n, m);
            System.out.println(min);

        }

    }
    static void sort(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i = o1[1] - o2[1];
                return -i;
            }
        });
    }

    static int getMin(int[][]mid,int[][]evening,int t, int n , int m){
        int min = -1;
        for( int i = -1 ; i  < n ; i++){
            int   tempX = 0 , tempT =0;
            int tempEX = 0 ,tempET = 0;
            if( i != -1){
                tempX = mid[i][0];
                tempT = mid[i][1];
            }
            for( int j = -1 ; j < m ; j++){
                if( j != -1 ){
                    tempEX = evening[j][0];
                    tempET = evening[j][1];
                }
                if( tempT + tempET >= t){
                    if(min == -1){
                        min = tempEX+tempX;
                    }else{
                        min = Math.min(min,tempEX+tempX);
                    }
                }else if ( j != -1){
                    break;//后面的都小于这个
                }else  if( j == 0)
                    return min;
            }
        }
        return min;
    }
}
