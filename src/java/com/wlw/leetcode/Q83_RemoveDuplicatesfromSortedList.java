package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.ListNode;

public class Q83_RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {
		Q83_RemoveDuplicatesfromSortedList test = new Q83_RemoveDuplicatesfromSortedList();
		
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
		ListNode newHead = new ListNode(head.val-1);
		ListNode newLast = newHead;
		ListNode cur = head;
		while(cur != null)	{
			if(cur.next == null || cur.val != cur.next.val)	{
				newLast.next = new ListNode(cur.val);
				newLast = newLast.next;
			}
			cur = cur.next;
		}
		return newHead.next;
    }
}

