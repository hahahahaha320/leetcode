package com.wlw.leetcode;

import java.util.Date;
import java.util.Stack;

import com.wlw.leetcode.util.TreeNode;

public class Q98_ValidateBinarySearchTree {

	public static void main(String[] args) {
		Q98_ValidateBinarySearchTree test = new Q98_ValidateBinarySearchTree();
		
		Date start = new Date();
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(15);
		TreeNode node7 = new TreeNode(25);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		Object result = test.isValidBST(node1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public boolean isValidBST(TreeNode root) {
		if(root == null)	{
			return true;
		}
		if(root.left != null)	{
			if(!isMax(root.left,root.val))	{
				return false;
			}
			if(!isValidBST(root.left))	{
				return false;
			}
		}
		if(root.right != null)	{
			if(!isMin(root.right,root.val))	{
				return false;
			}
			if(!isValidBST(root.right))	{
				return false;
			}
		}
        return true;
    }
	
	public boolean isMin(TreeNode root,int num)	{
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
	    while(cur!=null||!s.empty()) {
	        while(cur!=null) {
	        	if(cur.val <= num)	{
	        		return false;
	        	}
	            s.push(cur);
	            cur=cur.left;
	        }
	        if(!s.empty()) {
	        	cur = s.pop();
	        	cur = cur.right;
	        }
	    }
	    return true;
	}
	public boolean isMax(TreeNode root,int num)	{
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
	    while(cur!=null||!s.empty()) {
	        while(cur!=null) {
	        	if(cur.val >= num)	{
	        		return false;
	        	}
	            s.push(cur);
	            cur=cur.left;
	        }
	        if(!s.empty()) {
	        	cur = s.pop();
	        	cur = cur.right;
	        }
	    }
	    return true;
	}
}

