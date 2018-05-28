package sum3Closest;

import java.util.Arrays;

/**
 * 题目：Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author yifei
 *
 */
//思路：同三数相加思想一样，保存各组合的差值gap，与当前最小minGap比较，得到最终差值最小的组合
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minGap = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length-2; i++) {
			int low = i+1;
			int high = nums.length-1;
			while (low<high) {
				int temp = nums[i]+nums[low]+nums[high];
				int gapabs = Math.abs(temp-target);
				if (temp==target) {
					return temp;
				}else if (temp<target) {
					if (gapabs<minGap) {
						minGap = gapabs;
						result = temp;
					}
					low++;
				}else {
					if (gapabs<minGap) {
						minGap = gapabs;
						result = temp;
					}
					high--;
				}
			}
		}
        return result;
    }
    public static void main(String[] args) {
    	int[] nums = new int[]{-1, 0, 1,1, 55};
		System.out.println(new Solution().threeSumClosest(nums,3));
	}
}
