/**
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question.
 */

package cn.itcast;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class lengthOfLongestSubstring {

	//自己的思路
	 public int lengthOfLongestSubstring(String s) {
	        int p1=0,p2=0;
	        int length=s.length();
	        if(length==0) return 0;
	        Map<Character,Integer> map=new HashMap<>();
	        int maxLength=0;
	        while(p2<length){
	          if(!map.containsKey(s.charAt(p2))){
	        	  map.put(s.charAt(p2), p2);
	        	  int len=p2-p1+1;
	        	  if(maxLength<(p2-p1+1)) maxLength=len;
	        	  p2++;
	          }else{
	        	 p1=map.get(s.charAt(p2))+1;
	        	 map.clear();
	        	 int p11=p1;
	        	 while(p11<=p2){
	        		 map.put(s.charAt(p11), p11);
	        		 p11++;
	        	 }
	        	 p2++;
	          }	
	        }
	      
	        return maxLength;
	    }
	 
	 
	 // 更巧妙的方法
	 public int lengthOfLongestSubstring2(String s) {
	        if (s.length()==0) return 0;
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        int max=0;
	        for (int i=0, j=0; i<s.length(); ++i){
	            if (map.containsKey(s.charAt(i))){
	                j = Math.max(map.get(s.charAt(i))+1,j);
	            }
	            map.put(s.charAt(i),i);
	            max = Math.max(max,i-j+1);
	        }
	        return max;
	    }
	 @Test
	 public void test(){
		 String ss="pwwkew";
		 lengthOfLongestSubstring(ss);
	 }
}
