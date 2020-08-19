package interview.examOnline.Emm;

/**
 * ¿‡√Ë ˆ
 *
 * @author yfk
 * @date 2020/7/20
 */
public class Emm {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int nums = in.nextInt();
//        for( int i = 0 ; i < nums ; i++){
//            int k = in.nextInt(), n = in.nextInt();
//            int[] arr = new int[n];
//            for( int j = 0 ; j < n ; j++){
//                arr[j] = in.nextInt();
//            }
//            int[] max = max(arr, k);
//            for( int j = 0 ; j < max.length ; j++){
//                if( j == max.length - 1){
//                    System.out.println(max[j] + " ");
//                }else{
//                    System.out.print(max[j] + " ");
//                }
//            }
////            System.out.println();
//        }
//        in.close();;
        int [] arr = {4,3,2,1};
        int k = 2;

        System.out.println(max(arr, k));
    }

    static int[] max(int [] arr,int k){
        int result = 0;
        int size = k;
        int start = 0;
        while (size > 0){
            //getMax
            int maxIndex = start;
            for( int i = start + 1 ; i <=  start + size && i < arr.length; i++){
                if( arr[i] > arr[maxIndex])
                    maxIndex = i;
            }
            //move
            int temp = arr[maxIndex];
            for( int i = maxIndex ; i > start ;i--){
                arr[i] = arr[i-1];
            }
            arr[start ] =temp;
            //change
            //maxIndex - start¥Œ move
            size = size - ( maxIndex - start);
            if(maxIndex - start == 0 && size + start > arr.length ){
                if( (size & 1) == 0)
                    break;
               int temp2 = arr[arr.length - 1];
               arr[arr.length-1] =  arr[arr.length - 2];
                arr[arr.length - 2] = temp2;
            }
            start++;
        }
//        for( int i = 0 ; i < arr.length ; i++){
//            result = result*10 + arr[i];
//        }
        return  arr;
    }
}
