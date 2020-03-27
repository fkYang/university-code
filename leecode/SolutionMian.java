package leecode;

import java.util.Stack;

public class SolutionMian {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findRepeatNumber(int[] nums) {
        for(int i = 0 ; i < nums.length;i++) {
        	if( nums[nums[i]]!=i ) {
        		nums[i] = nums[nums[i]];
        		nums[nums[i]] = i;
        	}
        	else {
        		return i;
        	}
        }
      //  Math.max
      //  nums.
        return -1;
    }
}
