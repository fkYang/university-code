package interview.examOnline.pdd;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/2
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        Integer[][] arr =new Integer[m][6];
        for(int i = 0 ; i < m ; i++){
            for( int j = 0 ; j < 6 ; j++){
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        List<Integer[]> list = getList(arr, m);
        List<Integer> ans = getAns(list);

        ans.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i = o1 - o2;
                return -i;
            }
        });
        System.out.println(ans.size());
        for(int i = 0 ; i < ans.size() ;i++){
            System.out.print(ans.get(i) + " ");
        }
    }

    static List<Integer[]> getList(Integer[][] arr , int m){
        List<Integer[]> ans = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            int index =0;
            for( int j = 0 ; j < 6 ; j++){
                if(arr[i][j] == 1){
                    index = j ;
                    break;
                }
            }
            switch(index){
                case 0 :
                    break;
                case 1://上下翻转
                    swap(arr[i],0,1);
                    swap(arr[i],4,5);
                    break;
                case 2://左右反
                    swap(arr[i],0,2);
                    swap(arr[i],1,3);
                    break;
                case 3:
                    swap(arr[i],3,0);
                    swap(arr[i],1,2);
                    break;
                case 4:
                    swap(arr[i],4,0);
                    swap(arr[i],5,1);
                    break;
                case 5:
                    swap(arr[i],5,0);
                    swap(arr[i],4,1);
                    break;
            }
          //  Integer[]
            swap(arr[i],3,4);// 上下，左前右后
            ans.add(arr[i]);
        }
        return ans;
    }

    static List<Integer> getAns( List<Integer[]> list){
        List<Integer> ans = new LinkedList<>();
        while(!list.isEmpty()){
            Integer[] temp = list.get(0);
            list.remove(0);
            int nums = 1;
            for( int i = 0 ; i < list.size() ; ){
                if( isValid(temp, list.get(i))){
                    list.remove(i);
                    nums++;
                }else{
                    i++;
                }
            }
            ans.add(nums);
        }
        return ans;
    }


    static boolean isValid(Integer[] first ,Integer[] second){
        if( !first[1].equals(second[1]))
            return  false;
        int index = 0;
        int one ,two;
        one = first[2]*1000+first[3]*100+ first[4]*10+first[5]*1;
        for( int i = 2 ; ;i++){
            if(first[2].equals(second[i])){
                index = i;
                break;
            }
        }
        switch (index){
            case 2:
                two = second[2]*1000+second[3]*100+ second[4]*10+second[5];
                if(two == one )return true;
//                two = second[2]*1000+second[5]*100+ second[4]*10+second[3];
//                if(two == one )return true;
                break;
            case 3:
                two = second[3]*1000+second[4]*100+ second[5]*10+second[2];
                if(two == one )return true;
//                two = second[3]*1000+second[2]*100+ second[5]*10+second[4];
//                if(two == one )return true;
                break;
            case 4:
                two = second[4]*1000+second[5]*100+ second[2]*10+second[3];
                if(two == one )return true;
//                two = second[4]*1000+second[3]*100+ second[2]*10+second[5];
//                if(two == one )return true;
                break;
            case 5:
                two = second[5]*1000+second[2]*100+ second[3]*10+second[4];
                if(two == one )return true;
//                two = second[5]*1000+second[4]*100+ second[3]*10+second[2];
//                if(two == one )return true;
                break;
        }
        return false;
    }
    static void swap(Integer[] arr ,int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
