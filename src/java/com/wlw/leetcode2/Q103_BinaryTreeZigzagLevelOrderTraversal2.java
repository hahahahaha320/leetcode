package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Q103_BinaryTreeZigzagLevelOrderTraversal2 {

	public static void main(String[] args) {
		Q103_BinaryTreeZigzagLevelOrderTraversal2 test = new Q103_BinaryTreeZigzagLevelOrderTraversal2();
		
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
        if(root == null) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
            
        helper(root, list, 0);
        
        return list;
    }
    
    public void helper(TreeNode root, List<List<Integer>> list, int level) {
        
        if(root == null) return;
        
        if(list.size() <= level) {
            list.add(level, new LinkedList<Integer>());
        }
        
        if(level%2==0) list.get(level).add(root.val);
        else list.get(level).add(0,root.val);
        
        helper(root.left, list, level+1);
        helper(root.right, list, level+1);
    }
}

