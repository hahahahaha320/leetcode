package com.wlw.leetcode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestRecursion {
    public static double recursion(double x) {  
        if (x < 3)  
          return 10.0;  
        
        double f1 = recursion(x - 1);  
        double f2 = recursion(x - 3);  
        double f3 = recursion(x - 2);  
        return (f1 + f2 + x) / f3;  
      }  
        
      public static double nonRecursion(double x) {  
        double initValue = x;  
        final int endFlag = 4; // count of branches plus 1  
        Map<Double, Double> values = new HashMap<Double, Double>();  
        StackItem ci = new StackItem(initValue);  
        while (ci != null) {  
          switch (ci.flag) {  
          case 0:  
            x = ci.number;  
            if (x < 3) { // exit of recursion  
              values.put(x, 10.0);  
              ci.flag = endFlag;  
            } else {  
              ci.flag = ci.flag + 1;  
              StackItem sub;  
              if (ci.next == null) {  
                sub = new StackItem();  
                sub.pre = ci;  
                ci.next = sub;  
              } else {  
                sub = ci.next;  
              }  
              sub.number = x - 1; // branch one  
              if (values.containsKey(sub.number)) {  
                sub.flag = endFlag;  
              } else {  
                sub.flag = 0;  
              }  
              ci = sub;  
            }  
            break;  
          case 1:  
            x = ci.number;  
            ci.flag = ci.flag + 1;  
            StackItem sub1;  
            if (ci.next.next == null) {  
              sub1 = new StackItem();  
              sub1.pre = ci.next;  
              ci.next.next = sub1;  
            } else {  
              sub1 = ci.next.next;  
            }  
            sub1.number = x - 3; // branch two  
            if (values.containsKey(sub1.number)) {  
              sub1.flag = endFlag;  
            } else {  
              sub1.flag = 0;  
            }  
            ci = sub1;  
            break;  
          case 2:  
            x = ci.number;  
            ci.flag = ci.flag + 1;  
            StackItem sub2;  
            if (ci.next.next.next == null) {  
              sub2 = new StackItem();  
              sub2.pre = ci.next.next;  
              ci.next.next.next = sub2;  
            } else {  
              sub2 = ci.next.next.next;  
            }  
            sub2.number = x - 2; // branch three  
            if (values.containsKey(sub2.number)) {  
              sub2.flag = endFlag;  
            } else {  
              sub2.flag = 0;  
            }  
            ci = sub2;  
            break;  
          case 3: // three sub items are ready, calculating using sub items  
            x = ci.number;  
            double f1 = values.get(ci.next.number);  
            double f2 = values.get(ci.next.next.number);  
            double f3 = values.get(ci.next.next.next.number);  
            values.put(x, (f1 + f2 + x) / f3); // recursive body  
            ci.flag = endFlag;  
            break;  
          case endFlag: // current item is ready, back to previous item             
            ci = ci.pre;  
            break;  
          }  
        }  
        return values.get(initValue);  
      }  
      
      public static void main(String[] args) {
    	 Date start = new Date();
  		Double result = recursion(40);
  		Date end = new Date();
  		Double result2 = nonRecursion(40);
  		Date end2 = new Date();
  		
  		System.out.println("time:"+ (end.getTime()-start.getTime()));
  		System.out.println("time2:"+ (end2.getTime()-end.getTime()));
  		
  		System.out.println(result);
  		System.out.println(result2);
	}
}
