package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given a string, find the length of the longest substring without repeating characters.
	Examples:
		Given "abcabcbb", the answer is "abc", which the length is 3.
		Given "bbbbb", the answer is "b", with the length of 1.
		Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	思路：1、遍历字符串，判断当前字符是否出现在前面，若出现，则从出现的地方之后重新开始遍历--------若字符串长度很长，且出现abcabcabc等重复叠加的，将导致多次回退遍历，从而提高时间复杂度
	
	正解：利用HashMap，从头到尾遍历一次，不存在回退情况，将每一个字符作为Key保存至Map中，其相应的value值为到该字符的子串长度，
		  通过放置一个index位，标志允许的最大长度子串的起始位，当遇到重复的字符会比较判断，并且会更新map中已存在的该Key值对应的Value以及更新起始位index
 * @author yifei
 *
 */

public class Solution {
	public int lengthOfLongestSubstring(String s) {
        if (s==null) {
			return 0;
		}
        if (s.length()==1) {
			return 1;
		}
        String maxLenStr = "";
        int sindex = 0;
        for (int i = 1; i < s.length();) {
        	String subStr = s.substring(sindex,i);
        	String cursorChar = s.substring(i, i+1);
			if (subStr.indexOf(cursorChar)!=-1) {
				int index = subStr.indexOf(cursorChar);
				sindex += index + 1;
				i = sindex + 1;
				if (maxLenStr.length() < subStr.length()) {
					maxLenStr = subStr;
				}
			} else if (i == s.length()-1) {
				String lastStr = s.substring(sindex,s.length());
				if (maxLenStr.length() < lastStr.length()) {
					maxLenStr = lastStr;
				}
				i++;
			}else {
				i++;
			}
		}
        return maxLenStr.length();
    }
	public int lengthOfLongestSubstring2(String s) {
		int maxLen = 0,index = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				index = Math.max(map.get(s.charAt(i)), index);
			}
			maxLen = Math.max(maxLen, i-index+1);//一定是使用上次出现的地方的value值到当前出现的地方得到的长度与maxLen比较，然后再更新map中的key为该字符对应的value
			map.put(s.charAt(i), i+1);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring2("pwlekew"));
		
	}
}
