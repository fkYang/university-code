package leecode;

import java.util.HashSet;
import java.util.Set;

public class MaxLength3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        int left = 0 , right = 0;
        while( left < s.length() && right< s.length()) {
        	if( set.contains(s.charAt(right))) {
        		max = Math.max(max, set.size());
        		set.remove(s.charAt(left));
        		left++;
        		continue;
        	}
        	set.add(s.charAt(right));
        	right++;
        }
       max = Math.max(max, set.size());
       return max;
    }

}
