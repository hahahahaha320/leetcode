package com.wlw.leetcode;

import java.util.Date;

public class Q25_ReverseNodesinkGroup {

	public static void main(String[] args) {
		Q25_ReverseNodesinkGroup test = new Q25_ReverseNodesinkGroup();
		
		Date start = new Date();
		
		ListNode result = test.reverseKGroup(ListNode.makeList(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}),5);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode pre = null;
		ListNode[] helpList = makeHelpList(head, k);
		
		ListNode first = head;
		if(helpList[k-1] == null)	{
			return first;
		} 
		first = helpList[k-1];
		while(helpList[k-1] != null)	{
			for(int i=k-1;i>0;i--)	{
				helpList[i].next = helpList[i-1];
			}
			helpList[0].next =  helpList[k];
			if(pre != null)	{
				pre.next = helpList[k-1];
			}
			if(helpList[k] != null)	{
				pre = helpList[0];
				helpList = makeHelpList(helpList[k],k);
			} else {
				return first;
			}
		}
		return first;
		
    }
	private ListNode[] makeHelpList(ListNode head, int k)	{
		ListNode[] list = new ListNode[k+1];
		try	{
			for(int i=0;i<=k;i++)	{
				list[i] = head;
				head = head.next;
			}
		} catch(Exception e )	{
		}
		return list;
	}
}

