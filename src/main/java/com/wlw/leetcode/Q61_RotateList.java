package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.ListNode;

public class Q61_RotateList {

	public static void main(String[] args) {
		Q61_RotateList test = new Q61_RotateList();
		
		Date start = new Date();
		
		ListNode head = ListNode.makeList(new int[]{});
		ListNode result = test.rotateRight(head,1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public ListNode rotateRight(ListNode head, int k) {
		if(k == 0 || head == null)	{
			return head;
		}
		int len = 0;
		ListNode next = head;
		ListNode tail = head;
		while(next != null)	{
			tail = next;
			len++;
			next = next.next;
			
		}
		k=k%len;
		if(k == 0)	{
			return head;
		}
		ListNode newTail = head;
		ListNode cur = head;
		for(int i=1;i<=len-k;i++)	{
			cur = cur.next;
			if(i == len-k-1)	{
				newTail = cur;
			}
		}
		tail.next = head;
		head = newTail.next;
		newTail.next = null;
        return head;
    }
}

