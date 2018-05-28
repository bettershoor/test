package removeDuplicatesfromSortedArray;

import java.util.Arrays;

/**
 * 题目：
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array,
 you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.

Clarification:
Confused why the returned value is an integer but your answer is an array?
Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

思路：索引j遍历nums，定义新的索引i用于保存不同的数组值，若出现不同的值则i++,同时将nums[j]赋值给nums[i]

 * @author yifei
 *
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        int i = 0;
        for (; i < nums.length-2; i+=2) {
			if (nums[i]!=nums[i+1]&&nums[i+1]!=nums[i+2]) {
				len +=2;
			}else if (nums[i]==nums[i+1]&&nums[i+1]!=nums[i+2]) {
				nums[i] = Integer.MAX_VALUE;
				len +=1;
			}else if (nums[i]!=nums[i+1]&&nums[i+1]==nums[i+2]) {
				nums[i+1] = Integer.MAX_VALUE;
				len +=1;
			}else {
				nums[i] = Integer.MAX_VALUE;
				nums[i+1] = Integer.MAX_VALUE;
				len +=0;
			}
		}
        if (i==nums.length-2) {
			if (nums[i]!=nums[i+1]) {
				len ++;
			}
		}
        Arrays.sort(nums);
        return len;
    }
//优化解：思路实现
    public int removeDuplicates2(int[] nums) {
    	if (nums.length==0) {
			return 0;
		}
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
			if (nums[i]!=nums[len]) {
				len++;
				nums[len]=nums[i];
			}
		}
        return len+1;
    }
    public static void main(String[] args) {
    	int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
		System.out.println(new Solution().removeDuplicates2(nums));
	}
}
