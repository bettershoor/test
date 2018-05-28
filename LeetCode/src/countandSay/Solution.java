package countandSay;
/**
 * 题目：
The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.
Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"

思路：题目意思与n无关，第n个输出是由n-1推导而出
	 可以采用递归的方式求解，也可以利用循环，求出通式
 * @author yifei
 *
 */
public class Solution {
    public String countAndSay(int n) {
        int count = 1;
        String result = new String("1");
        while (--n>0) {
        	StringBuffer temp = new StringBuffer();
			for (int i = 0; i < result.length(); i++) {
				if (i==result.length()-1||result.charAt(i)!=result.charAt(i+1)) {
					temp.append(count).append(result.charAt(i));
					count = 1;
				}else {
					count++;
				}		
			}
			result = new String(temp);
		}
        return new String(result);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().countAndSay(5));
	}
}
