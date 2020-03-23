package com.wlw.leetcode;

import java.util.Date;

public class Q05_LongestPalindromicSubstring {

	public static void main(String[] args) {
		Q05_LongestPalindromicSubstring test = new Q05_LongestPalindromicSubstring();
		Date start = new Date();
		
		//String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		//String str = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
		String str = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";
		String result = test.longestPalindrome(str);
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	public String longestPalindrome(String str) {
		int len = str.length();
		int maxLen = 1;
		String maxStr = str.substring(0,1);
		for(int i=1;i<len;i++)	{
			String palStr = str.charAt(i)+"";
			int maxPalLen = 1;
			
			int loopTime = Math.min(i,len-i-1);
			for(int j=1;j<=loopTime;j++)	{
				if(str.charAt(i-j) == str.charAt(i+j))	{
					maxPalLen = maxPalLen+2;
					palStr = str.charAt(i-j)+palStr+str.charAt(i-j);
				} else {
					break;
				}
			}
			if(maxLen < maxPalLen)	{
				maxStr = palStr;
				maxLen = maxPalLen;
			}
		}
		
		for(int i=1;i<len;i++)	{
			String palStr = str.charAt(i)+"";
			int maxPalLen = 1;
			if(i>=len-2 || str.charAt(i) != str.charAt(i+1))	{
				continue;
			} else {
				maxPalLen = 2;
				palStr = str.charAt(i)+""+str.charAt(i);
			}
			int loopTime = Math.min(i,len-i-2);
			for(int j=1;j<=loopTime;j++)	{
				if(str.charAt(i-j) == str.charAt(i+j+1))	{
					maxPalLen = maxPalLen+2;
					palStr = str.charAt(i-j)+palStr+str.charAt(i-j);
				} else {
					break;
				}
			}
			if(maxLen < maxPalLen)	{
				maxStr = palStr;
				maxLen = maxPalLen;
			}
		}
		
        return maxStr;
    }
	public String longestPalindrome1(String s) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<s.length();i++)	{
			sb.append(s.charAt(i)).append("#");
		}
		int len = sb.length();
		int maxLen = 1;
		String maxStr = s.substring(0,1);
		String str = sb.toString();
		for(int i=1;i<str.length();i++)	{
			String palStr = str.charAt(i)+"";
			int maxPalLen = 1;
			
			int loopTime = Math.min(i,len-i-1);
			for(int j=1;j<=loopTime;j++)	{
				if(str.charAt(i-j) == str.charAt(i+j))	{
					maxPalLen = maxPalLen+2;
					palStr = str.charAt(i-j)+palStr+str.charAt(i-j);
				} else {
					break;
				}
			}
			if(maxLen < maxPalLen)	{
				maxStr = palStr;
				maxLen = maxPalLen;
			}
		}
        return maxStr.replaceAll("#","");
    }
}

