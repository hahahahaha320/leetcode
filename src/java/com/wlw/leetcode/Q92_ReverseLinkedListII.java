package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.ListNode;

public class Q92_ReverseLinkedListII {

	public static void main(String[] args) {
		Q92_ReverseLinkedListII test = new Q92_ReverseLinkedListII();
		
		Date start = new Date();
		
		ListNode head = ListNode.makeList(new int[]{1,2,3,4,5});
		Object result = test.reverseBetween(head,1,5);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head,firstEnd = head,second = head,third = head;
        
        for(int i=1;i<=n+1;i++)	{
        	if(i==m-1)	{
        		second = cur.next;
        		firstEnd = cur;
        	}
        	if(i==n)	{
        		third = cur.next;
        		cur.next = null;
        		break;
        	}
        	cur = cur.next;
        }
        while(second != null)	{
        	ListNode next = second.next;
        	second.next = third;
        	third = second;
        	second = next;
        }
        if(m == 1)	{
        	return third;
        }
        firstEnd.next = third;
        return head;
    }
}

