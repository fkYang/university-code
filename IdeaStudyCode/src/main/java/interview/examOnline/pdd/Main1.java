package interview.examOnline.pdd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt(), n =in.nextInt();
        int[] arr = new int[n+2];
        for( int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        int[] ans = getAns(k, n, arr);
        if( ans == null){
            System.out.println("paradox");
        }else{
            for( int i = 0 ; i < 2 ; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }

    static int[] getAns(int k,int n , int[] arr){
        int[] ans = new int[2];
        int times = 0;
        for( int i = 0 ; i < n ; i++){
            k = k - arr[i];
            if( k == 0)
                return  null;
            if(k < 0){
                times++;
                k = -k;
            }
            ans[0] = k;
        }
        ans[1] = times;
        return ans;
    }

}
