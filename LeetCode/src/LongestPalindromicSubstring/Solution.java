package LongestPalindromicSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目：
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
	Example:
	Input: "babad"
	Output: "bab"
	Note: "aba" is also a valid answer.
	Example:
	Input: "cbbd"
	Output: "bb
	
       思路：1、单独编写一个判断是否为回文字符串的函数
       	2、遍历给定字符串，以当前字符为开头，遇到后面相同的字符为结尾，判断截取的该段字符是否回文，记录长度，并与最大长度比较和替换
 * @author yifei
 *
 */
public class Solution {
    public boolean judgePalindrome(String s) {
    	boolean flag = true;
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
    public String longestPalindrome(String s) {
    	String longestPalStr = "";
    	for (int i = 0; i < s.length(); i++) {
    		String curSubStr = s.substring(i);
			while (curSubStr.lastIndexOf(s.substring(i, i+1))!=-1) {//||curSubStr.lastIndexOf(s.substring(i, i+1))!=i
				String tempPalStr = s.substring(i, i+curSubStr.lastIndexOf(s.substring(i, i+1))+1);
				if (judgePalindrome(tempPalStr)) {//||tempPalStr.length() <= longestPalStr.length()
					if (longestPalStr.length()<tempPalStr.length()) {
						longestPalStr = tempPalStr;
					}
					break;
				}else {
					curSubStr = s.substring(i,i+curSubStr.lastIndexOf(s.substring(i, i+1)));
				}
			}
		}
    	return longestPalStr;
    }
//	System.out.println(s);
//	System.out.println(curSubStr);
//	System.out.println(curSubStr.lastIndexOf(s.substring(i, i+1)));
    public static void main(String[] args) {
    	System.out.println(new Solution().longestPalindrome("babaddtattarrattatddetartrateedredividerb"));	
	}	
}
