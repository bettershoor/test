package twoSum;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目：Given an array of integers, return indices of the two numbers such that they add up to a specific target.
		You may assume that each input would have exactly one solution, and you may not use the same element twice.
	Example:
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,

	思路：1、两层循环遍历，有符合的结果则跳出循环
	改进：使用一层循环遍历即可，每次将数组元素与角标对应保存至HashMap，每次判断target-nums[i]后的差值是否在map中，若存在，说明结果就是i与map中对应的key-value
return [0, 1].
 * @author yifei
 *
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] res = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]+nums[j]==target) {
					res[0] = i;
					res[1] = j;
					break;
				}
			}
		}
        return res;
    }
}
