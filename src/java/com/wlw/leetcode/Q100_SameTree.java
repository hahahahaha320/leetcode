package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.TreeNode;

public class Q100_SameTree {

	public static void main(String[] args) {
		Q100_SameTree test = new Q100_SameTree();
		
		Date start = new Date();
		
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(10);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(20);
		
		node1.left = node2;
		node1.right = node3;
		
		node4.left = node5;
		node4.right = node6;
		
		Object result = test.isSameTree(node6,null);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null)	{
			return true;
		}
        if(p==null && q!=null || p!=null &&q==null || p.val != q.val ||
        	!isSameTree(p.left,q.left) || !isSameTree(p.right,q.right))	{
        	return false;
        }
        return true;
    }
}

