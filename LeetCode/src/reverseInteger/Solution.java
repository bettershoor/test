package reverseInteger;
/**
 * 题目：Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

思路：1、将整数转换为字符串，然后利用StringBuffer类自带的reverse()函数进行逆转，之后对最后结果进行处理------------运行时间较长
	 2、利用除法与余数的结合，得到最终结果;注：C++/Java中负数取余运算：m%(-n) = m%n; (-m)%n = -(m%n)
 * @author yifei
 *
 */
public class Solution {
    public int reverse(int x) {
    	int negx = Math.abs(x);
    	int result = 0;
        String xStr = String.valueOf(negx);
        StringBuffer sb = new StringBuffer(xStr);
        sb = sb.reverse();
        String reverseXStr = new String(sb);
        reverseXStr = reverseXStr.replaceAll("^0*", "");
        if (x < 0) {
			reverseXStr = "-"+reverseXStr;
		}
        try {
			result = Integer.valueOf(reverseXStr).intValue();
		} catch (Exception e) {
			return 0;
		}
        return result;
    }
    public int reverse2(int x) {
    	long result = 0;
    	while (x!=0) {
			result = result*10+x%10;
			x = x/10;
		}
    	if (result<Integer.MIN_VALUE || result>Integer.MAX_VALUE) {
			return 0;
		}
        return (int)result;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().reverse2(-1023000));;
	}
}
