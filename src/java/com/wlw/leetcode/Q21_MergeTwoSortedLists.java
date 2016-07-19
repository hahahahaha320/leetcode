package com.wlw.leetcode;

import java.util.Date;

public class Q21_MergeTwoSortedLists {
	
	public static void main(String[] args) {
		Q21_MergeTwoSortedLists test = new Q21_MergeTwoSortedLists();
		
		Date start = new Date();
		
		ListNode result = test.mergeTwoLists(ListNode.makeList(new int[]{3,1,6,7}),ListNode.makeList(new int[]{5,4}));
		System.out.println(result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode cur = result;
		while(l1 != null && l2 != null)	{
			if(l1.val <= l2.val)	{
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if(l1 == null)	{
			cur.next = l2;
		} else if(l2 == null)	{
			cur.next = l1;
		}
		return result.next;
    }
}
