package com.wlw.leetcode.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wlw.leetcode.util.StackItem;

public class TestRecursion0 {
    public static double recursion(double x) {  
        if (x < 3)  
          return 10.0;  
        
        double f1 = recursion(x - 1);  
        double f2 = recursion(x - 3);  
        return f1 + f2;  
      }  
        
    public static double nonRecursion(double x) {  
        double initValue = x;  
        final int endFlag = 3; // count of branches plus 1     
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
            StackItem sub;  
            if (ci.next.next == null) {  
              sub = new StackItem();  
              sub.pre = ci.next;  
              ci.next.next = sub;  
            } else {  
              sub = ci.next.next;  
            }  
            sub.number = x - 3; // branch two     
            if (values.containsKey(sub.number)) {  
              sub.flag = endFlag;  
            } else {  
              sub.flag = 0;  
            }  
            ci = sub;  
            break;  
          case 2: // two sub items are ready, calculating using sub items     
            x = ci.number;  
            double f1 = values.get(ci.next.number);  
            double f2 = values.get(ci.next.next.number);  
            double result = f1 + f2; // recursive body  
            values.put(x, result);  
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
    	 int n = 60000;
  		//Double result = recursion(n);
  		Date end = new Date();
  		Double result2 = nonRecursion(n);
  		Date end2 = new Date();
  		
  		System.out.println("time:"+ (end.getTime()-start.getTime()));
  		System.out.println("time2:"+ (end2.getTime()-end.getTime()));
  		
  		//System.out.println(result);
  		System.out.println(result2);
	}
}
