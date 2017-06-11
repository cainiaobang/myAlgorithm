package cn.itcast;

/**
 You are given two non-empty linked lists representing two non-negative integers.
  The digits are stored in reverse order and each of their nodes contain a single digit. 
  Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}
public class addTwoNumbers {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       ListNode c3=new ListNode(0);
			ListNode result=c3;
			int sum=0;
			while(l1!=null||l2!=null)
			{
				sum/=10;
				if(l1!=null)
				{
					sum+=l1.val;
					l1=l1.next;
				}
				if(l2!=null)
				{
					sum+=l2.val;
					l2=l2.next;
				}
				c3.next=new ListNode(sum%10);
				c3=c3.next;
			}
			if(sum/10==1)
			{
				c3.next=new ListNode(1);
			}
			return result.next;
	    }
}
