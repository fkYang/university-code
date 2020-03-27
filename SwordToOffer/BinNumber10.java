package SwordToOffer;

import java.util.Scanner;


public class BinNumber10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int temp = 1;
		while(true) {
			temp = in.nextInt();
			System.out.println(Integer.toBinaryString(temp));
			System.out.println(wei(temp));
			System.out.println(move(temp));
		}
	}
	static int wei(int n) {
		int ans = 0;
		while(n!=0) {
			ans++;
			n = n & (n - 1);
			//最低二进制位，减一后，该位为0，其他低位是一，&之后，该位置为0
		}
		return ans;
	}
	
	static int move(int n) {
		int ans = 0;
		int flag = 1;
		while(flag != 0) {
			if( (n & flag) != 0)
				ans++;
			//对flag进行移位，防止负数右移时，带着符号右移
			flag = flag << 1;
		}
	return ans;
	}
}
