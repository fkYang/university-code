package leecode;
import java.util.ArrayList;
import java.util.List;
import  java.util.Stack;;
public class leecode22 {
	char[] elements = new char[2];
	Stack<Character> temp = new Stack<Character>();
	List<String> ansStrings = new ArrayList();
	StringBuilder tempans = new StringBuilder();
	public List<String> generateParenthesis(int n) {
	      elements[0] = '(';
	      elements[1] = ')';
		
		return ansStrings;
	  }
	public void calculate(int n) {
		if(n<=0) {
			ansStrings.add(tempans.toString());
			//tempans.deleteCharAt(index)
			return;
		}
			
		for(int i = 0 ; i < 2 ; i++) {
			temp.add(elements[i]);
			tempans.append(elements[i]);
			calculate(n-1);
			//temp.p
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution {
   
    
}