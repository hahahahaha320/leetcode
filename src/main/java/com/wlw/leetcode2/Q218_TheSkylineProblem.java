package com.wlw.leetcode2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.wlw.leetcode.util.ParamUtil;

public class Q218_TheSkylineProblem {
	private static long totalCount = 0;
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		Q218_TheSkylineProblem test = new Q218_TheSkylineProblem();
		
		Date start = new Date();
		
//		int[][] buildings = new int[][]{
//			{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
//		};
		//[2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0]
		
//		int[][] buildings = new int[][]{{0,2147483647,2147483647}};
		
		String testStr1 = ""+/**~{*/""
			+ "[[6765,184288,53874],[13769,607194,451649],[43325,568099,982005],[47356,933141,123943],[59810,561434,119381],[75382,594625,738524],[111895,617442,587304],[143767,869128,471633],[195676,285251,107127],[218793,772827,229219],[316837,802148,899966],[329669,790525,416754],[364886,882642,535852],[368825,651379,6209],[382318,992082,300642],[397203,478094,436894],[436174,442141,612149],[502967,704582,918199],[503084,561197,625737],[533311,958802,705998],[565945,674881,149834],[615397,704261,746064],[624917,909316,831007],[788731,924868,633726],[791965,912123,438310]]"
		+ "\r\n"/**}*/;
		
		String testStr2 = ""+/**~{*/""
			+ "[[2190,661048,758784],[9349,881233,563276],[12407,630134,38165],[22681,726659,565517],[31035,590482,658874],[41079,901797,183267],[41966,103105,797412],[55007,801603,612368],[58392,212820,555654],[72911,127030,629492],[73343,141788,686181],[83528,142436,240383],[84774,599155,787928],[106461,451255,856478],[108312,994654,727797],[126206,273044,692346],[134022,376405,472351],[151396,993568,856873],[171466,493683,664744],[173068,901140,333376],[179498,667787,518146],[182589,973265,394689],[201756,900649,31050],[215635,818704,576840],[223320,282070,850252],[252616,974496,951489],[255654,640881,682979],[287063,366075,76163],[291126,900088,410078],[296928,373424,41902],[297159,357827,174187],[306338,779164,565403],[317547,979039,172892],[323095,698297,566611],[323195,622777,514005],[333003,335175,868871],[334996,734946,720348],[344417,952196,903592],[348009,977242,277615],[351747,930487,256666],[363240,475567,699704],[365620,755687,901569],[369650,650840,983693],[370927,621325,640913],[371945,419564,330008],[415109,890558,606676],[427304,782478,822160],[439482,509273,627966],[443909,914404,117924],[446741,853899,285878],[480389,658623,986748],[545123,873277,431801],[552469,730722,574235],[556895,568292,527243],[568368,728429,197654],[593412,760850,165709],[598238,706529,500991],[604335,921904,990205],[627682,871424,393992],[630315,802375,714014],[657552,782736,175905],[701356,827700,70697],[712097,737087,157624],[716678,889964,161559],[724790,945554,283638],[761604,840538,536707],[776181,932102,773239],[855055,983324,880344]]"
			+ "\r\n"/**}*/;
		int[][] buildings = ParamUtil.str2IntArrArr(testStr2);
		
		Object result = test.getSkyline(buildings);
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime())+",totalCount:"+totalCount);
		System.out.println(result);
		List<int[]> result1 = (List<int[]>) result;
		for(int[] arr : result1)	{
			System.out.print(arr[0]+","+arr[1]+"  ");
		}
	}
	public List<int[]> getSkyline(int[][] buildings) {
        Set<Region> set = new TreeSet<Region>();
        set.add(new Region(0,Integer.MAX_VALUE,0));
        for(int i=0;i<buildings.length;i++)	{
        	int from = buildings[i][0];
        	int to = buildings[i][1];
        	int height = buildings[i][2];
        	Set<Region> addSet = new TreeSet<Region>();
        	for(Region region : set)	{
        		if(to <= region.from || from >=region.to || height <= region.height)	{
        			continue;
        		}
        		if(to > region.from && to < region.to && from <= region.from)	{
        			addSet.add(new Region(region.from,to,height));
        			region.from = to;
        			continue;
        		}
        		if(to > region.from && to < region.to && from > region.from)	{
        			addSet.add(new Region(from,to,height));
        			addSet.add(new Region(region.from,from,region.height));
        			region.from = to;
        			continue;
        		}
        		if(to > region.from && to >= region.to && from > region.from)	{
        			addSet.add(new Region(from,to,height));
        			region.to = from;
        			continue;
        		}
        		if(to >= region.to && from <= region.from)	{
        			region.height = height;
        			continue;
        		}
        		if(region.from >= to)	{
        			break;
        		}
            }
        	set.addAll(addSet);
        }
        set.add(new Region(Integer.MAX_VALUE,Integer.MAX_VALUE,0));
        List<int[]> result = new ArrayList<int[]>();
        Region pre = new Region(0,0,0);
        for(Region region : set)	{
        	if(!region.height.equals(pre.height))	{
        		result.add(new int[]{region.from,region.height});
        	}
        	pre = region;
        }
        return result;
	}
	public static class Region implements Comparable<Region>	{
		Integer from;
		Integer to;
		Integer height;
		public Region(Integer from,Integer to)	{
			this.from = from;
			this.to = to;
		}
		public Region(Integer from,Integer to,Integer height)	{
			this.from = from;
			this.to = to;
			this.height = height;
		}
		@Override
		public boolean equals(Object obj) {
			Region region = (Region)obj;
			return this.from == region.from && this.to == region.to;
		}
		@Override
		public int hashCode() {
			return from.hashCode()+to.hashCode();
		}
		@Override
		public int compareTo(Region o) {
			if(this.from > o.from)	{
				return 1;
			} else if(this.from == o.from)	{
				if(this.to == o.to)	{
					return 0;
				} else if(this.to > o.to)	{
					return 1;
				}
			}
			return -1;
		}
		@Override
		public String toString() {
			return this.from+"->"+this.to+":"+this.height;
		}
	}
	
}


