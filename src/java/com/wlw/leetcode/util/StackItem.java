package com.wlw.leetcode.util;

public class StackItem {
	public double number;  
    
	  public int flag;  
	    
	  public StackItem pre = null;  
	    
	  public StackItem next = null;  
	    
	  public StackItem() {  
	    this(0);  
	  }  
	    
	  public StackItem(double number) {  
	    this.number = number;  
	    this.flag = 0;  
	  }  
}
