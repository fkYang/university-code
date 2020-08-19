package interview.examOnline.qianxin;

import java.util.*;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/1
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int n = in.nextInt();
        int[][] kinds = new int[n][2];
        for( int i = 0 ; i < n ; i++){
            kinds[i][0] = in.nextInt();
            kinds[i][1] = in.nextInt();
        }
        in.close();
        sort(kinds);
        Set<Integer> set = new HashSet<>();
        int max = getMax(money, n, kinds, 0, set, 0);
        System.out.println(max);
    }
    static void sort(int[][] kinds){
        Arrays.sort(kinds, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                //w1*p2 < w2*p1
                return  -(first[1]*second[0] - first[0]*second[1]);
            }
        });

    }


   static int getMax(int money, int n, int[][] kinds, int index, Set<Integer> numKinds,int result){
        if(index >= kinds.length  )
            return 0;
        //优先第一个，其次第二个
       //不拿当前
       int sencond =  getMax(money, n, kinds, index+1, numKinds,result);

        int first = 0;
        //拿当前
        if(money > kinds[index][0] ){
            if(numKinds.contains(index) || numKinds.size() + 1 <= n ){
                money = money - kinds[index][0];
                first += kinds[index][1];
                numKinds.add(index);
                first +=  getMax(money, n, kinds, index, numKinds,result);
                //  result -= kinds[index][1];
//                numKinds.remove(index);
//                money = money + kinds[index][0];
            }
                //return result;
        }
        return  result + Math.max(first, sencond);
    }

}
