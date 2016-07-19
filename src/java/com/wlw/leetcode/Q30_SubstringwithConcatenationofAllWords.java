package com.wlw.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Q30_SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {
		Q30_SubstringwithConcatenationofAllWords test = new Q30_SubstringwithConcatenationofAllWords();
		
		Date start = new Date();
		
		String str = "qerhaxggvszzycpzcyjnmatlphjqedowjgdjflsaetbcxsdcrmpfmireqauufjsprvawgsymlbqlttnmicsumjyclvyqeqhxnivwaviowbzrumecqwzchzhuufmayuxlcuhepsunttfphluxhtcqujmpoypmspawlhddbxqwtxmcigarbejvnvmduesovslgbqlfncbibnlkvndyrnueiijcmbthvgqxwbclfduhtftqswpljjrutawgerpzxhytlcfqibzbgurargncrewnevvimmkkuifflmxtnzwvtpxmykppolevizfvmphgamnlzmgmlekhthtrsijiwndepjbbaijavynukviyzsfvaymujxchnglcrpfrxousohoydzyerfztgonplswaajeryjkyxgslqhmvgmzzsbvypkpccndcwhvxrivqqnegwsbeedgyebwtlnvoaaszkqwbattqizzhralyfryjsvegicujcoioggpgblzjmyqgaeegvcrqzwwkysvcgfrpnivovwziuqoxwudrywjasfksxhvgmovbyspupoelgskcopwmmfmelyzkfwqtknuiilezcikicvlqkhdwordzscmzyevkspuadzbfjlnmiacvjhtyzyzralsasnkkfhmignppacblfggqnbqoashcfafxnrhsyvcgkrwnwzydhgtvjkjjerojrvhgmqblmdryvpltrlwyrptbbfmfycppxwxkmyxacqzzgmszyoxpftshahoylfpjdmvqlsspktqsgireyrvdmqmmxdkiibtmpoeaiwrtshlyrfepwbvirjwqmgbxjulylpbvnsqfcefvjjnhniretnxivyfeuqchhfduyvcczhxktktgukmoxjysjfyevblegqagockpmkchuvnrgbhflfawkyahbolkgnsuqdkenmljjacpbjxoqxlavnjzbwjkkbecgqgverfotjfutcllzwoxjxwnufxeidgpuokyfrmybsuwwfhwdvvpvrcrybviedxytizabnachuaeckchfxwcqytqbqygvwgoghohvqmclmipwmwejtgbtctvssdqqjeyrvholtsyibpenmkzhtccvwxpqafimmifjptujlvtokxeykffdhiafhpxkxfwjnbsfuoqhljywgcwshcvqmvyvnvfkdbtsenxadnipwglfkhxrlvjzqhvfdapgekyixyjbltqkbdrlmqealnzexwjaxzidjinjgymureeujxfvnlvzzxfwtoyspixbqlkzjwtdczxlwfglqemrdrpygprvxqyqbipngkqilpvjweupkhinyangpgepxcfynwltgdetvbctfwkpftegtsmkysbvvgwiehdmnjfklhfsgqiljoreggqhyscvayffijrxuxjhgoamekapytvhbmoagqxgrdnbohyighsmvsbccbrcwnjybxahqzphcdismidsrveonhqrkithxfhycjhuiwblzldlvgfmdmbqttjedfnakwaofhjnemafaetvmykqkliggumkzbmlxnbcukpazqgzwbwkzgamtluafgkghyrglsiifzierqfnrbytiahbnbdsjpysoryzkijphsvzkamcdmxlpepehsxskxkypkzbsjszdpynrnpuboissxxbrwtdtdbknblfmfhpufcluugwiqobpncijwmfbnprqdyckfrfnus";
		List<Integer> result = test.findSubstring(str,new String[]{"tbbfmfycppxwxkmyxacqzz","gmszyoxpftshahoylfpjdm","vqlsspktqsgireyrvdmqmm","xdkiibtmpoeaiwrtshlyrf","epwbvirjwqmgbxjulylpbv","nsqfcefvjjnhniretnxivy","feuqchhfduyvcczhxktktg","ukmoxjysjfyevblegqagoc","kpmkchuvnrgbhflfawkyah","bolkgnsuqdkenmljjacpbj","xoqxlavnjzbwjkkbecgqgv","erfotjfutcllzwoxjxwnuf","xeidgpuokyfrmybsuwwfhw","dvvpvrcrybviedxytizabn","achuaeckchfxwcqytqbqyg","vwgoghohvqmclmipwmwejt","gbtctvssdqqjeyrvholtsy","ibpenmkzhtccvwxpqafimm","ifjptujlvtokxeykffdhia","fhpxkxfwjnbsfuoqhljywg","cwshcvqmvyvnvfkdbtsenx"});
		
		Date end = new Date();
		System.out.println("time:"+ (end.getTime()-start.getTime()));
		System.out.println(result);
	}
	
	public List<Integer> findSubstring(String s, String[] words) {
		int length = 0;
		for(String word : words)	{
			length += word.length();
		}
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<s.length()-length;i++)	{
			String sub = s.substring(i,i+length);
			if(isOk(sub, words))	{
				result.add(i);
			}
		}
		return result;
    }
	private boolean isOk(String sub,String[] words)	{
		for(String word : words)	{
			sub = sub.replaceFirst(word,"");
		}
		if(sub.length() == 0)	{
			return true;
		}
		return false;
	}
}

