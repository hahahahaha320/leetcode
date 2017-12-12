package com.wlw.leetcode2;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ParamUtil {
	
	public static List<String> str2List(String str)	{
		str = str.replaceAll("[\r\n\\[\\]\"]","");
		List<String> result = new ArrayList<String>();
		String[] sa = str.split(",");
		for(String a : sa)	{
			result.add(a);
		}
		return result;
	}
	
	public static TreeNode str2TreeNode(String str)	{
		str = str.replaceAll("[\r\n\\[\\]]","");
		String[] sa = str.split(",");
		if("null".equals(sa[0]))	{
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(sa[0]));
		try	{
			BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
			queue.put(root);
			for(int i=1;i<sa.length;)	{
				TreeNode parent = queue.take();
				if(!"null".equals(sa[i]))	{
					parent.left = new TreeNode(Integer.parseInt(sa[i]));
					queue.put(parent.left);
				}
				i++;
				if(i>=sa.length){
					break;
				}
				if(!"null".equals(sa[i]))	{
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
	public static void printTreeNode(TreeNode root)	{
		if(root == null)	{
			System.out.println("null,");
			return;
		} else {
			System.out.println(root.val+",");
		}
		try	{
			BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
			queue.put(root);
			int num = 1;
			while(!queue.isEmpty())	{
				TreeNode node = queue.take();
				if(node.left != null)	{
					queue.put(node.left);
					System.out.print(node.left.val+",");
				} else {
					System.out.print("null,");
				}
				if(node.right != null)	{
					queue.put(node.right);
					System.out.print(node.right.val+",");
				} else {
					System.out.print("null,");
				}
				num++;
				if(num % 10 == 0)	{
					System.out.println();
				}
			}
		} catch(Exception e)	{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {		
//		TreeNode root = str2TreeNode(testStr);
//		printTreeNode(root);
		String str = ""+/**~{*/""
			+ "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"
		+ "\r\n"/**}*/;
		List<String> result = str2List(str);
		System.out.println(result);
	}
	
	public static String testStr = ""+/**~{*/""
				+ "[-2,1,-1,8,5,7,4,9,null,3,null,0,6,5,2,null,null,null,null,3,null,7,null,0,2,1,2,null,null,null,nul"
+ "\r\nl,6,null,0,null,1,-1,0,0,null,null,null,null,8,3,7,null,9,-2,null,7,null,null,null,null,null,null,6"
+ "\r\n,null,null,null,null,3,null,null,7,1,1]"
			+ "\r\n"/**}*/;
}
