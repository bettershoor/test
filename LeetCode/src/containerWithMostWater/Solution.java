package containerWithMostWater;
/**
 * 题目：Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

思路：1、以当前的一条竖线为基准，遍历其他的线，求得各自容器的V，保存当前竖线为基准下的最大容器maxV；
	 2、遍历以其他竖线为基准的容器大小，与maxV比较并更新maxV的值================显然再次陷入超时状态，当n的值过大时
	 
优化解：从最左边和最右边组成的容器开始，依次向内缩小，比较每次的容器V，保存并更新最大的maxV
	 
 * @author yifei
 *
 */
public class Solution {
    public int maxArea(int[] height) {
    	int maxV = 0;
        for (int i = 0; i < height.length-1; i++) {
			for (int j = i+1; j < height.length; j++) {
				int v = (j-i)*Math.min(height[i],height[j]);
				if (maxV < v) {
					maxV = v;
				}
			}
		}
        return maxV;
    }
    public int maxArea2(int[] height) {
    	int maxV = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right) {
			maxV = Math.max(maxV, Math.min(height[left],height[right])*(right-left));
			if (height[left]<height[right]) {
				left++;
			}else {
				right--;
			}
		}
        return maxV;
    }
}
