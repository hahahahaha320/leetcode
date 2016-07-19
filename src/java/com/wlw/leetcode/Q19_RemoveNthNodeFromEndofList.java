package com.wlw.leetcode;

import java.util.Date;

public class Q19_RemoveNthNodeFromEndofList {
	
	public static void main(String[] args) {
		Q19_RemoveNthNodeFromEndofList test = new Q19_RemoveNthNodeFromEndofList();
		
		Date start = new Date();
		
		ListNode result = test.removeNthFromEnd(ListNode.makeList(new int[]{4,5,7,1,2}),5);
		System.out.println(result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int length = 0;
		ListNode cur = head;
		while(cur != null)	{
			length++;
			cur = cur.next;
		}
		if(n == length){
			return head.next;
		}
		cur = head;
		for(int i=0;i<length-n-1;i++)	{
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return head;
    }
}
