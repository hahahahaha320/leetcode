package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Q282_ExpressionAddOperators2 {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q282_ExpressionAddOperators2 test = new Q282_ExpressionAddOperators2();
		
		Date start = new Date();
		/*
		
		"123", 6 -> ["1+2+3", "1*2*3"] 
		"232", 8 -> ["2*3+2", "2+3*2"]
		"105", 5 -> ["1*0+5","10-5"]
		"00", 0 -> ["0+0", "0-0", "0*0"]
		"3456237490", 9191 -> []
		*/
		Object result = test.addOperators("232",8);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	
	List<String> res;  
    public List<String> addOperators(String num, int target) {  
    	res=new ArrayList<String>();  
        search(num,target,"",(long) 0,(long)0);  
        return res;  
    }  
      
    /*** 
     * 递归的时候，要想好需要什么样的参数，什么时候返回 
     * @param num 初始集合 
     * @param target 目标值 
     * @param tmp    当前集 
     * @param cures  当前结果 
     * @param prenum 上一次的结果，主要是为了用于乘法计算，因为优先级最高 
     */  
    public void search(String num,int target, String tmp,Long cures,long prenum) {  
        if(target==cures&&num.length()==0)  {  
            res.add(new String(tmp));  
            return;  
        }  
        for(int i=1;i<=num.length();i++)  {  
            String cur=num.substring(0, i);  
            /**去除掉00X的结果，但是允许单个0*/  
            if(cur.length()>1&&cur.charAt(0)=='0')  
                return;  
            /**因为有可能越界，所以使用long*/  
            long curnum=Long.parseLong(cur);  
            String sub=num.substring(i);  
            /**第一个数的话不用添加符号*/  
            if(tmp.length()==0)  {  
                search(sub,target,cur,curnum,curnum);  
            } else {  
                /**加法*/  
                search(sub,target,tmp+"+"+curnum,cures+curnum,curnum);  
                /**减法，注意当前结果值是-curnum*/  
                search(sub,target,tmp+"-"+curnum,cures-curnum,-curnum);  
                /**乘法*/  
                search(sub,target,tmp+"*"+curnum,(cures-prenum)+prenum*curnum,prenum*curnum);  
            }  
        }  
    }  

}

