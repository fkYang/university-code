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
			//��Ͷ�����λ����һ�󣬸�λΪ0��������λ��һ��&֮�󣬸�λ��Ϊ0
		}
		return ans;
	}
	
	static int move(int n) {
		int ans = 0;
		int flag = 1;
		while(flag != 0) {
			if( (n & flag) != 0)
				ans++;
			//��flag������λ����ֹ��������ʱ�����ŷ�������
			flag = flag << 1;
		}
	return ans;
	}
}
