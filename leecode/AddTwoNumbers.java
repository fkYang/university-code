package leecode;

public class AddTwoNumbers {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int goal = 0;
        ListNode result = new ListNode(0);
        ListNode ans = result;
        while( l1 != null && l2 != null) {
        	int nums = l1.val + l2.val + goal;
        	goal = nums / 10;
        	ListNode temp = new ListNode(nums % 10);
        	result.next = temp;
        	result = result.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while( l1 != null) {
        	int nums = l1.val+ goal;
        	goal = nums / 10;
        	ListNode temp = new ListNode(nums % 10);
        	result.next = temp;
        	result = result.next;
        	l1 = l1.next;
        }
        while( l2 != null) {
        	int nums =  l2.val + goal;
        	goal = nums / 10;
        	ListNode temp = new ListNode(nums % 10);
        	result.next = temp;
        	result = result.next;
        	l2 = l2.next;
        }
        if( goal != 0) {
        	ListNode temp = new ListNode(goal);
        	result.next = temp;
        }
        return ans.next;
       }
    
}

