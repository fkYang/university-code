package leecode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Water363 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean canMeasureWater(int x, int y, int z) {
	     if( x + y < z )
	        return false;
	     Set<Integer> results = new HashSet<Integer>();
	     Queue<Integer> temp = new LinkedList<Integer>();
	     temp.add(0);
	     while(!temp.isEmpty()) {
	    	 int n = temp.poll();
	    	 if( n + x <= x + y && results.add(n+x))
	    		 temp.add(n+x);
	    	 if( n - x >= 0 && results.add(n-x))
	    		 temp.add(n-x);
	    	 if( n + y <= x + y && results.add(n+y))
	    		 temp.add(n+y);
	    	 if( n - y >= 0 && results.add(n-y))
	    		 temp.add(n-y);
	    	 if(results.contains(z))
	    		 return true;
	     }
	     return false;    
	  }

}
