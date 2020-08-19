package interview.examOnline.ali;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++)
            arr[i] = in.nextInt();
        in.close();

        int result = nums(arr, m);
        System.out.println(result);
        //hashmap，最多的元素

    }
    //时间复杂度，还可以提高，hashmap，一轮计算完毕，减去首，看看max 次数 是否  m
    // ==m:前面的继续减
    // 《= ： 往后面加
    static int nums( int[] arr,int m){
        int result = 0;
        for( int i = 0 ; i < arr.length ; i++){//begin
            Map<Integer , Integer > map = new HashMap<>();
            for( int j = i ; j < arr.length ; j++){//此开始的所有
                int size = 1;
                if(map.containsKey(arr[j])){
                    size = map.get(arr[j]) + 1;//当前出现的次数
                    if(size >= m){
                        result = result + arr.length - j;
                        break;
                    }
                }
                map.put(arr[j],size);
            }

        }
        return  result;
    }

}