package com.wlw.leetcode2;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.wlw.leetcode.util.ParamUtil;
import com.wlw.leetcode.util.TreeNode;

public class Q297_SerializeandDeserializeBinaryTree {
	private static long totalCount = 0;
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Q297_SerializeandDeserializeBinaryTree test = new Q297_SerializeandDeserializeBinaryTree();
		
		Date start = new Date();
		
		String str = "1,2,3,n,n,4,5";
		
		Codec codec = new Codec();
		TreeNode root = codec.deserialize(str);
		
		//System.out.println(str);
		//ParamUtil.printTreeNode(root);
		String resultStr = codec.serialize(root);
		root = codec.deserialize(resultStr);
		ParamUtil.printTreeNode(root);
		
		//System.out.println("resultStr:"+resultStr);
		
		Date end = new Date();
		System.out.println();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
	}
	public static class Codec {
		
	    public String serialize(TreeNode root) {
	    	if(root == null)	{
				return "n";
			}
	    	StringBuffer sb = new StringBuffer();
	    	sb.append(root.val+",");
			try	{
				BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
				queue.put(root);
				while(!queue.isEmpty())	{
					TreeNode node = queue.take();
					if(node.left != null)	{
						queue.put(node.left);
						sb.append(node.left.val+",");
					} else {
						sb.append("n,");
					}
					if(node.right != null)	{
						queue.put(node.right);
						sb.append(node.right.val+",");
					} else {
						sb.append("n,");
					}
				}
			} catch(Exception e)	{
				e.printStackTrace();
			}
			return sb.toString();
	    }

	    public TreeNode deserialize(String data) {
	    	String[] sa = data.split(",");
			if("n".equals(sa[0]))	{
				return null;
			}
			TreeNode root = new TreeNode(Integer.parseInt(sa[0]));
			try	{
				BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
				queue.put(root);
				for(int i=1;i<sa.length;)	{
					TreeNode parent = queue.take();
					if(!"n".equals(sa[i]))	{
						parent.left = new TreeNode(Integer.parseInt(sa[i]));
						queue.put(parent.left);
					}
					i++;
					if(i>=sa.length){
						break;
					}
					if(!"n".equals(sa[i]))	{
						parent.right = new TreeNode(Integer.parseInt(sa[i]));
						queue.put(parent.right);
					}
					i++;
				}
			} catch(Exception e)	{
				e.printStackTrace();
				return null;
			}
			return root;
	    }
	}
}

