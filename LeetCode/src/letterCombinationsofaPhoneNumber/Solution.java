package letterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
	A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

思路：1、先将2-9作为key，其对应的字母List作为value，保存至HashMap中；
	 2、开辟combine方法，拼接两个List的所有字符串可能；
	 3、遍历digits数字串，digits[i]与digits[i+1]对应的List分别combine，得到新的List后与digits[i+2]继续combine，直至遍历结束
 * @author yifei
 *
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	map.put("2", Arrays.asList("a","b","c"));
    	map.put("3", Arrays.asList("d","e","f"));
    	map.put("4", Arrays.asList("g","h","i"));
    	map.put("5", Arrays.asList("j","k","l"));
    	map.put("6", Arrays.asList("m","n","o"));
    	map.put("7", Arrays.asList("p","q","r","s"));
    	map.put("8", Arrays.asList("t","u","v"));
    	map.put("9", Arrays.asList("w","x","y","z"));
    	List<String> result = new ArrayList<>();
    	for (int i = 0; i < digits.length(); i++) {
			String key = digits.substring(i, i+1);
			if (result.isEmpty()) {
				result = map.get(key);
			}else {
				result = combine(result, map.get(key));
			}
		}
    	return result;
    }
    public List<String> combine(List<String> list1,List<String> list2) {
    	List<String> res = new ArrayList<String>();
		for (String s1 : list1) {
			for (String s2 : list2) {
				res.add(s1+s2);
			}
		}
		return res;
	}
}
