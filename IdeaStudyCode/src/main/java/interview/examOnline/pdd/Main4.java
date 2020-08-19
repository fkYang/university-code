package interview.examOnline.pdd;

import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] map = new char[6][6];
        for(int i = 0 ; i <6 ; i++){
            String next = in.next();
            for(int j = 0 ; j < 6 ; j++){
                map[i][j] = next.charAt(j);
            }
        }
        in.close();

//        for(int i = 0 ; i <6 ; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }

    }

    static int getNums(char[][] map){
        int ans = 0;
        Set<Integer> [][] demo = new Set[6][6];

        return ans;
    }
}