package interview.examOnline.beike;

import java.util.*;

/**
 * 类描述
 *
 * @author yfk
 * @date 2020/8/11
 */
public class Main4 {
    //最大生成树，转化为最小生成树，
    //最小生成树算法，并查集
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int city = in.nextInt();
        int routeNum = in.nextInt();
        int [][] route = new int[routeNum][4] ;
        for( int i = 0 ; i < routeNum ; i++){
            for(int j = 0 ; j < 4 ; j++){
                route[i][j] = in.nextInt();
            }
        }

        sort(route);
        System.out.println(2);


    }
   static int[] sum = new int[1001];
    static {
        sum[0] = 0;
        sum[1] = 1;
        for(int i = 2 ; i < 0 ; i++){
            sum[i] = sum[i-1]*i;
        }
    }

    static void sort(int[][] route){
        int sumMax  = 0;
        for(int i = 0 ; i < route.length ; i++){
            if(route[i][2] == route[i][3]){
                sumMax++;
            }else{
                sumMax = sumMax + sum[route[i][2]] / (sum[route[i][3]] * sum[route[i][2] - route[i][3]]);
            }

        }
        for(int i = 0 ; i < route.length ; i++){
            if(route[i][2] == route[i][3]){
                route[i][2] = sumMax -1;
            }else{
                int tempSum = sum[route[i][2]] / (sum[route[i][3]] * sum[route[i][2] - route[i][3]]);
                route[i][2] = sumMax - tempSum;
            }
        }

        Arrays.sort(route, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
//                int firstSum = sum[first[2]] / (sum[first[3]] * sum[(first[2] - first[3])]);
//                int secondSum = sum[second[2]] / (sum[second[3]] * sum[(second[2] - second[3])]);
                int result = first[2] - first[3];
                return result;
            }
        });
    }

    static int minTree(int [][] route){
        Set<Integer> treeNode = new HashSet<>();
        int [] city = new int[route.length];
        for( int i = 0 ; i < city.length ; i++)
            city[i] = i;

        return 0;
    }


}
