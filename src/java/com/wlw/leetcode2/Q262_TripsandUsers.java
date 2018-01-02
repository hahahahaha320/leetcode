package com.wlw.leetcode2;

import java.util.Date;

public class Q262_TripsandUsers {
	private static long totalCount = 0;
	public static void main(String[] args) {
		Q262_TripsandUsers test = new Q262_TripsandUsers();
		
		Date start = new Date();
		
		String str = ""+/**~{*/""
			+ ""
+ "\r\nSELECT Request_at AS Day"
    + "\r\n, ROUND(COUNT(Status <> 'completed' OR NULL) / COUNT(*), 2) AS `Cancellation Rate`"
+ "\r\nFROM Trips"
+ "\r\nJOIN Users"
+ "\r\nON Users_Id = Client_Id AND Banned = 'No' AND Request_at BETWEEN '2013-10-01' AND '2013-10-03'"
+ "\r\nGROUP BY Request_at"
			+ "\r\n"
			+ "\r\n"
			+ "\r\n"
		+ "\r\n"
		+ "\r\n"/**}*/;;
		Object result = test.longestPalindrome(str);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
	}
	public String longestPalindrome(String str) {
        
		
		return "";
    }
}

