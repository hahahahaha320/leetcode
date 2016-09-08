package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q56_MergeIntervals {

	public static void main(String[] args) {
		Q56_MergeIntervals test = new Q56_MergeIntervals();
		
		Date start = new Date();
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		
		List<Interval> result = test.merge(intervals);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<Interval> merge(List<Interval> intervals) {
        return intervals;
    }
}

