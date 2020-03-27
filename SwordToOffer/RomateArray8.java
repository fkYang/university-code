package SwordToOffer;

public class RomateArray8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] t = {3,4,8,1,2};
		System.out.println(rotateMin(t));
		//System.out.println(t);
		for(int i = 0 ; i < t.length ; i++)
			System.out.println(t[i]);
	}
	static int rotateMin(int [] goal) {
		if(goal== null || goal.length == 0)
			return 0;
		int left = 0 ;
		int right = goal.length - 1;
		int mid = (left + right)/2;;
		while(goal[left] >= goal[right]) {
			mid = (left + right)/2;
			if(right - left == 1)
				return goal[right];
			if(goal[mid] >= goal[left])
				left = mid;
			if(goal[mid] <= goal[right]) {
				right = mid;
			}
		}
	return goal[right];
	}

}
