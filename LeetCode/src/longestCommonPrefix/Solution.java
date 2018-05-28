package longestCommonPrefix;
/**
 * 题目：Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 * @author yifei
 *
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if (strs.length == 0) {
			return "";
		}
    	if (strs.length == 1) {
			return strs[0];
		}
        int minindex = 0;
        String minStr = strs[0];
        String commonStr = new String("");
        for (int i = 1; i < strs.length; i++) {
			if (minStr.length()>strs[i].length()) {
				minStr = strs[i];
				minindex = i;
			}
		}
		for (int j = 0; j < minStr.length(); j++) {
			String substr = minStr.substring(0, j+1);
			boolean flag = true;
			for (int k = 0; k < strs.length; k++) {
				if (k!=minindex&&!strs[k].startsWith(substr)) {
					flag = false;
					break;
				}
			}
			if (flag&&commonStr.length()<substr.length()) {
				commonStr = substr;
			}
		}
        return commonStr;
    }
    public static void main(String[] args) {
    	String[] strings = new String[]{"ca","a"};
		System.out.println(new Solution().longestCommonPrefix(strings));
	}
}
