package zigzagConversion;
/**
 * 题目：
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:

	string convert(string text, int numRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

      思路：1、	ZigZag的格式：
			|     |     |
		    |   | |   |
		    | |   | |
		    |     |
	    2、遍历字符串，将最终结果的每行作为一个数组，将遍历的字符一次加入到这些行数组中
 * @author yifei
 *
 */
public class Solution {
//	public String convert(String s, int numRows) {
//		if (numRows == 1) {
//			return s;
//		}
//		int col = s.length()/(numRows+numRows-2);
//		int mod = s.length()%(numRows+numRows-2);
//		int extracol = 0,ncols;
//		if (mod == 0) {
//			extracol = 0;
//		}else if (mod > 0 && mod <= numRows) {
//			extracol = 1;
//		}else if (mod > numRows && mod < (numRows+numRows-2)) {
//			extracol = 2;
//		}
//		ncols = 2*col + extracol;
//		char[][] arr = new char[numRows][ncols];
//		int k = 0;
//		String result = new String();
//		for (int i = 0; i < ncols; i++) {
//			for (int j = 0; j < numRows; j++) {
//				if (((i+1)%2==0&&numRows!=2&&(j==0||j==numRows-1))||k>=s.length()) {
//					arr[j][i] = ' ';
//				}else {
//					arr[j][i] = s.charAt(k);
//					k++;
//				}
//			}
//		}
//		for (int i = 0; i < numRows; i++) {
//			for (int j = 0; j < ncols; j++) {
//				result += arr[i][j];
//			}
//		}
//		result = result.replaceAll(" ","");
//		return result;
//	}
	public String convert2(String s, int numRows) {
		String result = new String();
		char[] arr = s.toCharArray();
		int len = s.length(),i = 0;
		StringBuffer [] sb = new StringBuffer[numRows];
		for (int j = 0; j < sb.length; j++) {
			sb[j] = new StringBuffer();
		}
		while (i<len) {
			for (int idx = 0; idx < numRows && i<len; idx++,i++) {
				sb[idx].append(arr[i]);
			}
			for (int idx = numRows-2; idx > 0 && i<len; idx--,i++) {
				sb[idx].append(arr[i]);
			}
		}
		for (int j = 0; j < sb.length; j++) {
			result+=sb[j];
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().convert2("ABCDE", 4));
	}
}
