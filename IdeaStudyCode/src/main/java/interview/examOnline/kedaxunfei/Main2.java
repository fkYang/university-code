package interview.examOnline.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ÀàÃèÊö
 *
 * @author yfk
 * @date 2020/8/15
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for( int i = 0 ; i < num ; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        Arrays.sort(arr);
        for( int i = 0 ; i < num;i++)
            System.out.print(arr[i]+" ");
       // QuickSort(arr, 0, num);

    }

//    public static int[] QuickSort(int[] array, int start, int end) {
//
//        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
//        //ÅÅĞò
//        int smallIndex = partition(array, start, end);
//        // ×ó£¬ÓÒ  ÅÅĞò
//        if (smallIndex > start)//ÖÕÖ¹Ìõ¼ş
//            QuickSort(array, start, smallIndex - 1);
//        if (smallIndex < end)////ÖÕÖ¹Ìõ¼ş
//            QuickSort(array, smallIndex + 1, end);
//        return array;
//    }
//    public static int partition(int[] array, int start, int end) {
//        int pivot = (int) (start + Math.random() * (end - start + 1));
//        int smallIndex = start - 1;
//        smallIndex++;
//        swap(array, pivot, end);
//        for (int i = start; i <= end; i++)
//            if (array[i] <= array[end]) {
//                swap(array, i, smallIndex);
//                smallIndex++;
//            }
//        return smallIndex-1;
//    }
//
//    public static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

}
