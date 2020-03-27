package leecode;

public class MidNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode middleNode(ListNode head) {
		ListNode temp = head;
		if(temp == null )
			return null;
		int nums = 0;
		while(temp.next != null ) {
			nums++;
			temp = temp.next;
		}
		temp = head;
		nums = nums/2;
		for(int i = 0 ; i <= nums ; i++ )
			temp = temp.next;
		return temp;
		
    }
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}

}
