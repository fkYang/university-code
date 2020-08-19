package interview.examOnline.qianxin;

import java.util.LinkedList;
import java.util.List;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/1
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 goal = new Solution2();
        int [] arr = {1,1,2};
        int i = goal.reletive_7(arr);
        System.out.println(i);
    }
    /**
     * 返回亲7数个数
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    int nums = 0;
    public int reletive_7 (int[] digit) {
        // write code here
     //   int result = 0;
        List<Integer> goal = new LinkedList<>();
        getAll(digit,0,goal);
        //find all
        //test nums
        return nums;
    }
    void getAll(int[] arr , int index ,  List<Integer> goal){
        if(index == arr.length){
            int result = getNum(goal);
            if(isValid(result)){
               nums++;
                return ;//nums;
            }
        }
        for(int i = index ; i < arr.length ; i++){
            swap(arr, index,i);
            goal.add(arr[index]);
            getAll(arr, index+1, goal);
            goal.remove(goal.size()-1);
            swap(arr, index,i);
        }
    }

    void swap(int[] arr,int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    boolean isValid(int result){
        if( result%7 == 0)
            return true;
        return false;
    }

    int getNum(List<Integer> integers){
        int result = 0;
        int i = 0;
        while(i < integers.size()){
            result = result*10 + integers.get(i);
            i++;
        }
        return result;
    }
}
