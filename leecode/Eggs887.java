package leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Eggs887 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//
	public int superEggDrop(int K, int N) {
		int[][] dp = new int[K + 1][N + 1];
		int m = 0;
		for ( m = 1; dp[K][m] < N; m++)
		    for (int k = 1; k <= K; k++)
		        dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
		return m;
	}
	
	
	/*
	static Map<Pair,Integer> result = new HashMap<Eggs887.Pair,Integer>();
	int  dp(int k , int n) {
		if( k == 1 || n == 0) {
			result.put(new Pair(k, n), 0);
			return 0;
		}
		while()
	}
	public int superEggDrop(int K, int N) {
		
	}
	class Pair{
		public int x;
		public int y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}*/
	//线性查找
    public int superEggDropLining(int K, int N) {
        int[][] middleResults = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            middleResults[1][i] = i; // only one egg
            middleResults[0][i] = 0; // no egg
        }
        for (int i = 1; i <= K; i++) {
            middleResults[i][0] = 0; // zero floor
        }

        for (int k = 2; k <= K; k++) { // start from two egg
            for (int n = 1; n <= N; n++) {
                int tMinDrop = N * N;
                for (int x = 1; x <= n; x++) {
                    tMinDrop = Math.min(tMinDrop, 1 + Math.max(middleResults[k - 1][x - 1], middleResults[k][n - x]));
                }
                middleResults[k][n] = tMinDrop;
            }
        }

        return middleResults[K][N];
    }
//二分查找
Map<Integer, Integer> cache = new HashMap<>();
    
    public int superEggDropMidSearch(int K, int N) {
        if (N == 0)
            return 0;
        else if (K == 1)
            return N;

        Integer key = N * 1000 + K; // K <= 100
        if (cache.containsKey(key))
            return cache.get(key);

        int low = 1, high = N;
        while (low + 1 < high) {
            int middle = (low + high) / 2;
            int lowVal = superEggDrop(K - 1, middle - 1);
            int highVal = superEggDrop(K, N - middle);

            if (lowVal < highVal)
                low = middle;
            else if (lowVal > highVal)
                high = middle;
            else
                low = high = middle;
        }
        int minimum = 1 + Math.min(
                Math.max(superEggDrop(K - 1, low - 1), superEggDrop(K, N - low)),
                Math.max(superEggDrop(K - 1, high - 1), superEggDrop(K, N - high))
        );

        cache.put(key, minimum);

        return cache.get(key);
    }


	
}


