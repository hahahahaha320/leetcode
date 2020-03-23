package com.wlw.leetcode1;

import java.util.Date;

public class Q185_DepartmentTopThreeSalaries {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q185_DepartmentTopThreeSalaries test = new Q185_DepartmentTopThreeSalaries();
		
		Date start = new Date();
		
		String str = ""+/**~{*/""
			+ ""
+ "\r\nselect (select name from Department where id=e.DepartmentId) Department,"
+ "\r\nname Employee,Salary from employee e"
+ "\r\nwhere salary >="
+ "\r\nifnull((select salary from employee where DepartmentId=e.DepartmentId group by Salary order by Salary desc limit 2,1),-1)"
+ "\r\norder by e.DepartmentId,e.Salary desc;"
+ "\r\n"
			+ "\r\n"
+ "\r\nselect d.name Department,"
+ "\r\ne.name Employee,Salary from employee e left join Department d on e.DepartmentId=d.Id"
+ "\r\nwhere salary >="
+ "\r\nifnull((select salary from employee where DepartmentId=e.DepartmentId group by Salary order by Salary desc limit 2,1),-1)"
+ "\r\nand d.id is not null"
+ "\r\norder by e.DepartmentId,e.Salary desc;"
+ "\r\n"
		+ "\r\n"
		+ "\r\n"/**}*/;
		
		
		
		
		Object result = test.longestPalindrome(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	
	
	public String longestPalindrome(String str) {
        
		
		return "";
    }
}

