package searchInsertPosition;
/**
题目：
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
Input: [1,3,5,6], 5
Output: 2

Example 2:
Input: [1,3,5,6], 2
Output: 1

Example 3:
Input: [1,3,5,6], 7
Output: 4

Example 4:
Input: [1,3,5,6], 0
Output: 0

思路：遍历数组，终止条件为arr[i]>target，遇到arr[i]=target，则break，返回i,若没遇到，则同样返回i

 * @author yifei
 *
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
    	int i = 0;
        while (i<nums.length&&nums[i]<=target) {
			if (nums[i]==target) {
				return i;
			}else {
				i++;
			}
		}
        return i;
    }
    public static void main(String[] args) {
		int[] arr = new int[]{1,3,5,6};
		System.out.println(new Solution().searchInsert(arr, 5));
	}
}
