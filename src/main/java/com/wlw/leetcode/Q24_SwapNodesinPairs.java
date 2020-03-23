package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.ListNode;

public class Q24_SwapNodesinPairs {

	public static void main(String[] args) {
		Q24_SwapNodesinPairs test = new Q24_SwapNodesinPairs();
		
		Date start = new Date();
		
		ListNode result = test.swapPairs(ListNode.makeList(new int[]{1,2,3,4,5,6,7}));
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next==null)	{
			return head;
		}
		ListNode first = head.next;
		ListNode cur = head;
		ListNode pre = new ListNode(0);
		pre.next = head;
        while(cur!=null && cur.next!=null)	{
        	ListNode nextCur =  cur.next.next;
        	pre.next = cur.next;
        	cur.next.next = cur;
        	cur.next = nextCur;
        	cur = nextCur;
        	pre = pre.next.next;
        }
		return first;
    }
}

