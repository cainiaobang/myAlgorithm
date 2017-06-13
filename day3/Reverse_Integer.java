/**Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when 
the reversed integer overflows.
int的最大值为21474 83647
*/

package cn.itcast.day3;

import org.junit.Test;

public class Reverse_Integer {
	
	
	// 我的直观转换思路
	 public int reverse(int x){
		if(x==0) return 0;
		int[] nums=new int[10];
		int result=0;
		int i=0;
		while(x!=0){
			int num=x%10;
			nums[i]=num;
			if(i==9) {
				if(Math.abs(result)>214748364) return 0;
				else if(Math.abs(result)==214748364&&num>7) return 0;
			}
			result=result*10+num;
			x/=10;
			i++;
		}
		return result;
	 }
	 
	 
	 //思路2
	 public int reverse2(int x){
		 if(x==0) return 0;
		 int[] num=new int[10];
		 int j=0;
		 for(int i=0;i<10;i++,j++){
			 num[i]=x%10;
			 x/=10;
			 if(x==0) break;
		 }
		 double mm=0;
		 for(int i=0;i<=j;i++){
			 mm+=num[i]*Math.pow(10, j-i);
		 }
		  if(mm>Integer.MAX_VALUE||mm<Integer.MIN_VALUE) return 0;
		     else 
		     { 
		         int result=(int)mm;
		         return result;
		     }
	 }
	 
	 // 思路三
	 public int reverse3(int x){
			if(x==0) return 0;
		    double result=0;
			int i=0;
			while(x!=0){
				int num=x%10;
				result=result*10+num;
				x/=10;
			}
			if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) return 0;
			return (int)result;
		 }
	 
	 
	 
	 @Test
	 public void test(){
		 int mm=-2147483648;
		 System.out.println(reverse(mm));
	 }

}
