package com.wlw.leetcode1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wlw.leetcode.util.Point;

public class Q149MaxPointsonaLine2 {

	public static void main(String[] args) {
		Q149MaxPointsonaLine2 test = new Q149MaxPointsonaLine2();
		
		Date start = new Date();
//		Point[] points = new Point[]{new Point(2,3),new Point(3,3),new Point(-5,3)};
		Point[] points = new Point[]{new Point(3,1),new Point(12,3),new Point(3,1),new Point(-6,-1)};
//		Point[] points = new Point[]{new Point(0,0),new Point(94911151,94911150),new Point(94911152,94911151)};
//		Point[] points = new Point[]{new Point(0,0),new Point(Integer.MAX_VALUE,Integer.MAX_VALUE-1),
//				new Point(Integer.MAX_VALUE-1,Integer.MAX_VALUE-2)};
		
		Object result = test.maxPoints(points);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public int maxPoints(Point[] points) {
		if(points.length < 3)	{
			return points.length;
		}
		int result = 2;
		for(int i=0;i<points.length;i++)	{
			Map<java.math.BigDecimal,Integer> map = new HashMap<java.math.BigDecimal,Integer>();
			int samePointNum = 1;
			int noGradientNum = 0;
			int maxSameGradientNum = 0;
			for(int j=i+1;j<points.length;j++)	{
				Point p1 = points[i];
				Point p2 = points[j];
				if(p1.x == p2.x && p1.y == p2.y)	{
					samePointNum++;
				} else if(p1.x == p2.x)	{
					noGradientNum++;
				} else {
//					double k = (double)(p2.y-p1.y)/(p2.x-p1.x);
//					if(k == 0)	{
//						k = 0;
//					}
					java.math.BigDecimal b1 = new java.math.BigDecimal(p2.y-p1.y);
					java.math.BigDecimal b2 = new java.math.BigDecimal(p2.x-p1.x);
					java.math.BigDecimal k = b1.divide(b2,20,0);
					
					Integer num = map.get(k);
					if(num == null)	{
						num = 1;
					} else {
						num++;
					}
					map.put(k, num);
					if(maxSameGradientNum < num)	{
						maxSameGradientNum = num;
					}
				}
			}
			int max = samePointNum + Math.max(noGradientNum,maxSameGradientNum);
			if(result < max)	{
				result = max;
			}
		}
		return result;
    }
}

