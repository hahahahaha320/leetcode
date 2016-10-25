package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Q99_RecoverBinarySearchTree {

	public static void main(String[] args) {
		Q99_RecoverBinarySearchTree test = new Q99_RecoverBinarySearchTree();
		
		Date start = new Date();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		test.recoverTree(node1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(node1);
	}
	
	
	public void recoverTree(TreeNode root) {
		if(root==null)	{
			return;
		}
        List<Integer> midOrderList = midOrder(root);
        Collections.sort(midOrderList);
        recoverTreeRec(root,midOrderList,0,new HashMap<TreeNode,Integer>());
    }
	
	public void recoverTreeRec(TreeNode root,List<Integer> orderList,int start,Map<TreeNode,Integer> cache) {
        int leftClildNum = nodeNum(root.left,cache);
        root.val = orderList.get(start+leftClildNum);
        if(root.left != null)	{
        	recoverTreeRec(root.left, orderList, start,cache);
        }
        if(root.right != null)	{
        	recoverTreeRec(root.right, orderList, start+leftClildNum+1,cache);
        }
	}
	
	public List<Integer> midOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)	{
			return result;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
	    while(cur!=null||!s.empty()) {
	        while(cur!=null) {
	            s.push(cur);
	            cur=cur.left;
	        }
	        if(!s.empty()) {
	        	cur = s.pop();
	        	result.add(cur.val);
	        	cur = cur.right;
	        }
	    }
	    return result;
    }
	
	public int nodeNum(TreeNode root,Map<TreeNode,Integer> cache) {
		if(root == null)	{
			return 0;
		}
		if(cache.get(root) != null)	{
			return cache.get(root);
		}
	    int num = nodeNum(root.left,cache)+nodeNum(root.right,cache)+1;
	    cache.put(root,num);
	    return num;
    }
}

