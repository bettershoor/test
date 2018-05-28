package integertoRoman;
/**
 * 题目：Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. 
Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. 
Instead, the number four is written as IV. Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * @author yifei
 *
 */
public class Solution {
	public String convert(double number,int index) {
		String result = new String();
		if (index == 1) {
			if (number>=1&&number<5) {
				result = "I";
				if (number == 4) {
					result +="V";
				}else {
					for (int i = 0; i < number-1; i++) {
						result += "I";
					}
				}
			}
			if (number>=5&&number<10) {
				if (number == 9) {
					result = "IX";
				}else {
					result = "V";
					for (int i = 0; i < number%5; i++) {
						result += "I";
					}
				}
			}
		}
		if (index == 2) {
			if (number>=10&&number<50) {
				result = "X";
				if (number == 40) {
					result += "L";
				}else {
					for (int i = 0; i < number/10-1; i++) {
						result += "X";
					}
				}
			}
			if (number>=50&&number<100) {
				if (number == 90) {
					result = "XC";
				}else {
					result = "L";
					for (int i = 0; i < (number-50)/10; i++) {
						result += "X";
					}	
				}
			}
		}
		if (index == 3) {
			if (number>=100&&number<500) {
				result = "C";
				if (number == 400) {
					result += "D";
				}else {
					for (int i = 0; i < number/100-1; i++) {
						result += "C";
					}
				}
			}
			if (number>=500&&number<1000) {
				if (number == 900) {
					result = "CM";
				}else {
					result = "D";
					for (int i = 0; i < (number-500)/100; i++) {
						result += "C";
					}	
				}
			}
		}
		if (index == 4) {
			result = "M";
			for (int i = 0; i < number/1000-1; i++) {
				result += "M";
			}
		}
		return result;
	}
    public String intToRoman(int num) {
        String res = new String();
        int index = 1;
        while (num!=0) {
			double mod = num%10;
			mod = mod*Math.pow(10, index-1);
			String temp = convert(mod, index);
			res = temp + res;
			index ++;
			num = num/10;
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(58));
	}
 /**
  * 优化解：将已知的组合或特殊的组合与其对应的value值先对应保存至数组中，，然后拆分任意数num与数组中的已有组合比较，逐渐得出结果
  * @param num
  * @return
  */
    public String intToRoman2(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
