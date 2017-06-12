/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

package cn.itcast.day2;

import java.util.Arrays;

import org.junit.Test;

public class Median_of_Two_Sorted_Arrays {
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 int length1=nums1.length;
		 int length2=nums2.length;
		 int num1=0,num2=0;
		 int length=(length1+length2);
		 int lengthMedian=(length1+length2)/2+1;
		 int[] nums3=new int[lengthMedian];
		 for(int i=0;i<lengthMedian;i++){			 
			 if(num1<length1&&num2<length2){
				 if(nums1[num1]<nums2[num2]){
					 nums3[i]=nums1[num1++];
				 }else {
					nums3[i]=nums2[num2++];
				 }
			 }else if(num1<length1){
				 nums3[i]=nums1[num1++];
			 }else{
				 nums3[i]=nums2[num2++];
			 }	
		 }
		 if(length%2==0) return ((double)(nums3[lengthMedian-1]+nums3[lengthMedian-2]))/2;
		 else return (double)nums3[lengthMedian-1];
	 }
	 
	 @Test
	 public void test(){
		 int[] a={1,3};
		 int[] b={2};
		 System.out.println(findMedianSortedArrays(a,b));
	 }
	 
}
