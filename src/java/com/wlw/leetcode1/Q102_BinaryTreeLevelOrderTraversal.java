package com.wlw.leetcode1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q102_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		Q102_BinaryTreeLevelOrderTraversal test = new Q102_BinaryTreeLevelOrderTraversal();
		
		Date start = new Date();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		
		Object result = test.levelOrder(node1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)	{
			return result;
		}
		List<TreeNode> toDealList = new ArrayList<TreeNode>();
        List<TreeNode> resultNodeList = new ArrayList<TreeNode>();
        toDealList.add(root);
        while(toDealList.size() != 0)	{
        	List<Integer> subResult = new ArrayList<Integer>();
        	for(TreeNode node : toDealList)	{
        		subResult.add(node.val);
        		if(node.left != null)	{
        			resultNodeList.add(node.left);
        		}
        		if(node.right != null)	{
        			resultNodeList.add(node.right);
        		}
        	}
        	result.add(subResult);
        	List<TreeNode> temp = toDealList;
        	toDealList = resultNodeList;
        	resultNodeList = temp;
        	resultNodeList.clear();
        }
        return result;
	}
}

