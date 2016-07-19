package com.wlw.leetcode;

public class Q02_AddTwoNumbers {
	
	
	
	public static void main(String[] args) {
		
		Q02_AddTwoNumbers test =  new Q02_AddTwoNumbers();
		ListNode l1 =  test.bulidListNode(new int[]{9,3,4,4,5});
		ListNode l2 =  test.bulidListNode(new int[]{8,6,6,1,6,9});
		
		ListNode result = test.addTwoNumbers(l1, l2);
		test.printListNode(l1);
		test.printListNode(l2);
		
		test.printListNode(result);
		
	}
	private ListNode bulidListNode(int[] arr)	{
		ListNode result = new ListNode(arr[0]);
		ListNode cur = result;
		for(int i=1;i<arr.length;i++)	{
			ListNode newNode = new ListNode(arr[i]);
			cur.next = newNode;
			cur = newNode;
		}
		return result;
	}
	private void printListNode(ListNode l1)	{
		while(l1 != null){
			System.out.print(l1.val + ",");
			l1 = l1.next;
		}
		System.out.println();
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
        ListNode first = new ListNode(0);
        int add = 0;
        ListNode result = first;
        while(l1!=null || l2 != null){
        	ListNode cur = new ListNode(0);
            if(l1!=null){
                cur.val = l1.val;
                l1 =l1.next;
            }
            if(l2!=null){
                cur.val = cur.val + l2.val;
                l2=l2.next;
            }
            cur.val = cur.val + add;
            
            add = cur.val>=10?1:0;
            cur.val = cur.val%10;
            result.next = cur;
            result=cur;
        }
        if(add == 1)    {
            result.next = new ListNode(1);
        }
        return first.next;
    }
	//TODO:另一个简单方法：
	//根据链接算出1个数字，然后把2个数字相加，最后把和转化成 链接
}
