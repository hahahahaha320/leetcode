package com.wlw.leetcode;

import java.util.Date;

import com.wlw.leetcode.util.TreeNode;

public class Q99_RecoverBinarySearchTree4 {

	public static void main(String[] args) {
		Q99_RecoverBinarySearchTree4 test = new Q99_RecoverBinarySearchTree4();
		
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
	TreeNode node1 = null;
    TreeNode node2 = null;
    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
    
    TreeNode prev = null;
    private void inorderTraverse(TreeNode root) {
        if(root == null)	{
            return;
        }
        if(root.left != null)	{
        	inorderTraverse(root.left);
        }
        if(prev != null && root.val <= prev.val) {
            if (node1 == null) {
                node1 = prev;
            }
            node2 = root;
        }
        prev = root;
        if(root.right != null)	{
        	inorderTraverse(root.right);
        }
    }
}
