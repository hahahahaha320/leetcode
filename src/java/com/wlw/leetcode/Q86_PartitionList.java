package com.wlw.leetcode;

import java.util.Date;

public class Q86_PartitionList {

	public static void main(String[] args) {
		Q86_PartitionList test = new Q86_PartitionList();
		
		Date start = new Date();
		
		ListNode head = ListNode.makeList(new int[]{1,4,3,2,5,2});
		Object result = test.partition(head,3);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public ListNode partition(ListNode head, int x) {  
		ListNode cur = head;
		ListNode smallList = new ListNode(0);
		ListNode smallLast = smallList;
		ListNode greatList = new ListNode(0);
		ListNode greatLast = greatList;
		
		while(cur != null)	{
			ListNode next = cur.next;
			if(cur.val >= x)	{
				greatLast.next = cur;
				greatLast = greatLast.next;
				greatLast.next = null;
			} else {
				smallLast.next = cur;
				smallLast = smallLast.next;
				smallLast.next = null;
			}
			cur = next;
		}
		smallLast.next = greatList.next;
		return smallList.next;
	}
}

