package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q149MaxPointsonaLine {

	public static void main(String[] args) {
		Q149MaxPointsonaLine test = new Q149MaxPointsonaLine();
		
		Date start = new Date();
		Point[] points = new Point[4];
		points[0] = new Point(3,1);
		points[1] = new Point(12,3);
		points[2] = new Point(3,1);
		points[3] = new Point(-6,-1);
		
		Object result = test.maxPoints(points);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public int maxPoints(Point[] points) {
		if(points.length < 3)	{
			return points.length;
		}
		Map<String,Integer> pointNum = new HashMap<String,Integer>();
		List<Point> list = new ArrayList<Point>();
		for(int i=0;i<points.length;i++)	{
			String key = points[i].x+","+points[i].y;
			Integer num = pointNum.get(key);
			if(num == null)	{
				pointNum.put(key,1);
				list.add(points[i]);
			} else {
				pointNum.put(key,num+1);
			}
		}
		if(pointNum.size() == 1)	{
			return pointNum.get(list.get(0).x+","+list.get(0).y);
		}
		
		int result = 2;
		for(int i=0;i<list.size();i++)	{
			Map<String,Integer> map = new HashMap<String,Integer>();
			for(int j=i+1;j<list.size();j++)	{
				Point p1 = list.get(i);
				Point p2 = list.get(j);
				String g = gradient(p1,p2);
				System.out.println(g);
				Integer num = map.get(g);
				if(num == null)	{
					num = pointNum.get(p1.x+","+p1.y)+pointNum.get(p2.x+","+p2.y);
				} else {
					num = num + pointNum.get(p2.x+","+p2.y);
				}
				map.put(g, num);
				if(result < num)	{
					result = num;
				}
			}
		}
		return result;
    }
	private String gradient(Point p1,Point p2)	{
		if(p2.x == p1.x)	{
			return "max-"+p2.x;
		}
		java.math.BigDecimal b1 = new java.math.BigDecimal(p2.y-p1.y);
		java.math.BigDecimal b2 = new java.math.BigDecimal(p2.x-p1.x);
		java.math.BigDecimal k = b1.divide(b2,20,0);
		if(k.equals(0))	{
			k = new java.math.BigDecimal(0);
		}
		java.math.BigDecimal b = new java.math.BigDecimal(p2.y).subtract(k.multiply(new java.math.BigDecimal(p2.x)));
		return k+"-"+b;
	}
	
}

