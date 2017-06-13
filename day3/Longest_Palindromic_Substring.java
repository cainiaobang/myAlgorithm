/**
 Given a string s, find the longest palindromic substring in s. 
 You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example:
Input: "cbbd"
Output: "bb"
 */



//回文字符串问题有它自己的特点，从一个字符串中间出发，逐步检测两边的对应字符，自然完成对回文字符串的判定。
package cn.itcast.day3;

public class Longest_Palindromic_Substring {
	private int lo, maxLen;
	private String LongstPalindrome(String s){
		int len=s.length();
		if(len<2)
			return s;
		for(int i=0;i<len-1;i++){
			extendPalindrome(s,i,i);
			extendPalindrome(s,i,i+1);
		}
		return s.substring(lo,lo+maxLen);
	}
	
	private void extendPalindrome(String s,int j, int k){
		while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
			j--;k++;
		}
		if(maxLen<k-j-1){
			lo=j+1;
			maxLen=k-j-1;
		}
	}

}
