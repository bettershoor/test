package stringtoInteger_atoi;
/**
 * 题目：Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 
思路：1、处理字符串为空的情况
	开始遍历字符串：
	 2、处理字符串开头为空格的情况
	 3、处理第一个有效字符为“+、-”的情况
	 4、处理正常的字符串，转换时只需要使用字符运算：当前字符-'0'，判断是否处于0-9之间，得到的数为最末位，依次往前乘10相加
 * @author yifei
 *
 */
public class Solution {
    public int myAtoi(String str) {
        if (str==null||str.length()==0) {
			return 0;
		}
        int sign = 1,result = 0,index = 0;
        while(str.charAt(index)==' '&&index<str.length()){
        	index++;
        }
        if (str.charAt(index)=='+'||str.charAt(index)=='-') {	
			sign = str.charAt(index)=='+'?1:-1;
			index++;
		}
        while (index<str.length()) {
			int digit = str.charAt(index)-'0';
			if (digit<0||digit>9) {
				break;
			}
			if (result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&digit>Integer.MAX_VALUE%10)) {//注：逻辑与的优先级高于逻辑或
				return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
			}
			result = result*10 + digit;//特别注意，极大可能在这一步得到的result已经超出了int范围，因此判断越界应放在前面，然而放在前面判断时，则少了最大值的最后一位，需要做更详细判断处理
			index++;
			
		}
        return sign*result;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().myAtoi("      -11919730356x"));
	}
}
