package com.wlw.leetcode1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wlw.leetcode.util.ParamUtil;
import com.wlw.leetcode.util.TreeNode;

public class Q145_BinaryTreePostorderTraversal {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q145_BinaryTreePostorderTraversal test = new Q145_BinaryTreePostorderTraversal();
		
		Date start = new Date();
		
		String testStr = "1,2,3,4,5,6";
		TreeNode root = ParamUtil.str2TreeNode(testStr);
		ParamUtil.printTreeNode(root);
		
		Object result = test.postorderTraversal(root);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
	}
	public void helper(TreeNode root,List<Integer> result)	{
		if(root == null)	{
			return;
		}
		if(root.left != null)	{
			helper(root.left, result);
		}
		if(root.right != null)	{
			helper(root.right, result);
		}
		result.add(root.val);
	}
}

