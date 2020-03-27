package leecode;


public class Mianshi1716 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {1,2,3,1};
		int[] nums = {};
		System.out.println(massage(nums));
	}
	static public int massage(int[] nums) {
		if( nums== null || nums.length <=0 )
			return 0;
		int zero = 0;
		int one = nums[0];
		for( int i = 1 ; i < nums.length ; i++) {
			//0
			int tempzero = zero;
			int tempone = one;
			zero = Math.max(tempzero, tempone);
			one = nums[i] + tempzero;
		}
		return Math.max(zero, one);
	 }
	static void dp(int [][]nums , int start ) {
		
	}

}
