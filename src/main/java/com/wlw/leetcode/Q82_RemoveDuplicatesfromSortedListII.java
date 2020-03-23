package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.ListNode;

public class Q82_RemoveDuplicatesfromSortedListII {

	public static void main(String[] args) {
		Q82_RemoveDuplicatesfromSortedListII test = new Q82_RemoveDuplicatesfromSortedListII();
		
		Date start = new Date();
		
		int[] nums = new int[]{1,2,2};
		Object result = test.deleteDuplicates(ListNode.makeList(nums));
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)	{
			return head;
		}
		int preVal = head.val-1;
		ListNode newHead = new ListNode(preVal);
		ListNode newLast = newHead;
		ListNode cur = head;
		while(cur != null)	{
			if(cur.val != preVal && (cur.next == null || cur.val != cur.next.val))	{
				newLast.next = new ListNode(cur.val);
				newLast = newLast.next;
			}
			preVal = cur.val;
			cur = cur.next;
		}
		return newHead.next;
    }
}

