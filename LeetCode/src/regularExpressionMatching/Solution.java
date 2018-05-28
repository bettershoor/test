package regularExpressionMatching;
/**
 * 题目：Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

思路：
1、可以采用递归判断的方法，从前往后依次判断是否匹配：当p为空时，返回值为s是否为空
2、递归判断是否匹配的细节：
	①p的第二位是*，
		则判断s与p.substring(2)是否匹配（说明p的第一位字符与s的第一位不符，因此略去p的前两位，重新比较）
		或者
		如果firstMatch，则判断s.substring(1)与p是否匹配（说明s的第一位已匹配，而此时的p由于第二位是*，因此此时的p仍可重用）
	②p的第二位是其他
		则判断如果firstMatch，则判断s.substring(1)与p.substring(1)是否匹配（说明第一位匹配，则需要各自向后退一位，再次比较后续的子串是否符合）
	
容易误点项：*的使用
例如：s="bb"，p="cb*"=============输出应该是不匹配的，因为开头多了一个c
          而s="bb"，p="c*b*"============输出应该是匹配的，因为*可以代表c重复0次，即最终结果可以消除开头的c
          
 * @author yifei
 *
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
			return s.isEmpty();
		}
        boolean firstMatch = !s.isEmpty()&&(p.charAt(0)=='.'||p.charAt(0)==s.charAt(0));
        if (p.length()>=2 && p.charAt(1)=='*') {
			return isMatch(s, p.substring(2))||(firstMatch&&isMatch(s.substring(1), p));
		}else {
			return firstMatch&&isMatch(s.substring(1), p.substring(1));
		}
    }
    public static void main(String[] args) {
		System.out.println(new Solution().isMatch("ab", ".*c"));
	}
}
