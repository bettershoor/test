package implementstrStr;
/**
题目：
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

思路：直接使用Java的indexOf方法
	  或判断haystack中是否包含needle子串substring()

 * @author yifei
 *
 */
public class Solution {
	public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
//不使用indexOf()方法的实现：
	public int strStr2(String haystack, String needle) {
        if (haystack.length()<needle.length()) {
			return -1;
		}
        if (needle.length()==0) {
			return 0;
		}
        if (haystack.length()==0) {
			return -1;
		}
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
			if (haystack.substring(i, i+needle.length()).equals(needle)) {
				return i;
			}
		}
        return -1;
    }
}
