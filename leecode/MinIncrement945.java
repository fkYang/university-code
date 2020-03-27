package leecode;

import java.util.Arrays;


public class MinIncrement945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = new int[6];
		//[3,2,1,2,1,7]
				A[0] = 3 ;
		A[1] = 2;
		A[2] = 1;
		A[3]=2;
		A[4] =1;
		A[5]= 7;
			System.out.println(minIncrementForUnique(A));
	}
	//guibing
	//·Ö£¬ºÍ
	static  public int minIncrementForUnique(int[] A) {
		/* int result = 0;
		 Set<Integer> unique = new HashSet<Integer>();
		int i = 0;
		for(; i< A.length ; i++ ) {
			while(unique.contains(A[i])) {
				A[i]++;
				result++;
			}
			unique.add(A[i]);
		}
		return result;*/
		/*
		int[] count = new int[80000];
        for (int x: A) count[x]++;
        int ans , moved;
        ans = moved = 0;
        for(int i = 0 ; i < 80000 ; i++) {
        	if(count[i] >=2 )
        	{
        		moved += count[i] - 1;
        		ans -= i*(count[i] -1);
        	}
        	else if( moved >0 && count[i] == 0)
        	{
        		moved--;
        		ans += i; 
        	}
        }
        return ans;*/
		Arrays.sort(A);
		int startNum,endNum,repeat;
		startNum = endNum = repeat = 0;
		for(int i = 1 ; i < A.length ; i++ ) {
			if(A[i] == A[i-1]) {
				repeat++;
				startNum += A[i];
			}else if( repeat > 0 )
			{
				int temp = A[i] - A[i-1] -1;
				int min = Math.min(temp, repeat);
				repeat -= min;
				endNum += (A[i-1] + 1 + A[i-1]  + min)*min /2;
			}
		}
		if(A.length > 0  ){
            endNum += A[A.length -1 ]* repeat + repeat*(repeat+1)/2;
          //  endNum += ( A[A.length -1] + 1 + A[A.length -1] + repeat) * repeat /2;
        }
		return endNum - startNum;
	  }
	 

}
