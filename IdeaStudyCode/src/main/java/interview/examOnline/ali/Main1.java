package interview.examOnline.ali;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        List<LinkedList<Integer>> result = new LinkedList<>();
        if( n < 4 )
            return ;
//初始化
        LinkedList<Integer> indexFirst = new LinkedList<>();
        int [] arr = {2,4,1,3};
        for( int i = 0 ; i < arr.length ; i++)
            indexFirst.add(arr[i]);
        result.add(indexFirst);

        LinkedList<Integer> indexSecond = new LinkedList<>();
        int [] arr2 = {3,1,4,2};
        for( int i = 0 ; i < arr2.length ; i++)
            indexSecond.add(arr2[i]);
        result.add(indexSecond);

        for( int i = 4 ; i <= n ; i++){
            result = caculate(result, i);
        }
//        for(LinkedList<Integer> temp : result) {
//            System.out.println(temp);
//        }
        List<String> goal = new LinkedList<>();
        for(LinkedList<Integer> temp : result) {
            StringBuilder builder = new StringBuilder();
            for( int i = 0 ; i+1 < temp.size() ; i++){
                builder.append(temp.get(i) + " ");
            }
            builder.append(temp.get(temp.size()-1)+"");
            goal.add(builder.toString());
        }
        Collections.sort(goal);
        for( String s: goal)
            System.out.println(s);
        //
//        List<Integer> goal = new LinkedList<>();
//        for(LinkedList<Integer> temp : result) {
//            goal.addAll(temp);
//        }

    }

//        Collections.sort(result);



    //结果集，排序的第几个
   static  List<LinkedList<Integer>> caculate(List<LinkedList<Integer>> result , int n ){
        if(result.get(0).size() == n)
            return result;

        List<LinkedList<Integer>> goal = new LinkedList<>();
        for(LinkedList<Integer> temp : result){


            int index = temp.indexOf(n-1);
            //当前temp，n可以插入的所有可能情况
            for( int i = 0 ; i < n ; i++){
                LinkedList<Integer> tempGoal = new LinkedList<>();
                if( i - index == 1 || i ==index )//相差一
                    continue;
                //当前位置可以插入
                temp.add(i,n);
              //  temp.set(i,n);
               // tempGoal.addAll(temp);
                for( int j = 0 ; j<temp.size() ; j++){
                    tempGoal.add(temp.get(j));
                }
                goal.add(tempGoal);
                temp.remove(i);
            }
        }
        return goal;
    }


}