package com.wlw.leetcode;

import java.util.Date;
import java.util.Stack;

import com.wlw.leetcode.util.TreeNode;

public class Q99_RecoverBinarySearchTree3 {

	public static void main(String[] args) {
		Q99_RecoverBinarySearchTree3 test = new Q99_RecoverBinarySearchTree3();
		
		Date start = new Date();
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		
		test.recoverTree(node1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(node1);
	}
	public void recoverTree(TreeNode root) {
		if(root==null)	{
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode cur = root;
		TreeNode frontNode = null;
        TreeNode backNode = null;
	    while(cur!=null||!s.empty()) {
	        while(cur!=null) {
	            s.push(cur);
	            cur=cur.left;
	        }
	        if(!s.empty()) {
	        	cur = s.pop();
	        	if(pre!=null && pre.val > cur.val)	{
	        		if(frontNode == null)	{
	    				frontNode = pre;
	    			} 
	    			backNode = cur;
	        	}
	        	pre = cur;
	        	cur = cur.right;
	        }
	    }
        if(frontNode != null && backNode != null)	{
        	 int tmp = frontNode.val;
             frontNode.val = backNode.val;
             backNode.val = tmp;
        }
    }
}
