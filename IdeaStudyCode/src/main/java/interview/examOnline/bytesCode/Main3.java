package interview.examOnline.bytesCode;

import java.util.*;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/5/11
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//nus soc
        int m = in.nextInt(); //days
        int [] colors = new int[n];
        for( int i = 0 ; i < n ; i++){
            colors[i] = in.nextInt();
        }
        List<Set<Integer>> listSet = new ArrayList<>(m);//set ,袜子的下标
        for( int i = 0 ; i < m ; i++){
            listSet.add(new HashSet<>());
        }
        for( int i = 0 ; i < m ;i++){
            int left = in.nextInt();
            int right = in.nextInt();
            for( int j = 0 ; j < m;j++){
                Set<Integer> temp = listSet.get(j);
                if( temp.isEmpty()){
                    temp.add(left);
                    temp.add(right);
                    break;
                }
                if( temp.contains(left)){
                    temp.add(right);
                    break;
                }
                else if( temp.contains(right)){
                    temp.add(left);
                    break;
                }


            }
        }
        int result =0;
        int [] tempColorNums = new int[n] ;//set 中，颜色对数
        //计算染色树
        for( int i = 0 ; i < m ; i++){
            for( int k = 0 ; k < n ; k++){
                tempColorNums[k] = 0;
            }
            Set<Integer> temp = listSet.get(i);
            if( temp.size() == 0)
                break;
            Iterator<Integer> iterator = temp.iterator();
            while(iterator.hasNext()){
               int index = colors[iterator.next() -1] - 1;
               tempColorNums[index] = tempColorNums[index] +1;
            }
            //max
            int max = 0;
            for( int j = 0 ; j < n ;j++){
                max = Math.max(max,tempColorNums[j]);
            }
            result += temp.size()-max;
        }
        System.out.println(result);
    }
}
