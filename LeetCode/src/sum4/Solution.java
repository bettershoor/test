package sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：
 * 
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

思路：同三数相加一样，先数组排序，后固定两个数，同时判断后面是否有相同的数出现，若相同，则可以跳过
	  然后，利用low和high索引，对四个数进行加法，与target作比较，同时比较low后和high前的数是否重复，更新low与high
 * @author yifei
 *
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (nums.length<4) {
			return result;
		}
    	for (int i = 0; i < nums.length-3; i++) {
    		if (i==0||(i>0&&nums[i]!=nums[i-1])) {	
				for (int j = i+1; j < nums.length-2; j++) {
		    		if (j==i+1||(j>i+1&&nums[j]!=nums[j-1])) {	
		    			int low = j+1;
		    			int high = nums.length-1;
		    			while (low<high) {
							if (nums[i]+nums[j]+nums[low]+nums[high]==target) {
								result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
								while (low<high&&nums[low]==nums[low+1]) {
									low++;
								}
								while (low<high&&nums[high]==nums[high-1]) {
									high--;
								}
								low++;
								high--;
							}else if (nums[i]+nums[j]+nums[low]+nums[high]<target) {
								low++;
							}else {
								high--;
							}
						}
		    		}
				}
    		}
		}
    	return result;
    }
    public static void main(String[] args) {
		int [] nums = { 0, 0, 0,0};
		System.out.println(new Solution().fourSum(nums, 1));
	}
}
