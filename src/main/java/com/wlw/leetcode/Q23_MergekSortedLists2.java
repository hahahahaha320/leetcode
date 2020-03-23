package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.wlw.leetcode.util.ListNode;

public class Q23_MergekSortedLists2 {
	
	public static void main(String[] args) {
		Q23_MergekSortedLists2 test = new Q23_MergekSortedLists2();
		
		Date start = new Date();
		ListNode[] lists = new ListNode[]{ListNode.makeList(new int[]{3,1,6,7}),ListNode.makeList(new int[]{5,4}),
				ListNode.makeList(new int[]{2,6})};
		
		ListNode result = test.mergeKLists(lists);
		System.out.println(result);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<lists.length;i++)	{
        	ListNode node = lists[i];
        	while(node != null)	{
        		list.add(node.val);
        		node = node.next;
        	}
        }
        if(list.size() == 0)	{
        	return null;
        }
        Collections.sort(list);
        
        ListNode result = new ListNode(list.get(0));
        ListNode cur = result;
        for(int i=1;i<list.size();i++)	{
        	ListNode newNode = new ListNode(list.get(i));
        	cur.next = newNode;
        	cur = cur.next;
        }
        return result;
    }
	
}
