package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class Q99_RecoverBinarySearchTree2 {

	public static void main(String[] args) {
		Q99_RecoverBinarySearchTree2 test = new Q99_RecoverBinarySearchTree2();
		
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
		
		List<TreeNode> midOrderList = test.midOrder(node1);
		for(TreeNode node:midOrderList)	{
			System.out.print(node.val+",");
		}
	}
	
	
	public void recoverTree(TreeNode root) {
		if(root==null)	{
			return;
		}
        List<TreeNode> midOrderList = midOrder(root);
        int wrongNum=0;
        TreeNode frontNode = null;
        TreeNode backNode = null;
        for(int i=0;i<midOrderList.size()-1;i++)	{
    		if(midOrderList.get(i).val > midOrderList.get(i+1).val)	{
    			wrongNum++;
    			if(wrongNum == 1)	{
    				frontNode = midOrderList.get(i);
    			} 
    			backNode = midOrderList.get(i+1);
    		}
        }
        if(frontNode != null && backNode != null)	{
        	 int tmp = frontNode.val;
             frontNode.val = backNode.val;
             backNode.val = tmp;
        }
       
    }
	
	
	public List<TreeNode> midOrder(TreeNode root) {
		List<TreeNode> result = new ArrayList<TreeNode>();
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
	        	result.add(cur);
	        	cur = cur.right;
	        }
	    }
	    return result;
    }
}
