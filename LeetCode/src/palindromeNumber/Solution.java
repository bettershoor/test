package palindromeNumber;

import java.util.ArrayList;

/**
 * 题目：
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

	Example 1:
	
	Input: 121
	Output: true
	Example 2:
	
	Input: -121
	Output: false
	Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
	Example 3:
	
	Input: 10
	Output: false
	Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
	Follow up:
	
	Coud you solve it without converting the integer to a string?
    思路：
    1、常规思想可以通过字符串的正序与反序是否相同来判断回文（Stringbuffer.reverse()或者遍历charAt(index)）
    2、根据题目要求：在不使用字符串的情况下
       	解法：循环做除法运算，将每次的余数*10+上次的结果，最终可以得到倒序后的整数
 * @author yifei
 *
 */
public class Solution {
	public boolean isPalindrome(int x) {
        if (x<0) {
			return false;
		}
        int resx = 0,temp = x;
        do {
			int mod = temp%10;
			resx = resx*10+mod;
			temp = temp/10;
		}while (temp!=0);
        if (x!=resx) {
			return false;
		}
        return true;
    }
	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(121));
	}
}
