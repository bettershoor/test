package validParentheses;
/**
 * 题目：
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true

思路：开辟栈空间，遍历字符串，判断当前字符，
	  若为左括号，则压栈；
	  若为右括号，则判断栈是否为空，为空则无匹配,return false；
	  				      不为空，则取栈顶元素，判断是否与当前右括号字符匹配，不匹配则return false,匹配则继续往下遍历

 * @author yifei
 *
 */

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    	String[] leftBrackets = {"(","{","["};
    	String[] rightBrackets = {")","}","]"};
    	Stack<String> brackets = new Stack<>();
    	for (int i = 0; i < s.length(); i++) {
			String cur = s.substring(i,i+1);
			if (cur.equals("(")||cur.equals("{")||cur.equals("[")) {
				brackets.push(cur);
			}else {	
				if (brackets.isEmpty()) {
					return false;
				}else {
					String matchcur = new String();
					for (int j = 0; j < rightBrackets.length; j++) {
						if (cur.equals(rightBrackets[j])) {
							matchcur = leftBrackets[j];
							break;
						}
					}
					String top = brackets.pop();
					if (top.equals(matchcur)) {
						
					}else {
						return false;
					}
				}
			}
		}
    	if (brackets.isEmpty()) {
			return true;
		}
    	return false;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().isValid("(("));
	}
}
