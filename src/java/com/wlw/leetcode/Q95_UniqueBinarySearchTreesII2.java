package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q95_UniqueBinarySearchTreesII2 {

	public static void main(String[] args) {
		Q95_UniqueBinarySearchTreesII2 test = new Q95_UniqueBinarySearchTreesII2();
		
		Date start = new Date();
		
		Object result = test.generateTrees(9);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<TreeNode> generateTrees(int n) {
		if(n==0)	{
			return new ArrayList<TreeNode>();
		}
        return generateTrees(1, n,new HashMap<String,List<TreeNode>>());//从1作为root开始，到n作为root结束
    }
     
    private List<TreeNode> generateTrees(int left, int right,Map<String,List<TreeNode>> cache){
    	List<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right){
            res.add(null);
            return res;
        }
        String key = right+"_"+left;
        if(cache.containsKey(key))	{
        	return cache.get(key);
        }
        for (int i = left; i <= right; i++){
        	List<TreeNode> lefts = generateTrees(left, i-1,cache);//以i作为根节点，左子树由[1,i-1]构成
        	List<TreeNode> rights = generateTrees(i+1, right,cache);//右子树由[i+1, n]构成
            for (int j = 0; j < lefts.size(); j++){
                for (int k = 0; k < rights.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);
                }
            }
        }
        cache.put(key, res);
        return res;
    }
}

