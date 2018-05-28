package maximumSubarray;
/**
 * 题目：
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

思路：遍历数组，利用中间变量来保存当前sum最大值，
若当前sum与当前数组值的和小于当前数组值，说明前面的不再有用，当前sum值即为当前数组值，前面的报废，从当前数组值重新开始同样的比较
 * @author yifei
 *
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
			curmax = Math.max(nums[i], curmax+nums[i]);
			max = Math.max(max, curmax);
		}
        return max;
    }
    public static void main(String[] args) {
    	int[] nums=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new Solution().maxSubArray(nums));
	}
}
