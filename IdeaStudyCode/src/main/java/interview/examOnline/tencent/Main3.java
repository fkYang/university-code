package interview.examOnline.tencent;

import java.util.Scanner;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/4/26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        int[] packA= new int[nums];
        int[] packB = new int[nums];
        for( int i = 0 ; i < nums;i++){
            packA[i] = in.nextInt();
        }
        for( int i = 0 ; i < nums;i++){
            packB[i] = in.nextInt();
        }
        int  result =0;

//        Queue<Integer> queue = new LinkedList<>();
//        boolean goal = false;
//        while(goal){
//            for( int i = 1 ; i < nums ; i++){
//                if(packA[i-1] < packA[i])
//                    queue.offer(i);
//            }
//            int size = queue.size();
//            if(size == 0)
//                break;
//            for( int k = 0 ; k < size ; k++ ){
//                int i = queue.poll();
//
//                swap(packA,i-1,i);
//                swap(packB,i-1,i);
//                int temp = packA[i];
//                packA[i] = packB[i];
//                packB[i] = temp;
//
//                temp = packA[i-1];
//                packA[i-1] = packB[i-1];
//                packB[i-1] = temp;
//                result++;
//            }
//        }


        for( int i = 1 ; i < nums ; i++){

            int j = i;
            while(j>=1 && packA[j-1] > packA[j]){
                swap(packA,i-1,i);
                swap(packB,i-1,i);
                int temp = packA[i];
                packA[i] = packB[i];
                packB[i] = temp;

                temp = packA[i-1];
                packA[i-1] = packB[i-1];
                packB[i-1] = temp;
                result++;
            }
        }
        System.out.println(result);
    }
    static void swap( int[] nums ,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
