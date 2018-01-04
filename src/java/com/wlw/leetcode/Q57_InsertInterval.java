package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.wlw.leetcode.util.Interval;

public class Q57_InsertInterval {

	public static void main(String[] args) {
		Q57_InsertInterval test = new Q57_InsertInterval();
		
		Date start = new Date();
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		
		List<Interval> result = test.insert(intervals,new Interval(4,9));
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		Collections.sort(intervals,new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start)	{
					return -1;
				} else if(o1.start > o2.start){
					return 1;
				}
				return 0;
			}
		});
		List<Interval> result = new ArrayList<Interval>();
		for(Interval interval : intervals)	{
			boolean isMerge = false;
			for(Interval resultInterval:result)	{
				if(!(interval.end < resultInterval.start || interval.start>resultInterval.end))	{
					resultInterval.start = Math.min(resultInterval.start,interval.start);
					resultInterval.end = Math.max(resultInterval.end,interval.end);
					isMerge = true;
					break;
				}
			}
			if(!isMerge)	{
				result.add(interval);
			}
		}
        return result;
    }
}

