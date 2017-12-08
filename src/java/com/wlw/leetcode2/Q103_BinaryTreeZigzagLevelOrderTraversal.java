package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		Q103_BinaryTreeZigzagLevelOrderTraversal test = new Q103_BinaryTreeZigzagLevelOrderTraversal();
		
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
		
		Object result = test.zigzagLevelOrder(node1);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)	{
			return result;
		}
		List<TreeNode> toDealList = new ArrayList<TreeNode>();
        List<TreeNode> resultNodeList = new ArrayList<TreeNode>();
        toDealList.add(root);
        boolean pos = true;
        while(toDealList.size() != 0)	{
        	List<Integer> subResult = new ArrayList<Integer>();
        	for(TreeNode node : toDealList)	{
        		if(pos)	{
        			subResult.add(node.val);
        		} else {
        			subResult.add(0,node.val);
        		}
        		
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
        	pos = !pos;
        }
        return result;
	}
}

