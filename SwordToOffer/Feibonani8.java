package SwordToOffer;

import java.util.Scanner;


public class Feibonani8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true) {
			int n = in.nextInt();
			System.out.println(fibonacci(n));
		}
		//in.close();
	}
	static  public long fibonacci(int n) {
	        long result=0;
	        long preOne=1;
	        long preTwo=0;
	        if( n < 0)
	        	return 0;
	        if(n < 2) {
	            return n;
	        }
	      
	        for (int i = 2; i <= n; i++) {
	            result = preOne+preTwo;
	            preTwo = preOne;
	            preOne = result;
	        }
	        return preOne;
	    }
}
