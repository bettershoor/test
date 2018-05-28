package medianOfTwoSortedArrays;
/**
 * 题目：
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
	
	思路：1、合并两个数组，选出中间数得出结果
		 2、终止条件可以是：当合并后的数组角标到达了中间，后面的就可以不用合并了
 * @author yifei
 *
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int nums1len = nums1.length;
    	int nums2len = nums2.length;
    	int len = nums1len+nums2len;
        int[] merges = new int[len];
        for (int i = 0,j = 0,k = 0; k < len/2+1; k++) {	
			if (i == nums1len) {
				merges[k] = nums2[j];
				j++;
			} else if (j == nums2len) {
				merges[k] = nums1[i];
				i++;
			} else {
				if (nums1[i] <= nums2[j]) {
					merges[k] = nums1[i]; 
					i++;
				}else {
					merges[k] = nums2[j];
					j++;
				}
			}
		} 
        if (len%2 !=0 ) {
			return (double)merges[len/2];
		}else {
			return (double)(merges[len/2-1]+merges[len/2])/2;
		}
    }
    public static void main(String[] args) {
    	int[] nums1 = {1,2,5,6,8};
    	int[] nums2 = {3,4};
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
	}
}
