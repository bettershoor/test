package sum3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 题目：Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
思路：先找出所有的可能解，并对每个解List排序，最后利用Set过滤掉重复解List
 * @author yifei
 *
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	for (int i = 0; i < nums.length-2; i++) {
			for (int j = i+1; j < nums.length-1; j++) {
				List<Integer> temp = new ArrayList<>();
				for (int k = j+1; k < nums.length; k++) {
					if (nums[i]+nums[j]+nums[k]==0) {
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						Collections.sort(temp);
						resultList.add(temp);
						break;
					}
				}
			}
		}
    	Set<List<Integer>> resultSet = new HashSet<>(resultList);
    	List<List<Integer>> result = new ArrayList<>(resultSet);
    	return result;
    }
//优化解：
    public List<List<Integer>> threeSum2(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	for (int i = 0; i < nums.length-2; i++) {
    		if (i==0||(i>0&&nums[i]!=nums[i-1])) {
    			int low = i+1;
    			int high = nums.length-1;
    			while (low<high) {
    				if (nums[i]+nums[low]+nums[high]==0) {
						resultList.add(Arrays.asList(nums[i],nums[low],nums[high]));
						while (low<high&&nums[low]==nums[low+1]) {
							low++;
						}
						while (low<high&&nums[high]==nums[high-1]) {
							high--;
						}
						low++;
						high--;
					}else if (nums[i]+nums[low]+nums[high]<0) {
						low++;
					}else {
						high--;
					}
    			}
			}
		}
    	return resultList;
    }
    public static void main(String[] args) {
    	int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		System.out.println(new Solution().threeSum(nums));
	}
}
